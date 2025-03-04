package horizonleap.sistema_notificacao_agravos.gateway.db;

import java.io.Serializable;
import java.util.UUID;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Informacoes_adicionais")
public class InformacaoAgravoTableEntity implements Serializable {

    @Id
    @Column
    private UUID id;
    @Column
    private String nome;
    @ManyToOne
    @JoinColumn(name="agravo_id" , nullable= false)
    private AgravoTable agravo;

    public InformacaoAgravoEntity toInformacaoAgravoEntity(){
        return new InformacaoAgravoEntity(id, nome);
    }
}
