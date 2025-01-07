package Source.View;

import Source.Controller.PasswordController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gestor extends JFrame {
    private PasswordController passwordController;
    private JList<String> passwordList;
    private DefaultListModel<String> listModel;
    private JTextField passwordField;
    private JTextField nameField;
    private MainView mainWindow;  // Referencia a la ventana principal

    public Gestor(PasswordController controller, MainView mainWindow) {
        this.passwordController = controller;
        this.mainWindow = mainWindow;  // Ahora está correctamente inicializado
        System.out.println("Referencia mainWindow: " + this.mainWindow);
        initComponents();
        loadPasswords();
    }
    

    private void initComponents() {
        setTitle("Gestor de Contraseñas");
        setLayout(new BorderLayout());

        // Lista de contraseñas
        listModel = new DefaultListModel<>();
        passwordList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(passwordList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));  // Cambié a 4 filas para agregar un botón extra

        inputPanel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Contraseña:"));
        passwordField = new JTextField();
        inputPanel.add(passwordField);

        // Botones de acción
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new AddPasswordAction());
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new DeletePasswordAction());
        inputPanel.add(deleteButton);

        JButton updateButton = new JButton("Modificar");
        updateButton.addActionListener(new UpdatePasswordAction());
        inputPanel.add(updateButton);

        // Botón de retorno
        JButton returnButton = new JButton("Volver");
        returnButton.addActionListener(new ReturnButtonAction());
        inputPanel.add(returnButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Configuración de la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void loadPasswords() {
        listModel.clear();
        List<String> passwords = passwordController.getPasswords();
        for (String password : passwords) {
            listModel.addElement(password);
        }
    }

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica si mainWindow no es null antes de intentar usarla
        if (mainWindow != null) {
            mainWindow.setVisible(true);  // Muestra la ventana principal (MainView)
            this.setVisible(false);       // Oculta la ventana Gestor
        } else {
            System.out.println("Error: mainWindow es null");
        }
    }

    // Acción para agregar una nueva contraseña
    private class AddPasswordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String password = passwordField.getText();
            if (!name.isEmpty() && !password.isEmpty()) {
                try {
                    passwordController.addPassword(name, password);
                    loadPasswords();
                    nameField.setText("");
                    passwordField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Gestor.this, "Error al agregar la contraseña: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(Gestor.this, "Por favor, complete ambos campos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Acción para eliminar una contraseña
    private class DeletePasswordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedValue = passwordList.getSelectedValue();
            if (selectedValue != null) {
                try {
                    passwordController.deletePassword(selectedValue);
                    loadPasswords();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Gestor.this, "Error al eliminar la contraseña: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(Gestor.this, "Por favor, seleccione una contraseña para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Acción para modificar una contraseña
    private class UpdatePasswordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedValue = passwordList.getSelectedValue();
            if (selectedValue != null) {
                String name = nameField.getText();
                String password = passwordField.getText();
                if (!name.isEmpty() && !password.isEmpty()) {
                    try {
                        passwordController.deletePassword(selectedValue);
                        passwordController.addPassword(name, password);
                        loadPasswords();
                        nameField.setText("");
                        passwordField.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Gestor.this, "Error al modificar la contraseña: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(Gestor.this, "Por favor, complete ambos campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(Gestor.this, "Por favor, seleccione una contraseña para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Acción para el botón de retorno
    private class ReturnButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cierra la ventana actual (Gestor) y muestra la ventana principal
            Gestor.this.dispose();  // Cierra la ventana Gestor
            mainWindow.setVisible(true);  // Muestra la ventana principal
        }
    }
    
}
