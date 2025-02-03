package eduardo.estudo.mapper;

import eduardo.estudo.domain.Anime;
import eduardo.estudo.request.AnimePostRequest;
import eduardo.estudo.request.AnimePutRequest;
import eduardo.estudo.response.AnimeGetResponse;
import eduardo.estudo.response.AnimePostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {

    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(1000))")
//    Pega de producer do ProducerPostRequest
    Anime toAnime(AnimePostRequest postRequest);

    Anime toAnime(AnimePutRequest request);

    AnimeGetResponse toAnimeGetResponse(Anime anime);

    AnimePostResponse toAnimePostResponse(Anime animePosted);

    List<AnimeGetResponse> toAnimeGetResponseList(List<Anime> animes);

}
