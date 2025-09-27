package six.jay.EventClean.infrastructure.mapper;

import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.infrastructure.persistence.EventoEntity;

public class EventoEntityMapper {
    public EventoEntity toEntity(Evento evento){
        return new EventoEntity(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.organizador(),
                evento.capacidade(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.tipoEvento()
        );
    }

    public Evento toDomain(EventoEntity entity){
        return new Evento(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getIdentificador(),
                entity.getOrganizador(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getLocalEvento(),
                entity.getCapacidade(),
                entity.getTipoEvento()
        );
    }
}
