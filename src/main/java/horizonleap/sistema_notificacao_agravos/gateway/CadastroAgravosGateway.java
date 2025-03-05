package horizonleap.sistema_notificacao_agravos.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.sistema_notificacao_agravos.controller.CadastroAgravoController;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarInformacao;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cadastroAgravos")
public class CadastroAgravosGateway {

    @Autowired
    private CadastroAgravoController controller;

        
    @Operation(summary = "Cadastrar um agravo", tags = "Cadastro Agravos")
    @PostMapping("/")
    public ResponseEntity<AgravoEntity> cadastrarAgravo(@RequestBody RequisicaoCadastrarAgravoDTO requisicao) {
        
        return ResponseEntity.ok(controller.cadastrarAgravo(requisicao));
    }
        
    @Operation(summary = "Vincular uma informação adicionais a um agravo", tags = "Cadastro Agravos")
    @PostMapping("/informacao")
    public ResponseEntity<String> cadastrarInformacaoAgravo(@RequestBody RequisicaoCadastrarInformacao requisicao) {
        controller.cadastrarInformacao(requisicao);
        return ResponseEntity.ok("Ok");
    }

}
