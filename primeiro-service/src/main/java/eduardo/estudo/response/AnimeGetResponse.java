package eduardo.estudo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AnimeGetResponse {
    private Integer id;
    private String nome;
}
