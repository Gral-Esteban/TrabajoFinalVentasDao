/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;


import java.awt.*;
import java.awt.print.*;
import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ventasdao.ui.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ventasdao.controladores.DetalleFacturaControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.controladores.FacturaProductoControlador;
import ventasdao.controladores.FormaPagoControlador;
import ventasdao.controladores.LoginUserControlador;
import ventasdao.controladores.UpdateStockControlador;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.DetalleFactura;
import ventasdao.ui.grilla.GrillaCliente;
import ventasdao.ui.grilla.GrillaDetalleFactura;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;
import ventasdao.objetos.Usuario;
import static ventasdao.ui.abm.FacturaGetProducto.jtListadoProductos;
import ventasdao.ui.grilla.GrillaProducto;
/**
 *
 * @author Esteban DAlbano
 */
public class AbmFactura extends javax.swing.JInternalFrame implements Printable {
    
    
    private FacturaControlador facturaControlador = new FacturaControlador();
    
    private DetalleFacturaControlador detalleFacturaControlador = new DetalleFacturaControlador();
    
    
    private GrillaDetalleFactura grillaDetalleFactura;
    private DetalleFactura detalleFactura;
    
    private DefaultComboBoxModel modelCombo;
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    private String descontar = null ;
        
    private String total = null;
         
    private double newtotal = 0;
         
    private String newtotalcadena= null;
    
    private String cantidad = null; 
    
    List<DetalleFactura> detallefacturas = new ArrayList<>();
    
    private GrillaProducto grillaProducto;
    
     TableRowSorter trs;
     
     private UpdateStockControlador updateStockControlador = new UpdateStockControlador();
     
     private LoginUserControlador loginUser = new LoginUserControlador();
     
     
        
            
    
    
    
    
    private FormaPagoControlador formaPagoControlador = new FormaPagoControlador();
    
