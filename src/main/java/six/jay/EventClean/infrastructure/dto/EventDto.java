package six.jay.EventClean.infrastructure.dto;

import six.jay.EventClean.core.enums.EventTypes;
import java.time.LocalDateTime;

public record EventDto(
         Long id,

         String nome,

         String descricao,

         String identificador,

         LocalDateTime dataInicio,

         LocalDateTime dataFim,

         String localEvento,

         Integer capacidade,

         EventTypes tipo,

         String organizador

) { }