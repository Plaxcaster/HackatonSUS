package horizonleap.sistema_notificacao_agravos.gateway;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.sistema_notificacao_agravos.DTO.RequisicaoRegistroAgravoDTO;
import horizonleap.sistema_notificacao_agravos.controller.CadastroDoencaController;
import horizonleap.sistema_notificacao_agravos.controller.NotificacaoAgravoController;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/notificarAgravo")
public class NotificarAgravoGateway {

    @Autowired
    CadastroDoencaController cadastroDoencaController;

    @Autowired
    NotificacaoAgravoController notificacaoAgravoController;

    @Operation(summary = "Consultar dados para coleta de um doença especifica", tags = "Notificar Agravo")
    @GetMapping("/{cid_doenca}")
    public ResponseEntity<Set<InformacaoAgravoEntity>> dadosParaColeta(@PathVariable String cid_doenca) {

        return ResponseEntity.ok(cadastroDoencaController.consultarDadosParaColeta(cid_doenca));
    }
    
    @Operation(summary = "Notificar um agravo", tags = "Notificar Agravo")
    @PostMapping("/")
    public ResponseEntity<String> postMethodName(@RequestBody RequisicaoRegistroAgravoDTO requisicao) {
        
        notificacaoAgravoController.registrarAgravo(requisicao);
        return ResponseEntity.ok("BLZ");
    }
    
}
