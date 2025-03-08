package horizonleap.sistema_notificacao_agravos.gateway;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.sistema_notificacao_agravos.controller.CadastroAgravoController;
import horizonleap.sistema_notificacao_agravos.controller.NotificacaoAgravoController;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoRegistroAgravo;
import horizonleap.sistema_notificacao_agravos.data.RespostaDadosParaColeta;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/notificarAgravo")
public class NotificarAgravoGateway {

    private final CadastroAgravoController cadastroDoencaController;
    private final NotificacaoAgravoController notificacaoAgravoController;

    public NotificarAgravoGateway(CadastroAgravoController cadastroDoencaController,
            NotificacaoAgravoController notificacaoAgravoController) {
        this.cadastroDoencaController = cadastroDoencaController;
        this.notificacaoAgravoController = notificacaoAgravoController;
    }

    @Operation(summary = "Consultar dados para coleta de um doença especifica", tags = "Notificar Agravo")
    @GetMapping("/{cid_doenca}")
    public ResponseEntity<RespostaDadosParaColeta> dadosParaColeta(@PathVariable String cid_doenca) {
        try {

            return Optional.ofNullable(cadastroDoencaController.consultarDadosParaColeta(cid_doenca))
                    .map(resultado -> ResponseEntity.ok()
                            .body(RespostaDadosParaColeta.toRespostaDadosParaColeta(resultado)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Notificar um agravo", tags = "Notificar Agravo")
    @PostMapping("/")
    public ResponseEntity<String> postMethodName(@RequestBody RequisicaoRegistroAgravo requisicao) {

        notificacaoAgravoController.registrarAgravo(requisicao);
        return ResponseEntity.ok("BLZ");
    }

}
