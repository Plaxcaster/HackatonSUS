package horizonleap.sistema_notificacao_agravos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;

@Component
public interface InformacaoAgravoRepository extends JpaRepository<InformacaoAgravoEntity, UUID>{

}
