package eduardo.estudo.repository;

import eduardo.estudo.domain.Producer;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ProducerData {
    private final List<Producer> producers = new ArrayList<>();

    {
        producers.add(Producer.builder().id(1L).nome("Mappa").createdAt(LocalDateTime.now()).build());
        producers.add(Producer.builder().id(2L).nome("Kyoto").createdAt(LocalDateTime.now()).build());
        producers.add(Producer.builder().id(3L).nome("Madhouse").createdAt(LocalDateTime.now()).build());
    }
}
