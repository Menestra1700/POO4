package uni1a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @Test
    void testActor() {
        Actor a = new Actor("Juan", 40);
        assertEquals("Juan", a.getNombre());
        assertEquals(40, a.getEdad());
    }
}
