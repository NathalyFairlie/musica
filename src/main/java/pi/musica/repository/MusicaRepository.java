package pi.musica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.musica.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}