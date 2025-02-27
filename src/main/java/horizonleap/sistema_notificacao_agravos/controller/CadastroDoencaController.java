package horizonleap.sistema_notificacao_agravos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.useCases.CadastroDoencaUseCases;

@Component
public class CadastroDoencaController {

    private CadastroDoencaUseCases cadastroUseCases;

    public CadastroDoencaController(CadastroDoencaUseCases usecase) {
        this.cadastroUseCases = usecase;
    }

    public List<InformacaoAgravoEntity> consultarDadosParaColeta(String cid_doenca) {
        if (cid_doenca.isBlank()) {
            return Arrays.asList();
        }
        // TODO Criar validação do formato do CID
        return cadastroUseCases.consultaDadosParaColeta(cid_doenca);
    }

}
