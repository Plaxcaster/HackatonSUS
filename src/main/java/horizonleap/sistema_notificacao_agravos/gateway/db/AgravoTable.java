package horizonleap.sistema_notificacao_agravos.gateway.db;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agravo")
public class AgravoTable implements Serializable {
    @Id
    @Column
    private UUID id;
    @Column
    private String CID;
    @Column
    private String nome;
    @OneToMany( mappedBy = "agravo")
    private Set<InformacaoAgravoTableEntity> informacoesEsperadas;

    public AgravoEntity toAgravoEntity() {
        Set<InformacaoAgravoEntity> informacoes = Set.of();
        informacoesEsperadas.forEach(elemento -> informacoes.add(elemento.toInformacaoAgravoEntity()));

        return AgravoEntity.builder()
                .CID(CID)
                .id(id)
                .nome(nome)
                .informacoesEsperadas(informacoes)
                .build();
    }
}
