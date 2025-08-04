package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TemporadasFile {

    public static List<Temporada> leerTemporadas(String archivo) {
        List<Temporada> temporadas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    int numeroTemporada = Integer.parseInt(partes[0].trim());
                    int numeroEpisodios = Integer.parseInt(partes[1].trim());
                    temporadas.add(new Temporada(numeroTemporada, numeroEpisodios));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + archivo + ". Se continúa con lista vacía.");
        } catch (IOException e) {
            System.out.println("Error al leer temporadas: " + e.getMessage());
            e.printStackTrace();
        }
        return temporadas;
    }

    public static void guardarTemporadas(List<Temporada> temporadas, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Temporada t : temporadas) {
                bw.write(t.getNumero() + "," + t.getCantidadEpisodios());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar temporadas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

