package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SeriesFileMalformedLineTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("malformed_series", ".csv");
        Files.writeString(temp, "T1,Género,notanumber,Netflix\n" + 
                                "Solo,Campo\n" +                  
                                "Correcta,Drama,45,HBO\n");       
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void leerSeriesIgnoraMalformadas() {
        List<SerieDeTV> leidas = SeriesFile.leerSeries(temp.toString());
        assertEquals(1, leidas.size());
        assertEquals("Correcta", leidas.get(0).getTitulo());
    }
}
