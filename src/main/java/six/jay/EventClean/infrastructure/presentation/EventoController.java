package six.jay.EventClean.infrastructure.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.useCases.CriarEventoUseCase;
import six.jay.EventClean.core.useCases.FiltrarIdentificadorEventoUseCase;
import six.jay.EventClean.core.useCases.ListarEventosUseCase;
import six.jay.EventClean.infrastructure.dto.EventoDto;
import six.jay.EventClean.infrastructure.mapper.EventoDtoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final ListarEventosUseCase listarEventosUseCase;
    private final FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase;
    private final EventoDtoMapper mapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, ListarEventosUseCase listarEventosUseCase, FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase, EventoDtoMapper mapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.listarEventosUseCase = listarEventosUseCase;
        this.filtrarIdentificadorEventoUseCase = filtrarIdentificadorEventoUseCase;
        this.mapper = mapper;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String,Object>> criarEvento(@RequestBody EventoDto dto){
        Evento evento = criarEventoUseCase.execute(mapper.toDomain(dto));
        Map<String,Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastrado no banco de dado.");
        response.put("Dados: ",mapper.toDto(evento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("listareventos")
    public List<EventoDto> listarEventos(){
        return listarEventosUseCase.execute().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("evento/{identificador}")
    public ResponseEntity<Evento> filtrarEventoPorIdentificador(@PathVariable String identificador){
        Evento evento = filtrarIdentificadorEventoUseCase.execute(identificador);
        return ResponseEntity.ok(evento);
    }
}
