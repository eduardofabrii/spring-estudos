package eduardo.estudo.repository;

import eduardo.estudo.domain.Producer;
import external.dependency.Connection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProducerHardCodedRepository {
    private final Connection connection;
    private final ProducerData producerData;

    public List<Producer> findAll() {
        return producerData.getProducers();
    }

    public Optional<Producer> findById(Long id) {
        return producerData.getProducers().stream().filter(producer -> producer.getId().equals(id)).findFirst();
    }

    public List<Producer> findByNome(String nome) {
        log.debug(connection);
        return producerData.getProducers().stream().filter(producer -> producer.getNome().equalsIgnoreCase(nome)).toList();
    }

    public Producer save(Producer producer) {
        producerData.getProducers().add(producer);
        return producer;
    }

    public void delete(Producer producer) {
        producerData.getProducers().remove(producer);
    }

    public void update(Producer producer) {
        delete(producer);
        save(producer);
    }
}
