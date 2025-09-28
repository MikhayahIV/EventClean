package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class ListarEventoUseCaseImpl implements ListarEventosUseCase{

    private final EventoGateway eventoGateway;

    public ListarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.listarEventos();
    }
}
