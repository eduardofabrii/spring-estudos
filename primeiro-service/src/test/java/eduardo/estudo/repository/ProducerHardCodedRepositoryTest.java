package eduardo.estudo.repository;

import eduardo.estudo.domain.Producer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProducerHardCodedRepositoryTest {

    private final List<Producer> producerList = new ArrayList<>();

    @InjectMocks
    private ProducerHardCodedRepository repository;

    @Mock
    private ProducerData producerData;

    @BeforeEach
    void init() {
        producerList.add(Producer.builder().id(1L).nome("McQueen").createdAt(LocalDateTime.now()).build());
        producerList.add(Producer.builder().id(2L).nome("Pelé Jr").createdAt(LocalDateTime.now()).build());
        producerList.add(Producer.builder().id(3L).nome("Wishes Laundry").createdAt(LocalDateTime.now()).build());
        BDDMockito.when(producerData.getProducers()).thenReturn(producerList);
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll_ReturnsAllProducers_WhenSucessful() {

        var producers = repository.findAll();
        Assertions.assertThat(producers).hasSize(producers.size());
    }
}