package uni1a;

import java.util.List;

public class DocumentalesController {
    private final ConsolaView view;
    private final String archivo;
    private List<Documental> documentales;

    public DocumentalesController(ConsolaView view, String archivo) {
        this.view = view;
        this.archivo = archivo;
        this.documentales = DocumentalesFile.leerDocumentales(archivo);
        if (documentales == null) documentales = new java.util.ArrayList<>();
    }

    public void iniciar() {
        while (true) {
            view.mostrarMenuDocumentales();
            int opcion = view.leerOpcion();
            switch (opcion) {
                case 1 -> view.mostrarDocumentales(documentales);
                case 2 -> {
                    Documental nuevo = view.pedirDatosDocumental();
                    documentales.add(nuevo);
                    DocumentalesFile.guardarDocumentales(documentales, archivo);
                    view.mostrarMensaje("Documental guardado.");
                }
                case 3 -> { return; }
                default -> view.mostrarMensaje("Opción inválida.");
            }
        }
    }

    List<Documental> getDocumentales() {
        return documentales;
    }
}
