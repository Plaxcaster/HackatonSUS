package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Informações definindo um agravo.
 */
@Getter
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({ "informacoesEsperadas" })
@Table(name = "AGRAVO", uniqueConstraints = @UniqueConstraint(columnNames = "CID"))
public class AgravoEntity implements Serializable {
    @Id
    @Column
    private UUID id;
    @Column
    private String CID;
    @Column
    private String nome;
    @OneToMany(mappedBy = "agravo", cascade = CascadeType.PERSIST)
    private Set<InformacaoAgravoEntity> informacoesEsperadas;

    public AgravoEntity(String CID) {
        this.CID = CID;
    }

    public void adicionarInformacoes(InformacaoAgravoEntity informacao) {
        informacao.setAgravo(this);
        this.informacoesEsperadas.add(informacao);
    }

    @Override
    public String toString() {
        return "AgravoEntity [id=" + id + ", CID=" + CID + ", nome=" + nome + ",informacoes="
                + informacoesEsperadas.size() + "]";
    }

}