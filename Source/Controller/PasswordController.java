package Source.Controller;

import Source.Components.PasswordManager;

import java.util.List;

public class PasswordController {
    private PasswordManager passwordManager;

    public PasswordController() throws Exception {
        this.passwordManager = new PasswordManager();
    }

    /**
     * Agrega una nueva contraseña al gestor.
     * 
     * @param name Nombre asociado a la contraseña.
     * @param password Contraseña a agregar.
     * @throws Exception Si ocurre un error al agregar la contraseña.
     */
    public void addPassword(String name, String password) throws Exception {
        if (name == null || name.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y la contraseña no pueden estar vacíos.");
        }
        passwordManager.addPassword(name + ": " + password);
    }

    /**
     * Elimina una contraseña del gestor.
     * 
     * @param password Contraseña a eliminar.
     * @return true si se eliminó, false si no se encontró.
     * @throws Exception Si ocurre un error al eliminar la contraseña.
     */
    public boolean deletePassword(String password) throws Exception {
        return passwordManager.deletePassword(password);
    }

    /**
     * Devuelve una lista inmutable de contraseñas.
     * 
     * @return Lista inmutable de contraseñas.
     */
    public List<String> getPasswords() {
        return passwordManager.getPasswords();
    }
}