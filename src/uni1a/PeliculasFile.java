package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculasFile {

    public static void guardarPeliculas(List<Pelicula> peliculas, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Pelicula p : peliculas) {
                String linea = p.getTitulo() + "," + p.getGenero() + "," + p.getDuracion() + "," + p.getDirector() + "," + p.getAnio();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar películas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Pelicula> leerPeliculas(String archivo) {
        List<Pelicula> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 5) {
                    continue;
                }
                try {
                    String titulo = partes[0].trim();
                    String genero = partes[1].trim();
                    int duracion = Integer.parseInt(partes[2].trim());
                    String director = partes[3].trim();
                    int anio = Integer.parseInt(partes[4].trim());
                    lista.add(new Pelicula(titulo, genero, duracion, director, anio));
                } catch (NumberFormatException e) {
                    System.out.println("Línea ignorada por formato inválido: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer películas: " + e.getMessage());
        }
        return lista;
    }
}
