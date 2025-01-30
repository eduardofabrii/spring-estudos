package eduardo.estudo.domain;

import eduardo.estudo.controller.AnimeController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Anime {
    private Long id;
    private String nome;
    @Getter
    private static List<Anime> animes = new ArrayList<>();

    static {
        animes.add(new Anime(1l, "Naruto Shippuden"));
        animes.add(new Anime(2l, "Dragon Ball Z"));
        animes.add(new Anime(3l, "One Piece"));
    }

}
