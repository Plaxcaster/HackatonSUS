package horizonleap.sistema_notificacao_agravos.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.sistema_notificacao_agravos.DTO.RequisicaoRegistroAgravoDTO;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.AgravoNotificacaoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.NotificacaoAgravosRepository;

@Component
public class NotificacaoAgravoController {

    @Autowired
    AgravoRepository cadastroDoenca;

    @Autowired
    NotificacaoAgravosRepository notificacaoRepository;

    public void registrarAgravo(RequisicaoRegistroAgravoDTO requisicao) {
        notificacaoRepository.registrarAgravo(transformarRequisicaoEmEntidade(requisicao));

    }

    private AgravoNotificacaoEntity transformarRequisicaoEmEntidade(RequisicaoRegistroAgravoDTO registroDto) {
        AgravoEntity agravo = cadastroDoenca.findByCID(registroDto.cid()).toAgravoEntity();

        return AgravoNotificacaoEntity.builder()
                .codigoCep(registroDto.codigoCep())
                .codigoCpf(registroDto.codigoCpf())
                .identificacaoMedico(registroDto.identificacaoMedico())
                .horaDeRegistro(LocalDateTime.now())
                .agravo(agravo)
                .build();
    }
}
