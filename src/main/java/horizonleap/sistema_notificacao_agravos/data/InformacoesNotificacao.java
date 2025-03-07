package horizonleap.sistema_notificacao_agravos.data;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformacoesNotificacao implements Serializable {
    private JsonNode json;
}
