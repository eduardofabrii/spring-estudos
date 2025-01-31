package eduardo.estudo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Builder
@ToString
public class AnimePostRequest {
    private Integer id;
    private String nome;
}
