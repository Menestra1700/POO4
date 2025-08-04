package uni1a;

public class Temporada {
    private int numero;
    private int cantidadEpisodios;

    public Temporada(int numero, int cantidadEpisodios) {
        this.numero = numero;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public void mostrarInfo() {
        System.out.println("Temporada " + numero + " | Episodios: " + cantidadEpisodios);
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }
}
