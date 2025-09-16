package tech.build.consultas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne(optional = false)
    private Paciente paciente;

    @ManyToMany
    @JoinTable(
            name = "atendimento_procedimento",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "procedimento_id")
    )
    private List<Procedimento> procedimentos;

    @Enumerated(EnumType.STRING)
    private AtendimentoTipo tipo;

    private String planNumber; // opcional (somente obrigatório se tipo == PLANO)

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // id do usuário que efetuou o atendimento

    private BigDecimal valorTotal;
}
