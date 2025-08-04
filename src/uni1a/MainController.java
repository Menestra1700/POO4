package uni1a;

public class MainController {
    private final ConsolaView view;
    private final PeliculasController peliculasController;
    private final SeriesController seriesController;
    private final DocumentalesController documentalesController;
    private final ActoresController actoresController;
    private final TemporadasController temporadasController;
    private final InvestigadoresController investigadoresController;

    public MainController() {
        view = new ConsolaView();
        peliculasController = new PeliculasController(view, "C:/Users/User/Desktop/peliculas.csv");
        seriesController = new SeriesController(view, "C:/Users/User/Desktop/series.csv");
        documentalesController = new DocumentalesController(view, "C:/Users/User/Desktop/documentales.csv");
        actoresController = new ActoresController(view, "C:/Users/User/Desktop/actores.csv");
        temporadasController = new TemporadasController(view, "C:/Users/User/Desktop/temporadas.csv");
        investigadoresController = new InvestigadoresController(view, "C:/Users/User/Desktop/investigadores.csv");
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuPrincipal();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> peliculasController.iniciar();
                case 2 -> seriesController.iniciar();
                case 3 -> documentalesController.iniciar();
                case 4 -> actoresController.iniciar();
                case 5 -> temporadasController.iniciar();
                case 6 -> investigadoresController.iniciar();
                case 7 -> {
                    view.mostrarMensaje("Saliendo...");
                    return;
                }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }
}

