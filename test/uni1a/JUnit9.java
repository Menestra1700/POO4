package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DocumentalesFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("docs", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerDocumentales() {
        Documental d1 = new Documental("D1", "Arte", 30, "Historia", "Narrador1");
        Documental d2 = new Documental("D2", "Ciencia", 45, "Física", "Narrador2");
        List<Documental> originales = List.of(d1, d2);
        DocumentalesFile.guardarDocumentales(originales, temp.toString());
        List<Documental> leidos = DocumentalesFile.leerDocumentales(temp.toString());

        assertEquals(2, leidos.size());
        assertEquals("D1", leidos.get(0).getTitulo());
        assertEquals("Física", leidos.get(1).getTema());
    }
}
