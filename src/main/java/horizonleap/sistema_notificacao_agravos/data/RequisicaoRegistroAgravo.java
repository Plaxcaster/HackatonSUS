package horizonleap.sistema_notificacao_agravos.data;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class RequisicaoRegistroAgravo {
    private String codigoCpf;
    private String codigoCep;
    private long identificacaoMedico;
    private String cid;
    
    private JsonNode informacoesJson;

}
