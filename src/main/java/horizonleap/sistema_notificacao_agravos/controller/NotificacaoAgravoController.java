package horizonleap.sistema_notificacao_agravos.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoRegistroAgravo;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.NotificacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.NotificacaoAgravosRepository;

@Component
public class NotificacaoAgravoController {

    @Autowired
    AgravoRepository agravoRepository;

    @Autowired
    NotificacaoAgravosRepository notificacaoRepository;

    public void registrarAgravo(RequisicaoRegistroAgravo requisicao) {
        notificacaoRepository.saveAndFlush(transformarRequisicaoEmEntidade(requisicao));
    }

    private NotificacaoAgravoEntity transformarRequisicaoEmEntidade(RequisicaoRegistroAgravo dto) {
        AgravoEntity agravo = agravoRepository.findByCID(dto.getCid());
        return new NotificacaoAgravoEntity(LocalDateTime.now(), agravo.getId(), dto.getCodigoCpf(), dto.getCodigoCep(),
                dto.getIdentificacaoMedico());
    }
}
