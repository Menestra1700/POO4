package uni1a;

import java.util.List;
import java.util.Scanner;

public class ConsolaView {
    private final Scanner scanner = new Scanner(System.in);
    private int leerEnteroSeguro(String mensaje) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(entrada);
                if (valor < 0) {
                    System.out.println("Por favor, ingrese un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, por favor ingrese un número válido.");
            }
        }
        return valor;
    }
    public void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE CONTENIDO AUDIOVISUAL ===");
        System.out.println("1. Películas");
        System.out.println("2. Series de TV");
        System.out.println("3. Documentales");
        System.out.println("4. Actores");
        System.out.println("5. Temporadas");
        System.out.println("6. Investigadores");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMenuPeliculas() {
        System.out.println("\n=== MENÚ PELÍCULAS ===");
        System.out.println("1. Listar películas");
        System.out.println("2. Agregar película");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public Pelicula pedirDatosPelicula() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        int duracion = leerEnteroSeguro("Duración (min): ");
        System.out.print("Director: ");
        String director = scanner.nextLine();
        int anio = leerEnteroSeguro("Año: ");
        return new Pelicula(titulo, genero, duracion, director, anio);
    }

    public void mostrarPeliculas(List<Pelicula> peliculas) {
        if (peliculas == null || peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (Pelicula p : peliculas) {
                p.mostrarDetalles();
                System.out.println("--");
            }
        }
    }

    public void mostrarMenuSeries() {
        System.out.println("\n=== MENÚ SERIES DE TV ===");
        System.out.println("1. Listar series");
        System.out.println("2. Agregar serie");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public SerieDeTV pedirDatosSerie() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        int duracion = leerEnteroSeguro("Duración promedio (min): ");
        System.out.print("Plataforma: ");
        String plataforma = scanner.nextLine();
        return new SerieDeTV(titulo, genero, duracion, plataforma);
    }

    public void mostrarSeries(List<SerieDeTV> series) {
        if (series == null || series.isEmpty()) {
            System.out.println("No hay series registradas.");
        } else {
            for (SerieDeTV s : series) {
                s.mostrarDetalles();
                System.out.println("--");
            }
        }
    }

    public void mostrarMenuDocumentales() {
        System.out.println("\n=== MENÚ DOCUMENTALES ===");
        System.out.println("1. Listar documentales");
        System.out.println("2. Agregar documental");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public Documental pedirDatosDocumental() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        int duracion = leerEnteroSeguro("Duración (min): ");
        System.out.print("Tema: ");
        String tema = scanner.nextLine();
        System.out.print("Narrador: ");
        String narrador = scanner.nextLine();
        return new Documental(titulo, genero, duracion, tema, narrador);
    }

    public void mostrarDocumentales(List<Documental> documentales) {
        if (documentales == null || documentales.isEmpty()) {
            System.out.println("No hay documentales registrados.");
        } else {
            for (Documental d : documentales) {
                d.mostrarDetalles();
                System.out.println("--");
            }
        }
    }

    public void mostrarMenuActores() {
        System.out.println("\n=== MENÚ ACTORES ===");
        System.out.println("1. Listar actores");
        System.out.println("2. Agregar actor");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public Actor pedirDatosActor() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int edad = leerEnteroSeguro("Edad: ");
        return new Actor(nombre, edad);
    }

    public void mostrarActores(List<Actor> actores) {
        if (actores == null || actores.isEmpty()) {
            System.out.println("No hay actores registrados.");
        } else {
            for (Actor a : actores) {
                a.mostrarInfo();
                System.out.println("--");
            }
        }
    }

    public void mostrarMenuTemporadas() {
        System.out.println("\n=== MENÚ TEMPORADAS ===");
        System.out.println("1. Listar temporadas");
        System.out.println("2. Agregar temporada");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public Temporada pedirDatosTemporada() {
        int numero = leerEnteroSeguro("Número de temporada: ");
        int episodios = leerEnteroSeguro("Cantidad de episodios: ");
        return new Temporada(numero, episodios);
    }

    public void mostrarTemporadas(List<Temporada> temporadas) {
        if (temporadas == null || temporadas.isEmpty()) {
            System.out.println("No hay temporadas registradas.");
        } else {
            for (Temporada t : temporadas) {
                t.mostrarInfo();
                System.out.println("--");
            }
        }
    }

    public void mostrarMenuInvestigadores() {
        System.out.println("\n=== MENÚ INVESTIGADORES ===");
        System.out.println("1. Listar investigadores");
        System.out.println("2. Agregar investigador");
        System.out.println("3. Volver");
        System.out.print("Opción: ");
    }

    public Investigador pedirDatosInvestigador() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        return new Investigador(nombre, especialidad);
    }

    public void mostrarInvestigadores(List<Investigador> investigadores) {
        if (investigadores == null || investigadores.isEmpty()) {
            System.out.println("No hay investigadores registrados.");
        } else {
            for (Investigador i : investigadores) {
                i.mostrarInfo();
                System.out.println("--");
            }
        }
    }
}

