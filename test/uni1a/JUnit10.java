package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ActoresFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("actores", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerActores() {
        Actor a1 = new Actor("Juan", 30);
        Actor a2 = new Actor("María", 25);
        List<Actor> originales = List.of(a1, a2);
        ActoresFile.guardarActores(originales, temp.toString());
        List<Actor> leidos = ActoresFile.leerActores(temp.toString());

        assertEquals(2, leidos.size());
        assertEquals("Juan", leidos.get(0).getNombre());
        assertEquals(25, leidos.get(1).getEdad());
    }
}
