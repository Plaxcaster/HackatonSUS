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
    void testDadosParaColeta() {
      given().filter(new AllureRestAssured())
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .when()
      .get("/notificarAgravo/A01")
      .then()
      .statusCode(HttpStatus.SC_OK);
    }
}
