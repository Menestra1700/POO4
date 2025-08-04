package uni1a;

import java.util.ArrayList;

public class Noticiero extends ContenidoAudiovisual {
    private String canal;
    private ArrayList<Documental> documentales;

    public Noticiero(String titulo, String genero, int duracion, String canal) {
        super(titulo, genero, duracion);
        this.canal = canal;
        this.documentales = new ArrayList<>();
    }

    public void agregarDocumental(Documental doc) {
        documentales.add(doc);
    }

    public void mostrarDetalles() {
        System.out.println("Noticiero: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Canal: " + canal);
        System.out.println("Documentales incluidos:");
        for (Documental d : documentales) {
            d.mostrarDetalles();
            System.out.println("-----");
        }
    }
}
