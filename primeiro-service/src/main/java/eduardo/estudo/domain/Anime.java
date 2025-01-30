package eduardo.estudo.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Anime {
    private Long id;

    private String nome;

    public Anime(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static List<Anime> getAnimes() {
        List<Anime> animes = new ArrayList<>();

        animes.add(new Anime(1l, "Naruto Shippuden"));
        animes.add(new Anime(2l, "Dragon Ball Z"));
        animes.add(new Anime(3l, "One Piece"));

        return animes;
    }
}
