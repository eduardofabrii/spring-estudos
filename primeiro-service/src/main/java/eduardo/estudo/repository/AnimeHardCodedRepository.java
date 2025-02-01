package eduardo.estudo.repository;

import eduardo.estudo.domain.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimeHardCodedRepository {
    private static final List<Anime> ANIMES = new ArrayList<>();

    static {
        ANIMES.add(Anime.builder().id(1L).nome("Naruto Shippuden").build());
        ANIMES.add(Anime.builder().id(2L).nome("Dragon Ball Z").build());
        ANIMES.add(Anime.builder().id(3L).nome("One Piece").build());
    }

    public List<Anime> findAll() {
        return AnimeHardCodedRepository.ANIMES;
    }

    public Optional<Anime> findById(Long id) {
        return ANIMES.stream().filter(anime -> anime.getId().equals(id)).findFirst();
    }

    public List<Anime> findByNome(String nome) {
        return ANIMES.stream().filter(anime -> anime.getNome().equalsIgnoreCase(nome)).toList();
    }

    public Anime save(Anime anime) {
        ANIMES.add(anime);
        return anime;
    }

    public void delete(Anime anime) {
        ANIMES.remove(anime);
    }

    public void update(Anime anime) {
        delete(anime);
        save(anime);
    }
}
