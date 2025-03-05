package horizonleap.sistema_notificacao_agravos.controller;

import java.util.Set;

import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarInformacao;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.useCases.CadastroDoencaUseCases;

@Component
public class CadastroAgravoController {

    private CadastroDoencaUseCases cadastroUseCases;

    public CadastroAgravoController(CadastroDoencaUseCases usecase) {
        this.cadastroUseCases = usecase;
    }

    public Set<InformacaoAgravoEntity> consultarDadosParaColeta(String cid_doenca) {
        if (cid_doenca.isBlank()) {
            return Set.of();
        }
        // TODO Criar validação do formato do CID
        return cadastroUseCases.consultaDadosParaColeta(cid_doenca);
    }

    public AgravoEntity cadastrarAgravo(RequisicaoCadastrarAgravoDTO requisicao) {
        return cadastroUseCases.cadastrarAgravo(requisicao);
    }

    public InformacaoAgravoEntity cadastrarInformacao(RequisicaoCadastrarInformacao requisicao) {
        return cadastroUseCases.cadastrarInformacao(requisicao);

    }

}
