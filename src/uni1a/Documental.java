package uni1a;

public class Documental {
    private String titulo;
    private String genero;
    private int duracion;
    private String tema;
    private String narrador;

    public Documental(String titulo, String genero, int duracion, String tema, String narrador) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.tema = tema;
        this.narrador = narrador;
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

    public String getTema() {
        return tema;
    }

    public String getNarrador() {
        return narrador;
    }

    public void mostrarDetalles() {
        System.out.println("Documental: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Tema: " + tema);
        System.out.println("Narrador: " + narrador);
    }
}

