package six.jay.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.useCases.CriarEventoUseCase;
import six.jay.EventClean.infrastructure.dto.EventoDto;
import six.jay.EventClean.infrastructure.mapper.EventoDtoMapper;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper mapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper mapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.mapper = mapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto){
        Evento evento = criarEventoUseCase.execute(mapper.toDomain(dto));
        return mapper.toDto(evento);
    }
}
