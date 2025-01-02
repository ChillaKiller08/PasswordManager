package Source.Components;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Base64;

public class PasswordManager {
    private final List<String> passwords;
    private final SecretKey secretKey;

    private static final String FILE_PATH = "passwords.dat";

    /**
     * Constructor de la clase. Inicializa la lista de contraseñas y la clave secreta.
     * Si el archivo existe, carga las contraseñas desde él.
     */
    public PasswordManager() throws Exception {
        this.passwords = new ArrayList<>();
        this.secretKey = generateOrLoadKey();
        loadPasswords();
    }

    /**
     * Genera o carga la clave de cifrado.
     * 
     * @return SecretKey utilizada para cifrar y descifrar datos.
     * @throws Exception Si ocurre un error al generar o cargar la clave.
     */
    private SecretKey generateOrLoadKey() throws Exception {
        File keyFile = new File("key.dat");
        if (keyFile.exists()) {
            // Cargar clave desde archivo
            try (FileInputStream fis = new FileInputStream(keyFile)) {
                byte[] keyBytes = fis.readAllBytes();
                return new SecretKeySpec(keyBytes, "AES");
            }
        } else {
            // Generar nueva clave y guardarla
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // Tamaño de clave: 128 bits
            SecretKey key = keyGen.generateKey();
            try (FileOutputStream fos = new FileOutputStream(keyFile)) {
                fos.write(key.getEncoded());
            }
            return key;
        }
    }

    /**
     * Añade una contraseña y guarda los datos en el archivo.
     * 
     * @param password Contraseña a añadir.
     * @throws Exception Si ocurre un error al guardar los datos.
     */
    public void addPassword(String password) throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía ni ser nula.");
        }
        passwords.add(password);
        savePasswords();
    }

    /**
     * Elimina una contraseña y actualiza el archivo.
     * 
     * @param password Contraseña a eliminar.
     * @return true si se eliminó, false si no se encontró.
     * @throws Exception Si ocurre un error al guardar los datos.
     */
    public boolean deletePassword(String password) throws Exception {
        boolean removed = passwords.remove(password);
        if (removed) {
            savePasswords();
        }
        return removed;
    }

    /**
     * Devuelve una lista inmutable de contraseñas.
     * 
     * @return Lista inmutable de contraseñas.
     */
    public List<String> getPasswords() {
        return Collections.unmodifiableList(passwords);
    }

    /**
     * Guarda las contraseñas cifradas en un archivo.
     * 
     * @throws Exception Si ocurre un error durante el cifrado o escritura.
     */
    private void savePasswords() throws Exception {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            List<String> encryptedPasswords = new ArrayList<>();
            for (String password : passwords) {
                encryptedPasswords.add(encrypt(password));
            }
            oos.writeObject(encryptedPasswords);
        }
    }

    /**
     * Carga las contraseñas desde el archivo y las descifra.
     * 
     * @throws Exception Si ocurre un error durante la lectura o descifrado.
     */
    @SuppressWarnings("unchecked")
    private void loadPasswords() throws Exception {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                List<String> encryptedPasswords = (List<String>) ois.readObject();
                for (String encryptedPassword : encryptedPasswords) {
                    passwords.add(decrypt(encryptedPassword));
                }
            }
        }
    }

    /**
     * Cifra un texto utilizando AES.
     * 
     * @param plainText Texto plano a cifrar.
     * @return Texto cifrado en Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    private String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Descifra un texto cifrado utilizando AES.
     * 
     * @param encryptedText Texto cifrado en Base64.
     * @return Texto plano descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    private String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        return new String(cipher.doFinal(decodedBytes));
    }

    /**
     * Limpia todas las contraseñas de la lista y del archivo.
     * 
     * @throws Exception Si ocurre un error al guardar los datos.
     */
    public void clearPasswords() throws Exception {
        passwords.clear();
        savePasswords();
    }
}