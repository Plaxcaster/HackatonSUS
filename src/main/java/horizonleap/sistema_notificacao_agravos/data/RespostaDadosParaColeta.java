package horizonleap.sistema_notificacao_agravos.data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import lombok.Data;

@Data
public class RespostaDadosParaColeta {
    private Set<RespostaInformacaoAgravo> conjunto;

    public static RespostaDadosParaColeta toRespostaDadosParaColeta(Collection<InformacaoAgravoEntity> colecao) {
        var resposta = new RespostaDadosParaColeta();
        Set<RespostaInformacaoAgravo> conjunto = new HashSet<>();

        colecao.forEach(item -> conjunto.add(RespostaInformacaoAgravo.toRespostaInformacaoAgravo(item)));
        resposta.setConjunto(conjunto);
        
        return resposta;
    }
}
