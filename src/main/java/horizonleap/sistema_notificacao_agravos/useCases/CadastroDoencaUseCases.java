package horizonleap.sistema_notificacao_agravos.useCases;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity.AgravoEntityBuilder;

@Component
public class CadastroDoencaUseCases {

    public Set<InformacaoAgravoEntity> consultaDadosParaColeta(String cid_doenca) {
        
        return mockDeConsultaDeCid(cid_doenca).getInformacoesEsperadas();
    }

    private AgravoEntity mockDeConsultaDeCid(String cid){
        AgravoEntityBuilder builder = AgravoEntity.builder().id(UUID.randomUUID()).CID(cid);
        var info1 = new InformacaoAgravoEntity(UUID.randomUUID(), "contato com animais");
        var info2 = new InformacaoAgravoEntity(UUID.randomUUID(), "contato com plantas carnivoras");

        builder.informacoesEsperadas(Set.of(info1 , info2));

        if (cid.equals("A01")){
            builder.nome("Febra Tifoide");
        } else if(cid.equals("A02")){
            builder.nome("salmonela");
        } else {
            builder.nome("outras Infecções");
        }

        return builder.build();
    }
}
