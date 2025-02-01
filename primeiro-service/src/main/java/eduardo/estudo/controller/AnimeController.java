package eduardo.estudo.controller;

import eduardo.estudo.domain.Anime;
import eduardo.estudo.mapper.AnimeMapper;
import eduardo.estudo.request.AnimePostRequest;
import eduardo.estudo.request.AnimePutRequest;
import eduardo.estudo.response.AnimeGetResponse;
import eduardo.estudo.response.AnimePostResponse;
import eduardo.estudo.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/animes")
@Slf4j
public class AnimeController {

    private static final AnimeMapper MAPPER = AnimeMapper.INSTANCE;
    private AnimeService service;

    public AnimeController() {
        this.service = new AnimeService();
    }

    @GetMapping
    public ResponseEntity<List<AnimeGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request received to list all animes, param name: '{}'", name);

        var animes = service.findAll(name);
        var animeGetResponses = MAPPER.toAnimeGetResponseList(animes);

        return ResponseEntity.ok(animeGetResponses);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeGetResponse> findById(@PathVariable Long id) {
        log.debug("Request to find anime by id: '{}'", id);

        var anime = service.findByIdOrThrowNotFound(id);
        var animeGetResponse = MAPPER.toAnimeGetResponse(anime);

        return ResponseEntity.ok(animeGetResponse);
    }


    @PostMapping(headers = "x-api-key")
    public ResponseEntity<AnimePostResponse> save(@RequestBody AnimePostRequest request,
                                                  @RequestHeader HttpHeaders headers) {
        log.info("{}" + headers);

        var anime = MAPPER.toAnime(request);
        var animeSaved = service.save(anime);
        var animePostResponse = MAPPER.toAnimePostResponse(animeSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(animePostResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.debug("Request to delete anime by id: '{}'", id);

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody AnimePutRequest request) {
        log.debug("Request to delete anime '{}'", request);

        var animeToUpdate = MAPPER.toAnime(request);

        service.update(animeToUpdate);

        return ResponseEntity.noContent().build();
    }
}
