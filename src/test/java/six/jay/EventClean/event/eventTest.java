package six.jay.EventClean.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import six.jay.EventClean.core.entities.Evento;
import six.jay.EventClean.core.enums.TiposEvento;
import six.jay.EventClean.infrastructure.gateway.EventoRepositoryGateway;
import six.jay.EventClean.infrastructure.mapper.EventoEntityMapper;
import six.jay.EventClean.infrastructure.persistence.EventoEntity;
import six.jay.EventClean.infrastructure.persistence.EventoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class eventTest {
    @Mock
    private EventoRepository repository;

    @Mock
    private EventoEntityMapper mapper;

    @InjectMocks
    private EventoRepositoryGateway gateway;

    private EventoEntity entity;
    private Evento domain;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        entity = new EventoEntity();
        entity.setId(1L);
        entity.setNome("Evento Teste");
        entity.setIdentificador("EVT123");

        domain = new Evento(1L,
                "Show de Rock",
                "Evento musical com várias bandas",
                "ROCK2025",
                "Vitor Dias",
                LocalDateTime.of(2025, 10, 10, 20, 0),
                LocalDateTime.of(2025, 10, 11, 2, 0),
                "Arena SP",
                5000,
                TiposEvento.WORKSHOP);
    }

    @Test
    void deveCriarEventoComSucesso() {
        when(mapper.toEntity(domain)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(domain);

        Evento resultado = gateway.criarEvento(domain);

        assertNotNull(resultado);
        assertEquals("ROCK2025", resultado.identificador());
        verify(repository, times(1)).save(entity);
    }

    @Test
    void deveListarEventosComSucesso() {
        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(domain);

        List<Evento> resultado = gateway.listarEventos();

        assertEquals(1, resultado.size());
        assertEquals("Show de Rock", resultado.get(0).nome());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveVerificarSeIdentificadorExiste() {
        entity.setIdentificador("ROCK2025");
        when(repository.findAll()).thenReturn(List.of(entity));

        boolean existe = gateway.identificadorExiste("ROCK2025");

        assertTrue(existe);
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveRetornarEventoPorIdentificador() {
        when(repository.findByidentificador("ROCK2025")).thenReturn(Optional.of(domain));

        Optional<Evento> resultado = gateway.filtrarEventoIdentificador("ROCK2025");

        assertTrue(resultado.isPresent());
        assertEquals("ROCK2025", resultado.get().identificador());
        verify(repository, times(1)).findByidentificador("ROCK2025");
    }

    @Test
    void deveRetornarOptionalVazioQuandoIdentificadorNaoExistir() {
        when(repository.findByidentificador("NAO_EXISTE")).thenReturn(Optional.empty());

        Optional<Evento> resultado = gateway.filtrarEventoIdentificador("NAO_EXISTE");

        assertTrue(resultado.isEmpty());
        verify(repository, times(1)).findByidentificador("NAO_EXISTE");
    }
}
