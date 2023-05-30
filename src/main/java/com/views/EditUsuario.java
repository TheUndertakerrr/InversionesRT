/**
 * EditUsuario.java
 * Esta clase representa un panel de edición de usuario, donde se pueden modificar los datos de un
 * usuario existente en un sistema.
 * El panel contiene varios campos de entrada, como cédula, nombre, apellido, nombre de usuario,
 * contraseña, correo, teléfono, estado y permisos.
 * Por otra parte, hay botones y etiquetas para interactuar con la interfaz.
 * La clase incluye métodos para inicializar los estilos de la interfaz, establecer el usuario seleccionado,
 * mostrar el nombre del usuario a editar, establecer los datos del usuario en los campos
 * correspondientes y realizar la acción de actualización al presionar el botón "Actualizar".
 * También se proporcionan métodos para validar el formato del correo electrónico y número de
 * teléfono, verificar la existencia de ciertos datos en la base de datos, obtener valores de la base de
 * datos y actualizar los datos del usuario.
 * Este archivo es parte del paquete "com.views".
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
package com.views;

import java.awt.Color;
import com.clase.bd.Conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class EditUsuario extends javax.swing.JPanel {

    String userUpdate = "";

    public EditUsuario() {
        initComponents();
        initStyles();
        campoCedula.setEditable(false);
    }

    private void initStyles() {
        // Tipografía para los títulos de los campos.
        tituloGestionar.putClientProperty("FlatLaf.styleClass", "h1");
        tituloGestionar.setForeground(new java.awt.Color(90, 58, 201));

        tituloCedula.putClientProperty("FlatLaf.styleClass", "h3");
        tituloCedula.setForeground(Color.DARK_GRAY);

        tituloNombre.putClientProperty("FlatLaf.styleClass", "h3");
        tituloNombre.setForeground(Color.DARK_GRAY);

        tituloApellido.putClientProperty("FlatLaf.styleClass", "h3");
        tituloApellido.setForeground(Color.DARK_GRAY);

        tituloUsername.putClientProperty("FlatLaf.styleClass", "h3");
        tituloUsername.setForeground(Color.DARK_GRAY);

        tituloPassword.putClientProperty("FlatLaf.styleClass", "h3");
        tituloPassword.setForeground(Color.DARK_GRAY);

        tituloCorreo.putClientProperty("FlatLaf.styleClass", "h3");
        tituloCorreo.setForeground(Color.DARK_GRAY);

        tituloTelefono.putClientProperty("FlatLaf.styleClass", "h3");
        tituloTelefono.setForeground(Color.DARK_GRAY);

        tituloEstatus.putClientProperty("FlatLaf.styleClass", "h3");
        tituloEstatus.setForeground(Color.DARK_GRAY);

        tituloPermisos.putClientProperty("FlatLaf.styleClass", "h3");
        tituloPermisos.setForeground(Color.DARK_GRAY);

        // Texto dentro de los campos, indicando la información que se debe introducir.
        campoNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre.");
        campoApellido.putClientProperty("JTextField.placeholderText", "Ingrese el apellido.");
        campoUsername.putClientProperty("JTextField.placeholderText", "Ingrese el username.");
        campoPassword.putClientProperty("JTextField.placeholderText", "Ingrese la contraseña.");
        campoCorreo.putClientProperty("JTextField.placeholderText", "Ingrese el correo.");
        campoTelefono.putClientProperty("JTextField.placeholderText", "Ingrese el teléfono.");

        // Propiedades de los ComboBox (redondos).
        comboEstatus.putClientProperty("JComponent.roundRect", true);
        comboEstatus.putClientProperty("FlatLaf.style", "large");

        comboPermisos.putClientProperty("JComponent.roundRect", true);
        comboPermisos.putClientProperty("FlatLaf.style", "large");

        // Propiedades del botón (redondo).
        botonActualizar.putClientProperty("JButton.buttonType", "roundRect");
    }

    // Recoge el nombre y apellido del usuario que está iniciando sesión.
    public void setUsuarioSeleccionado(String usuario, String apellido) {
        userUpdate = usuario + " " + apellido;
    }

    // Muestra el nombre y apellido del usuario que se va a editar.
    public void nombreUsuario() {
        tituloGestionar.setText("Gestionar Usuario de - " + userUpdate);
    }

    // Método que me recoge los datos del usuario seleccionado.
    public void setDatos(String cedula, String nombre, String apellido, String username, String contraseña, String correo, String telefono, String estatus, String permisos) {

        campoCedula.setText(cedula);
        campoNombre.setText(nombre);
        campoApellido.setText(apellido);
        campoUsername.setText(username);
        campoPassword.setText(contraseña);
        campoCorreo.setText(correo);
        campoTelefono.setText(telefono);

        // Configura el valor seleccionado en los JComboBox
        if (estatus.equals("Activo")) {
            comboEstatus.setSelectedIndex(1);

        } else if (estatus.equals("Inactivo")) {
            comboEstatus.setSelectedIndex(2);
        }

        if (permisos.equals("Administrador")) {
            comboPermisos.setSelectedIndex(1);

        } else if (permisos.equals("Usuario")) {
            comboPermisos.setSelectedIndex(2);
        }
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
        tituloGestionar = new javax.swing.JLabel();
        tituloCedula = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloApellido = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        tituloUsername = new javax.swing.JLabel();
        campoUsername = new javax.swing.JTextField();
        tituloPassword = new javax.swing.JLabel();
        campoPassword = new javax.swing.JPasswordField();
        tituloCorreo = new javax.swing.JLabel();
        campoCorreo = new javax.swing.JTextField();
        tituloTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        tituloEstatus = new javax.swing.JLabel();
        comboEstatus = new javax.swing.JComboBox<>();
        tituloPermisos = new javax.swing.JLabel();
        comboPermisos = new javax.swing.JComboBox<>();
        botonActualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloGestionar.setText("Gestionar Usuario");

        tituloCedula.setText("Cedula");

        tituloNombre.setText("Nombre");

        tituloApellido.setText("Apellido");

        tituloUsername.setText("Username");

        tituloPassword.setText("Contraseña");

        tituloCorreo.setText("Correo");

        tituloTelefono.setText("Teléfono");

        tituloEstatus.setText("Estatus");

        comboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el estatus", "Activo", "Inactivo" }));
        comboEstatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tituloPermisos.setText("Permisos de");

        comboPermisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona el permiso", "Administrador", "Usuario" }));
        comboPermisos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botonActualizar.setBackground(new java.awt.Color(90, 58, 201));
        botonActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizar.setText("Actualizar");
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(292, 292, 292))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloGestionar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(191, 191, 191))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoUsername, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(76, 76, 76))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(tituloCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(7, 7, 7))
                                    .addComponent(tituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tituloApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(200, 200, 200)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstatus, 0, 1, Short.MAX_VALUE)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(tituloEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(79, 79, 79)))
                                .addGap(30, 30, 30)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(tituloPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(151, 151, 151))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(comboPermisos, 0, 1, Short.MAX_VALUE)
                                        .addGap(110, 110, 110))))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(tituloCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(134, 134, 134))
                                    .addComponent(campoPassword)
                                    .addComponent(campoCorreo)
                                    .addComponent(campoTelefono)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(tituloTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(124, 124, 124)))
                                .addGap(191, 191, 191))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(301, 301, 301))))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tituloGestionar)
                .addGap(24, 24, 24)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloPassword)
                            .addComponent(tituloCedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloNombre)
                                .addGap(12, 12, 12)
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tituloApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tituloUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tituloTelefono)
                                .addGap(12, 12, 12)
                                .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tituloEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tituloPermisos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(47, 47, 47)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        // Obtiene los valores de los campos de texto y los JComboBox.
        String cedula = campoCedula.getText().trim();
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellido.getText().trim();
        String username = campoUsername.getText().trim();
        String password = campoPassword.getText().trim();
        String correo = campoCorreo.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String estatus = comboEstatus.getSelectedItem().toString();
        String permisos = comboPermisos.getSelectedItem().toString();

        // Validación de campos vacíos.
        if (nombre.isEmpty() || apellido.isEmpty() || username.isEmpty() || password.isEmpty()
                || correo.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Límites de caracteres.
        int maxCaracteresNombre = 35;
        int maxCaracteresApellido = 35;
        int maxCaracteresUsername = 20;
        int maxCaracteresContraseña = 20;
        int maxCaracteresCorreo = 50;
        int maxCaracteresTelefono = 11;

        // Validación de longitud de campos.
        if (nombre.length() > maxCaracteresNombre || apellido.length() > maxCaracteresApellido
                || username.length() > maxCaracteresUsername || password.length() > maxCaracteresContraseña
                || correo.length() > maxCaracteresCorreo || telefono.length() > maxCaracteresTelefono) {
            JOptionPane.showMessageDialog(null, "Se ha excedido el límite de caracteres en uno o más campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación de formato de correo electrónico.
        if (!validarFormatoCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El formato del correo electrónico no es válido.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de formato de número de teléfono.
        if (!validarFormatoTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "El formato del número de teléfono no es válido.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean verificarExistencia = false;

        if (!username.equals(getUsernameFromDatabase(cedula))
                || !correo.equals(getCorreoFromDatabase(cedula)) || !telefono.equals(getTelefonoFromDatabase(cedula))) {
            verificarExistencia = !estatus.equals("Inactivo");
        }

        if (verificarExistencia) {
            List<String> camposEnUso = verificarExistencia(cedula, username, correo, telefono);
            if (!camposEnUso.isEmpty()) {
                StringBuilder mensaje = new StringBuilder();
                if (camposEnUso.size() == 1) {
                    mensaje.append("La siguiente información ya está en uso:\n\n");
                } else {
                    mensaje.append("Los siguientes datos ya están en uso:\n\n");
                }

                int contador = 1;
                for (String campo : camposEnUso) {
                    String primerLetraMayuscula = campo.substring(0, 1).toUpperCase() + campo.substring(1);
                    mensaje.append(contador).append(". ").append(primerLetraMayuscula).append("\n");
                    contador++;
                }

                mensaje.append("\nIngresa valores únicos para la información mencionada.");
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Realiza la actualización en la base de datos.
        if (actualizarDatosUsuario(cedula, nombre, apellido, username, password, correo, telefono, estatus, permisos)) {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Actualización exitosa.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "¡Error al actualizar los datos del usuario!"
                    + " Póngase en contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Formato para la validación del correo electrónico.
    private boolean validarFormatoCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    // Formato para la validación del número de teléfono.
    private boolean validarFormatoTelefono(String telefono) {
        Pattern patternTelefono = Pattern.compile("^\\d{11}$");
        Matcher matcherTelefono = patternTelefono.matcher(telefono);
        return matcherTelefono.matches();
    }

    // Verifica si existe los datos en la base de datos.
    private List<String> verificarExistencia(String cedula, String username, String correo, String telefono) {
        List<String> camposEnUso = new ArrayList<>();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT username, correo, telefono FROM usuario WHERE (username = ? OR correo = ? OR telefono = ?) AND cedula != ?");
            pst.setString(1, username);
            pst.setString(2, correo);
            pst.setString(3, telefono);
            pst.setString(4, cedula);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    camposEnUso.add("username");
                }
                if (rs.getString("correo").equals(correo)) {
                    camposEnUso.add("correo");
                }
                if (rs.getString("telefono").equals(telefono)) {
                    camposEnUso.add("telefono");
                }
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al verificar la existencia de valores en la base de datos: " + e);
            camposEnUso.add("error");
        }

        return camposEnUso;
    }

    // Obtener el username actual del usuario en la base de datos
    private String getUsernameFromDatabase(String cedula) {
        String username = "";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT username FROM usuario WHERE cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el username del usuario: " + e);
        }
        return username;
    }

    // Obtener el correo actual del usuario en la base de datos
    private String getCorreoFromDatabase(String cedula) {
        String correo = "";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT correo FROM usuario WHERE cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                correo = rs.getString("correo");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el correo del usuario: " + e);
        }
        return correo;
    }

    // Obtener el teléfono actual del usuario en la base de datos
    private String getTelefonoFromDatabase(String cedula) {
        String telefono = "";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT telefono FROM usuario WHERE cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                telefono = rs.getString("telefono");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el teléfono del usuario: " + e);
        }
        return telefono;
    }

    // Actualiza los datos del usuario en la tabla y en la base de datos.
    private boolean actualizarDatosUsuario(String cedula, String nombre, String apellido, String username,
            String password, String correo, String telefono, String estatus, String permisos) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE usuario SET nombre = ?, apellido = ?, username = ?, contraseña = ?, "
                    + "correo = ?, telefono = ?, estatus = ?, tipo_nivel = ? WHERE cedula = ?");

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, username);
            pst.setString(4, password);
            pst.setString(5, correo);
            pst.setString(6, telefono);
            pst.setString(7, estatus);
            pst.setString(8, permisos);
            pst.setString(9, cedula);

            int resultado = pst.executeUpdate();
            cn.close();

            return resultado > 0; // Devuelve true si se actualizó al menos un registro

        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del usuario: " + e);
            return false;
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoUsername;
    private javax.swing.JComboBox<String> comboEstatus;
    private javax.swing.JComboBox<String> comboPermisos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tituloApellido;
    private javax.swing.JLabel tituloCedula;
    private javax.swing.JLabel tituloCorreo;
    private javax.swing.JLabel tituloEstatus;
    private javax.swing.JLabel tituloGestionar;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloPassword;
    private javax.swing.JLabel tituloPermisos;
    private javax.swing.JLabel tituloTelefono;
    private javax.swing.JLabel tituloUsername;
    // End of variables declaration//GEN-END:variables

    // Vacia los campos una vez registrado el usuario.
    public void limpiarCampos() {
        campoCedula.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoUsername.setText("");
        campoPassword.setText("");
        campoCorreo.setText("");
        campoTelefono.setText("");
        comboEstatus.setSelectedIndex(0);
        comboPermisos.setSelectedIndex(0);
    }
}
