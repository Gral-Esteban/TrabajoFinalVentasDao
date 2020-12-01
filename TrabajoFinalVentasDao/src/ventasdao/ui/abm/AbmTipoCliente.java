/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import ventasdao.controladores.TipoClienteControlador;
import ventasdao.objetos.TipoCliente;
import ventasdao.ui.grilla.GrillaTipoCliente;


/**
 *
 * @author Esteban DAlbano
 */
public class AbmTipoCliente extends javax.swing.JInternalFrame {

    private TipoCliente tipoCliente;
    private GrillaTipoCliente grillaTipoCliente;
    private TipoClienteControlador tipoClienteControlador = new TipoClienteControlador();
    
    
    
    public AbmTipoCliente() {
        
        initComponents();
        
        ArrayList<TipoCliente> tipoClientes;
        try {
            tipoClientes = tipoClienteControlador.listar();
            
            grillaTipoCliente = new GrillaTipoCliente(tipoClientes);
             jtListadoTipoClientes.setModel(grillaTipoCliente);
        } catch (Exception e) {
            e.printStackTrace ();
        }


        
       
       
    }
    
    public void limpiarCampos(){
    
    jtfNombre.setText("");
    jtfDescripcion.setText("");
    jtfId.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfId = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoTipoClientes = new javax.swing.JTable();

        setClosable(true);
        setTitle("Tipo Clientes");

        jtfId.setEditable(false);
        jtfId.setEnabled(false);

        jLabel1.setText("Id");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jtListadoTipoClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListadoTipoClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoTipoClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoTipoClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombre)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtListadoTipoClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoTipoClientesMouseClicked
        // TODO add your handling code here:
        
       TipoCliente tipoCliente = grillaTipoCliente.getTipoClienteFromRow(jtListadoTipoClientes.getSelectedRow());
       
       jtfNombre.setText(tipoCliente.getNombre());
       jtfDescripcion.setText(tipoCliente.getDescripcion());
       jtfId.setText( tipoCliente.getId().toString() );
    }//GEN-LAST:event_jtListadoTipoClientesMouseClicked

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:
        
          tipoCliente = new TipoCliente();
        
        tipoCliente.setNombre(jtfNombre.getText());
        tipoCliente.setDescripcion(jtfDescripcion.getText());
        
        
        try {
            tipoClienteControlador.crear(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        tipoClienteControlador = new TipoClienteControlador();
        ArrayList<TipoCliente> tipoClientes = new ArrayList<>();

        try {
            tipoClientes = tipoClienteControlador.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaTipoCliente = new GrillaTipoCliente(tipoClientes);
        jtListadoTipoClientes.setModel(grillaTipoCliente);
        
        //Esto limpia campos
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        jtfId.setText("");
        
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        
      try {
            // TODO add your handling code here:
            
            // TODO add your handling code here:
            tipoCliente = new TipoCliente();
            
            tipoCliente.setNombre( jtfNombre.getText() );
            tipoCliente.setDescripcion( jtfDescripcion.getText() );
            tipoCliente.setId( Integer.parseInt( jtfId.getText() ) );
            
            tipoClienteControlador.modificar(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoTipoClientes.setModel( new GrillaTipoCliente( tipoClienteControlador.listar() ));
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        tipoClienteControlador = new TipoClienteControlador();
        ArrayList<TipoCliente> tipoClientes = new ArrayList<>();

        try {
            tipoClientes = tipoClienteControlador.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaTipoCliente = new GrillaTipoCliente(tipoClientes);
        jtListadoTipoClientes.setModel(grillaTipoCliente);
        
        //Esto limpia campos
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        jtfId.setText("");   
        
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        
        tipoCliente = new TipoCliente();
       tipoCliente.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            tipoClienteControlador.eliminar(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoTipoClientes.setModel(new GrillaTipoCliente(tipoClienteControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        tipoClienteControlador = new TipoClienteControlador();
        ArrayList<TipoCliente> tipoClientes = new ArrayList<>();

        try {
            tipoClientes = tipoClienteControlador.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaTipoCliente = new GrillaTipoCliente(tipoClientes);
        jtListadoTipoClientes.setModel(grillaTipoCliente);
        
        //Esto limpia campos
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        jtfId.setText("");
          
        
        
        
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JTable jtListadoTipoClientes;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
