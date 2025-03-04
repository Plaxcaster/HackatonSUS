package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "AGRAVO" )
public class AgravoEntity implements Serializable {
    @Id
    @Column
    private UUID id;
    @Column
    private String CID;
    @Column
    private String nome;
    @OneToMany( mappedBy = "agravo")
    private Set<InformacaoAgravoEntity> informacoesEsperadas;

    public AgravoEntity(String CID){
        this.CID = CID;
    }

}