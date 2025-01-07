package Source.Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ImageToTextPasswordGenerator {

    // Método que recibe dos imágenes, convierte las imágenes a texto y genera una contraseña segura
    public static String generatePasswordFromImageContent(File image1) throws IOException {
        // Obtener el contenido en texto de las imágenes
        String text1 = getImageText(image1);
        
        // Generar una contraseña segura utilizando los primeros 100 caracteres de cada imagen
        return text1;
    }

    // Método que convierte el contenido de una imagen a texto (utilizando los primeros 100 caracteres)
    private static String getImageText(File image) throws IOException {
        if (image != null && image.exists()) {
            // Leer el archivo de la imagen
            FileInputStream fileInputStream = new FileInputStream(image);
            byte[] fileContent = new byte[(int) image.length()];
            fileInputStream.read(fileContent);
            fileInputStream.close();
            
            // Convertir el contenido del archivo a una cadena usando UTF-8
            String fileContentString = new String(fileContent, StandardCharsets.UTF_8);
            
            // Retornar los primeros 100 caracteres del contenido como texto
            return fileContentString.length() > 100 ? fileContentString.substring(0, 100) : fileContentString;
        } else {
            throw new IllegalArgumentException("La imagen no existe o es inválida.");
        }
    }
}