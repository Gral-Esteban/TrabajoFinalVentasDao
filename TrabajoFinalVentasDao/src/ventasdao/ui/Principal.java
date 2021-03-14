/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ventasdao.controladores.LoginUserControlador;
import ventasdao.objetos.Usuario;
import ventasdao.ui.abm.AbmCategoria;
import ventasdao.ui.abm.AbmCliente;
import ventasdao.ui.abm.AbmProducto;
import ventasdao.ui.abm.AbmTipoCliente;
import ventasdao.ui.abm.AbmFactura;
import ventasdao.ui.abm.AbmUsuario;
import ventasdao.ui.abm.FacturaAnulacion;

/**
 *
 * @author Hugo Chanampe
 */
public class Principal extends javax.swing.JFrame {
    
    
    LoginUserControlador login = new LoginUserControlador();
    

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        menuVisibleOff();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpContenedorPrincipal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jtfUser = new javax.swing.JTextField();
        jtfPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbLogin = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiCategoria = new javax.swing.JMenuItem();
        jmiCliente = new javax.swing.JMenuItem();
        jmiProducto = new javax.swing.JMenuItem();
        jmiTipoCliente = new javax.swing.JMenuItem();
        jmiFactura = new javax.swing.JMenuItem();
        jmiAnularFactura = new javax.swing.JMenuItem();
        jmiUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpContenedorPrincipal.setPreferredSize(new java.awt.Dimension(1600, 900));

        jtfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUserActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        jLabel2.setText("Password");

        jLabel3.setText("           Sistema de Ventas CS&F v0.01");

