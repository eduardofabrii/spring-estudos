package eduardo.estudo.controller;

import eduardo.estudo.domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
