package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {

    @Test
    void testGettersYConstructor() {
        Pelicula p = new Pelicula("Título", "Acción", 100, "Director X", 2023);
        assertEquals("Título", p.getTitulo());
        assertEquals("Acción", p.getGenero());
        assertEquals(100, p.getDuracion());
        assertEquals("Director X", p.getDirector());
        assertEquals(2023, p.getAnio());
    }
}
