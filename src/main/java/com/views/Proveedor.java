/**
 * Proveedor.java
 * Proporciona funcionalidades como consultar y mostrar proveedores en una tabla, buscar 
 * proveedores, editar y eliminar proveedores. 
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

import java.sql.*;
import com.clase.bd.Conexion;
import com.menu.DashboardAdmin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class Proveedor extends javax.swing.JPanel {

    public static String proveedorUpdate = "";
    // Evita que los datos de la tabla se editen.
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 5) {
                return true;
            } else {
                return false;
            }
        }
    };

    public Proveedor() {
        initComponents();
        initStyles();
        consultaTable();
        propertyColumnTable();
    }

    private void initStyles() {
        // Tipografía para el título principal.
        tituloProveedor.putClientProperty("FlatLaf.styleClass", "h1");
        tituloProveedor.setForeground(new java.awt.Color(90, 58, 201));

        // Texto dentro de los campos, indicando la información que se debe introducir.
        search.putClientProperty("JTextField.placeholderText", "Ingrese el proveedor que desea buscar.");

        // Propiedades para el ScrollPane.
        scrollPane.putClientProperty("JScrollBar.showButtons", true);

        // Propiedades del botón (redondo).
        botonBuscar.putClientProperty("JButton.buttonType", "roundRect");
        botonEditar.putClientProperty("JButton.buttonType", "roundRect");
        botonNuevo.putClientProperty("JButton.buttonType", "roundRect");
        botonBorrar.putClientProperty("JButton.buttonType", "roundRect");
    }

    // Método que cambia las propiedades de la tabla.
    private void propertyColumnTable() {

        // Margen de las celdas de la tabla
        tablaProveedor.getColumnModel().setColumnMargin(45);

        // Alto de filas
        tablaProveedor.setRowHeight(22);

        // Ancho de columnas
        tablaProveedor.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaProveedor.getColumnModel().getColumn(0).setResizable(false);

        tablaProveedor.getColumnModel().getColumn(1).setPreferredWidth(20);
        tablaProveedor.getColumnModel().getColumn(1).setResizable(false);

        tablaProveedor.getColumnModel().getColumn(2).setPreferredWidth(30);
        tablaProveedor.getColumnModel().getColumn(2).setResizable(false);

        tablaProveedor.getColumnModel().getColumn(3).setPreferredWidth(140);
        tablaProveedor.getColumnModel().getColumn(3).setResizable(false);

        tablaProveedor.getColumnModel().getColumn(4).setPreferredWidth(30);
        tablaProveedor.getColumnModel().getColumn(4).setResizable(false);
    }

    // Método que consulta en la BD y muestra los proveedores registrados en la tabla.
    private void consultaTable() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT id_proveedor, nombre, apellido, direccion, telefono "
                    + "FROM proveedor ORDER BY id_proveedor");

            ResultSet rs = pst.executeQuery();

            tablaProveedor = new JTable(model);
            scrollPane.setViewportView(tablaProveedor);

            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Dirección");
            model.addColumn("Teléfono");

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en llenar la tabla." + e);
            JOptionPane.showMessageDialog(null, "¡Error en mostrar la información! Póngase en "
                    + "contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean eliminarProveedores(List<String> ids) {
        try {
            Connection cn = Conexion.conectar();
            StringBuilder consulta = new StringBuilder();
            consulta.append("DELETE FROM proveedor WHERE id_proveedor IN (");
            for (int i = 0; i < ids.size(); i++) {
                consulta.append("?");
                if (i < ids.size() - 1) {
                    consulta.append(",");
                }
            }
            consulta.append(")");
            PreparedStatement pst = cn.prepareStatement(consulta.toString());
            for (int i = 0; i < ids.size(); i++) {
                pst.setString(i + 1, ids.get(i));
            }
            int resultado = pst.executeUpdate();
            cn.close();

            return resultado > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar proveedores: " + e);
            JOptionPane.showMessageDialog(null, "¡Error al eliminar proveedores! Póngase en "
                    + "contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
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
        tituloProveedor = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        botonNuevo = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 490));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloProveedor.setText("Proveedores");

        botonBuscar.setBackground(new java.awt.Color(90, 58, 201));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.setBorderPainted(false);
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaProveedor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Apellido", "Dirección", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProveedor.setFocusable(false);
        tablaProveedor.getTableHeader().setResizingAllowed(false);
        tablaProveedor.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tablaProveedor);
        if (tablaProveedor.getColumnModel().getColumnCount() > 0) {
            tablaProveedor.getColumnModel().getColumn(0).setResizable(false);
            tablaProveedor.getColumnModel().getColumn(1).setResizable(false);
            tablaProveedor.getColumnModel().getColumn(2).setResizable(false);
            tablaProveedor.getColumnModel().getColumn(3).setResizable(false);
            tablaProveedor.getColumnModel().getColumn(4).setResizable(false);
        }

        botonNuevo.setBackground(new java.awt.Color(90, 58, 201));
        botonNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonNuevo.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevo.setText("Nuevo");
        botonNuevo.setBorderPainted(false);
        botonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonEditar.setBackground(new java.awt.Color(90, 58, 201));
        botonEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonEditar.setText("Editar");
        botonEditar.setBorderPainted(false);
        botonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonBorrar.setBackground(new java.awt.Color(90, 58, 201));
        botonBorrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        botonBorrar.setText("Borrar");
        botonBorrar.setBorderPainted(false);
        botonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloProveedor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(botonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(botonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(scrollPane))
                        .addGap(35, 35, 35))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tituloProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        DashboardAdmin.ShowJPanel(new UpProveedor());
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // Cambia el idioma de los botones del cuadro de diálogo JOptionPane a español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");

        // Obtiene los índices de las filas seleccionadas en la tabla
        int[] filasSeleccionadas = tablaProveedor.getSelectedRows();

        // Verifica si hay filas seleccionadas
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona al menos un proveedor para eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Prepara el mensaje de confirmación
        String mensajeConfirmacion;
        if (filasSeleccionadas.length == 1) {
            mensajeConfirmacion = "¿Está seguro(a) de eliminar el proveedor seleccionado?";
        } else {
            mensajeConfirmacion = "¿Está seguro(a) de eliminar los " + filasSeleccionadas.length + " proveedores seleccionados?";
        }

        // Muestra el mensaje de confirmación antes de eliminar los usuarios
        int opcion = JOptionPane.showConfirmDialog(null, mensajeConfirmacion,
                "Eliminar proveedor", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<String> ids = new ArrayList<>();

            // Obtén los valores de la columna "Cedula" de las filas seleccionadas
            for (int filaSeleccionada : filasSeleccionadas) {
                String ids1 = tablaProveedor.getValueAt(filaSeleccionada, 0).toString();
                ids.add(ids1);
            }

            // Realiza la eliminación de las filas en la base de datos
            if (eliminarProveedores(ids)) {
                // Elimina las filas de la tabla
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    model.removeRow(filasSeleccionadas[i]);
                }

                // Determinar el mensaje a mostrar
                String mensaje;
                if (filasSeleccionadas.length == 1) {
                    mensaje = "Proveedor eliminado correctamente.";

                } else {
                    mensaje = "Proveedores eliminados correctamente.";

                }

                JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los proveedores.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed

        int filaSeleccionada = tablaProveedor.getSelectedRow();
        if (filaSeleccionada != -1) {

            // Obtiene los datos del usuario seleccionado en la tabla.
            String codigo = tablaProveedor.getValueAt(filaSeleccionada, 0).toString();
            String nombre = tablaProveedor.getValueAt(filaSeleccionada, 1).toString();
            String apellido = tablaProveedor.getValueAt(filaSeleccionada, 2).toString();
            String direccion = tablaProveedor.getValueAt(filaSeleccionada, 3).toString();
            String telefono = tablaProveedor.getValueAt(filaSeleccionada, 4).toString();

            // Mostrar el JPanel "EditProducto" y establecer los valores de los campos
            EditProveedor editProveedorPanel = new EditProveedor();
            editProveedorPanel.setProveedorSeleccionado(nombre, apellido); // Obtiene el nombre y apellido de la tabla dentro de los parentesis.
            editProveedorPanel.nombreProveedor();
            editProveedorPanel.setDatos(codigo, nombre, apellido, direccion, telefono);

            // Mostrar el JPanel "EditProducto" en el DashboardAdmin
            DashboardAdmin.ShowJPanel(editProveedorPanel);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor de la tabla.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        String terminoBusqueda = search.getText().trim();

        // Validar que se haya ingresado un término de búsqueda válido
        if (terminoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un término de búsqueda.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Realiza la búsqueda en la base de datos y muestra los resultados.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst;
            String consulta = "SELECT * FROM proveedor WHERE id_proveedor LIKE ? OR nombre LIKE ? OR apellido LIKE ? "
                    + "OR direccion LIKE ? OR telefono LIKE ?";

            pst = cn.prepareStatement(consulta);

            // Utilizar el término de búsqueda en los parámetros de la consulta
            pst.setString(1, "%" + terminoBusqueda + "%");
            pst.setString(2, "%" + terminoBusqueda + "%");
            pst.setString(3, "%" + terminoBusqueda + "%");
            pst.setString(4, "%" + terminoBusqueda + "%");
            pst.setString(5, "%" + terminoBusqueda + "%");

            ResultSet rs = pst.executeQuery();

            // Crea un StringBuilder para almacenar los resultados de la búsqueda.
            StringBuilder resultados = new StringBuilder();

            // Recorre los resultados de la consulta y agrega al StringBuilder.
            while (rs.next()) {
                String codigo = rs.getString("id_proveedor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                resultados.append("Código: ").append(codigo).append("\n");
                resultados.append("Nombre: ").append(nombre).append("\n");
                resultados.append("Apellido: ").append(apellido).append("\n");
                resultados.append("Dirección: ").append(direccion).append("\n");
                resultados.append("Teléfono: ").append(telefono).append("\n\n");
            }

            cn.close();

            // Muestra los resultados de la búsqueda en un JOptionPane.
            if (resultados.length() > 0) {
                JOptionPane.showMessageDialog(null, resultados.toString(), "Resultados de búsqueda",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.", "Error en búsqueda",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            System.err.println("Error en la búsqueda: " + e);
            JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda. Por favor, intenta "
                    + "nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField search;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JLabel tituloProveedor;
    // End of variables declaration//GEN-END:variables
}
