package uni1a;

public abstract class ContenidoAudiovisual {
    protected String titulo;
    protected String genero;
    protected int duracion; 

    public ContenidoAudiovisual(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public abstract void mostrarDetalles();
}
