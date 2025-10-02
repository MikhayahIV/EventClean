package six.jay.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import six.jay.EventClean.core.entities.Evento;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
    Optional<Evento> findByidentificador(String identificador);
}
