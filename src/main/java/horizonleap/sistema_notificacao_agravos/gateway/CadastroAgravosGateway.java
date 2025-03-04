package horizonleap.sistema_notificacao_agravos.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.sistema_notificacao_agravos.controller.CadastroAgravoController;
import horizonleap.sistema_notificacao_agravos.data.RequisicaoCadastrarAgravoDTO;
import horizonleap.sistema_notificacao_agravos.entity.AgravoEntity;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cadastroAgravos")
public class CadastroAgravosGateway {

    @Autowired
    private CadastroAgravoController controller;

        
    @Operation(summary = "Cadastrar um agravo", tags = "Cadastro Agravos")
    @PostMapping("/")
    public ResponseEntity<AgravoEntity> postMethodName(@RequestBody RequisicaoCadastrarAgravoDTO requisicao) {
        
        return ResponseEntity.ok(controller.cadastrarAgravo(requisicao));
    }

}
