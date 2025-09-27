package six.jay.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;
import six.jay.EventClean.core.entites.Event;
import six.jay.EventClean.infrastructure.persistence.EventEntity;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
                event.id(),
                event.nome(),
                event.descricao(),
                event.identificador(),
                event.dataInicio(),
                event.dataFim(),
                event.localEvento(),
                event.capacidade(),
                event.tipo(),
                event.organizador()
        );
    }

    public Event toDomain(EventEntity entity){
        return new Event(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getIdentificador(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getLocalEvento(),
                entity.getCapacidade(),
                entity.getTipo(),
                entity.getOrganizador()
        );
    }

}