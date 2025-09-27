package six.jay.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;
import six.jay.EventClean.core.entites.Event;
import six.jay.EventClean.infrastructure.dto.EventDto;

@Component
public class EventDtoMapper {

     public EventDto toDto(Event entity){
         return new EventDto(
                 entity.id(),
                 entity.nome(),
                 entity.descricao(),
                 entity.identificador(),
                 entity.dataInicio(),
                 entity.dataFim(),
                 entity.localEvento(),
                 entity.capacidade(),
                 entity.tipo(),
                 entity.organizador()
         );
     }

     public Event toDomain(EventDto dto){
         return new Event(
                 dto.id(),
                 dto.nome(),
                 dto.descricao(),
                 dto.identificador(),
                 dto.dataInicio(),
                 dto.dataFim(),
                 dto.localEvento(),
                 dto.capacidade(),
                 dto.tipo(),
                 dto.organizador()
         );
     }

}