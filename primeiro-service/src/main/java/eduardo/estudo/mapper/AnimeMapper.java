package eduardo.estudo.mapper;

import eduardo.estudo.domain.Anime;
import eduardo.estudo.domain.Producer;
import eduardo.estudo.request.AnimePostRequest;
import eduardo.estudo.request.ProducerPostRequest;
import eduardo.estudo.response.AnimeGetResponse;
import eduardo.estudo.response.ProducerGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimeMapper {

    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1000))")
    @Mapping(target = "nome")
//    Pega de producer do ProducerPostRequest
    Anime toAnime(AnimePostRequest postRequest);

    AnimeGetResponse toAnimeGetResponse(Anime anime);

    List<AnimeGetResponse> toAnimeGetResponseList(List<Anime> animes);
}
