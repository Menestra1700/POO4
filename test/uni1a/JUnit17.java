package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TemporadasControllerTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuTemporadas() {}
        @Override
        public int leerOpcion() { return opciones.isEmpty() ? 3 : opciones.poll(); }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("temps_ctrl", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void testAgregarTemporadaYLeer() {
        StubView stub = new StubView(List.of(2, 3));
        TemporadasController controller = new TemporadasController(stub, temp.toString());
        Temporada t = new Temporada(5, 12);
        controller.getTemporadas().add(t);
        TemporadasFile.guardarTemporadas(controller.getTemporadas(), temp.toString());
        List<Temporada> leidas = TemporadasFile.leerTemporadas(temp.toString());
        assertEquals(1, leidas.size());
        assertEquals(5, leidas.get(0).getNumero());
    }
}
