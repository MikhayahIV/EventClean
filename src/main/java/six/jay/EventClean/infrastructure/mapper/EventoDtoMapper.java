package six.jay.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.infrastructure.dto.EventoDto;

@Component
public class EventoDtoMapper {
    public EventoDto toDto(Evento evento){
        return new EventoDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.organizador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.localEvento(),
                evento.capacidade(),
                evento.tipoEvento());
    }

    public Evento toDomain(EventoDto dto){
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificador(),
                dto.organizador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.localEvento(),
                dto.capacidade(),
                dto.tipoEvento());
    }
}
