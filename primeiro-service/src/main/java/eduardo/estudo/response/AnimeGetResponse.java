package eduardo.estudo.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnimeGetResponse {
    private Integer id;
    private String nome;
}