        jbLogin.setText("Login");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPassword)
                    .addComponent(jtfUser)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jbLogin)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jdpContenedorPrincipal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpContenedorPrincipalLayout = new javax.swing.GroupLayout(jdpContenedorPrincipal);
        jdpContenedorPrincipal.setLayout(jdpContenedorPrincipalLayout);
        jdpContenedorPrincipalLayout.setHorizontalGroup(
            jdpContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpContenedorPrincipalLayout.createSequentialGroup()
                .addGap(532, 532, 532)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(732, Short.MAX_VALUE))
        );
        jdpContenedorPrincipalLayout.setVerticalGroup(
            jdpContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpContenedorPrincipalLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");

        jmiCategoria.setText("Categoria");
        jmiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCategoria);

        jmiCliente.setText("Cliente");
        jmiCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmiCliente);

        jmiProducto.setText("Producto");
        jmiProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiProducto);

        jmiTipoCliente.setText("TipoCliente");
        jmiTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jmiTipoCliente);

        jmiFactura.setText("Facturar");
        jmiFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFacturaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiFactura);

        jmiAnularFactura.setText("AnularFactura");
        jmiAnularFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAnularFacturaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAnularFactura);

        jmiUsuario.setText("Usuario");
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmiUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpContenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpContenedorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVisibleOff(){
        
        jmiCliente.setVisible(false);
        jmiCategoria.setVisible(false);
        jmiProducto.setVisible(false);
        jmiTipoCliente.setVisible(false);
        jmiFactura.setVisible(false);
        jmiAnularFactura.setVisible(false);
        jmiUsuario.setVisible(false);
    }
    
    private void menuVisibleOn(){
        
        jmiCliente.setVisible(true);
        jmiCategoria.setVisible(true);
        jmiProducto.setVisible(true);
        jmiTipoCliente.setVisible(true);
        jmiFactura.setVisible(true);
        jmiAnularFactura.setVisible(true);
        jmiUsuario.setVisible(true);
    }
    
    private void menuVendedorVisibleOn(){
        
        jmiCliente.setVisible(false);
        jmiCategoria.setVisible(false);
        jmiProducto.setVisible(false);
        jmiTipoCliente.setVisible(false);
        jmiFactura.setVisible(true);
        jmiAnularFactura.setVisible(false);
        jmiUsuario.setVisible(false);

    }
    
    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClienteActionPerformed
        // TODO add your handling code here:
        AbmCliente abmCliente = new AbmCliente();
        jdpContenedorPrincipal.add(abmCliente);
        abmCliente.setVisible(true);

    }//GEN-LAST:event_jmiClienteActionPerformed

    private void jmiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriaActionPerformed
        // TODO add your handling code here:

        AbmCategoria abmCategoria = new AbmCategoria();
        jdpContenedorPrincipal.add(abmCategoria);
        abmCategoria.setVisible(true);
    }//GEN-LAST:event_jmiCategoriaActionPerformed

    private void jmiProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductoActionPerformed
        // TODO add your handling code here:
        AbmProducto abmProducto = new AbmProducto();
        jdpContenedorPrincipal.add(abmProducto);
        abmProducto.setVisible(true);
        abmProducto.toFront();
        
    }//GEN-LAST:event_jmiProductoActionPerformed

    private void jmiTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoClienteActionPerformed
        // TODO add your handling code here:
        AbmTipoCliente abmtipoCliente = new AbmTipoCliente();
         jdpContenedorPrincipal.add(abmtipoCliente);
         abmtipoCliente.setVisible(true);
    }//GEN-LAST:event_jmiTipoClienteActionPerformed

    private void jmiFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFacturaActionPerformed
        // TODO add your handling code here:
         AbmFactura abmFacturar = new AbmFactura();
         jdpContenedorPrincipal.add(abmFacturar);
         abmFacturar.setVisible(true);
    }//GEN-LAST:event_jmiFacturaActionPerformed

    private void jmiAnularFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAnularFacturaActionPerformed
        // TODO add your handling code here:
        FacturaAnulacion facturaAnulacion = new FacturaAnulacion();
        jdpContenedorPrincipal.add(facturaAnulacion);
        facturaAnulacion.setVisible(true);
    }//GEN-LAST:event_jmiAnularFacturaActionPerformed

                                    
    
    
    
    private void jtfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUserActionPerformed

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        // TODO add your handling code here:
    
        String usuario = jtfUser.getText();
        String clave = jtfPassword.getText();
        
        Usuario entidad = new Usuario();
        
        entidad.setNombre(usuario);
        entidad.setClave(clave);
        
        try {
            //entidad.setTipo(null);
            
            entidad=login.consultar(entidad);
            
            
            
            switch(entidad.getTipo()){
                
                case "administrador":
                    JOptionPane.showMessageDialog(null, "El login fue exitoso tipo de usuario:"+entidad.getTipo());
                    menuVisibleOn();
                    break;
                case "vendedor":
                    JOptionPane.showMessageDialog(null, "El login fue exitoso tipo de usuario:"+entidad.getTipo());
                    menuVendedorVisibleOn();
                    break;
                case "unknow":
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta");
                    break;
                    
                default:
            }
            
            /*  if(entidad.getTipo().equals("administrador")){
            JOptionPane.showMessageDialog(null, "El login fue exitoso tipo de usuario:"+entidad.getTipo());
            menuVisibleOn();
            }
            
            if(entidad.getTipo().equals("vendedor")){
            JOptionPane.showMessageDialog(null, "El login fue exitoso tipo de usuario:"+entidad.getTipo());
            menuVendedorVisibleOn();
            }
            
            else{
            JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no existen");
            }
            
            */
            } 
        catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //Con esto hago visible o no las opciones del menu
                    /*jmiCliente.setVisible(false);*/
        

        
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioActionPerformed
        // TODO add your handling code here:
       
        AbmUsuario abmUsuario = new AbmUsuario();
         jdpContenedorPrincipal.add(abmUsuario);
         abmUsuario.setVisible(true);
              
    }//GEN-LAST:event_jmiUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbLogin;
    public static javax.swing.JDesktopPane jdpContenedorPrincipal;
    private javax.swing.JMenuItem jmiAnularFactura;
    private javax.swing.JMenuItem jmiCategoria;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiFactura;
    private javax.swing.JMenuItem jmiProducto;
    private javax.swing.JMenuItem jmiTipoCliente;
    private javax.swing.JMenuItem jmiUsuario;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
}


//jmi=java menu item