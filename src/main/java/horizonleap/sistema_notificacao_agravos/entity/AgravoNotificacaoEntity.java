package horizonleap.sistema_notificacao_agravos.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

/** 
 * Notificação de um agravo específico para um paciente por um médico
 */
@Getter
@Builder
public class AgravoNotificacaoEntity {

    @NotNull
    private AgravoEntity agravo;
    private LocalDateTime horaDeRegistro;
    private String codigoCpf;
    private String codigoCep;
    private long identificacaoMedico;
}
