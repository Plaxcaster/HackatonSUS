package horizonleap.sistema_notificacao_agravos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;

@Component
public interface AgravoRepository extends JpaRepository<AgravoEntity, UUID>  {
    public AgravoEntity findByCID(String Cid);
}
