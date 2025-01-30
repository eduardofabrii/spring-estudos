package eduardo.estudo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Producer {
    private Long id;
    @JsonProperty("full_name")
    private String nome;
    @Getter
    private static List<Producer> producers = new ArrayList<>();

    static {
        producers.add(new Producer(1l, "Mappa"));
        producers.add(new Producer(2l, "Kyoto"));
        producers.add(new Producer(3l, "Madhouse"));
    }

}
