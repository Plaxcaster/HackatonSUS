package horizonleap.sistema_notificacao_agravos.gateway.db;

import horizonleap.sistema_notificacao_agravos.entity.AgravoNotificacaoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notificacao_agravo")
public class NotificacaoAgravoTableEntity {
    @EmbeddedId
    private NotificacaoAgravoTableId id;
    @Column
    private String codigoCep;
    @Column
    private long identificacaoMedico;

    public AgravoNotificacaoEntity toAgravoNotificacaoEntity() {
        return AgravoNotificacaoEntity.builder()
                .agravo(id.getAgravo().toAgravoEntity())
                .codigoCpf(id.getCodigoCpf())
                .horaDeRegistro(id.getHoraDeRegistro())
                .codigoCep(codigoCep)
                .identificacaoMedico(identificacaoMedico)
                .build();
    }
}
