package Source.Components;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImagePasswordGenerator {

    // Método que recibe dos imágenes y genera una contraseña segura
    public static String generatePasswordFromImages(File image) {
        // Obtener la información de las imágenes
        String info1 = getImageInfo(image);
        
        // Generar una contraseña segura usando la información de las imágenes
        return info1;
    }

    // Método que extrae la información (nombre, fecha, tamaño) de una imagen
    private static String getImageInfo(File image) {
        if (image != null && image.exists()) {
            // Obtener el nombre del archivo
            String fileName = image.getName();
            
            // Obtener la fecha de modificación del archivo
            Date lastModified = new Date(image.lastModified());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fileDate = dateFormat.format(lastModified);
            
            // Obtener el tamaño del archivo en bytes
            long fileSize = image.length();
            
            // Concatenar la información en una sola cadena
            return fileName + fileDate + fileSize;
        } else {
            throw new IllegalArgumentException("La imagen no existe o es inválida.");
        }
    }
}
