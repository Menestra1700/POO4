package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DocumentalesControllerTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuDocumentales() {}
        @Override
        public int leerOpcion() { return opciones.isEmpty() ? 3 : opciones.poll(); }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("docs_ctrl", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void testAgregarDocumentalYLeer() {
        StubView stub = new StubView(List.of(2, 3));
        DocumentalesController controller = new DocumentalesController(stub, temp.toString());
        Documental d = new Documental("DocTest", "Histórico", 40, "Guerra", "NarradorZ");
        controller.getDocumentales().add(d);
        DocumentalesFile.guardarDocumentales(controller.getDocumentales(), temp.toString());
        List<Documental> leidos = DocumentalesFile.leerDocumentales(temp.toString());
        assertEquals(1, leidos.size());
        assertEquals("DocTest", leidos.get(0).getTitulo());
    }
}

