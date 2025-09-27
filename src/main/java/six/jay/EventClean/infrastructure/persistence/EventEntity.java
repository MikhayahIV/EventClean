package six.jay.EventClean.infrastructure.persistence;

import jakarta.persistence.*;
import six.jay.EventClean.core.enums.EventTypes;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String identificador;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "local_evento")
    private String localEvento;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private EventTypes tipo;

    private String organizador;


    public EventEntity() {
    }

    public EventEntity(Long id, String nome, String descricao, String identificador, LocalDateTime dataInicio, LocalDateTime dataFim, String localEvento, Integer capacidade, EventTypes tipo, String organizador) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificador = identificador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.localEvento = localEvento;
        this.capacidade = capacidade;
        this.tipo = tipo;
        this.organizador = organizador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public EventTypes getTipo() {
        return tipo;
    }

    public void setTipo(EventTypes tipo) {
        this.tipo = tipo;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
}