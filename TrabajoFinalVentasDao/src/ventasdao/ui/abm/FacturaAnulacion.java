/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;


import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.ArrayList;
import ventasdao.controladores.DetalleFacturaControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.objetos.DetalleFacturaAnulacion;
import ventasdao.objetos.Factura;
import ventasdao.objetos.ObjetoFacturaAnulacion;
import ventasdao.ui.grilla.GrillaDetalleFacturaAnulacion;
import ventasdao.ui.grilla.GrillaFacturaAnulacion;

/**
 *
 * @author Esteban DAlbano
 */
public class FacturaAnulacion extends javax.swing.JInternalFrame {
    
    
    private FacturaControlador facturaControlador;
    
    private DetalleFacturaControlador detalleFacturaControlador;
    
    ObjetoFacturaAnulacion objetoFacturaAnulacion;
    
    GrillaFacturaAnulacion grillaFacturaAnulacion;
    
    GrillaDetalleFacturaAnulacion grillaDetalleFacturaAnulacion;
    
    ArrayList<ObjetoFacturaAnulacion> objetoFacturaAnulaciones;
    
    ArrayList <DetalleFacturaAnulacion> objetoDetalleFacturaAnulaciones;
       
             
    
    /**
     * Creates new form FacturaAnulacion
     */
    public FacturaAnulacion() {
        initComponents();
        
       cargarTablaFactAnu ();
        
    }

    
    
    
    void cargarTablaFactAnu (){
        
       objetoFacturaAnulaciones = new ArrayList <> ();
       
       facturaControlador = new FacturaControlador();
        
      // objetoFacturaAnulacion = new ObjetoFacturaAnulacion();
       
       
       
       try {
           objetoFacturaAnulaciones = facturaControlador.listar2();
           grillaFacturaAnulacion = new GrillaFacturaAnulacion(objetoFacturaAnulaciones);
           jtFacturas.setModel(grillaFacturaAnulacion);
           
/*         
///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
            trs = new TableRowSorter(jtListadoProductos.getModel());
            jtListadoProductos.setRowSorter(trs);  /////
           */
           
       } catch (Exception ex) {
           Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        
    }
    
    void LimpiarDetalleFacturas(int fact_id) {
        
           
            objetoDetalleFacturaAnulaciones = new ArrayList <> ();
       
            detalleFacturaControlador = new DetalleFacturaControlador();
            
            try {
               objetoDetalleFacturaAnulaciones = detalleFacturaControlador.listar(fact_id);
           grillaDetalleFacturaAnulacion = new GrillaDetalleFacturaAnulacion(objetoDetalleFacturaAnulaciones);
            jtDetalleFacturas.setModel(grillaDetalleFacturaAnulacion);
               
             /*
               ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria 
               trs = new TableRowSorter(jtListadoProductos.getModel()); 
            jtListadoProductos.setRowSorter(trs);  /////
             */
               
           } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
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
        jtFacturas = new javax.swing.JTable();
        jbAnular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalleFacturas = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Anulacion Factura");

        jtFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFacturas);

        jbAnular.setText("Anular");
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
            }
        });

        jtDetalleFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane2.setViewportView(jtDetalleFacturas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jbAnular)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAnular)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFacturasMouseClicked
        // TODO add your handling code here:
        
        int filasele = jtFacturas.getSelectedRow();
        
        String fact_id_S = jtFacturas.getValueAt(filasele, 0).toString();
        
        int fact_id_I = Integer.parseInt(fact_id_S);
        
        if(filasele !=-1){
            
            objetoDetalleFacturaAnulaciones = new ArrayList <> ();
       
            detalleFacturaControlador = new DetalleFacturaControlador();
            
            try {
               objetoDetalleFacturaAnulaciones = detalleFacturaControlador.listar(fact_id_I);
           grillaDetalleFacturaAnulacion = new GrillaDetalleFacturaAnulacion(objetoDetalleFacturaAnulaciones);
            jtDetalleFacturas.setModel(grillaDetalleFacturaAnulacion);
               
             /*
               ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria 
               trs = new TableRowSorter(jtListadoProductos.getModel()); 
            jtListadoProductos.setRowSorter(trs);  /////
             */
               
           } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
        }
        
    }//GEN-LAST:event_jtFacturasMouseClicked

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        // TODO add your handling code here:
        
        int filasele = jtFacturas.getSelectedRow();
        
        String fact_id_S = jtFacturas.getValueAt(filasele, 0).toString();
        
        int fact_id_I = Integer.parseInt(fact_id_S);
        
        
        try {
            detalleFacturaControlador.eliminar(fact_id_I);
        } catch (Exception ex) {
            Logger.getLogger(FacturaAnulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            facturaControlador.eliminar(fact_id_I);
        } catch (Exception ex) {
            Logger.getLogger(FacturaAnulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarTablaFactAnu ();
        
        LimpiarDetalleFacturas(fact_id_I);
        
        
        
    }//GEN-LAST:event_jbAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAnular;
    private javax.swing.JTable jtDetalleFacturas;
    private javax.swing.JTable jtFacturas;
    // End of variables declaration//GEN-END:variables
}
