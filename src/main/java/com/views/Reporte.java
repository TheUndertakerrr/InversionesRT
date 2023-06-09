/**
 * Reporte.java
 * Esta clase se utiliza para generar reportes en PDF de usuarios, productos y proveedores. 
 * Cada método está asociado a un botón en la interfaz de usuario y se encarga de generar el reporte 
 * correspondiente con los datos obtenidos de una base de datos.
 * Se creará una carpeta en la ubicación predeterminada de Documentos llamada 
 * 'Reporte InversionesRT'. Dentro de esta carpeta, encontrarás tres subcarpetas: 'Reporte Usuarios',
 * 'Reporte Productos' y 'Reporte Proveedores'.
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

import com.clase.bd.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reporte extends javax.swing.JPanel {

    public Reporte() {
        initComponents();
        initStyle();
    }

    private void initStyle() {
        tituloGenerarReporte.putClientProperty("FlatLaf.styleClass", "h1");
        tituloGenerarReporte.setForeground(new java.awt.Color(90, 58, 201));

        tituloSeleccionar.putClientProperty("FlatLaf.styleClass", "h3");
        tituloSeleccionar.setForeground(Color.DARK_GRAY);

        tituloReporteUsuario.putClientProperty("FlatLaf.styleClass", "h2");
        tituloReporteUsuario.setForeground(new java.awt.Color(90, 58, 201));

        tituloReporteProducto.putClientProperty("FlatLaf.styleClass", "h2");
        tituloReporteProducto.setForeground(new java.awt.Color(90, 58, 201));

        tituloReporteProveedor.putClientProperty("FlatLaf.styleClass", "h2");
        tituloReporteProveedor.setForeground(new java.awt.Color(90, 58, 201));
    }

    /**
     * *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        tituloGenerarReporte = new javax.swing.JLabel();
        tituloSeleccionar = new javax.swing.JLabel();
        tituloReporteUsuario = new javax.swing.JLabel();
        botonReporteUsuario = new javax.swing.JButton();
        tituloReporteProducto = new javax.swing.JLabel();
        botonReporteProducto = new javax.swing.JButton();
        tituloReporteProveedor = new javax.swing.JLabel();
        botonReporteProveedor = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(0, 0, 0));

        tituloGenerarReporte.setText("Generar Reporte");

        tituloSeleccionar.setText("Seleccione la información que desea visualizar en el reporte.");

        tituloReporteUsuario.setText("Reporte de Usuarios");

        botonReporteUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reporte-usuario.png"))); // NOI18N
        botonReporteUsuario.setBorderPainted(false);
        botonReporteUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReporteUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteUsuarioActionPerformed(evt);
            }
        });

        tituloReporteProducto.setText("Reporte de Productos");

        botonReporteProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reporte-producto.png"))); // NOI18N
        botonReporteProducto.setBorderPainted(false);
        botonReporteProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReporteProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteProductoActionPerformed(evt);
            }
        });

        tituloReporteProveedor.setText("Reporte de Proveedores");

        botonReporteProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reporte-proveedor.png"))); // NOI18N
        botonReporteProveedor.setBorderPainted(false);
        botonReporteProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonReporteProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloReporteUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(153, 153, 153))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(botonReporteUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(163, 163, 163)))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(tituloReporteProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(257, 257, 257))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(botonReporteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(277, 277, 277))))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(botonReporteProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(409, 409, 409))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloGenerarReporte)
                            .addComponent(tituloSeleccionar)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(tituloReporteProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(356, 356, 356))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tituloGenerarReporte)
                .addGap(18, 18, 18)
                .addComponent(tituloSeleccionar)
                .addGap(47, 47, 47)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloReporteUsuario)
                    .addComponent(tituloReporteProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonReporteProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReporteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(tituloReporteProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporteProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
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

    private void botonReporteUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteUsuarioActionPerformed
        Document documento = new Document();

        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Documents/Reportes de InversionesRT/Reporte Usuario";
            File carpeta = new File(rutaCarpeta);

            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta si no existe
            }

            String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String rutaArchivo = rutaCarpeta + "/Reporte de Usuarios " + fechaActual + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));

            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/headerPDF.jpg"));
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance(image, null);
            header.setAlignment(Element.ALIGN_MIDDLE);

            Paragraph parrafoFecha = new Paragraph();
            parrafoFecha.setAlignment(Paragraph.ALIGN_LEFT);
            Font fontFecha = FontFactory.getFont("Arial", 12, Font.NORMAL);
            fontFecha.setColor(BaseColor.GRAY);
            parrafoFecha.setFont(fontFecha);
            parrafoFecha.add(fechaActual);
            parrafoFecha.add("\n\n"); // Salto de línea adicional

            Paragraph parrafoTitulo = new Paragraph();
            parrafoTitulo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafoTitulo.add("\n \n");
            parrafoTitulo.add(new Phrase("Listado de Usuarios \n \n",
                    FontFactory.getFont("Arial", 16, Font.BOLD, new BaseColor(90, 58, 201))));

            documento.open();
            documento.add(parrafoFecha);
            documento.add(header);
            documento.add(parrafoTitulo);

            PdfPTable tabla = new PdfPTable(7);
            tabla.setWidthPercentage(100); // Establece el ancho de la tabla al 100% del ancho disponible

            // Ancho relativo de las columnas
            float[] columnWidths = {33f, 35f, 33f, 80f, 42f, 30f, 45f};
            tabla.setWidths(columnWidths);

            tabla.addCell(createTableCell("Cedula", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Nombre", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Apellido", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Correo", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Teléfono", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Estatus", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Permisos", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT cedula, nombre, apellido, "
                        + "correo, telefono, estatus, tipo_nivel FROM usuario");

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tabla.addCell(createTableCell(rs.getString(1), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(2), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(3), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(4), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(5), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(6), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(7), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                }

                documento.add(tabla);
            } catch (SQLException e) {
                System.err.print("Error en generar el reporte de usuarios. " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de usuarios generado exitosamente!"
                    + "\n\nSe ha creado en la carpeta Documentos.",
                    "Generación de Reporte", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.println("Error en generar el PDF" + e);
        }
    }//GEN-LAST:event_botonReporteUsuarioActionPerformed

    private void botonReporteProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteProductoActionPerformed
        Document documento = new Document();

        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Documents/Reportes de InversionesRT/Reporte Producto";
            File carpeta = new File(rutaCarpeta);

            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta si no existe
            }

            String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String rutaArchivo = rutaCarpeta + "/Reporte de Productos " + fechaActual + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));

            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/headerPDF.jpg"));
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance(image, null);
            header.setAlignment(Element.ALIGN_MIDDLE);

            Paragraph parrafoFecha = new Paragraph();
            parrafoFecha.setAlignment(Paragraph.ALIGN_LEFT);
            Font fontFecha = FontFactory.getFont("Arial", 12, Font.NORMAL);
            fontFecha.setColor(BaseColor.GRAY);
            parrafoFecha.setFont(fontFecha);
            parrafoFecha.add(fechaActual);
            parrafoFecha.add("\n\n"); // Salto de línea adicional

            Paragraph parrafoTitulo = new Paragraph();
            parrafoTitulo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafoTitulo.add("\n \n");
            parrafoTitulo.add(new Phrase("Listado de Productos \n \n",
                    FontFactory.getFont("Arial", 16, Font.BOLD, new BaseColor(90, 58, 201))));

            documento.open();
            documento.add(parrafoFecha);
            documento.add(header);
            documento.add(parrafoTitulo);

            PdfPTable tabla = new PdfPTable(8);
            tabla.setWidthPercentage(100); // Establece el ancho de la tabla al 100% del ancho disponible

            // Ancho relativo de las columnas
            float[] columnWidths = {25f, 42f, 33f, 25f, 27f, 28f, 35f, 30f};
            tabla.setWidths(columnWidths);

            tabla.addCell(createTableCell("Código", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Barcode", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Nombre", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Precio", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Stock", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Cantidad", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Descripción", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Fecha de creación", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT codigo_prod, barcode, nombre, precio,"
                        + "stock, cantidad, descripcion, fecha_creacion FROM producto");

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tabla.addCell(createTableCell(rs.getString(1), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(2), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(3), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(4), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(5), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(6), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(7), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(8), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                }

                documento.add(tabla);
            } catch (SQLException e) {
                System.err.print("Error en generar el reporte de productos. " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de productos generado exitosamente!"
                    + "\n\nSe ha creado en la carpeta Documentos.",
                    "Generación de Reporte", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.println("Error en generar el PDF" + e);
        }
    }//GEN-LAST:event_botonReporteProductoActionPerformed

    private void botonReporteProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteProveedorActionPerformed
        Document documento = new Document();

        try {
            String rutaCarpeta = System.getProperty("user.home") + "/Documents/Reportes de InversionesRT/Reporte Proveedor";
            File carpeta = new File(rutaCarpeta);

            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta si no existe
            }

            String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String rutaArchivo = rutaCarpeta + "/Reporte de Proveedores " + fechaActual + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));

            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/images/headerPDF.jpg"));
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance(image, null);
            header.setAlignment(Element.ALIGN_MIDDLE);

            Paragraph parrafoFecha = new Paragraph();
            parrafoFecha.setAlignment(Paragraph.ALIGN_LEFT);
            Font fontFecha = FontFactory.getFont("Arial", 12, Font.NORMAL);
            fontFecha.setColor(BaseColor.GRAY);
            parrafoFecha.setFont(fontFecha);
            parrafoFecha.add(fechaActual);
            parrafoFecha.add("\n\n"); // Salto de línea adicional

            Paragraph parrafoTitulo = new Paragraph();
            parrafoTitulo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafoTitulo.add("\n \n");
            parrafoTitulo.add(new Phrase("Listado de Proveedores \n \n",
                    FontFactory.getFont("Arial", 16, Font.BOLD, new BaseColor(90, 58, 201))));

            documento.open();
            documento.add(parrafoFecha);
            documento.add(header);
            documento.add(parrafoTitulo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100); // Establece el ancho de la tabla al 100% del ancho disponible

            // Ancho relativo de las columnas
            float[] columnWidths = {25f, 40f, 40f, 100f, 35f};
            tabla.setWidths(columnWidths);

            tabla.addCell(createTableCell("Código", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Nombre", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Apellido", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Dirección", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));
            tabla.addCell(createTableCell("Teléfono", Element.ALIGN_CENTER, BaseColor.WHITE, 12, true, new BaseColor(90, 58, 201)));

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("SELECT id_proveedor, nombre, apellido,"
                        + " direccion, telefono FROM proveedor");

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tabla.addCell(createTableCell(rs.getString(1), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(2), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(3), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(4), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                    tabla.addCell(createTableCell(rs.getString(5), Element.ALIGN_CENTER, new BaseColor(51, 51, 51), 11, false, BaseColor.WHITE));
                }

                documento.add(tabla);
            } catch (SQLException e) {
                System.err.print("Error en generar el reporte de proveedores. " + e);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "¡Reporte de proveedores generado exitosamente!"
                    + "\n\nSe ha creado en la carpeta Documentos.",
                    "Generación de Reporte", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.err.println("Error en generar el PDF" + e);
        }
    }//GEN-LAST:event_botonReporteProveedorActionPerformed

    private PdfPCell createTableCell(String text, int alignment, BaseColor textColor, int fontSize, boolean bold, BaseColor backgroundColor) {
        Font font = FontFactory.getFont("Arial", fontSize, bold ? Font.BOLD : Font.NORMAL, textColor);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(alignment);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Alineación vertical
        cell.setBorderColor(BaseColor.GRAY);
        cell.setBorderWidth(1f);
        cell.setFixedHeight(30f); // Cambia el tamaño de la altura de las celdas
        cell.setBackgroundColor(backgroundColor);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton botonReporteProducto;
    private javax.swing.JButton botonReporteProveedor;
    private javax.swing.JButton botonReporteUsuario;
    private javax.swing.JLabel tituloGenerarReporte;
    private javax.swing.JLabel tituloReporteProducto;
    private javax.swing.JLabel tituloReporteProveedor;
    private javax.swing.JLabel tituloReporteUsuario;
    private javax.swing.JLabel tituloSeleccionar;
    // End of variables declaration//GEN-END:variables
}
