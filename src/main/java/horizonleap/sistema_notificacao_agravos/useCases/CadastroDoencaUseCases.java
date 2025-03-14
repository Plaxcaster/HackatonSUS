package horizonleap.sistema_notificacao_agravos.useCases;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarInformacao;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.InformacaoAgravoRepository;

@Component
public class CadastroDoencaUseCases {

    private final AgravoRepository agravoRepository;
    private final InformacaoAgravoRepository informacaorepository;

    public CadastroDoencaUseCases(AgravoRepository agravoRepository,
            InformacaoAgravoRepository informacaorepository) {
        this.informacaorepository = informacaorepository;
        this.agravoRepository = agravoRepository;
    }

    public Set<InformacaoAgravoEntity> consultaDadosParaColeta(String cid_doenca) throws ObjectNotFoundException {

        return Optional.ofNullable(agravoRepository.findByCID(cid_doenca))
                .map(resultado -> resultado.getInformacoesEsperadas())
                .orElseThrow(() -> new ObjectNotFoundException(new InformacaoAgravoEntity(), "informações do agravo"));
    }

    public AgravoEntity cadastrarAgravo(RequisicaoCadastrarAgravoDTO requisicao) {
        AgravoEntity agravo = AgravoEntity.builder().CID(requisicao.getCid()).nome(requisicao.getNome())
                .id(UUID.randomUUID())
                .informacoesEsperadas(Set.of()).build();

        return agravoRepository.save(agravo);
    }

    public InformacaoAgravoEntity cadastrarInformacao(RequisicaoCadastrarInformacao requisicao) {
        AgravoEntity agravo = agravoRepository.findByCID(requisicao.getCid());

        InformacaoAgravoEntity informacao = new InformacaoAgravoEntity(requisicao.getNome(), agravo,
                requisicao.getChaveJson(), requisicao.getDescricao());
        informacaorepository.save(informacao);

        agravo.adicionarInformacoes(informacao);
        agravoRepository.save(agravo);

        return informacao;
    }
}
