package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerieDeTVTest {

    @Test
    void testAgregarYObtenerTemporadas() {
        SerieDeTV s = new SerieDeTV("Serie", "Drama", 50, "Netflix");
        assertTrue(s.getTemporadas().isEmpty());
        s.agregarTemporada(new Temporada(1, 8));
        assertEquals(1, s.getTemporadas().size());
        Temporada t = s.getTemporadas().get(0);
        assertEquals(1, t.getNumero());
        assertEquals(8, t.getCantidadEpisodios());
    }
}
