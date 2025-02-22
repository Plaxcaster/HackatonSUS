package horizonleap.sistema_notificacao_agravos.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import horizonleap.sistema_notificacao_agravos.useCases.CadastroDoencaUseCases;

public class CadastroDoencaControllerTest {
    private CadastroDoencaController controller;

    @Mock
    private CadastroDoencaUseCases useCases;

    AutoCloseable openMock;

    @BeforeEach
    void setup() {
        openMock = MockitoAnnotations.openMocks(this);
        controller = new CadastroDoencaController(useCases);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMock.close();
    }

    @Test
    void verificaComportamentoComCIDZerado() {
        assertThat(controller.consultarDadosParaColeta(0)).isNotNull();
        assertThat(controller.consultarDadosParaColeta(0).isEmpty());
    }

    @Test
    void verificaComportamentoParaCidValido() {
        List<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("cor favorita");
        listaEsperada.add("signo");

        when(useCases.consultaDadosParaColeta(1)).thenReturn(listaEsperada);

        assertThat(controller.consultarDadosParaColeta(0)).isNotNull();
        assertThat(controller.consultarDadosParaColeta(1)).isNotEmpty();
        assertThat(controller.consultarDadosParaColeta(1)).isEqualTo(listaEsperada);

    }
}
