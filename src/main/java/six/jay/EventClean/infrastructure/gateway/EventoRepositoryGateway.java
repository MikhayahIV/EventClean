package six.jay.EventClean.infrastructure.gateway;

import org.springframework.stereotype.Component;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.gateway.EventoGateway;
import six.jay.EventClean.infrastructure.mapper.EventoEntityMapper;
import six.jay.EventClean.infrastructure.persistence.EventoEntity;
import six.jay.EventClean.infrastructure.persistence.EventoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository repository;
    private final EventoEntityMapper mapper;

    public EventoRepositoryGateway(EventoRepository repository, EventoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Evento criarEvento(Evento evento) {
        EventoEntity eventoEntity = mapper.toEntity(evento);
        EventoEntity novoEvent = repository.save(eventoEntity);
        return mapper.toDomain(novoEvent);
    }

    @Override
    public List<Evento> listarEventos() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public boolean identificadorExiste(String identificador) {
        return repository.findAll().stream().anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }


    @Override
    public Optional<Evento> filtrarEventoIdentificador(String identificador) {
        return repository.findByidentificador(identificador);
    }
}
