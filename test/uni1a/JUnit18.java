package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class InvestigadoresControllerTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuInvestigadores() {}
        @Override
        public int leerOpcion() { return opciones.isEmpty() ? 3 : opciones.poll(); }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("invest_ctrl", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void testAgregarInvestigadorYLeer() {
        StubView stub = new StubView(List.of(2, 3));
        InvestigadoresController controller = new InvestigadoresController(stub, temp.toString());
        Investigador i = new Investigador("Carmen", "Sociología");
        controller.getInvestigadores().add(i);
        InvestigadoresFile.guardarInvestigadores(controller.getInvestigadores(), temp.toString());
        List<Investigador> leidos = InvestigadoresFile.leerInvestigadores(temp.toString());
        assertEquals(1, leidos.size());
        assertEquals("Carmen", leidos.get(0).getNombre());
    }
}
