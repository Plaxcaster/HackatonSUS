package horizonleap.sistema_notificacao_agravos.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.sistema_notificacao_agravos.controller.CadastroDoencaController;
import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/notificarAgravo")
public class NotificarAgravoGateway {

    @Autowired 
    CadastroDoencaController cadastroDoencaController;

   @Operation(summary = "Hello word" ,  tags = "Notificar Agravo")
   @GetMapping("/Helloworld")
    public ResponseEntity<String> HelloWorld() {

        return ResponseEntity.ok("Hello World!");
    }

   @Operation(summary = "Consultar dados para coleta de um doença especifica" ,  tags = "Notificar Agravo")
   @GetMapping("/{cid_doenca}")
    public ResponseEntity<List<InformacaoAgravoEntity>> dadosParaColeta(@PathVariable String cid_doenca) {

        return ResponseEntity.ok(cadastroDoencaController.consultarDadosParaColeta(cid_doenca));
    }
}
