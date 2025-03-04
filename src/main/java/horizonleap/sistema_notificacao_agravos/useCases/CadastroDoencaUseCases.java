package horizonleap.sistema_notificacao_agravos.useCases;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;

@Component
public class CadastroDoencaUseCases {

    @Autowired
    AgravoRepository repository;

    public Set<InformacaoAgravoEntity> consultaDadosParaColeta(String cid_doenca) {

        return repository.findByCID(cid_doenca).getInformacoesEsperadas();
    }

    public AgravoEntity cadastrarAgravo(RequisicaoCadastrarAgravoDTO requisicao) {
        AgravoEntity agravo = AgravoEntity.builder().CID(requisicao.getCid()).nome(requisicao.getNome()).id(UUID.randomUUID())
                .informacoesEsperadas(Set.of()).build();

        return repository.save(agravo);
    }
}
