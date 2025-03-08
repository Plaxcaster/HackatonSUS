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
class NotificarAgravoGatewayIntegrationTest {

  @LocalServerPort
  private int port;

  @BeforeEach
  void setup(){
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

    @Test
    void deveConseguirBuscarCidExistente() {
      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .when()
      .get("/notificarAgravo/A03")
      .then()
      .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void deveConseguirBuscarCidComInformacoesCadastradas() {
      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .when()
      .get("/notificarAgravo/A01")
      .then()
      .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void deveRetornarObjectNotFoundSeCidNaoEstiverNoCadastro() {
      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .when()
      .get("/notificarAgravo/A04")
      .then()
      .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    void deveConseguirRegistrarAgravoSeminformacoesJson() {
      String body = "{\r\n" + //
                "  \"codigoCpf\": \"04740003112\",\r\n" + //
                "  \"codigoCep\": \"73020012\",\r\n" + //
                "  \"identificacaoMedico\": 555555,\r\n" + //
                "  \"cid\": \"A03\",\r\n" + //
                "  \"informacoesJson\": {}\r\n" + //
                "}";

      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(body)
      .when()
      .post("/notificarAgravo/")
      .then()
      .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void deveConseguirRegistrarAgravoCominformacoesJson() {
      String body = "{\r\n" + //
                "  \"codigoCpf\": \"04740003112\",\r\n" + //
                "  \"codigoCep\": \"73020012\",\r\n" + //
                "  \"identificacaoMedico\": 555555,\r\n" + //
                "  \"cid\": \"A02\",\r\n" + //
                "  \"informacoesJson\": {\"exterior\": \"0\"}\r\n" + //
                "}";

      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(body)
      .when()
      .post("/notificarAgravo/")
      .then()
      .statusCode(HttpStatus.SC_OK);
    }
}
