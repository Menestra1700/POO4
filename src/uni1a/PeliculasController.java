package uni1a;

import java.util.List;
import java.util.ArrayList;

public class PeliculasController {
    private final ConsolaView view;
    private final String archivo;
    private List<Pelicula> peliculas;

    public PeliculasController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.peliculas = PeliculasFile.leerPeliculas(archivo);
        if (peliculas == null) peliculas = new ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuPeliculas(); 
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarPeliculas(peliculas);
                case 2 -> {
                    Pelicula nueva = view.pedirDatosPelicula();
                    peliculas.add(nueva);
                    PeliculasFile.guardarPeliculas(peliculas, archivo);
                    view.mostrarMensaje("Película guardada.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }
}

