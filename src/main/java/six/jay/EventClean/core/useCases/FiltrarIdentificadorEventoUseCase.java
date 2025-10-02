package six.jay.EventClean.core.useCases;

import six.jay.EventClean.core.entities.Evento;

import java.util.List;

public interface FiltrarIdentificadorEventoUseCase {

    Evento execute(String identificador);
}
