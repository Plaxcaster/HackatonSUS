package horizonleap.sistema_notificacao_agravos.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Notificação de um agravo específico para um paciente por um médico
 */
@Getter
@Entity
@Table(name = "NOTIFICACAO_AGRAVO")
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoAgravoEntity {
    @EmbeddedId
    private NotificacaoAgravoId Id;
    @Column
    private String codigoCep;
    @Column
    private long identificacaoMedico;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "informacoes", columnDefinition = "jsonb")
    private JsonNode informacoes;

    public UUID getAgravoId() {
        return Id.getAgravoId();
    }

    public LocalDateTime getHoraDeRegistro() {
        return Id.getHoraDeRegistro();
    }

    public String getCpf() {
        return Id.getCpf();
    }

    public void setAgravo(UUID agravo) {
        this.Id.setAgravoId(agravo);
    }

    public void setHoraRegistro(LocalDateTime horaDeRegistro) {
        this.Id.setHoraDeRegistro(horaDeRegistro);
    }

    public void setCpf(String cpf) {
        this.Id.setCpf(cpf);
    }

    /**
     * @param id
     * @param codigoCep
     * @param identificacaoMedico
     */
    public NotificacaoAgravoEntity(LocalDateTime horarioDeRegistro, UUID agravo, String cpf, String codigoCep,
            long identificacaoMedico , JsonNode json) {
        this.Id = new NotificacaoAgravoId(agravo, horarioDeRegistro, cpf);
        this.codigoCep = codigoCep;
        this.identificacaoMedico = identificacaoMedico;
        this.informacoes = json;
    }

}
