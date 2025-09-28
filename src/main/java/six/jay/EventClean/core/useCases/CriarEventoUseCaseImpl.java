package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.gateway.EventoGateway;
import six.jay.EventClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase{

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if(eventoGateway.identificadorExiste(evento.identificador())){
            throw new DuplicateEventException("O identificador: "+evento.identificador()+" ja esta em uso para outro evento!");
        }
        return eventoGateway.criarEvento(evento);
    }
}
