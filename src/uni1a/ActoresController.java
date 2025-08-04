package uni1a;

import java.util.List;

public class ActoresController {
    private final ConsolaView view;
    private final String archivo;
    private List<Actor> actores;

    public ActoresController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.actores = ActoresFile.leerActores(archivo);
        if (actores == null) actores = new java.util.ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuActores();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarActores(actores);
                case 2 -> {
                    Actor nuevo = view.pedirDatosActor();
                    actores.add(nuevo);
                    ActoresFile.guardarActores(actores, archivo);
                    view.mostrarMensaje("Actor guardado.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    List<Actor> getActores() {
        return actores;
    }
}

