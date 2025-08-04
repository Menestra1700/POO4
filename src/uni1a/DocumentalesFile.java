package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentalesFile {

    public static List<Documental> leerDocumentales(String archivo) {
        List<Documental> lista = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear archivo de documentales: " + e.getMessage());
            }
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String titulo = partes[0].trim();
                    String genero = partes[1].trim();
                    int duracion;
                    try {
                        duracion = Integer.parseInt(partes[2].trim());
                    } catch (NumberFormatException ex) {
                        System.out.println("Duración inválida en línea: " + linea + " -> se omite");
                        continue;
                    }
                    String tema = partes[3].trim();
                    String narrador = partes[4].trim();
                    lista.add(new Documental(titulo, genero, duracion, tema, narrador));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer documentales: " + e.getMessage());
        }
        return lista;
    }

    public static void guardarDocumentales(List<Documental> lista, String archivo) {
        File file = new File(archivo);
        try {
            file.getParentFile().mkdirs();
        } catch (Exception ignored) {
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Documental d : lista) {
                bw.write(d.getTitulo() + "," + d.getGenero() + "," + d.getDuracion() + "," + d.getTema() + "," + d.getNarrador());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar documentales: " + e.getMessage());
        }
    }
}
