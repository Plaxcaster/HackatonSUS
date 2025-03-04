package horizonleap.sistema_notificacao_agravos.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.DTO.RequisicaoRegistroAgravoDTO;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.NotificacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.NotificacaoAgravosRepository;

@Component
public class NotificacaoAgravoController {

    @Autowired
    AgravoRepository cadastroDoenca;

    @Autowired
    NotificacaoAgravosRepository notificacaoRepository;

    public void registrarAgravo(RequisicaoRegistroAgravoDTO requisicao) {
        notificacaoRepository.saveAndFlush(transformarRequisicaoEmEntidade(requisicao));

    }

    private NotificacaoAgravoEntity transformarRequisicaoEmEntidade(RequisicaoRegistroAgravoDTO dto) {
        AgravoEntity agravo = cadastroDoenca.findByCID(dto.cid());
        return new NotificacaoAgravoEntity(LocalDateTime.now(), agravo, dto.codigoCpf(), dto.codigoCep(),
                dto.identificacaoMedico());

    }
}
