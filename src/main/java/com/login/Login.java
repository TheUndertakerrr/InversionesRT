/**
 * Login.java
 * Esta clase proporciona la interfaz de inicio de sesión para los usuarios del sistema Inversiones R.T.
 * Permite a los usuarios ingresar su nombre de usuario y contraseña, autenticar sus credenciales y
 * acceder al sistema. 
 * Además, verifica el estado y nivel de acceso del usuario y redirige al panel de control 
 * correspondiente (Dashboard) según su nivel de permisos.
 *
 * Este archivo es parte de InversionesRT.
 *
 * InversionesRT es software libre: puedes redistribuirlo y/o modificarlo
 * bajo los términos de la Licencia Pública General GNU publicada por
 * la Free Software Foundation, ya sea la versión 3 de la Licencia, o
 * (a su elección) cualquier versión posterior.
 *
 * InversionesRT se distribuye con la esperanza de que sea útil,
 * pero SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de
 * COMERCIABILIDAD o APTITUD PARA UN PROPÓSITO PARTICULAR. Consulta la
 * Licencia Pública General GNU para más detalles.
 *
 * Deberías haber recibido una copia de la Licencia Pública General GNU
 * junto con [nombre del proyecto]. En caso contrario, consulta
 * <https://www.gnu.org/licenses/gpl-3.0.html>.
 */
