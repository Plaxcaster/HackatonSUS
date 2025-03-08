package horizonleap.sistema_notificacao_agravos.gateway;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

@Sql("setup.sql")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroAgravosGatewayTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void deveCadastrarUmAgravoNovo() {
        String body = "{\r\n" + //
                "  \"cid\": \"A070\",\r\n" + //
                "  \"nome\": \"nome doença\"\r\n" + //
                "}";

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(body)
                .when()
                .post("/cadastroAgravos/")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void naoDevePermitirAgravoRepetido() {
        String body = "{\r\n" + //
                "  \"cid\": \"A02\",\r\n" + //
                "  \"nome\": \"nome doença\"\r\n" + //
                "}";

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(body)
                .when()
                .post("/cadastroAgravos/")
                .then()
                .statusCode(HttpStatus.SC_CONFLICT);
    }

    @Test
    void testCadastrarInformacaoAgravo() {
        String body = "{\r\n" + //
                "  \"nome\": \"Teste informacao\",\r\n" + //
                "  \"cid\": \"A02\",\r\n" + //
                "  \"descricao\": \"Informação a ser incluída\",\r\n" + //
                "  \"chaveJson\": \"chaveJson\"\r\n" + //
                "}";

        given().filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(body)
                .when()
                .post("/cadastroAgravos/informacao")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
