package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvestigadoresFile {

    public static List<Investigador> leerInvestigadores(String archivo) {
        List<Investigador> investigadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 2) {
                    String nombre = campos[0].trim();
                    String especialidad = campos[1].trim();
                    investigadores.add(new Investigador(nombre, especialidad));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer Investigadores: " + e.getMessage());
        }
        return investigadores;
    }

    public static void guardarInvestigadores(List<Investigador> investigadores, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Investigador i : investigadores) {
                bw.write(i.getNombre() + "," + i.getEspecialidad());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar Investigadores: " + e.getMessage());
        }
    }
}

