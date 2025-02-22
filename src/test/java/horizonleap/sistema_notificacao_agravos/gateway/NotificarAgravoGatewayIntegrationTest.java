package horizonleap.sistema_notificacao_agravos.gateway;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificarAgravoGatewayIntegrationTest {

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setup(){
    RestAssured.port = port;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

    @Test
    void testHelloWorld() {
        given().filter(new AllureRestAssured())
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .when()
        .get("/notificarAgravo/Helloworld")
        .then()
        .statusCode(HttpStatus.SC_OK);
    }

    @Test
    void testDadosParaColeta() {

    }
}
