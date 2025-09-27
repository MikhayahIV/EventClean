package six.jay.EventClean.core.entities;

import six.jay.EventClean.core.enums.TiposEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        String identificador,
        String organizador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String localEvento,
        Integer capacidade,
        TiposEvento tipoEvento
){}