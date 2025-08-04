package uni1a;

import java.util.List;

public class TemporadasController {
    private final ConsolaView view;
    private final String archivo;
    private List<Temporada> temporadas;

    public TemporadasController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.temporadas = TemporadasFile.leerTemporadas(archivo);
        if (temporadas == null) temporadas = new java.util.ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuTemporadas();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarTemporadas(temporadas);
                case 2 -> {
                    Temporada nueva = view.pedirDatosTemporada();
                    temporadas.add(nueva);
                    TemporadasFile.guardarTemporadas(temporadas, archivo);
                    view.mostrarMensaje("Temporada guardada.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    List<Temporada> getTemporadas() {
        return temporadas;
    }
}

