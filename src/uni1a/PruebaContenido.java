package uni1a;

public class PruebaContenido {
    public static void main(String[] args) {
       
        Pelicula peli = new Pelicula("El Regreso", "Acción", 120, "Carlos Ruiz", 2024);

        Trailer trailer = new Trailer("Avance de 'El Regreso'", "Acción", 3, peli, "01-07-2025");

        Documental doc1 = new Documental("Selvas del Amazonas", "Naturaleza", 25, "Ecosistemas", "Ana Torres");
        Documental doc2 = new Documental("Cambio Climático 2025", "Ciencia", 30, "Clima", "Luis Gómez");

        Noticiero noti = new Noticiero("Noticias 24", "Informativo", 60, "Canal Global");
        noti.agregarDocumental(doc1);
        noti.agregarDocumental(doc2);

        System.out.println();
        trailer.mostrarDetalles();
        System.out.println();
        noti.mostrarDetalles();
    }
}
