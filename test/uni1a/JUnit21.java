package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DocumentalesControllerEdgeCasesTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        private final List<String> mensajes = new ArrayList<>();

        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuDocumentales() {}

        @Override
        public int leerOpcion() {
            return opciones.isEmpty() ? 3 : opciones.poll();
        }

        @Override
        public void mostrarMensaje(String msg) {
            mensajes.add(msg);
        }

        List<String> getMensajes() { return mensajes; }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("docs_ctrl_edge", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void listarVacioNoFalla() {
        StubView stub = new StubView(List.of(1, 3));
        DocumentalesController controller = new DocumentalesController(stub, temp.toString());
        controller.iniciar();
    }

    @Test
    void opcionInvalidaSeNotifica() {
        StubView stub = new StubView(List.of(-5, 3));
        DocumentalesController controller = new DocumentalesController(stub, temp.toString());
        controller.iniciar();
        assertTrue(stub.getMensajes().stream().anyMatch(m -> m.contains("Opción inválida")));
    }
}
