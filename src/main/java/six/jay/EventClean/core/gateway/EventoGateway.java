package six.jay.EventClean.core.gateway;

import six.jay.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Evento criarEvento(Evento evento);
    List<Evento> listarEventos();
    boolean identificadorExiste(String identificador);
    Optional<Evento> filtrarEventoIdentificador(String identificador);

}
