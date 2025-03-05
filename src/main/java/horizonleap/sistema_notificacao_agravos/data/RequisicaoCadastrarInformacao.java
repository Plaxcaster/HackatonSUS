package horizonleap.sistema_notificacao_agravos.data;

import lombok.Data;

@Data
public class RequisicaoCadastrarInformacao {
    private String nome;
    private String cid;
    private String descricao;
    private String chaveJson;
}
