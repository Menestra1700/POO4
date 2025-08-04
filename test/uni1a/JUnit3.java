package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DocumentalTest {

    @Test
    void testGetters() {
        Documental d = new Documental("Doc", "Ciencia", 30, "Espacio", "Narrador Y");
        assertEquals("Doc", d.getTitulo());
        assertEquals("Ciencia", d.getGenero());
        assertEquals(30, d.getDuracion());
        assertEquals("Espacio", d.getTema());
        assertEquals("Narrador Y", d.getNarrador());
    }
}
