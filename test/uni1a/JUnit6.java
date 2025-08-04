package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvestigadorTest {

    @Test
    void testInvestigador() {
        Investigador i = new Investigador("Ana", "Biología");
        assertEquals("Ana", i.getNombre());
        assertEquals("Biología", i.getEspecialidad());
    }
}
