package eduardo.estudo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Builder
public class AnimePostRequest {
    private Integer id;
    private String nome;
}
