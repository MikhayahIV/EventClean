package six.jay.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.*;
import six.jay.EventClean.core.entites.Event;
import six.jay.EventClean.core.useCases.CriarEventoUseCase;
import six.jay.EventClean.infrastructure.dto.EventDto;
import six.jay.EventClean.infrastructure.mapper.EventDtoMapper;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventDtoMapper eventDtoMapper;

    public EventController(CriarEventoUseCase criarEventoUseCase, EventDtoMapper eventDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("/criarevento")
    public EventDto criarEvento(@RequestBody EventDto dto){
        Event novoEvento = criarEventoUseCase.execute(eventDtoMapper.toDomain(dto));
        return eventDtoMapper.toDto(novoEvento);
    }


}
