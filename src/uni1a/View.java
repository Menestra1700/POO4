package uni1a;

import uni1a.Pelicula;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("=== SISTEMA DE CONTENIDO AUDIOVISUAL ===");
        System.out.println("1. Listar películas");
        System.out.println("2. Agregar película");
        System.out.println("3. Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public Pelicula pedirDatosPelicula() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Duración (min): ");
        int duracion = Integer.parseInt(scanner.nextLine());
        System.out.print("Director: ");
        String director = scanner.nextLine();
        System.out.print("Año: ");
        int anio = Integer.parseInt(scanner.nextLine());
        return new Pelicula(titulo, genero, duracion, director, anio);
    }

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (Pelicula p : peliculas) {
                p.mostrarDetalles();
                System.out.println("--");
            }
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
