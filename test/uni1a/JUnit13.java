package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class InvestigadoresFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("invest", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerInvestigadores() {
        Investigador i1 = new Investigador("Ana", "Biología");
        Investigador i2 = new Investigador("Luis", "Historia");
        List<Investigador> originales = List.of(i1, i2);
        InvestigadoresFile.guardarInvestigadores(originales, temp.toString());
        List<Investigador> leidos = InvestigadoresFile.leerInvestigadores(temp.toString());

        assertEquals(2, leidos.size());
        assertEquals("Ana", leidos.get(0).getNombre());
        assertEquals("Historia", leidos.get(1).getEspecialidad());
    }
}
