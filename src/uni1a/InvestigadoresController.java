package uni1a;

import java.util.List;

public class InvestigadoresController {
    private final ConsolaView view;
    private final String archivo;
    private List<Investigador> investigadores;

    public InvestigadoresController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.investigadores = InvestigadoresFile.leerInvestigadores(archivo);
        if (investigadores == null) investigadores = new java.util.ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuInvestigadores();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarInvestigadores(investigadores);
                case 2 -> {
                    Investigador nuevo = view.pedirDatosInvestigador();
                    investigadores.add(nuevo);
                    InvestigadoresFile.guardarInvestigadores(investigadores, archivo);
                    view.mostrarMensaje("Investigador guardado.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    List<Investigador> getInvestigadores() {
        return investigadores;
    }
}
