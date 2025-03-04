package horizonleap.sistema_notificacao_agravos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.NotificacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.NotificacaoAgravoId;

@Component
public interface NotificacaoAgravosRepository extends JpaRepository<NotificacaoAgravoEntity, NotificacaoAgravoId> {

}
