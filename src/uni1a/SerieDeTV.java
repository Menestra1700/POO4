package uni1a;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV {
    private String titulo;
    private String genero;
    private int duracionPromedio;
    private String plataforma;
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, String genero, int duracionPromedio, String plataforma) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracionPromedio = duracionPromedio;
        this.plataforma = plataforma;
        this.temporadas = new ArrayList<>();
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracionPromedio() { return duracionPromedio; }
    public String getPlataforma() { return plataforma; }
    public List<Temporada> getTemporadas() { return temporadas; }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }
    
    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    public void mostrarDetalles() {
        System.out.println("Serie: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración promedio: " + duracionPromedio + " min");
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Temporadas: " + temporadas.size());
    }
}
