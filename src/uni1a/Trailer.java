package uni1a;

public class Trailer extends ContenidoAudiovisual {
    private Pelicula peliculaPromocionada;
    private String fechaLanzamiento;

    public Trailer(String titulo, String genero, int duracion, Pelicula peliculaPromocionada, String fechaLanzamiento) {
        super(titulo, genero, duracion);
        this.peliculaPromocionada = peliculaPromocionada;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void mostrarDetalles() {
        System.out.println("Trailer: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Fecha de lanzamiento: " + fechaLanzamiento);
        System.out.println("Promociona la película: " + peliculaPromocionada.getTitulo());
    }
}
