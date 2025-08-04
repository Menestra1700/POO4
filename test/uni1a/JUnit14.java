package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SeriesControllerTest {

    static class StubView extends ConsolaView {
        private final Queue<Integer> opciones;
        StubView(List<Integer> seq) { super(); opciones = new ArrayDeque<>(seq); }

        @Override
        public void mostrarMenuSeries() {}
        @Override
        public int leerOpcion() { return opciones.isEmpty() ? 3 : opciones.poll(); }
    }

    private Path temp;

    @BeforeEach
    void setup() throws Exception {
        temp = Files.createTempFile("series_ctrl", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void testAgregarYGuardarSerie() {
        StubView stub = new StubView(List.of(2, 3));
        SeriesController controller = new SeriesController(stub, temp.toString());
        SerieDeTV s = new SerieDeTV("STest", "Thriller", 55, "Prime");
        controller.getSeries().add(s);
        SeriesFile.guardarSeries(controller.getSeries(), temp.toString());
        List<SerieDeTV> leidas = SeriesFile.leerSeries(temp.toString());
        assertEquals(1, leidas.size());
        assertEquals("STest", leidas.get(0).getTitulo());
    }
}
