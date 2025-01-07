package Source.View;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Imagenes extends javax.swing.JFrame {

    private File imagen1, imagen2;

    public Imagenes() {
        initComponents();
        this.setTitle("KeyForge - Imagenes");
        this.setLocationRelativeTo(null); // Centrar ventana
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton(); // Nuevo botón para seleccionar segunda imagen
        jButton9 = new javax.swing.JButton(); // Botón para generar por imagen
        jButton10 = new javax.swing.JButton(); // Botón para generar por metadatos

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione las imágenes:");

        jButton1.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton1.setText("Seleccionar Imagen 1");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(evt -> seleccionarImagen(1));

        jButton2.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(evt -> limpiar());

        jButton3.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton3.setText("Generar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setText("Contraseña generada");

        jButton4.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton4.setText("Historial");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton5.setIcon(new javax.swing.ImageIcon("Assets/4571914521627270250-32.png")); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton6.setIcon(new javax.swing.ImageIcon("Assets/1947336761647100444-32.png")); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton7.setIcon(new javax.swing.ImageIcon("Assets/21260910731571183076-32.png")); // NOI18N
        jButton7.setToolTipText("");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton8.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton8.setText("Seleccionar Imagen 2");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(evt -> seleccionarImagen(2));

        jButton9.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton9.setText("Generar por Imagen");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(evt -> generarPorImagen());

        jButton10.setFont(new java.awt.Font("Eras Light ITC", 0, 14)); // NOI18N
        jButton10.setText("Generar por Metadatos");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(evt -> generarPorMetadatos());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(250, 250, 250))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addGap(10, 10, 10)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton9)
                    .addComponent(jButton2))
                .addComponent(jButton10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void seleccionarImagen(int imagenNumero) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            if (imagenNumero == 1) {
                imagen1 = archivoSeleccionado;
            } else {
                imagen2 = archivoSeleccionado;
            }
        }
    }

    private void limpiar() {
        imagen1 = null;
        imagen2 = null;
        jLabel2.setText("Contraseña generada");
    }

    private void generarPorImagen() {
        if (imagen1 != null && imagen2 != null) {
            // Lógica para generar la contraseña (por ejemplo, usando las imágenes)
            String generatedPassword = "Contraseña generada con las imágenes"; // Reemplaza con la lógica real
            setGeneratedPassword(generatedPassword); // Mostrar la contraseña real
        } else {
            jLabel2.setText("Seleccione ambas imágenes primero");
        }
    }

    private void generarPorMetadatos() {
        // Lógica para generar la contraseña por metadatos
        String generatedPassword = "Contraseña generada con metadatos"; // Reemplaza con la lógica real
        setGeneratedPassword(generatedPassword); // Mostrar la contraseña real
    }

    // Método para actualizar el texto de la contraseña generada
    public void setGeneratedPassword(String password) {
        jLabel2.setText("Contraseña generada: " + password);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Imagenes().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8; // Nuevo botón para seleccionar la segunda imagen
    private javax.swing.JButton jButton9; // Botón para generar por imagen
    private javax.swing.JButton jButton10; // Botón para generar por metadatos
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}