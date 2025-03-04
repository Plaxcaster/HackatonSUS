package horizonleap.sistema_notificacao_agravos.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import horizonleap.sistema_notificacao_agravos.entity.InformacaoAgravoEntity;
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
        assertThat(controller.consultarDadosParaColeta("")).isNotNull();
        assertThat(controller.consultarDadosParaColeta("").isEmpty());
    }

    @Test
    void verificaComportamentoParaCidValido() {
        Set<InformacaoAgravoEntity> listaEsperada = Set.of();
        listaEsperada.add(new InformacaoAgravoEntity(UUID.randomUUID(), "item 1"));
        listaEsperada.add(new InformacaoAgravoEntity(UUID.randomUUID(), "item 2"));

        when(useCases.consultaDadosParaColeta("A70")).thenReturn(listaEsperada);


        assertThat(controller.consultarDadosParaColeta("AAA")).isNotNull();
        assertThat(controller.consultarDadosParaColeta("AAA")).isEmpty();
        assertThat(controller.consultarDadosParaColeta("A70")).isNotEmpty();
        assertThat(controller.consultarDadosParaColeta("A70")).isEqualTo(listaEsperada);

    }
}
 