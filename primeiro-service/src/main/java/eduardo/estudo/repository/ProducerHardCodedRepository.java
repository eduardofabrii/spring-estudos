package eduardo.estudo.repository;

import eduardo.estudo.domain.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProducerHardCodedRepository {
    private static final List<Producer> PRODUCERS = new ArrayList<>();

    static {
        PRODUCERS.add(Producer.builder().id(1L).nome("Mappa").createdAt(LocalDateTime.now()).build());
        PRODUCERS.add(Producer.builder().id(2L).nome("Kyoto").createdAt(LocalDateTime.now()).build());
        PRODUCERS.add(Producer.builder().id(3L).nome("Madhouse").createdAt(LocalDateTime.now()).build());
    }

    public static List<Producer> findAll() {
        return ProducerHardCodedRepository.PRODUCERS;
    }

    public Optional<Producer> findById(Long id) {
        return PRODUCERS.stream().filter(producer -> producer.getId().equals(id)).findFirst();
    }

    public List<Producer> findByNome(String nome) {
        return PRODUCERS.stream().filter(producer -> producer.getNome().equalsIgnoreCase(nome)).toList();
    }

    public Producer save(Producer producer) {
        PRODUCERS.add(producer);
        return producer;
    }

    public void delete(Producer producer) {
        PRODUCERS.remove(producer);
    }

    public void update(Producer producer) {
        delete(producer);
        save(producer);
    }
}
