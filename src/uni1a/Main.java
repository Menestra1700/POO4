package uni1a;

public class Main {
    public static void main(String[] args) {
        try {
            MainController controller = new MainController();
            controller.iniciar();
        } catch (Exception e) {
            System.out.println("Error al iniciar el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
