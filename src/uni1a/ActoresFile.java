package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActoresFile {

    public static List<Actor> leerActores(String archivo) {
        List<Actor> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int edad = Integer.parseInt(partes[1].trim());
                    lista.add(new Actor(nombre, edad));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer actores: " + e.getMessage());
        }
        return lista;
    }

    public static void guardarActores(List<Actor> actores, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Actor actor : actores) {
                bw.write(actor.getNombre() + "," + actor.getEdad());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar actores: " + e.getMessage());
        }
    }
}
