package uni1a;

public class Pelicula extends ContenidoAudiovisual {
    private String director;
    private int anio;

    public Pelicula(String titulo, String genero, int duracion, String director, int anio) {
        super(titulo, genero, duracion);
        this.director = director;
        this.anio = anio;
    }

    public void mostrarDetalles() {
        System.out.println("Película: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Director: " + director);
        System.out.println("Año: " + anio);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDirector() {
        return director;
    }

    public int getAnio() {
        return anio;
    }
}
