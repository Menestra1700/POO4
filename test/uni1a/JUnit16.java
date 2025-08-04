package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ActoresControllerTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuActores() {}
        @Override
        public int leerOpcion() { return opciones.isEmpty() ? 3 : opciones.poll(); }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("actores_ctrl", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void testAgregarActorYLeer() {
        StubView stub = new StubView(List.of(2, 3));
        ActoresController controller = new ActoresController(stub, temp.toString());
        Actor a = new Actor("Prueba", 50);
        controller.getActores().add(a);
        ActoresFile.guardarActores(controller.getActores(), temp.toString());
        List<Actor> leidos = ActoresFile.leerActores(temp.toString());
        assertEquals(1, leidos.size());
        assertEquals("Prueba", leidos.get(0).getNombre());
    }
}
