package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemporadaTest {

    @Test
    void testTemporada() {
        Temporada t = new Temporada(2, 10);
        assertEquals(2, t.getNumero());
        assertEquals(10, t.getCantidadEpisodios());
    }
}
