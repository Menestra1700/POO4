package uni1a;

import java.util.List;

public class SeriesController {
    private final ConsolaView view;
    private final String archivo;
    private List<SerieDeTV> series;

    public SeriesController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.series = SeriesFile.leerSeries(archivo);
        if (series == null) series = new java.util.ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuSeries();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarSeries(series);
                case 2 -> {
                    SerieDeTV nueva = view.pedirDatosSerie();
                    series.add(nueva);
                    SeriesFile.guardarSeries(series, archivo);
                    view.mostrarMensaje("Serie guardada.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    List<SerieDeTV> getSeries() {
        return series;
    }
}
