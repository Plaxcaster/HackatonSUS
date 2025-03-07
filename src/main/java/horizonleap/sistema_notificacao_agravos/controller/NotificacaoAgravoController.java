package horizonleap.sistema_notificacao_agravos.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import horizonleap.sistema_notificacao_agravos.data.RequisicaoRegistroAgravo;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.NotificacaoAgravoEntity;
import horizonleap.sistema_notificacao_agravos.repository.AgravoRepository;
import horizonleap.sistema_notificacao_agravos.repository.NotificacaoAgravosRepository;

@Component
public class NotificacaoAgravoController {

    private final AgravoRepository agravoRepository;
    private final NotificacaoAgravosRepository notificacaoRepository;
    private final ObjectMapper objectMapper;

    public NotificacaoAgravoController(AgravoRepository agravoRepository,
            NotificacaoAgravosRepository notificacaoRepository,
            ObjectMapper objectMapper) {
        this.agravoRepository = agravoRepository;
        this.notificacaoRepository = notificacaoRepository;
        this.objectMapper = objectMapper;
    }


    public void registrarAgravo(RequisicaoRegistroAgravo requisicao) {
        notificacaoRepository.saveAndFlush(transformarRequisicaoEmEntidade(requisicao));
    }

    private NotificacaoAgravoEntity transformarRequisicaoEmEntidade(RequisicaoRegistroAgravo dto)   {
        AgravoEntity agravo = agravoRepository.findByCID(dto.getCid());
        JsonNode json;
        try{
            json = objectMapper.readTree(dto.getInformacoesJson().traverse());
        } catch(IOException e ){
            json = new ObjectMapper().createObjectNode();
        }
        return new NotificacaoAgravoEntity(LocalDateTime.now(), agravo.getId(), dto.getCodigoCpf(), dto.getCodigoCep(),
                dto.getIdentificacaoMedico() , json);
    }
}
