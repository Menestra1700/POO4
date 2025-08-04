package uni1a;

import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class PeliculasFileTest {

    private Path temp;

    @BeforeEach
    void setUp() throws Exception {
        temp = Files.createTempFile("pelis", ".csv");
    }

    @AfterEach
    void tearDown() throws Exception {
        Files.deleteIfExists(temp);
    }

    @Test
    void guardarYLeerPeliculas() {
        List<Pelicula> originales = List.of(
            new Pelicula("A", "Género", 90, "Dir", 2021),
            new Pelicula("B", "Comedia", 120, "Dir2", 2022)
        );
        PeliculasFile.guardarPeliculas(originales, temp.toString());
        List<Pelicula> leidas = PeliculasFile.leerPeliculas(temp.toString());

        assertEquals(2, leidas.size());
        assertEquals("A", leidas.get(0).getTitulo());
        assertEquals("Comedia", leidas.get(1).getGenero());
    }

    @Test
    void leerArchivoInexistenteDevuelveVacio() throws Exception {
        Path noExiste = temp.resolveSibling("no_existe.csv");
        Files.deleteIfExists(noExiste);
        List<Pelicula> leidas = PeliculasFile.leerPeliculas(noExiste.toString());
        assertNotNull(leidas);
        assertTrue(leidas.isEmpty());
    }
}
