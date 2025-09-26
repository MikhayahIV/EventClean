package six.jay.EventClean.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import six.jay.EventClean.core.enums.EventTypes;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String identificador;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String localEvento;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private EventTypes tipo;

    private String organizador;

}