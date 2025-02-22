package horizonleap.sistema_notificacao_agravos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.useCases.CadastroDoencaUseCases;

@Component
public class CadastroDoencaController {

    private CadastroDoencaUseCases cadastroUseCases;

    public CadastroDoencaController(CadastroDoencaUseCases usecase){
        this.cadastroUseCases = usecase;
    }

    public List<String> consultarDadosParaColeta(Integer cid_doenca) {
        if (cid_doenca <= 0){
            return Arrays.asList();
        }

        return cadastroUseCases.consultaDadosParaColeta(cid_doenca);
    }

}
