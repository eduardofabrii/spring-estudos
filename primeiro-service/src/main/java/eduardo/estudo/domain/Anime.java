package eduardo.estudo.domain;

import eduardo.estudo.controller.AnimeController;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Anime {
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    @Getter
    private static List<Anime> animes = new ArrayList<>();
}
