/**
 * Usuario.java
 * Proporciona funcionalidades como consultar y mostrar usuarios en una tabla, buscar usuarios, 
 * editar y eliminar usuarios. 
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

/**
 *
 * @author Smith Marcano
 */
public class Usuario extends javax.swing.JPanel {

    public static String userUpdate = "";
    // Evita que los datos de la tablan se editen.
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 8) {
                return true;
            } else {
                return false;
            }
        }
    };

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        initStyles();
        consultaTable();
        propertyColumnTable();
    }

    private void initStyles() {
        // Tipografía para el título principal.
        tituloUsuario.putClientProperty("FlatLaf.styleClass", "h1");
        tituloUsuario.setForeground(new java.awt.Color(90, 58, 201));

        // Texto dentro de los campos, indicando la información que se debe introducir.
        search.putClientProperty("JTextField.placeholderText", "Ingrese el usuario que desea buscar.");

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
        tablaUsuario.getColumnModel().setColumnMargin(14);

        // Alto de filas
        tablaUsuario.setRowHeight(22);

        // Ancho de columnas
        tablaUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaUsuario.getColumnModel().getColumn(0).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(1).setPreferredWidth(55);
        tablaUsuario.getColumnModel().getColumn(1).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(2).setPreferredWidth(55);
        tablaUsuario.getColumnModel().getColumn(2).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(3).setPreferredWidth(70);
        tablaUsuario.getColumnModel().getColumn(3).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(4).setPreferredWidth(85);
        tablaUsuario.getColumnModel().getColumn(4).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(5).setPreferredWidth(65);
        tablaUsuario.getColumnModel().getColumn(5).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(6).setPreferredWidth(40);
        tablaUsuario.getColumnModel().getColumn(6).setResizable(false);

        tablaUsuario.getColumnModel().getColumn(7).setPreferredWidth(75);
        tablaUsuario.getColumnModel().getColumn(7).setResizable(false);
    }

    // Método que consulta en la BD y muestra los usuarios registrados en la tabla.
    private void consultaTable() {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT cedula, nombre, apellido, username,"
                    + "correo, telefono, estatus, tipo_nivel FROM usuario");

            ResultSet rs = pst.executeQuery();

            tablaUsuario = new JTable(model);
            scrollPane.setViewportView(tablaUsuario);

            model.addColumn("Cedula");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Username");
            model.addColumn("Correo");
            model.addColumn("Teléfono");
            model.addColumn("Estatus");
            model.addColumn("Permisos");

            while (rs.next()) {
                Object[] fila = new Object[8];

                for (int i = 0; i < 8; i++) {
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

    private boolean eliminarUsuarios(List<String> cedulas) {
        try {
            Connection cn = Conexion.conectar();
            StringBuilder consulta = new StringBuilder();
            consulta.append("DELETE FROM usuario WHERE cedula IN (");
            for (int i = 0; i < cedulas.size(); i++) {
                consulta.append("?");
                if (i < cedulas.size() - 1) {
                    consulta.append(",");
                }
            }
            consulta.append(")");
            PreparedStatement pst = cn.prepareStatement(consulta.toString());
            for (int i = 0; i < cedulas.size(); i++) {
                pst.setString(i + 1, cedulas.get(i));
            }

            // Ejecuta la consulta de eliminación
            int resultado = pst.executeUpdate();
            cn.close();

            return resultado > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar los usuarios: " + e);
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
        tituloUsuario = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        botonNuevo = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 490));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloUsuario.setText("Usuarios");

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

        tablaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Username", "Correo", "Teléfono", "Estatus", "Permisos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuario.setFocusable(false);
        tablaUsuario.getTableHeader().setResizingAllowed(false);
        tablaUsuario.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(tablaUsuario);
        if (tablaUsuario.getColumnModel().getColumnCount() > 0) {
            tablaUsuario.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(3).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(4).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(5).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(6).setResizable(false);
            tablaUsuario.getColumnModel().getColumn(7).setResizable(false);
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
                        .addComponent(tituloUsuario)
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
                .addComponent(tituloUsuario)
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
        DashboardAdmin.ShowJPanel(new UpUsuario());
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // Cambia el idioma de los botones del cuadro de diálogo JOptionPane a español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");

        // Obtiene los índices de las filas seleccionadas en la tabla
        int[] filasSeleccionadas = tablaUsuario.getSelectedRows();

        // Verifica si hay filas seleccionadas
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona al menos un usuario para eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Prepara el mensaje de confirmación
        String mensajeConfirmacion;
        if (filasSeleccionadas.length == 1) {
            mensajeConfirmacion = "¿Está seguro(a) de eliminar el usuario seleccionado?";
        } else {
            mensajeConfirmacion = "¿Está seguro(a) de eliminar los " + filasSeleccionadas.length + " usuarios seleccionados?";
        }

        // Muestra el mensaje de confirmación antes de eliminar los usuarios
        int opcion = JOptionPane.showConfirmDialog(null, mensajeConfirmacion,
                "Eliminar elementos", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            List<String> cedulas = new ArrayList<>();

            // Obtén los valores de la columna "Cedula" de las filas seleccionadas
            for (int filaSeleccionada : filasSeleccionadas) {
                String cedula = tablaUsuario.getValueAt(filaSeleccionada, 0).toString();
                cedulas.add(cedula);
            }

            // Realiza la eliminación de las filas en la base de datos
            if (eliminarUsuarios(cedulas)) {
                // Elimina las filas de la tabla
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    model.removeRow(filasSeleccionadas[i]);
                }

                // Determinar el mensaje a mostrar
                String mensaje;
                if (filasSeleccionadas.length == 1) {
                    mensaje = "Usuario eliminado correctamente.";

                } else {
                    mensaje = "Usuarios eliminados correctamente.";

                }

                JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed

        int filaSeleccionada = tablaUsuario.getSelectedRow();
        if (filaSeleccionada != -1) {

            // Obtiene los datos del usuario seleccionado en la tabla.
            String cedula = tablaUsuario.getValueAt(filaSeleccionada, 0).toString();
            String nombre = tablaUsuario.getValueAt(filaSeleccionada, 1).toString();
            String apellido = tablaUsuario.getValueAt(filaSeleccionada, 2).toString();
            String username = tablaUsuario.getValueAt(filaSeleccionada, 3).toString();
            String correo = tablaUsuario.getValueAt(filaSeleccionada, 4).toString();
            String telefono = tablaUsuario.getValueAt(filaSeleccionada, 5).toString();
            String estatus = tablaUsuario.getValueAt(filaSeleccionada, 6).toString();
            String permisos = tablaUsuario.getValueAt(filaSeleccionada, 7).toString();

            // Realiza una consulta adicional para obtener la contraseña del usuario.
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT contraseña FROM usuario WHERE cedula = ?");
                pst.setString(1, cedula);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String contraseña = rs.getString("contraseña");

                    // Mostrar el JPanel "EditUsuario" y establecer los valores de los campos
                    EditUsuario editUsuarioPanel = new EditUsuario();
                    editUsuarioPanel.setUsuarioSeleccionado(nombre, apellido); // Obtiene el nombre y apellido de la tabla dentro de los parentesis.
                    editUsuarioPanel.nombreUsuario();
                    editUsuarioPanel.setDatos(cedula, nombre, apellido, username, contraseña, correo, telefono, estatus, permisos);

                    // Mostrar el JPanel "EditUsuario" en el DashboardAdmin
                    DashboardAdmin.ShowJPanel(editUsuarioPanel);
                }

                cn.close();

            } catch (SQLException e) {
                System.err.println("Error al obtener la contraseña del usuario: " + e);
                JOptionPane.showMessageDialog(null, "¡Error al obtener la contraseña del usuario! "
                        + "Póngase en contacto con el Administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla.", "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // Obtener el término de búsqueda ingresado por el usuario
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
            String consulta;

            // Verificar si el término de búsqueda es "Activo" o "Inactivo"
            if (terminoBusqueda.equalsIgnoreCase("Activo")) {
                consulta = "SELECT * FROM usuario WHERE estatus = 'Activo'";
                pst = cn.prepareStatement(consulta);
                
            } else if (terminoBusqueda.equalsIgnoreCase("Inactivo")) {
                consulta = "SELECT * FROM usuario WHERE estatus = 'Inactivo'";
                pst = cn.prepareStatement(consulta);
                
            } else {
                consulta = "SELECT * FROM usuario WHERE cedula LIKE ? OR nombre LIKE ? OR apellido LIKE ? "
                        + "OR username LIKE ? OR contraseña LIKE ? OR correo LIKE ? OR telefono LIKE ? OR estatus LIKE ? OR tipo_nivel LIKE ?";
                
                pst = cn.prepareStatement(consulta);

                // Utilizar el término de búsqueda en los parámetros de la consulta
                pst.setString(1, "%" + terminoBusqueda + "%");
                pst.setString(2, "%" + terminoBusqueda + "%");
                pst.setString(3, "%" + terminoBusqueda + "%");
                pst.setString(4, "%" + terminoBusqueda + "%");
                pst.setString(5, "%" + terminoBusqueda + "%");
                pst.setString(6, "%" + terminoBusqueda + "%");
                pst.setString(7, "%" + terminoBusqueda + "%");
                pst.setString(8, "%" + terminoBusqueda + "%");
                pst.setString(9, "%" + terminoBusqueda + "%");
            }

            ResultSet rs = pst.executeQuery();

            // Crea un StringBuilder para almacenar los resultados de la búsqueda.
            StringBuilder resultados = new StringBuilder();

            // Recorre los resultados de la consulta y agrega al StringBuilder.
            while (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String username = rs.getString("username");
                String contraseña = rs.getString("contraseña");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String estatus = rs.getString("estatus");
                String permisos = rs.getString("tipo_nivel");

                resultados.append("Cédula: ").append(cedula).append("\n");
                resultados.append("Nombre: ").append(nombre).append("\n");
                resultados.append("Apellido: ").append(apellido).append("\n");
                resultados.append("Username: ").append(username).append("\n");
                resultados.append("Contraseña: ").append(contraseña).append("\n");
                resultados.append("Correo: ").append(correo).append("\n");
                resultados.append("Teléfono: ").append(telefono).append("\n");
                resultados.append("Estatus: ").append(estatus).append("\n");
                resultados.append("Permisos: ").append(permisos).append("\n\n");
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
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JLabel tituloUsuario;
    // End of variables declaration//GEN-END:variables
}
