/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source.Components;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordGenerator {

    // Método que combina las dos cadenas y genera una contraseña encriptada
    public static String generateSecurePassword(String cadena1, String cadena2) {
        String combinedString = cadena1 + cadena2;
        return encryptSHA256(combinedString);
    }

    // Método para encriptar con SHA-256
    private static String encryptSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la cadena", e);
        }
    }
}