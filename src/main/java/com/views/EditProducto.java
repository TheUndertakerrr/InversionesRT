/**
 * EditProducto.java
 * Implementa la funcionalidad de interfaz de usuario para editar y actualizar información de un producto
 * en el sistema.
 * Proporciona campos para modificar el código, el barcode, el nombre, el precio, el stock, la cantidad
 * y la descripción del producto.  
 * Además de eso, incluye validaciones de datos y se conecta a una base de datos para realizar las 
 * actualizaciones correspondientes.
 * Esta clase también ofrece opciones de limpieza de campos y validación de formatos de barcode.
 * Permite una gestión eficiente y sencilla de la información de los productos."
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
import javax.swing.SpinnerNumberModel;

public class EditProducto extends javax.swing.JPanel {

    String productoUpdate = "";

    public EditProducto() {
        initComponents();
        initStyles();
        campoCodigo.setEditable(false);
        propertyTextArea();
        propertySpinner();
    }

    private void initStyles() {
        // Tipografía para los títulos de los campos.
        tituloGestionar.putClientProperty("FlatLaf.styleClass", "h1");
        tituloGestionar.setForeground(new java.awt.Color(90, 58, 201));

        tituloCodigo.putClientProperty("FlatLaf.styleClass", "h3");
        tituloCodigo.setForeground(Color.DARK_GRAY);

        tituloBarcode.putClientProperty("FlatLaf.styleClass", "h3");
        tituloBarcode.setForeground(Color.DARK_GRAY);

        tituloNombre.putClientProperty("FlatLaf.styleClass", "h3");
        tituloNombre.setForeground(Color.DARK_GRAY);

        tituloPrecio.putClientProperty("FlatLaf.styleClass", "h3");
        tituloPrecio.setForeground(Color.DARK_GRAY);

        tituloStock.putClientProperty("FlatLaf.styleClass", "h3");
        tituloStock.setForeground(Color.DARK_GRAY);

        tituloCantidad.putClientProperty("FlatLaf.styleClass", "h3");
        tituloCantidad.setForeground(Color.DARK_GRAY);

        tituloDescripcion.putClientProperty("FlatLaf.styleClass", "h3");
        tituloDescripcion.setForeground(Color.DARK_GRAY);

        // Texto dentro de los campos, indicando la información que se debe introducir.
        campoBarcode.putClientProperty("JTextField.placeholderText", "Ingrese el barcode del producto.");
        campoNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre.");
        campoPrecio.putClientProperty("JTextField.placeholderText", "Ingrese el precio.");

        // Propiedades de los ComboBox (redondos).
        comboStock.putClientProperty("JComponent.roundRect", true);
        comboStock.putClientProperty("FlatLaf.style", "large");

        spinnerCantidad.putClientProperty("JComponent.roundRect", true);
        spinnerCantidad.putClientProperty("FlatLaf.style", "large");

        // Propiedades del botón (redondo).
        botonActualizar.putClientProperty("JButton.buttonType", "roundRect");
    }

    // Realiza el salto de línea automático y se ajusta el texto al TextArea.
    private void propertyTextArea() {
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);
    }

    // Propiedades del Spinner.
    private void propertySpinner() {
        SpinnerNumberModel snp = new SpinnerNumberModel();
        snp.setMaximum(1000);
        snp.setMinimum(0);
        spinnerCantidad.setModel(snp);
    }

    // Recoge el barcode del producto seleccionado.
    public void setProductoSeleccionado(String barcode) {
        productoUpdate = barcode;
    }

    // Muestra el barcode del producto que se va a editar.
    public void nombreProducto() {
        tituloGestionar.setText("Gestionar Producto de Barcode - " + productoUpdate);
    }

    // Método que me recoge los datos del producto seleccionado.
    public void setDatos(String codigo, String barcode, String nombre, String precio, String stock, String cantidad, String descripcion) {
        campoCodigo.setText(codigo);
        campoBarcode.setText(barcode);
        campoNombre.setText(nombre);
        campoPrecio.setText(precio);
        textAreaDescripcion.setText(descripcion);

        // Configura el valor para que recoja el Spinner.
        int cantidadValue = Integer.parseInt(cantidad);
        SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinnerCantidad.getModel();
        spinnerModel.setValue(cantidadValue);

        // Configura el valor seleccionado en los JComboBox
        if (stock.equals("Disponible")) {
            comboStock.setSelectedIndex(1);

        } else if (stock.equals("Agotado")) {
            comboStock.setSelectedIndex(2);
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
        tituloCodigo = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        tituloBarcode = new javax.swing.JLabel();
        campoBarcode = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloPrecio = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        separadorFormulario = new javax.swing.JSeparator();
        tituloStock = new javax.swing.JLabel();
        comboStock = new javax.swing.JComboBox<>();
        tituloCantidad = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        tituloDescripcion = new javax.swing.JLabel();
        scrollPaneDescripcion = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        botonActualizar = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloGestionar.setText("Gestionar Producto");

        tituloCodigo.setText("Código");

        tituloBarcode.setText("Barcode");

        tituloNombre.setText("Nombre");

        tituloPrecio.setText("Precio");

        separadorFormulario.setForeground(new java.awt.Color(204, 204, 204));
        separadorFormulario.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tituloStock.setText("Stock");

        comboStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la disponibilidad", "Disponible", "Agotado" }));

        tituloCantidad.setText("Cantidad");

        tituloDescripcion.setText("Descripción");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        scrollPaneDescripcion.setViewportView(textAreaDescripcion);

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
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloGestionar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(135, 135, 135))
                            .addComponent(campoNombre)
                            .addComponent(campoBarcode)
                            .addComponent(campoCodigo)
                            .addComponent(campoPrecio)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(129, 129, 129)))
                        .addGap(115, 115, 115)
                        .addComponent(separadorFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(205, 205, 205))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(186, 186, 186))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(spinnerCantidad)
                                .addGap(150, 150, 150))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(172, 172, 172))
                            .addComponent(scrollPaneDescripcion)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(comboStock, 0, 0, Short.MAX_VALUE)
                                .addGap(114, 114, 114)))))
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
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tituloCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(separadorFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloBarcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
        String barcode = campoBarcode.getText().trim();
        String nombre = campoNombre.getText().trim();
        String precio = campoPrecio.getText().trim();
        String stock = comboStock.getSelectedItem().toString();
        int cantidad = (int) spinnerCantidad.getValue();
        String descripcion = textAreaDescripcion.getText().trim();

        // Límites de caracteres.
        int maxCaracteresBarcode = 13;
        int maxCaracteresNombre = 30;
        int maxCaracteresPrecio = 10;
        int maxCaracteresDescripcion = 100;

        // Verificar si el símbolo "Bs" está presente y eliminarlo si es necesario.
        if (precio.endsWith("Bs")) {
            precio = precio.substring(0, precio.length() - 2).trim();
        }

        // Validación de campos vacíos.
        if (barcode.isEmpty() || nombre.isEmpty() || precio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de longitud de campos
        if (barcode.length() > maxCaracteresBarcode || nombre.length() > maxCaracteresNombre
                || precio.length() > maxCaracteresPrecio || descripcion.length() > maxCaracteresDescripcion) {
            JOptionPane.showMessageDialog(null, "Se ha excedido el límite de caracteres en uno o más campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación de formato de barcode.
        if (!validarFormatoBarcode(barcode)) {
            JOptionPane.showMessageDialog(null, "El formato del barcode no es válido.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (actualizarDatosProducto(codigo, barcode, nombre, precio, stock, cantidad, descripcion)) {
            limpiarCampos();

            textAreaDescripcion.setText("Ingrese una breve descripción del producto.");
            textAreaDescripcion.setForeground(Color.GRAY);

            JOptionPane.showMessageDialog(null, "Actualización exitosa.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡Error al actualizar los datos del producto!"
                    + " Póngase en contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Formato para la validación del correo electrónico.
    private boolean validarFormatoBarcode(String barcode) {
        Pattern patternBarcode = Pattern.compile("^[0-9]{13}$");
        Matcher matcherBarcode = patternBarcode.matcher(barcode);
        return matcherBarcode.matches();
    }

    // Actualiza los datos del usuario en la tabla y en la base de datos.
    private boolean actualizarDatosProducto(String codigo, String barcode, String nombre, String precio, String stock, int cantidad, String descripcion) {
        try {
            Connection cn = Conexion.conectar();

            // Verificar si el barcode ha sido modificado
            if (!barcode.equals(obtenerBarcodeOriginal(codigo))) {
                // Verificar la existencia del nuevo barcode en la base de datos
                if (verificarExistenciaBarcode(barcode)) {
                    JOptionPane.showMessageDialog(null, "El barcode ya está en uso.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    cn.close();
                    return false;
                }
            }

            PreparedStatement pst = cn.prepareStatement(
                    "UPDATE producto SET barcode = ?, nombre = ?, precio = ?, stock = ?, cantidad = ?, descripcion = ? WHERE codigo_prod = ?");

            pst.setString(1, barcode);
            pst.setString(2, nombre);
            pst.setString(3, precio);
            pst.setString(4, stock);
            pst.setInt(5, cantidad);
            pst.setString(6, descripcion);
            pst.setString(7, codigo);

            int resultado = pst.executeUpdate();
            cn.close();

            return resultado > 0; // Devuelve true si se actualizó al menos un registro

        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del producto: " + e);
            return false;
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private boolean verificarExistenciaBarcode(String barcode) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT barcode FROM producto WHERE barcode = ?");
            pst.setString(1, barcode);

            ResultSet rs = pst.executeQuery();

            boolean existeBarcode = rs.next();

            cn.close();

            return existeBarcode;

        } catch (SQLException e) {
            System.err.println("Error al verificar la existencia del barcode en la base de datos: " + e);
            return false;
        }
    }

    private String obtenerBarcodeOriginal(String codigo) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT barcode FROM producto WHERE codigo_prod = ?");
            pst.setString(1, codigo);

            ResultSet rs = pst.executeQuery();

            String barcodeOriginal = "";

            if (rs.next()) {
                barcodeOriginal = rs.getString("barcode");
            }

            cn.close();

            return barcodeOriginal;

        } catch (SQLException e) {
            System.err.println("Error al obtener el barcode original: " + e);
            return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JTextField campoBarcode;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JComboBox<String> comboStock;
    private javax.swing.JScrollPane scrollPaneDescripcion;
    private javax.swing.JSeparator separadorFormulario;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel tituloBarcode;
    private javax.swing.JLabel tituloCantidad;
    private javax.swing.JLabel tituloCodigo;
    private javax.swing.JLabel tituloDescripcion;
    private javax.swing.JLabel tituloGestionar;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloPrecio;
    private javax.swing.JLabel tituloStock;
    // End of variables declaration//GEN-END:variables

    // Vacia los campos una vez registrado el usuario.
    public void limpiarCampos() {
        campoCodigo.setText("");
        campoBarcode.setText("");
        campoNombre.setText("");
        campoPrecio.setText("");
        comboStock.setSelectedIndex(0);
        spinnerCantidad.setValue(0);
        textAreaDescripcion.setText("");
    }
}
