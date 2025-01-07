package Source.Controller;

import Source.Components.ImagePasswordGenerator;
import Source.Components.ImageToTextPasswordGenerator;
import Source.Components.PasswordGenerator;
import Source.View.Imagenes;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class PasswordGenerationController {

    private Imagenes imagenesView; // Vista de la aplicación
    private File image1; // Primera imagen seleccionada
    private File image2; // Segunda imagen seleccionada

    // Constructor
    public PasswordGenerationController(Imagenes imagenesView) {
        this.imagenesView = imagenesView;
    }

    // Método para manejar el evento de generar por metadatos
    public void generatePasswordByMetadata() {
        try {
            if (image1 == null || image2 == null) {
                JOptionPane.showMessageDialog(imagenesView, "Debe seleccionar ambas imágenes primero.");
                return;
            }

            // Generar las cadenas por metadatos usando ImagePasswordGenerator
            String cadena1 = ImagePasswordGenerator.generatePasswordFromImages(image1);
            String cadena2 = ImagePasswordGenerator.generatePasswordFromImages(image2);

            // Generar la contraseña segura utilizando PasswordGenerator
            String securePassword = PasswordGenerator.generateSecurePassword(cadena1, cadena2);

            // Mostrar la contraseña generada en la vista
            imagenesView.setGeneratedPassword(securePassword); // Mostrar la contraseña real
        } catch (IllegalArgumentException e) {
            // Capturamos el error si las imágenes son inválidas
            JOptionPane.showMessageDialog(imagenesView, "Error al procesar las imágenes: " + e.getMessage());
        }
    }

    // Método para manejar el evento de generar por contenido de imagen (convertido a texto)
    public void generatePasswordByImageContent() {
        try {
            if (image1 == null || image2 == null) {
                JOptionPane.showMessageDialog(imagenesView, "Debe seleccionar ambas imágenes primero.");
                return;
            }

            // Generar las contraseñas usando los primeros 100 caracteres del contenido de cada imagen
            String cadena1 = ImageToTextPasswordGenerator.generatePasswordFromImageContent(image1);
            String cadena2 = ImageToTextPasswordGenerator.generatePasswordFromImageContent(image2);

            // Generar la contraseña segura utilizando PasswordGenerator
            String securePassword = PasswordGenerator.generateSecurePassword(cadena1, cadena2);
            System.out.println(securePassword);

            // Mostrar la contraseña generada en la vista
            imagenesView.setGeneratedPassword(securePassword); // Mostrar la contraseña real
        } catch (IOException e) {
            // Capturamos errores de entrada/salida, por ejemplo, si hay un problema al leer el archivo
            JOptionPane.showMessageDialog(imagenesView, "Error al procesar las imágenes: " + e.getMessage());
        }
    }

    // Métodos para establecer las imágenes seleccionadas
    public void setImage1(File image1) {
        this.image1 = image1;
    }

    public void setImage2(File image2) {
        this.image2 = image2;
    }
}
