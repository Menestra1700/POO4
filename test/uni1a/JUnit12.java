package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TemporadasFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("temps", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerTemporadas() {
        Temporada t1 = new Temporada(1, 5);
        Temporada t2 = new Temporada(2, 10);
        List<Temporada> originales = List.of(t1, t2);
        TemporadasFile.guardarTemporadas(originales, temp.toString());
        List<Temporada> leidas = TemporadasFile.leerTemporadas(temp.toString());

        assertEquals(2, leidas.size());
        assertEquals(1, leidas.get(0).getNumero());
        assertEquals(10, leidas.get(1).getCantidadEpisodios());
    }
}
