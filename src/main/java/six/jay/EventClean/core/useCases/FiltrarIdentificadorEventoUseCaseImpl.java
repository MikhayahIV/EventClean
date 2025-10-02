package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.gateway.EventoGateway;
import six.jay.EventClean.infrastructure.exception.NotFoundEventException;

import java.util.List;

public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase{

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarEventoIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Evento com o identificador: "+identificador+" não  encontrado"));
    }
}
