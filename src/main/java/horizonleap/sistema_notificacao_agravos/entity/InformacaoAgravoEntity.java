package horizonleap.sistema_notificacao_agravos.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 
 * Descrição de uma informação que pode ser incluída como informação adicional de um registro de agravo
 */
@Getter
@AllArgsConstructor
public class InformacaoAgravoEntity {

    private UUID id;
    private String nome;
}
