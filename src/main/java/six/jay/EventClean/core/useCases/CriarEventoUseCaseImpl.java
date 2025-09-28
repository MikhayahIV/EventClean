package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
