package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SeriesFile {

    public static List<SerieDeTV> leerSeries(String archivo) {
        List<SerieDeTV> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 4) {
                    continue; 
                }
                try {
                    String titulo = partes[0].trim();
                    String genero = partes[1].trim();
                    int duracion = Integer.parseInt(partes[2].trim());
                    String plataforma = partes[3].trim();
                    lista.add(new SerieDeTV(titulo, genero, duracion, plataforma));
                } catch (NumberFormatException e) {
                    System.out.println("Línea de serie ignorada por formato inválido: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer series: " + e.getMessage());
        }
        return lista;
    }

    public static void guardarSeries(List<SerieDeTV> series, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (SerieDeTV s : series) {
                String linea = s.getTitulo() + "," + s.getGenero() + "," + s.getDuracionPromedio() + "," + s.getPlataforma();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar series: " + e.getMessage());
        }
    }
}


