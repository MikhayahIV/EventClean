package six.jay.EventClean.infrastructure.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import six.jay.EventClean.core.entites.Event;
import six.jay.EventClean.core.gateway.EventGateway;
import six.jay.EventClean.infrastructure.mapper.EventEntityMapper;
import six.jay.EventClean.infrastructure.persistence.EventEntity;
import six.jay.EventClean.infrastructure.persistence.EventRepository;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper mapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Override
    public Event criarEvento(Event event) {
        EventEntity entity = mapper.toEntity(event);
        EventEntity novoEvento = eventRepository.save(entity);
        return mapper.toDomain(novoEvento);
    }
}
