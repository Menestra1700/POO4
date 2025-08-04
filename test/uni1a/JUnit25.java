package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class PeliculasFileMalformedLineTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("malformed_pelis", ".csv");
        Files.writeString(temp, "Titulo,Género,notanumber,Director,2022\n" +
                                "Solo,2,3\n" +
                                "Bien,Comedia,90,Dir,2021\n");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void leerIgnoraLineasMalformadasYParseaBien() {
        List<Pelicula> leidas = PeliculasFile.leerPeliculas(temp.toString());
        assertEquals(1, leidas.size());
        assertEquals("Bien", leidas.get(0).getTitulo());
    }
}
