package six.jay.EventClean.infrastructure.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria um novo evento", description = "Recebe dados de um EventoDto e persiste o novo evento no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Evento cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos.")
    })
    public ResponseEntity<Map<String,Object>> criarEvento(@RequestBody EventoDto dto){
        Evento evento = criarEventoUseCase.execute(mapper.toDomain(dto));
        Map<String,Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastrado no banco de dado.");
        response.put("Dados: ",mapper.toDto(evento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("listareventos")
    @Operation(summary = "Lista todos os eventos", description = "Retorna uma lista de todos os eventos ativos cadastrados no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de eventos retornada com sucesso.")
    })
    public List<EventoDto> listarEventos(){
        return listarEventosUseCase.execute().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("evento/{identificador}")
    @Operation(summary = "Busca um evento por identificador único", description = "Filtra e retorna um evento específico usando seu identificador único (String).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evento encontrado e retornado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Evento não encontrado para o identificador fornecido.")
    })
    public ResponseEntity<Evento> filtrarEventoPorIdentificador(@PathVariable String identificador){
        Evento evento = filtrarIdentificadorEventoUseCase.execute(identificador);
        return ResponseEntity.ok(evento);
    }
}
