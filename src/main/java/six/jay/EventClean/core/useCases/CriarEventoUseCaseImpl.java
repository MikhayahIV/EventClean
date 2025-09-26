package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entites.Event;
import six.jay.EventClean.core.gateway.EventGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventGateway eventGateway;

    public CriarEventoUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event evento){
        return eventGateway.criarEvento(evento);
    }

}