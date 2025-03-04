package horizonleap.sistema_notificacao_agravos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.gateway.db.AgravoTable;

@Component
public interface AgravoRepository extends JpaRepository<AgravoTable, UUID>  {
    public AgravoTable findByCID(String Cid);
}
