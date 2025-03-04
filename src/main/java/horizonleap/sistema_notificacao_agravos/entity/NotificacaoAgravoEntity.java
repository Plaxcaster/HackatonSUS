package horizonleap.sistema_notificacao_agravos.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

/**
 * Notificação de um agravo específico para um paciente por um médico
 */
@Getter
@Entity
@Table(name = "NOTIFICACAO_AGRAVO")
public class NotificacaoAgravoEntity {
    @EmbeddedId
    private NotificacaoAgravoId Id;
    @Column
    private String codigoCep;
    @Column
    private long identificacaoMedico;

    public AgravoEntity getAgravo() {
        return Id.getAgravo();
    }

    public LocalDateTime getHoraDeRegistro() {
        return Id.getHoraDeRegistro();
    }

    public String getCpf() {
        return Id.getCpf();
    }

    public void setAgravo(AgravoEntity agravo) {
        this.Id.setAgravo(agravo);
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
    public NotificacaoAgravoEntity(LocalDateTime horarioDeRegistro, AgravoEntity agravo, String cpf, String codigoCep,
            long identificacaoMedico) {
        this.Id = new NotificacaoAgravoId(agravo, horarioDeRegistro, cpf);
        this.codigoCep = codigoCep;
        this.identificacaoMedico = identificacaoMedico;
    }

}
