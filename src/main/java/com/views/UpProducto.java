/**
 * UpProducto.java
 * Esta clase representa la interfaz de usuario para registrar productos en el sistema.
 * Proporciona campos y controles para ingresar y validar la información de un producto, y permite 
 * registar la información de los campos en la base de datos.
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class UpProducto extends javax.swing.JPanel {

    public UpProducto() {
        initComponents();
        initStyles();
        propertyTextArea();
        propertySpinner();
        disableSpinner();
    }

    private void initStyles() {
        // Tipografía para los títulos de los campos.
        tituloRegistrar.putClientProperty("FlatLaf.styleClass", "h1");
        tituloRegistrar.setForeground(new java.awt.Color(90, 58, 201));

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
        campoBarcode.putClientProperty("JTextField.placeholderText", "Ingrese el barcode.");
        campoNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre.");
        campoPrecio.putClientProperty("JTextField.placeholderText", "Ingrese el precio.");

        // Propiedades de los ComboBox, Spinner y botón (redondos).
        comboStock.putClientProperty("JComponent.roundRect", true);
        comboStock.putClientProperty("FlatLaf.style", "large");

        spinnerCantidad.putClientProperty("JComponent.roundRect", true);
        spinnerCantidad.putClientProperty("FlatLaf.style", "large");

        botonRegistrar.putClientProperty("JButton.buttonType", "roundRect");

    }

    // Realiza el salto de línea automático y se ajusta el texto al TextArea.
    private void propertyTextArea() {
        textAreaDescripcion.setLineWrap(true);
        textAreaDescripcion.setWrapStyleWord(true);

        String placeholder = "Ingrese una breve descripción del producto.";

        textAreaDescripcion.setText(placeholder);
        textAreaDescripcion.setForeground(Color.GRAY);

        textAreaDescripcion.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textAreaDescripcion.getText().equals(placeholder)) {
                    textAreaDescripcion.setText("");
                    textAreaDescripcion.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textAreaDescripcion.getText().isEmpty()) {
                    textAreaDescripcion.setText(placeholder);
                    textAreaDescripcion.setForeground(Color.GRAY);
                }
            }
        });
    }

    // Propiedades del Spinner.
    private void propertySpinner() {
        SpinnerNumberModel snp = new SpinnerNumberModel();
        snp.setMaximum(1000);
        snp.setMinimum(0);
        spinnerCantidad.setModel(snp);
    }
    
    // Si la opción del comboBox es "Agotado", el spinner se desactiva.
    private void disableSpinner() {
        comboStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboStock.getSelectedItem();
                boolean isAgotado = selectedOption.equals("Agotado");
                spinnerCantidad.setEnabled(!isAgotado);
                if (isAgotado) {
                    spinnerCantidad.setValue(0);
                }
            }
        });
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
        tituloRegistrar = new javax.swing.JLabel();
        tituloBarcode = new javax.swing.JLabel();
        campoBarcode = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloPrecio = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        separadorMitad = new javax.swing.JSeparator();
        tituloStock = new javax.swing.JLabel();
        comboStock = new javax.swing.JComboBox<>();
        tituloCantidad = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        tituloDescripcion = new javax.swing.JLabel();
        scrollPaneDescripcion = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        botonRegistrar = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloRegistrar.setText("Registrar Producto");

        tituloBarcode.setText("Barcode");

        tituloNombre.setText("Nombre");

        tituloPrecio.setText("Precio");

        separadorMitad.setForeground(new java.awt.Color(204, 204, 204));
        separadorMitad.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tituloStock.setText("Stock");

        comboStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la disponibilidad", "Disponible", "Agotado" }));

        tituloCantidad.setText("Cantidad");

        spinnerCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tituloDescripcion.setText("Descripción");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        scrollPaneDescripcion.setViewportView(textAreaDescripcion);

        botonRegistrar.setBackground(new java.awt.Color(90, 58, 201));
        botonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("Registrar");
        botonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
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
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(135, 135, 135))
                            .addComponent(campoNombre)
                            .addComponent(campoBarcode)
                            .addComponent(campoPrecio)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(comboStock, 0, 0, Short.MAX_VALUE)
                                .addGap(48, 48, 48)))
                        .addGap(116, 116, 116)
                        .addComponent(separadorMitad, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(186, 186, 186))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(spinnerCantidad)
                                .addGap(148, 148, 148))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(tituloDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(172, 172, 172))
                            .addComponent(scrollPaneDescripcion))
                        .addGap(90, 90, 90))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloRegistrar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(292, 292, 292))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tituloRegistrar)
                .addGap(24, 32, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorMitad, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPaneDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
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
                        .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboStock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
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

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed

        // Recoge los datos introducidos en los campos (JTextField).
        String barcode = campoBarcode.getText().trim();
        String nombre = campoNombre.getText().trim();
        String precio = campoPrecio.getText().trim();
        int stockCmb = comboStock.getSelectedIndex() + 1;
        int cantidadSpnr = (int) spinnerCantidad.getValue();
        String descripcion = textAreaDescripcion.getText().trim();

        // Límites de caracteres.
        int maxCaracteresBarcode = 13;
        int maxCaracteresNombre = 30;
        int maxCaracteresPrecio = 10;
        int maxCaracteresDescripcion = 100;

        // Validación de formato de barcode
        Pattern patternBarcode = Pattern.compile("^[0-9]{13}$");
        Matcher matcherBarcode = patternBarcode.matcher(barcode);

        if (!matcherBarcode.matches()) {
            JOptionPane.showMessageDialog(null, "El formato del código de barras no es válido. Debe contener exactamente 13 dígitos.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
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

        // Validación de selección de stock.
        String stock = null;
        switch (stockCmb) {
            case 1:
                stock = "";
                break;
            case 2:
                stock = "Disponible";
                break;
            case 3:
                stock = "Agotado";
                break;
            default:
                break;
        }

        if (stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una opción de disponibilidad.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validación de existencia de Barcode.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT barcode FROM producto WHERE barcode = ?");

            pst.setString(1, barcode);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El barcode se encuentra registrado.", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);

                cn.close();

            } else {
                cn.close();

                // Insertación de datos en la BD y método para limpiar los campos.
                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "INSERT INTO producto (barcode, nombre, precio, stock, cantidad, descripcion, fecha_creacion) VALUES (?, ?, ?, ?, ?, ?, NOW())");

                    pst2.setString(1, barcode);
                    pst2.setString(2, nombre);
                    pst2.setString(3, precio);
                    pst2.setString(4, stock);
                    pst2.setInt(5, cantidadSpnr);
                    pst2.setString(6, descripcion);

                    pst2.executeUpdate();
                    cn2.close();

                    // Método para vaciar los campos.
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Se ha registrado el producto con éxito.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException e) {
                    System.err.println("Error en registrar producto" + e);
                    JOptionPane.showMessageDialog(null, "¡Error al registrar producto! Póngase en "
                            + "contacto con el Administrador.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en validar el barcode." + e);
            JOptionPane.showMessageDialog(null, "¡Error al comparar el barcode! Póngase en "
                    + "contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField campoBarcode;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JComboBox<String> comboStock;
    private javax.swing.JScrollPane scrollPaneDescripcion;
    private javax.swing.JSeparator separadorMitad;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel tituloBarcode;
    private javax.swing.JLabel tituloCantidad;
    private javax.swing.JLabel tituloDescripcion;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloPrecio;
    private javax.swing.JLabel tituloRegistrar;
    private javax.swing.JLabel tituloStock;
    // End of variables declaration//GEN-END:variables

    // Vacia los campos una vez registrado el usuario.
    public void limpiarCampos() {
        campoBarcode.setText("");
        campoNombre.setText("");
        campoPrecio.setText("");
        comboStock.setSelectedIndex(0);
        spinnerCantidad.setValue(0);
        textAreaDescripcion.setText("");
    }
}