package com.login;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import java.util.Collections;
import javax.swing.UIManager;
import java.sql.*;
import com.clase.bd.Conexion;
import com.menu.DashboardAdmin;
import com.menu.DashboardUser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.awt.event.KeyEvent;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    String password = "";

    public Login() {
        initComponents();
        initStyles();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        campoPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPasswordKeyPressed(evt);
            }
        });

    }

    //Estilos para los títulos, campos y redondeado del botón.
    private void initStyles() {

        tituloPrincipal.putClientProperty("FlatLaf.style", "font: $h1.font");
        tituloPrincipal.setForeground(new java.awt.Color(51, 51, 51));

        tituloLogin.putClientProperty("FlatLaf.styleClass", "h2");
        tituloLogin.setForeground(new java.awt.Color(90, 58, 201));

        tituloUsuario.putClientProperty("FlatLaf.styleClass", "h3");
        tituloUsuario.setForeground(new java.awt.Color(51, 51, 51));

        tituloPassword.putClientProperty("FlatLaf.styleClass", "h3");
        tituloPassword.setForeground(new java.awt.Color(51, 51, 51));

        campoUsuario.putClientProperty("JTextField.placeholderText", "Ingrese su usuario.");

        campoPassword.putClientProperty("JTextField.placeholderText", "Ingrese su contraseña.");

        botonEntrar.putClientProperty("JButton.buttonType", "roundRect");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bgImages = new javax.swing.JPanel();
        images = new javax.swing.JLabel();
        bgContenido = new javax.swing.JPanel();
        tituloPrincipal = new javax.swing.JLabel();
        tituloLogin = new javax.swing.JLabel();
        tituloUsuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        tituloPassword = new javax.swing.JLabel();
        campoPassword = new javax.swing.JPasswordField();
        botonEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(800, 435));

        background.setBackground(new java.awt.Color(255, 255, 255));

        bgImages.setBackground(new java.awt.Color(255, 255, 255));

        images.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sitio-construccion.jpg"))); // NOI18N

        javax.swing.GroupLayout bgImagesLayout = new javax.swing.GroupLayout(bgImages);
        bgImages.setLayout(bgImagesLayout);
        bgImagesLayout.setHorizontalGroup(
            bgImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(images, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgImagesLayout.setVerticalGroup(
            bgImagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(images, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bgContenido.setBackground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("¡Bienvenido a Inversiones R.T!");

        tituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLogin.setText("Acceda a su cuenta");

        tituloUsuario.setText("Usuario");

        tituloPassword.setText("Contraseña");

        botonEntrar.setBackground(new java.awt.Color(90, 58, 201));
        botonEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        botonEntrar.setText("Entrar");
        botonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgContenidoLayout = new javax.swing.GroupLayout(bgContenido);
        bgContenido.setLayout(bgContenidoLayout);
        bgContenidoLayout.setHorizontalGroup(
            bgContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tituloLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContenidoLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(bgContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgContenidoLayout.createSequentialGroup()
                        .addComponent(tituloPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(160, 160, 160))
                    .addGroup(bgContenidoLayout.createSequentialGroup()
                        .addComponent(tituloUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(180, 180, 180))
                    .addComponent(campoUsuario)
                    .addComponent(campoPassword))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgContenidoLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(botonEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
        );
        bgContenidoLayout.setVerticalGroup(
            bgContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgContenidoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(tituloPrincipal)
                .addGap(18, 18, 18)
                .addComponent(tituloLogin)
                .addGap(36, 36, 36)
                .addComponent(tituloUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tituloPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(botonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(bgImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bgContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgImages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bgContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarActionPerformed
        user = campoUsuario.getText().trim();
        password = campoPassword.getText().trim();

        if (!user.equals("") && !password.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                if (cn != null) {
                    PreparedStatement pst = cn.prepareStatement("SELECT estatus, tipo_nivel FROM usuario "
                            + "WHERE username = ? AND contraseña = ?");
                    pst.setString(1, user);
                    pst.setString(2, password);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String estatus = rs.getString("estatus");
                        String tipo_nivel = rs.getString("tipo_nivel");

                        if (estatus.equalsIgnoreCase("Activo")) {
                            if (tipo_nivel.equalsIgnoreCase("Administrador")) {
                                dispose();
                                new DashboardAdmin().setVisible(true);

                            } else if (tipo_nivel.equalsIgnoreCase("Usuario")) {
                                dispose();
                                new DashboardUser().setVisible(true);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Tu usuario está inactivo. Por favor, contacta al administrador.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        boolean usuarioCorrecto = false;
                        boolean passwordCorrecta = false;

                        PreparedStatement pstUsuario = cn.prepareStatement("SELECT COUNT(*) FROM usuario WHERE username = ?");
                        pstUsuario.setString(1, user);
                        ResultSet rsUsuario = pstUsuario.executeQuery();

                        if (rsUsuario.next()) {
                            int count = rsUsuario.getInt(1);
                            usuarioCorrecto = count > 0;
                        }

                        PreparedStatement pstPassword = cn.prepareStatement("SELECT COUNT(*) FROM usuario WHERE contraseña = ?");
                        pstPassword.setString(1, password);
                        ResultSet rsPassword = pstPassword.executeQuery();

                        if (rsPassword.next()) {
                            int count = rsPassword.getInt(1);
                            passwordCorrecta = count > 0;
                        }

                        if (!usuarioCorrecto && !passwordCorrecta) {
                            JOptionPane.showMessageDialog(null, "El usuario y la contraseña ingresados son incorrectos.",
                                    "Error", JOptionPane.ERROR_MESSAGE);

                            campoUsuario.setText("");
                            campoPassword.setText("");

                        } else if (!usuarioCorrecto) {
                            JOptionPane.showMessageDialog(null, "El usuario ingresado es incorrecto.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            campoUsuario.setText("");

                        } else if (!passwordCorrecta) {
                            JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            campoPassword.setText("");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La base de datos no está disponible actualmente.",
                            "Error de conexión", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón Entrar" + e);
                JOptionPane.showMessageDialog(null, "¡Error al Iniciar Sesión en el sistema! Póngase "
                        + "en contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes ingresar el usuario y la contraseña.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEntrarActionPerformed

    private void campoPasswordKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonEntrarActionPerformed(null);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Look and Fell para mejorar el estilo de los componentes. 
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            UIManager.put("Component.focusWidth", 1);
            FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#5A3AC9"));
            FlatIntelliJLaf.setup();

        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bgContenido;
    private javax.swing.JPanel bgImages;
    private javax.swing.JButton botonEntrar;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel images;
    private javax.swing.JLabel tituloLogin;
    private javax.swing.JLabel tituloPassword;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JLabel tituloUsuario;
    // End of variables declaration//GEN-END:variables
}