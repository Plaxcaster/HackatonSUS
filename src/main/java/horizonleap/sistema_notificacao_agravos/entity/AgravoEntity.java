package horizonleap.sistema_notificacao_agravos.entity;

import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Informações definindo um agravo.
 */
@Getter
@AllArgsConstructor
@Builder
public class AgravoEntity {
    private UUID id;
    private String CID;
    private String nome;
    private Set<InformacaoAgravoEntity> informacoesEsperadas;

    public AgravoEntity(String CID){
        this.CID = CID;
    }
}