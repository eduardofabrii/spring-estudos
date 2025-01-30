package eduardo.estudo.controller;

import eduardo.estudo.domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("v1/animes")
public class AnimeController {

    @GetMapping
    public List<Anime> listAll(@RequestParam(required = false) String name) {
        var animes = Anime.getAnimes();

        if (name == null) return animes;
        return animes.stream().filter(anime -> anime.getNome().equals(name)).toList();
    }

    @GetMapping("{id}")
    public Anime listAll(@PathVariable Long id) {
        return Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping
    public Anime save(@RequestBody Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(1000));
        Anime.getAnimes().add(anime);
        return anime;
    }
}
