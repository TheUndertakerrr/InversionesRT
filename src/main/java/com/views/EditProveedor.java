/**
 * EditProveedor.java
 * Esta clase representa la interfaz de usuario para editar la información de un proveedor en el sistema.
 * Permite modificar el nombre, apellido, dirección y número de teléfono del proveedor seleccionado.
 * Adicionalmente, valida los datos ingresados y actualiza los registros correspondientes en la base de 
 * datos.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class EditProveedor extends javax.swing.JPanel {

    String proveedorUpdate = "";

    public EditProveedor() {
        initComponents();
        initStyles();
        campoCodigo.setEditable(false);
        propertyTextArea();
    }

    private void initStyles() {
        // Tipografía para los títulos de los campos.
        tituloGestionar.putClientProperty("FlatLaf.styleClass", "h1");
        tituloGestionar.setForeground(new java.awt.Color(90, 58, 201));

        tituloCodigo.putClientProperty("FlatLaf.styleClass", "h3");
        tituloCodigo.setForeground(Color.DARK_GRAY);

        tituloNombre.putClientProperty("FlatLaf.styleClass", "h3");
        tituloNombre.setForeground(Color.DARK_GRAY);

        tituloApellido.putClientProperty("FlatLaf.styleClass", "h3");
        tituloApellido.setForeground(Color.DARK_GRAY);

        tituloDireccion.putClientProperty("FlatLaf.styleClass", "h3");
        tituloDireccion.setForeground(Color.DARK_GRAY);

        tituloTelefono.putClientProperty("FlatLaf.styleClass", "h3");
        tituloTelefono.setForeground(Color.DARK_GRAY);

        // Texto dentro de los campos, indicando la información que se debe introducir.
        campoNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre.");
        campoApellido.putClientProperty("JTextField.placeholderText", "Ingrese el apellido.");
        campoTelefono.putClientProperty("JTextField.placeholderText", "Ingrese el teléfono.");

        // Propiedades del botón (redondo).
        botonActualizar.putClientProperty("JButton.buttonType", "roundRect");
    }

    // Realiza el salto de línea automático y se ajusta el texto al TextArea.
    private void propertyTextArea() {
        textAreaDireccion.setLineWrap(true);
        textAreaDireccion.setWrapStyleWord(true);
    }

    // Recoge el nombre y apellido del proveedor.
    public void setProveedorSeleccionado(String nombre, String apellido) {
        proveedorUpdate = nombre + " " + apellido;
    }

    // Muestra el nombre y apellido del proveedor que se va a editar.
    public void nombreProveedor() {
        tituloGestionar.setText("Gestionar Proveedor de - " + proveedorUpdate);
    }

    // Método que me recoge los datos del proveedor seleccionado.
    public void setDatos(String codigo, String nombre, String apellido, String direccion, String telefono) {
        campoCodigo.setText(codigo);
        campoNombre.setText(nombre);
        campoApellido.setText(apellido);
        textAreaDireccion.setText(direccion);
        campoTelefono.setText(telefono);
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
        tituloCodigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloApellido = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        separadorFormulario = new javax.swing.JSeparator();
        tituloDireccion = new javax.swing.JLabel();
        scrollPaneDireccion = new javax.swing.JScrollPane();
        textAreaDireccion = new javax.swing.JTextArea();
        tituloTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloGestionar.setText("Gestionar Proveedor");

        tituloCodigo.setText("Código");

        tituloNombre.setText("Nombre");

        tituloApellido.setText("Apellido");

        separadorFormulario.setForeground(new java.awt.Color(204, 204, 204));
        separadorFormulario.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tituloDireccion.setText("Dirección");

        textAreaDireccion.setColumns(20);
        textAreaDireccion.setRows(5);
        scrollPaneDireccion.setViewportView(textAreaDireccion);

        tituloTelefono.setText("Teléfono");

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

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloGestionar)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellido)
                            .addComponent(campoNombre)
                            .addComponent(campoCodigo)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(129, 129, 129)))
                        .addGap(115, 115, 115)
                        .addComponent(separadorFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(184, 184, 184))
                            .addComponent(scrollPaneDireccion)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(188, 188, 188))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(campoTelefono)
                                .addGap(66, 66, 66)))))
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(292, 292, 292))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tituloGestionar)
                .addGap(41, 41, 41)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPaneDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(separadorFormulario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
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
        String codigo = campoCodigo.getText().trim();
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellido.getText().trim();
        String direccion = textAreaDireccion.getText().trim();
        String telefono = campoTelefono.getText().trim();

        // Límites de caracteres.
        int maxCaracteresNombre = 30;
        int maxCaracteresApellido = 30;
        int maxCaracteresTelefono = 11;

        // Validación de formato de número de teléfono
        Pattern patternTelefono = Pattern.compile("^\\d{11}$");
        Matcher matcherTelefono = patternTelefono.matcher(telefono);

        if (!matcherTelefono.matches()) {
            JOptionPane.showMessageDialog(null, "El formato del número de teléfono no es válido.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de campos vacíos.
        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de longitud de campos
        if (nombre.length() > maxCaracteresNombre || apellido.length() > maxCaracteresApellido
                || telefono.length() > maxCaracteresTelefono) {
            JOptionPane.showMessageDialog(null, "Se ha excedido el límite de caracteres en uno o más campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar la longitud de la dirección
        if (direccion.length() > 100) { // Ajusta el tamaño máximo permitido según la estructura de tabla
            JOptionPane.showMessageDialog(null, "La dirección es demasiado larga. Por favor, ingresa una dirección más corta.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener el proceso de registro.
        }

        if (actualizarDatosProveedor(codigo, nombre, apellido, direccion, telefono)) {
            limpiarCampos();

            textAreaDireccion.setText("Ingrese la dirección del proveedor.");
            textAreaDireccion.setForeground(Color.GRAY);
            
            JOptionPane.showMessageDialog(null, "Actualización exitosa.", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "¡Error al actualizar los datos del proveedor!"
                    + " Póngase en contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Actualiza los datos del proveedor en la tabla y en la base de datos.
    private boolean actualizarDatosProveedor(String codigo, String nombre, String apellido, String direccion, String telefono) {
        try {
            Connection cn = Conexion.conectar();

            // Verificar si el teléfono ha sido modificado.
            if (!telefono.equals(obtenerTelefonoOriginal(telefono))) {
                // Verificar la existencia del nuevo teléfono en la base de datos.
                if (verificarExistenciaTelefono(telefono)) {
                    JOptionPane.showMessageDialog(null, "El número de teléfono ya está en uso.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    cn.close();
                    return false;
                }
            }

            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE proveedor SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id_proveedor = ?");

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, direccion);
            pst.setString(4, telefono);
            pst.setString(5, codigo);

            int resultado = pst.executeUpdate();
            cn.close();

            return resultado > 0; // Devuelve true si se actualizó al menos un registro.

        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del proveedor: " + e);
            return false;
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private boolean verificarExistenciaTelefono(String telefono) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT telefono FROM proveedor WHERE id_proveedor = ?");
            pst.setString(1, telefono);

            ResultSet rs = pst.executeQuery();

            boolean existeTelefono = rs.next();

            cn.close();

            return existeTelefono;

        } catch (SQLException e) {
            System.err.println("Error al verificar la existencia del teléfono en la base de datos: " + e);
            return false;
        }
    }

    private String obtenerTelefonoOriginal(String telefono) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT telefono FROM proveedor WHERE id_proveedor = ?");
            pst.setString(1, telefono);

            ResultSet rs = pst.executeQuery();

            String telefonoOriginal = "";

            if (rs.next()) {
                telefonoOriginal = rs.getString("telefono");
            }

            cn.close();

            return telefonoOriginal;

        } catch (SQLException e) {
            System.err.println("Error al obtener el teléfono original: " + e);
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JScrollPane scrollPaneDireccion;
    private javax.swing.JSeparator separadorFormulario;
    private javax.swing.JTextArea textAreaDireccion;
    private javax.swing.JLabel tituloApellido;
    private javax.swing.JLabel tituloCodigo;
    private javax.swing.JLabel tituloDireccion;
    private javax.swing.JLabel tituloGestionar;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloTelefono;
    // End of variables declaration//GEN-END:variables

    // Vacia los campos una vez registrado el usuario.
    public void limpiarCampos() {
        campoCodigo.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        textAreaDireccion.setText("");
        campoTelefono.setText("");
    }
}
