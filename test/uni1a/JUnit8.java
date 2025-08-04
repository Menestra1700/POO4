package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SeriesFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("series", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerSeries() {
        SerieDeTV s1 = new SerieDeTV("S1", "SciFi", 40, "Netflix");
        SerieDeTV s2 = new SerieDeTV("S2", "Drama", 50, "HBO");
        List<SerieDeTV> originales = List.of(s1, s2);
        SeriesFile.guardarSeries(originales, temp.toString());
        List<SerieDeTV> leidas = SeriesFile.leerSeries(temp.toString());

        assertEquals(2, leidas.size());
        assertEquals("S1", leidas.get(0).getTitulo());
        assertEquals("Drama", leidas.get(1).getGenero());
    }
}
