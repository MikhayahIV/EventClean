package six.jay.EventClean.core.gateway;

import six.jay.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento criarEvento(Evento evento);
    List<Evento> listarEventos();
    boolean identificadorExiste(String identificador);

}
