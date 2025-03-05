package horizonleap.sistema_notificacao_agravos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class NotificacaoAgravoId implements Serializable {
    private UUID agravoId;
    private LocalDateTime horaDeRegistro;
    private String cpf;
}