    /**
     * Creates new form Factura
     */
    public AbmFactura() {
        initComponents();
        
       /*Deshabilitamos la opcion de crear otra factura mientras este activa esta  */
       ventasdao.ui.Principal.jmiFactura.setVisible(false);

       
       /*Colocamos iconos a los botones   */
        jbImprimir.setIcon(SetIcono("/icons/printer.png",jbImprimir,20,30)); //muestra el icono de impresora
        jbSalir.setIcon(SetIcono("/icons/exit2.png",jbSalir,40,50)); //muestra el icono de exit
        jbAltaFactura.setIcon(SetIcono("/icons/confirmar.png",jbAltaFactura,30,30)); //muestra el icono de confirmar
        jbEliminar.setIcon(SetIcono("/icons/eliminar.png",jbEliminar,20,25)); //muestra el icono de confirmar
        jbAgregarCliente.setIcon(SetIcono("/icons/add_user.png",jbAgregarCliente,20,25)); //muestra el icono de confirmar
        jbAgregarProducto.setIcon(SetIcono("/icons/add_product.png",jbAgregarProducto,20,25)); //muestra el icono de confirmar
        
        jtfTotal.setText("0");
        jtfClienteIF.setText("0");
        
        jTabbedPane1.setVisible(false); 
        
        /*LLamamos a la funcion del controlador LoginUserControlador  consultar_user_online*/
        Usuario usuario_activo= new Usuario();
        
        try {
            usuario_activo = loginUser.consultar_user_activo();
            jtfExpedidor.setText(usuario_activo.getNombre());
            
        } 
        catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         try {
           ArrayList<FormaPago> formapagos = formaPagoControlador.listar();
           modelCombo = new DefaultComboBoxModel(formapagos.toArray());
           jcbFormaPago.setModel(modelCombo);
           
       } catch (Exception ex) {
           ex.printStackTrace();
       }
        
        
        
        
        
        
        
    }
    
    
    /**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    
    
 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFactura = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoFacturacion = new javax.swing.JTable();
        jtfFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroFactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jcbEDDI = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jtfPagaCon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfVuelto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfDescuento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfInteres = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfTCD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfTCI = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfVCD = new javax.swing.JTextField();
        jtfVCI = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtfClienteIF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNombreF = new javax.swing.JTextField();
        jtfApellidoF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtfExpedidor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpObservaciones = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jbAgregarProducto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jbAgregarCliente = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbAltaFactura = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion");

        jPanelFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtListadoFacturacion.setForeground(new java.awt.Color(0, 127, 248));
        jtListadoFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Precio", "Cantidad", "Proveedor"
            }
        ));
        jtListadoFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoFacturacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoFacturacion);

        jPanelFactura.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 56, 746, 244));

        jtfFecha.setEditable(false);
        jPanelFactura.add(jtfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 18, 143, -1));

        jLabel5.setText("Fecha de venta");
        jPanelFactura.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 21, 84, -1));

        jtfNumeroFactura.setEditable(false);
        jPanelFactura.add(jtfNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 18, 293, -1));

        jLabel1.setText("Numero de Factura");
        jPanelFactura.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 21, -1, -1));

        jtfTotal.setEditable(false);
        jPanelFactura.add(jtfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 159, -1));

        jcbEDDI.setText("Descuento/Interes");
        jcbEDDI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jcbEDDIStateChanged(evt);
            }
        });
        jPanelFactura.add(jcbEDDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        jLabel4.setText("Total $");
        jPanelFactura.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 315, -1, -1));

        jtfPagaCon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfPagaConCaretUpdate(evt);
            }
        });
        jtfPagaCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPagaConActionPerformed(evt);
            }
        });
        jtfPagaCon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPagaConKeyTyped(evt);
            }
        });
        jPanelFactura.add(jtfPagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 311, 126, 23));

        jLabel10.setText("Paga con $");
        jPanelFactura.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 315, -1, -1));

        jtfVuelto.setEditable(false);
        jPanelFactura.add(jtfVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 340, 126, 23));

        jLabel11.setText("Vuelto $");
        jPanelFactura.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 343, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));

        jtfDescuento.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfDescuentoCaretUpdate(evt);
            }
        });

        jLabel12.setText("Descuento %");

        jtfInteres.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtfInteresCaretUpdate(evt);
            }
        });

        jLabel15.setText("Interes %");

        jtfTCD.setEditable(false);

        jLabel13.setText("T c/d $");

        jtfTCI.setEditable(false);

        jLabel14.setText("T c/i $");

        jtfVCD.setEditable(false);

        jtfVCI.setEditable(false);

        jLabel16.setText("vuelto $");

        jLabel17.setText("vuelto $");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfInteres, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jtfDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTCI, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jtfTCD, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfVCI, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfVCD)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTCD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jtfVCD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jtfTCI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfVCI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("F1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("F2", jPanel2);

        jPanelFactura.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 371, -1, 110));

        jtfClienteIF.setEditable(false);
        jPanelFactura.add(jtfClienteIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 46, -1));

        jLabel9.setText("Id");
        jPanelFactura.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 324, -1, -1));

        jLabel2.setText("Cliente");
        jPanelFactura.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 60, 20));

        jtfNombreF.setEditable(false);
        jPanelFactura.add(jtfNombreF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 174, 28));

        jtfApellidoF.setEditable(false);
        jtfApellidoF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfApellidoFActionPerformed(evt);
            }
        });
        jPanelFactura.add(jtfApellidoF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 174, 27));

        jLabel6.setText("Nombre");
        jPanelFactura.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 359, -1, -1));

        jLabel7.setText("Apellido");
        jPanelFactura.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 393, -1, -1));

        jLabel18.setText("Expedida por");
        jPanelFactura.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        jtfExpedidor.setEditable(false);
        jPanelFactura.add(jtfExpedidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 174, 28));

        jScrollPane2.setViewportView(jtpObservaciones);

        jPanelFactura.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 518, 498, 55));

        jLabel8.setText("Observaciones");
        jPanelFactura.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 498, -1, -1));

        jbAgregarProducto.setBackground(new java.awt.Color(196, 192, 180));
        jbAgregarProducto.setText("Agregar Producto");
        jbAgregarProducto.setToolTipText("");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 580, 160, 50));

        jLabel3.setText("Forma de pago");
        jPanelFactura.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 517, 92, -1));

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelFactura.add(jcbFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 537, 125, 25));

        jbAgregarCliente.setBackground(new java.awt.Color(196, 192, 180));
        jbAgregarCliente.setText("Agregar Cliente");
        jbAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarClienteActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 580, 150, 50));

        jbEliminar.setBackground(new java.awt.Color(196, 192, 180));
        jbEliminar.setText("Eliminar");
        jbEliminar.setToolTipText("");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 117, 50));

        jbAltaFactura.setBackground(new java.awt.Color(196, 192, 180));
        jbAltaFactura.setText("Confirmar");
        jbAltaFactura.setToolTipText("");
        jbAltaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaFacturaActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbAltaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 117, 50));

        jbSalir.setBackground(new java.awt.Color(196, 192, 180));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 117, 50));

        jbImprimir.setBackground(new java.awt.Color(196, 192, 180));
        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });
        jPanelFactura.add(jbImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 117, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(jtListadoFacturacion);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        // TODO add your handling code here:

        PrinterJob gap = PrinterJob.getPrinterJob();
        gap.setPrintable(this);
        boolean top = gap.printDialog();

        if(top){
            try {
                gap.print();
            }
            catch (PrinterException ex) {
                Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        ventasdao.ui.Principal.jmiFactura.setVisible(true);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbAltaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaFacturaActionPerformed
        // TODO add your handling code here:

        boolean validacionStock=false;

        /// Cargo el Array del grilla factura que seria el detalle de la factura
        int cantidadfilas = jtListadoFacturacion.getRowCount();

        for (int i = 0; i < cantidadfilas; i++) {
            DetalleFactura detallefactura = new DetalleFactura();

            detallefactura.setCodigo(jtListadoFacturacion.getValueAt(i, 0).toString());  //Codigo del producto
            detallefactura.setProveedor(jtListadoFacturacion.getValueAt(i, 4).toString());  //Proveedor del producto
            //JOptionPane.showMessageDialog(null,"ProductoId"+jtListadoFacturacion.getValueAt(i, 4).toString());
            detallefactura.setCantidad(Integer.parseInt(jtListadoFacturacion.getValueAt(i, 3).toString()));   //cantidad
            //JOptionPane.showMessageDialog(null,"Cantidad="+jtListadoFacturacion.getValueAt(i, 3).toString());
            //detallefactura.setFactura_id(Integer.parseInt(jtfNumeroFactura.getText())); //factura_id

            //JOptionPane.showMessageDialog(null,"carga el 1er elemento del arraylist cuando i="+i);
            detallefacturas.add(detallefactura);

        }

        try {
            validacionStock = updateStockControlador.validar(detallefacturas);
            detallefacturas.clear();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (validacionStock) {

            /*Validamos la entradas*/
            if (Integer.parseInt(jtfClienteIF.getText()) > 0 && Float.parseFloat(jtfTotal.getText()) != 0.0) {

                Factura factura = new Factura();
                //Cargo la factura
                factura.setMonto_total(Float.parseFloat(jtfTotal.getText()));
                factura.setCliente_id(Integer.parseInt(jtfClienteIF.getText()));
                factura.setFormapago((FormaPago) (jcbFormaPago.getSelectedItem()));
                factura.setObservaciones(jtpObservaciones.getText());
                factura.setExpedidor(jtfExpedidor.getText());

                try {
                    facturaControlador.crear(factura);  //Creamos la factura para asi tener un numero de factura
                    //limpiarCampos();
                } catch (Exception ex) {
                    Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
                }

              //Cargo detalle factura  
                for (int i = 0; i < cantidadfilas; i++) {
            DetalleFactura detallefactura = new DetalleFactura();

            detallefactura.setCodigo(jtListadoFacturacion.getValueAt(i, 0).toString());  //Codigo del producto
            detallefactura.setProveedor(jtListadoFacturacion.getValueAt(i, 4).toString());  //Proveedor del producto
            //JOptionPane.showMessageDialog(null,"ProductoId"+jtListadoFacturacion.getValueAt(i, 4).toString());
            detallefactura.setCantidad(Integer.parseInt(jtListadoFacturacion.getValueAt(i, 3).toString()));   //cantidad
            //JOptionPane.showMessageDialog(null,"Cantidad="+jtListadoFacturacion.getValueAt(i, 3).toString());
            detallefactura.setFactura_id(Integer.parseInt(jtfNumeroFactura.getText())); //factura_id

            //JOptionPane.showMessageDialog(null,"carga el 1er elemento del arraylist cuando i="+i);
            detallefacturas.add(detallefactura);

        }
                
                
                //En esta parte actualizo el stock en la base de datos un avez que se confirmo la factura y que se valido el stock
                try {
                    updateStockControlador.decrementar(detallefacturas);
                    //limpiarCampos();
                } catch (Exception ex) {
                    Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*Aqui se crea la el detallefactura no sin antes haber hecho la validacion anterior*/
                try {
                    detalleFacturaControlador.crear(detallefacturas);
                    //limpiarCampos();
                } catch (Exception ex) {
                    Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "La factura se creo Exitosamente!!!");

            } //Cierro el if validacion

            //Incializo el array detallefacturas porque si no al dar confirmar 2 veces seguidas se carga el doble de productos ya que conserva los que cargo la 1era vez
            detallefacturas.clear();

        } //Cierro el If de validacionStock
        else {
            if (Integer.parseInt(jtfClienteIF.getText()) == 0) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un cliente");
            }
            if (Float.parseFloat(jtfTotal.getText()) == 0.0) {
                JOptionPane.showMessageDialog(null, "Debe Agregar al menos un producto a la factura");
            }
        }
    }//GEN-LAST:event_jbAltaFacturaActionPerformed

    
    
    
    
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:

        modelo = (DefaultTableModel) jtListadoFacturacion.getModel();

        int filasele = jtListadoFacturacion.getSelectedRow();

        String factCOD = jtListadoFacturacion.getValueAt(filasele, 0).toString(); //Codigo del producto en factura
        String factPROV = jtListadoFacturacion.getValueAt(filasele, 4).toString(); //Proveedor del producto en factura
        int factCANT = Integer.parseInt(jtListadoFacturacion.getValueAt(filasele, 3).toString()); // Cantidad del producto en factura

        descontar = jtListadoFacturacion.getValueAt(filasele, 2).toString();

        cantidad = jtListadoFacturacion.getValueAt(filasele, 3).toString();

        total = jtfTotal.getText();

        newtotal = Double.parseDouble(total) - Double.parseDouble(descontar)* Double.parseDouble(cantidad);

        newtotalcadena= String.valueOf(newtotal);

        jtfTotal.setText(newtotalcadena);

        modelo.removeRow(filasele);

        //Validamos que exista una tabla activa del otro lado
        int cantfilasFGP = FacturaGetProducto.jtListadoProductos.getRowCount();

        if(cantfilasFGP>0) {

            String var = FacturaGetProducto.jcbCategorias.getSelectedItem().toString();

            //  if(var.equals("Todos")) {

                //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla

                ArrayList<Producto> aOproductos = new ArrayList<>();

                for(int i=0;i<cantfilasFGP;i++){

                    Producto Oproducto = new Producto();

                    Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
                    Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
                    Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
                    Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 3).toString()));
                    Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 4).toString()));
                    Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 5).toString()));
                    Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 6).toString()));
                    Oproducto.setImagen((jtListadoProductos.getValueAt(i, 7).toString()));
                    Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 8).toString()));

                    if(Oproducto.getCodigo().equals(factCOD) && Oproducto.getProveedor().equals(factPROV))
                    Oproducto.setStock(Oproducto.getStock()+factCANT);

                    aOproductos.add(Oproducto);

                }

                grillaProducto = new GrillaProducto(aOproductos);
                jtListadoProductos.setModel(grillaProducto);

                ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
                trs = new TableRowSorter(jtListadoProductos.getModel());
                jtListadoProductos.setRowSorter(trs);  /////

                // }

        }

        /*
        detalleFactura = new DetalleFactura();
        detalleFactura.setId(Integer.parseInt(jtfId.getText()));

        try {
            facturaProductoControlador.eliminar(detalleFactura);
        } catch (Exception ex) {
            Logger.getLogger(AbmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            jtListadoFacturacion.setModel(new GrillaDetalleFactura(facturaProductoControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        facturaProductoControlador = new FacturaProductoControlador();
        ArrayList<DetalleFactura> detallefacturas = new ArrayList<>();

        try {
            detallefacturas = facturaProductoControlador.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaDetalleFactura = new GrillaDetalleFactura(detallefacturas);
        jtListadoFacturacion.setModel(grillaDetalleFactura);

        */

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarClienteActionPerformed
        // TODO add your handling code here:

        //Abrir un modulo desde otro modulo

        FacturaGetCliente facturaGetCliente = new FacturaGetCliente();
        Principal.jdpContenedorPrincipal.add(facturaGetCliente);

        facturaGetCliente.toFront();
        facturaGetCliente.setVisible(true);
    }//GEN-LAST:event_jbAgregarClienteActionPerformed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        // TODO add your handling code here:

        //Abrir un modulo desde otro modulo

        FacturaGetProducto abmGetProducto = new FacturaGetProducto();
        Principal.jdpContenedorPrincipal.add(abmGetProducto);
        abmGetProducto.setVisible(true);

        abmGetProducto.toFront();
        abmGetProducto.setVisible(true);
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jtfApellidoFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfApellidoFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfApellidoFActionPerformed

    private void jtfInteresCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfInteresCaretUpdate
        // TODO add your handling code here:
        String bandera = jtfInteres.getText();

        if(bandera.equals("")){

        }

        else {
            DecimalFormat df = new DecimalFormat("#.00");

            Double total = Double.parseDouble(jtfTotal.getText());
            Double porcent_interes = Double.parseDouble(jtfInteres.getText());
            Double efectivo = Double.parseDouble(jtfPagaCon.getText());
            Double interes = (porcent_interes*total)/100;
            Double totalCI = total + interes;
            Double vueltoCI = efectivo - totalCI;
            String totalCIs = String.valueOf(df.format(totalCI));
            String vueltoCIs = String.valueOf(df.format(vueltoCI));
            jtfTCI.setText(totalCIs);
            jtfVCI.setText(vueltoCIs);

        }

    }//GEN-LAST:event_jtfInteresCaretUpdate

    private void jtfDescuentoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfDescuentoCaretUpdate
        // TODO add your handling code here:
        String bandera = jtfDescuento.getText();

        if(bandera.equals("")){

        }

        else {
            DecimalFormat df = new DecimalFormat("#.00");

            Double total = Double.parseDouble(jtfTotal.getText());
            Double porcent_descuento = Double.parseDouble(jtfDescuento.getText());
            Double efectivo = Double.parseDouble(jtfPagaCon.getText());
            Double descuento = (porcent_descuento*total)/100;
            Double totalCD = total - descuento;
            Double vueltoCD = efectivo - totalCD;
            String totalCDs = String.valueOf(df.format(totalCD));
            String vueltoCDs = String.valueOf(df.format(vueltoCD));
            jtfTCD.setText(totalCDs);
            jtfVCD.setText(vueltoCDs);

        }

    }//GEN-LAST:event_jtfDescuentoCaretUpdate

    private void jtfPagaConKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPagaConKeyTyped
        // TODO add your handling code here:
            char validar = evt.getKeyChar();     //|| 
        
        String s = String.valueOf(validar);
        
         byte[] bytes =s.getBytes(StandardCharsets.US_ASCII);
         
         //JOptionPane.showMessageDialog(rootPane, "El numerico ASCII de:"+s +" es:"+bytes[0]);
        
        if( (bytes[0]<48 || bytes[0]>57) && bytes[0]!=8 && bytes[0]!=127){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_jtfPagaConKeyTyped

    private void jtfPagaConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPagaConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPagaConActionPerformed

    private void jtfPagaConCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtfPagaConCaretUpdate
        // TODO add your handling code here:
        String bandera = jtfPagaCon.getText();
        DecimalFormat df = new DecimalFormat("#.00");

        if(bandera.equals("")){

        }

        else {
            Double total = Double.parseDouble(jtfTotal.getText());
            Double efectivo = Double.parseDouble(jtfPagaCon.getText());
            Double vueltoD = efectivo - total;
            String vueltoS = String.valueOf(df.format(vueltoD));
            jtfVuelto.setText(vueltoS);
        }

    }//GEN-LAST:event_jtfPagaConCaretUpdate

    private void jcbEDDIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jcbEDDIStateChanged
        // TODO add your handling code here:
        if(jcbEDDI.isSelected())
        jTabbedPane1.setVisible(true);
        else{
            jTabbedPane1.setVisible(false);
        }
    }//GEN-LAST:event_jcbEDDIStateChanged

    private void jtListadoFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoFacturacionMouseClicked
        // TODO add your handling code here:

        /*   DetalleFactura detallefactura = grillaDetalleFactura.getDetalleFacturaFromRow(jtListadoFacturacion.getSelectedRow());

        jtfId.setText( detallefactura.getId().toString() );        */
    }//GEN-LAST:event_jtListadoFacturacionMouseClicked


    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanelFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAgregarCliente;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbAltaFactura;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbEDDI;
    public static javax.swing.JComboBox<String> jcbFormaPago;
    public static javax.swing.JTable jtListadoFacturacion;
    public static javax.swing.JTextField jtfApellidoF;
    public static javax.swing.JTextField jtfClienteIF;
    private javax.swing.JTextField jtfDescuento;
    public static javax.swing.JTextField jtfExpedidor;
    public static javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfInteres;
    public static javax.swing.JTextField jtfNombreF;
    public static javax.swing.JTextField jtfNumeroFactura;
    private javax.swing.JTextField jtfPagaCon;
    private javax.swing.JTextField jtfTCD;
    private javax.swing.JTextField jtfTCI;
    public static javax.swing.JTextField jtfTotal;
    private javax.swing.JTextField jtfVCD;
    private javax.swing.JTextField jtfVCI;
    private javax.swing.JTextField jtfVuelto;
    public static javax.swing.JTextPane jtpObservaciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graf, PageFormat pageForm, int pageIndex) throws PrinterException {
        
           if(pageIndex>0){
            
            return NO_SUCH_PAGE;
        }
           
           /*
           JInternalFrame frame = new JInternalFrame();
           
           
           ((BasicInternalFrameUI) this.getUI()).setNorthPane(null); //Quita el titulo y los botones del JInternalFrame
           */
      
       
           
        
        jbAgregarProducto.setVisible(false);//Oculto los botones previo a imprimir
        jbAgregarCliente.setVisible(false);
        jbEliminar.setVisible(false);
        jbAltaFactura.setVisible(false);
        jbSalir.setVisible(false);
        jbImprimir.setVisible(false);
        
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pageForm.getImageableX() + 30, pageForm.getImageableY() + 30);
        hub.scale(0.5, 0.5);
        jPanelFactura.printAll(graf); //this hace referencia al objeto creado del tipo JInternalFrame
        
        jbAgregarProducto.setVisible(true);//Muestro los botones luego de imprimir
        jbAgregarCliente.setVisible(true);
        jbEliminar.setVisible(true);
        jbAltaFactura.setVisible(true);
        jbSalir.setVisible(true);
        jbImprimir.setVisible(true);
        
        
        
      
        
        return PAGE_EXISTS;
    }
    
    
    
    public Icon SetIcono(String url,JButton boton,int ancho,int alto){
        
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        
        boton= new JButton();
        /*int ancho =20;//boton.getWidth();
        int alto =30;//boton.getHeight();*/
       
       
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        return icono;
        
    }
    
    //Esta funcion me quita los bordes del JInternalFrame
    
    /*void remove_title_bar(){
    putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
    getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    this.setBorder(null);
    }*/
    
    
}



/*Idea de la implementacion
creo una tabla factura donde tiene un ID unico y un nombre de cliente
luego otra tabla detalle factura que esta relacionada con un Fk factura_id
referenciada a la tabla factura, se van igresando registros en detalle factura y todos esos
registros estaran asociados a la AbmFactura Id correspondiente
luego cuando cree una nueva factura se incrementa el registro de factura y ese
sera el factura_id que se usara en la tabla detalle factura para los nuevos registros y se repite el
proceso para las proximas facturas creadas*/


/*Como solucionar el problema de que se mueven los controles al ajustarlos o ejecutar el modulo?,
bien esto es facil, se selecciona en el layaout (del objeto donde se encuentren los controles) la opcion Absolute Layaout
Tambien se recomienda para proximos proyectos trabajr sobre JFrame en lugar de usar los JInternalFrame
ya que este ultimo es mucho mas complicado de configurar
Otra cosa importante es siempre poenr un JPane antes de empezar a poner los controles para poder cambiar
los colores con facilidad y muchas otras facilidades
*/