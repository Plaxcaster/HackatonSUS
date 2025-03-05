package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Descrição de uma informação que pode ser incluída como informação adicional
 * de um registro de agravo
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@ToString
@Table(name = "INFORMACOES_AGRAVO")
@JsonIgnoreProperties({ "agravo" })
public class InformacaoAgravoEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    private String nome;
    @Column
    private String chaveJson;
    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "agravo_id", nullable = false)
    private AgravoEntity agravo;
    /**
     * @param nome
     * @param agravo
     */
    public InformacaoAgravoEntity(String nome, AgravoEntity agravo , String chaveJson , String descricao) {
        this.nome = nome;
        this.agravo = agravo;
        this.chaveJson = chaveJson;
        this.descricao = descricao;
    }

}
