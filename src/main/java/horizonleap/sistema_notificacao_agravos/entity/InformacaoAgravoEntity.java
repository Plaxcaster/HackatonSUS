package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Descrição de uma informação que pode ser incluída como informação adicional
 * de um registro de agravo
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INFORMACOES_AGRAVO")
public class InformacaoAgravoEntity implements Serializable {

    @Id
    @Column
    private UUID id;
    @Column
    private String nome;
    @ManyToOne
    @JoinColumn(name = "agravo_id", nullable = false)
    private AgravoEntity agravo;
}
