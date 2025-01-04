package Source;

import Source.View.MainView;

public class MainApp {
    public MainApp() {
        // Constructor de la clase principal
    }

    public static void main(String[] args) {
        // Crear la instancia de MainView y hacerla visible
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}