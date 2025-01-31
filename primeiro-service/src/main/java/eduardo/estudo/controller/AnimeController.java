package eduardo.estudo.controller;

import eduardo.estudo.domain.Anime;
import eduardo.estudo.domain.Producer;
import eduardo.estudo.mapper.AnimeMapper;
import eduardo.estudo.mapper.ProducerMapper;
import eduardo.estudo.request.AnimePostRequest;
import eduardo.estudo.request.ProducerPostRequest;
import eduardo.estudo.response.AnimeGetResponse;
import eduardo.estudo.response.ProducerGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/animes")
@Slf4j
public class AnimeController {

    private static final AnimeMapper MAPPER = AnimeMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<AnimeGetResponse>> listAll(@RequestParam(required = false) String name) {
        log.debug("Request received to list all animes, param name: '{}'", name);

        var animes = Anime.getAnimes();
        List<AnimeGetResponse> animeGetResponseList = MAPPER.toAnimeGetResponseList(animes);

        if (name == null) return ResponseEntity.ok(animeGetResponseList);

        var response = animeGetResponseList.stream().filter(anime -> anime.getNome().equalsIgnoreCase(name)).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeGetResponse> listAll(@PathVariable Long id) {
        log.debug("Request to find anime by id: '{}'", id);

        var animeGetResponse = Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .map(MAPPER::toAnimeGetResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producer not found"));

        return ResponseEntity.ok(animeGetResponse);
    }

    @PostMapping
    public ResponseEntity<AnimeGetResponse> save(@RequestBody AnimePostRequest animePostRequest) {
        log.debug("Request to post anime '{}'", animePostRequest);

        var anime = MAPPER.toAnime(animePostRequest);
        var response = MAPPER.toAnimeGetResponse(anime);

        Anime.getAnimes().add(anime);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
