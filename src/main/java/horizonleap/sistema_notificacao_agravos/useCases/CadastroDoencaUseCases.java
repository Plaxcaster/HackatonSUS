package horizonleap.sistema_notificacao_agravos.useCases;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarInformacao;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.InformacaoAgravoRepository;

@Component
public class CadastroDoencaUseCases {

    @Autowired
    AgravoRepository agravoRepository;

    @Autowired
    InformacaoAgravoRepository informacaorepository;

    public Set<InformacaoAgravoEntity> consultaDadosParaColeta(String cid_doenca) {

        return agravoRepository.findByCID(cid_doenca).getInformacoesEsperadas();
    }

    public AgravoEntity cadastrarAgravo(RequisicaoCadastrarAgravoDTO requisicao) {
        AgravoEntity agravo = AgravoEntity.builder().CID(requisicao.getCid()).nome(requisicao.getNome())
                .id(UUID.randomUUID())
                .informacoesEsperadas(Set.of()).build();

        return agravoRepository.save(agravo);
    }

    public InformacaoAgravoEntity cadastrarInformacao(RequisicaoCadastrarInformacao requisicao) {
        AgravoEntity agravo = agravoRepository.findByCID(requisicao.getCid());

        InformacaoAgravoEntity informacao = new InformacaoAgravoEntity( requisicao.getNome(), agravo);
        informacaorepository.save(informacao);

        agravo.adicionarInformacoes(informacao);
        System.out.println(agravo.getId());
        agravo.getInformacoesEsperadas().forEach(i -> System.out.println(i.toString()));
        agravoRepository.save(agravo);

        return informacao;
    }
}
