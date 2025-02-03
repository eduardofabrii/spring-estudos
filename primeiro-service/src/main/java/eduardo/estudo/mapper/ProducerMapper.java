package eduardo.estudo.mapper;

import eduardo.estudo.domain.Producer;
import eduardo.estudo.request.ProducerPostRequest;
import eduardo.estudo.request.ProducerPutRequest;
import eduardo.estudo.response.ProducerGetResponse;
import eduardo.estudo.response.ProducerPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProducerMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1000))")
//    Pega de producer do ProducerPostRequest
    Producer toProducer(ProducerPostRequest postRequest);

    Producer toProducer(ProducerPutRequest producer);

    ProducerGetResponse toProducerGetResponse(Producer producer);

    ProducerPostResponse toProducerPostResponse(Producer producerSaved);

    List<ProducerGetResponse> toProducerGetResponseList(List<Producer> producers);
}
