/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ventasdao.ui.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ventasdao.controladores.DetalleFacturaControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.controladores.FacturaProductoControlador;
import ventasdao.controladores.FormaPagoControlador;
import ventasdao.controladores.UpdateStockControlador;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.DetalleFactura;
import ventasdao.ui.grilla.GrillaCliente;
import ventasdao.ui.grilla.GrillaDetalleFactura;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;
import static ventasdao.ui.abm.FacturaGetProducto.jtListadoProductos;
import ventasdao.ui.grilla.GrillaProducto;
/**
 *
 * @author Esteban DAlbano
 */
public class AbmFactura extends javax.swing.JInternalFrame {
    
    
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
     
     
        
            
    
    
    
    
    private FormaPagoControlador formaPagoControlador = new FormaPagoControlador();
    
    /**
     * Creates new form Factura
     */
    public AbmFactura() {
        initComponents();
        
        
        
        jtfTotal.setText("0");
        
        /*ArrayList<DetalleFactura> detallefacturas = new ArrayList<DetalleFactura>();
        
        grillaDetalleFactura = new GrillaDetalleFactura(detallefacturas);
         jtListadoFacturacion.setModel(grillaDetalleFactura);
        *
        
        
        /*
         ArrayList<DetalleFactura> detallefacturas;
        try {
            detallefacturas = facturaProductoControlador.listar();
           grillaDetalleFactura = new GrillaDetalleFactura(detallefacturas);
             jtListadoFacturacion.setModel(grillaDetalleFactura);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        
      */
        
         try {
           ArrayList<FormaPago> formapagos = formaPagoControlador.listar();
           modelCombo = new DefaultComboBoxModel(formapagos.toArray());
           jcbFormaPago.setModel(modelCombo);
           
       } catch (Exception ex) {
           ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoFacturacion = new javax.swing.JTable();
        jbAgregarProducto = new javax.swing.JButton();
        jbAgregarCliente = new javax.swing.JButton();
        jtfNumeroFactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbAltaFactura = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jtfObservaciones = new javax.swing.JTextField();
        jtfNombreF = new javax.swing.JTextField();
        jtfApellidoF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfClienteIF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion");

        jtListadoFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad", "Producto_Id"
            }
        ));
        jtListadoFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoFacturacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoFacturacion);

        jbAgregarProducto.setText("Agregar Producto");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jbAgregarCliente.setText("Agregar Cliente");
        jbAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de Factura");

        jLabel2.setText("Cliente");

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Forma de pago");

        jLabel4.setText("Total");

        jbAltaFactura.setText("Confirmar");
        jbAltaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaFacturaActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha de venta");

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre");

        jLabel7.setText("Apellido");

        jLabel8.setText("Observaciones");

        jLabel9.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfClienteIF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNombreF, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfApellidoF, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfClienteIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombreF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfApellidoF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jtfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        getAccessibleContext().setAccessibleParent(jtListadoFacturacion);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        // TODO add your handling code here:
        
        //Abrir un modulo desde otro modulo

  FacturaGetProducto abmGetProducto = new FacturaGetProducto();
        Principal.jdpContenedorPrincipal.add(abmGetProducto);
        abmGetProducto.setVisible(true);
        
        
        abmGetProducto.toFront();
        abmGetProducto.setVisible(true);
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jbAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarClienteActionPerformed
        // TODO add your handling code here:
        
          //Abrir un modulo desde otro modulo

        FacturaGetCliente facturaGetCliente = new FacturaGetCliente();
        Principal.jdpContenedorPrincipal.add(facturaGetCliente);
       
        
        facturaGetCliente.toFront();
        facturaGetCliente.setVisible(true);
    }//GEN-LAST:event_jbAgregarClienteActionPerformed

    
    
    
    
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        
        
       
        modelo = (DefaultTableModel) jtListadoFacturacion.getModel();
        
        int filasele = jtListadoFacturacion.getSelectedRow();
        
        
        int factPID = Integer.parseInt(jtListadoFacturacion.getValueAt(filasele, 4).toString()); //Guardo este dato
        int factPST = Integer.parseInt(jtListadoFacturacion.getValueAt(filasele, 3).toString()); // Guardo este dato
        
        
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
        
        
        Oproducto.setId(Integer.parseInt(jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setCategoria_id(Integer.parseInt(jtListadoProductos.getValueAt(i, 1).toString()));
        Oproducto.setNombre((jtListadoProductos.getValueAt(i, 2).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setPrecio(Float.parseFloat(jtListadoProductos.getValueAt(i, 4).toString()));
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 5).toString()));
        Oproducto.setFechaAlta((jtListadoProductos.getValueAt(i, 6).toString()));
        
        
        
       
         if(Oproducto.getId()==factPID)
           Oproducto.setStock(Oproducto.getStock()+factPST); 
       
        
            
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

    private void jtListadoFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoFacturacionMouseClicked
        // TODO add your handling code here:
        
     /*   DetalleFactura detallefactura = grillaDetalleFactura.getDetalleFacturaFromRow(jtListadoFacturacion.getSelectedRow());
       
       jtfId.setText( detallefactura.getId().toString() );        */
    }//GEN-LAST:event_jtListadoFacturacionMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbAltaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaFacturaActionPerformed
        // TODO add your handling code here:
        
         Factura factura = new Factura();
        
        factura.setMonto_total(Float.parseFloat(jtfTotal.getText()));
        factura.setCliente_id(Integer.parseInt(jtfClienteIF.getText()));
        factura.setFormapago((FormaPago)(jcbFormaPago.getSelectedItem()));
        factura.setObservaciones(jtfObservaciones.getText());
       
      
        
        
       try {
           facturaControlador.crear(factura);
           //limpiarCampos();
       } catch (Exception ex) {
           Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        /// Cargo el Array del grilla factura
        
        int cantidadfilas = jtListadoFacturacion.getRowCount();
        
        for(int i=0;i<cantidadfilas;i++){
            DetalleFactura detallefactura = new DetalleFactura();
            
        detallefactura.setProducto_id(Integer.parseInt(jtListadoFacturacion.getValueAt(i, 4).toString()));  //producto_id
         //JOptionPane.showMessageDialog(null,"ProductoId"+jtListadoFacturacion.getValueAt(i, 4).toString());
        detallefactura.setCantidad(Integer.parseInt(jtListadoFacturacion.getValueAt(i, 3).toString()));   //cantidad
         //JOptionPane.showMessageDialog(null,"Cantidad="+jtListadoFacturacion.getValueAt(i, 3).toString());
        detallefactura.setFactura_id(Integer.parseInt(jtfNumeroFactura.getText())); //factura_id
            
             //JOptionPane.showMessageDialog(null,"carga el 1er elemento del arraylist cuando i="+i);
            
            detallefacturas.add(detallefactura);
       
        }
        
        
        
        
        
        try {
           detalleFacturaControlador.crear(detallefacturas);
           //limpiarCampos();
       } catch (Exception ex) {
           Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
       //En esta parte actualizo el stock en la base de datos un avez que se confirmo la factura
       try {
           updateStockControlador.decrementar(detallefacturas);
           //limpiarCampos();
       } catch (Exception ex) {
           Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
        
        
        
        
        JOptionPane.showMessageDialog(null,"La factura se creo Exitosamente!!!");
        
        
        
        
        
        
    }//GEN-LAST:event_jbAltaFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarCliente;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbAltaFactura;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<String> jcbFormaPago;
    public static javax.swing.JTable jtListadoFacturacion;
    public static javax.swing.JTextField jtfApellidoF;
    public static javax.swing.JTextField jtfClienteIF;
    public static javax.swing.JTextField jtfFecha;
    public static javax.swing.JTextField jtfNombreF;
    public static javax.swing.JTextField jtfNumeroFactura;
    public static javax.swing.JTextField jtfObservaciones;
    public static javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}



/*Idea de la implementacion
creo una tabla factura donde tiene un ID unico y un nombre de cliente
luego otra tabla detalle factura que esta relacionada con un Fk factura_id
referenciada a la tabla factura, se van igresando registros en detalle factura y todos esos
registros estaran asociados a la AbmFactura Id correspondiente
luego cuando cree una nueva factura se incrementa el registro de factura y ese
sera el factura_id que se usara en la tabla detalle factura para los nuevos registros y se repite el
proceso para las proximas facturas creadas*/