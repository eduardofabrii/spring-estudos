package eduardo.estudo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Producer {
    private Long id;
    @JsonProperty("full_name")
    private String nome;
    @Getter
    private static List<Producer> producers = new ArrayList<>();
    private LocalDateTime createdAt;

    static {
        producers.add(Producer.builder().id(1L).nome("Mappa").createdAt(LocalDateTime.now()).build());
        producers.add(Producer.builder().id(2L).nome("Kyoto").createdAt(LocalDateTime.now()).build());
        producers.add(Producer.builder().id(3L).nome("Madhouse").createdAt(LocalDateTime.now()).build());
    }

}
