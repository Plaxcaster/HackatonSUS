package horizonleap.sistema_notificacao_agravos.gateway.db;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class NotificacaoAgravoTableId implements Serializable {
    private AgravoTable agravo;
    private LocalDateTime horaDeRegistro;
    private String codigoCpf;

}
