package horizonleap.sistema_notificacao_agravos.data;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import lombok.Data;

@Data
public class RespostaInformacaoAgravo {
    private String nome;
    private String chaveJson;
    private String descricao;

    public static RespostaInformacaoAgravo toRespostaInformacaoAgravo(InformacaoAgravoEntity entity){
        var resposta = new RespostaInformacaoAgravo();
        resposta.setNome(entity.getNome());
        resposta.setChaveJson(entity.getChaveJson());
        resposta.setDescricao(entity.getDescricao());

        return resposta;
    }
}
