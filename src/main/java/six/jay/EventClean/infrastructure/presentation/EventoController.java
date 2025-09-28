package six.jay.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.*;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.useCases.CriarEventoUseCase;
import six.jay.EventClean.core.useCases.ListarEventosUseCase;
import six.jay.EventClean.infrastructure.dto.EventoDto;
import six.jay.EventClean.infrastructure.mapper.EventoDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final ListarEventosUseCase listarEventosUseCase;
    private final EventoDtoMapper mapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, ListarEventosUseCase listarEventosUseCase, EventoDtoMapper mapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.listarEventosUseCase = listarEventosUseCase;
        this.mapper = mapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto){
        Evento evento = criarEventoUseCase.execute(mapper.toDomain(dto));
        return mapper.toDto(evento);
    }

    @GetMapping("listareventos")
    public List<EventoDto> listarEventos(){
        return listarEventosUseCase.execute().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
