package six.jay.EventClean.infrastructure.persistence;


import jakarta.persistence.*;
import six.jay.EventClean.core.enums.TiposEvento;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_event")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private String organizador;
    private Integer capacidade;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String localEvento;
    private TiposEvento tipoEvento;

    public EventoEntity() {
    }

    public EventoEntity(Long id, String nome, String descricao, String identificador, String organizador, Integer capacidade, LocalDateTime dataInicio, LocalDateTime dataFim, String localEvento, TiposEvento tipoEvento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificador = identificador;
        this.organizador = organizador;
        this.capacidade = capacidade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.localEvento = localEvento;
        this.tipoEvento = tipoEvento;
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

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
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

    public TiposEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TiposEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}

