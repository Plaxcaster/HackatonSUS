package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class NotificacaoAgravoId implements Serializable {
    private AgravoEntity agravo;
    private LocalDateTime horaDeRegistro;
    private String cpf;
}
