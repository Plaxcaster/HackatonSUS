package horizonleap.sistema_notificacao_agravos.useCases;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;

@Component
public class CadastroDoencaUseCases {

    @Autowired
    AgravoRepository repository;

    public Set<InformacaoAgravoEntity> consultaDadosParaColeta(String cid_doenca) {
        
        return repository.findByCID(cid_doenca).getInformacoesEsperadas();
    }
}
