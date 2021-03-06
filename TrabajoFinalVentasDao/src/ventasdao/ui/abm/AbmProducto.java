/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;



/**
 *
 * @author Esteban DAlbano
 */
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import ventasdao.controladores.CategoriaControlador;
import ventasdao.controladores.FacturaProductoControlador;
import ventasdao.controladores.ImportarArchivoControlador;
import ventasdao.controladores.ProductoControlador;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaProducto;


public class AbmProducto extends javax.swing.JInternalFrame {

   private ProductoControlador controladorProducto;
   private CategoriaControlador categoriaControlador;
   private DefaultComboBoxModel modelCombo;
   private GrillaProducto grillaProducto;
   
   
   ImportarArchivoControlador importar = new ImportarArchivoControlador();
   
   TableRowSorter trs;
   
   FacturaProductoControlador facturaProductoControlador;
   
   
    
    public AbmProducto() {
        initComponents();
        
       

           
        ArrayList<Producto> productos;
        
       controladorProducto = new ProductoControlador();
       categoriaControlador = new CategoriaControlador();
       
       
       try {
           productos = controladorProducto.listar();
           grillaProducto = new GrillaProducto(productos);
           jtListadoProductos.setModel(grillaProducto);
           
       } catch (Exception ex) {
           Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       try {
           ArrayList<String> categorias = categoriaControlador.listar2();
           modelCombo = new DefaultComboBoxModel(categorias.toArray());
           jcbCategorias.setModel(modelCombo);
           
       } catch (Exception ex) {
           Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
        
         //Agrego la opcion de Todos al jcbCategorias
           jcbCategorias.addItem("Todos");
           
          //jcbCategorias.addItem(new ComboItem(0, "Pan"));
             //para seleccionar el de ID = 2, huevos
           //jcbCategorias.setSelectedIndex(2);
             jcbCategorias.setToolTipText("Todos");
           
           
          //para seleccionar el de valor "Todos" por defecto en el combo box (es necesario agregar la propiedad editable al JCB)
            jcbCategorias.setSelectedItem("Todos");
       
       
            configtable();
       
    }
    
    
    
    
     /*############### Configuracion de la tabla ##################*/
    public void configtable() {
        
        
        TableColumn columna = null;
//se hace el recorrido de tu arreglo de columnas
for (int i = 0; i < jtListadoProductos.getColumnCount(); i++) {
    columna = jtListadoProductos.getColumnModel().getColumn(i);
    switch(i){
        case 0:
            columna.setWidth(80); //Codigo
            break;
        case 1:
            columna.setPreferredWidth(320); //Descripcion
            break;
        case 2:

               columna.setPreferredWidth(80); //P_Dolar
            break;
        case 3:
           columna.setPreferredWidth(80); //P_Costo
            break;
        case 4:
            columna.setPreferredWidth(80); //P_Venta
            break;
        case 5:
            columna.setPreferredWidth(80); //Origen
            break;
        case 6:
            columna.setPreferredWidth(80); //Proveedor
            break;
        case 7:
            columna.setPreferredWidth(60);  //Stock
            break;
        case 8:
            columna.setPreferredWidth(90);  //Categoria
            break;
            
        default:columna.setPreferredWidth(80);     
        //etc aqui las demas columnas
                }

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

        jtfCodigo = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jcbCategorias = new javax.swing.JComboBox<>();
        jtfPrecioVenta = new javax.swing.JTextField();
        jdcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbRegistrarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoProductos = new javax.swing.JTable();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbImportar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfPrecioCosto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfPrecioDolar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfOrigen = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfProveedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfImagen = new javax.swing.JTextField();
        jlImagen = new javax.swing.JLabel();
        jbReset = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBackup = new javax.swing.JButton();
        jtfFiltradoCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfFiltradoDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(1026, 560));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, -1));

        jtfDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(jtfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 880, -1));

        jcbCategorias.setEditable(true);
        jcbCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriasItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 133, -1));
        getContentPane().add(jtfPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, -1));
        getContentPane().add(jdcFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 130, -1));

        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 48, 20));

        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 60, 20));

        jLabel3.setText("P_venta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 65, 20));

        jLabel4.setText("Categoria");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        jLabel5.setText("Fecha Ingreso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 71, 20));

        jbRegistrarProducto.setText("Registrar");
        jbRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 120, 45));

        jtListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "P_Dolar", "P_Costo", "P_Venta", "Origen", "Proveedor", "Stock", "Categoria", "Imagen", "Fecha_Ingreso"
            }
        ));
        jtListadoProductos.setShowGrid(true);
        jtListadoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoProductosMouseClicked(evt);
            }
        });
        jtListadoProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtListadoProductosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoProductos);
        if (jtListadoProductos.getColumnModel().getColumnCount() > 0) {
            jtListadoProductos.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtListadoProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtListadoProductos.getColumnModel().getColumn(10).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 11, 997, 396));

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 120, 45));

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 120, 45));
        getContentPane().add(jtfStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, -1));

        jLabel8.setText("Stock");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 50, 20));

        jbImportar.setText("Importar");
        jbImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImportarActionPerformed(evt);
            }
        });
        getContentPane().add(jbImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 120, 46));

        jLabel9.setText("P_costo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 61, 20));
        getContentPane().add(jtfPrecioCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 130, -1));

        jLabel10.setText("P_dolar");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 20));
        getContentPane().add(jtfPrecioDolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, -1));

        jLabel11.setText("Origen");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 20));

        jtfOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(jtfOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 130, -1));

        jLabel12.setText("Proveedor");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 60, 20));

        jtfProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(jtfProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 130, -1));

        jLabel13.setText("Imagen");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 53, 20));

        jtfImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfImagenActionPerformed(evt);
            }
        });
        getContentPane().add(jtfImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 880, -1));
        getContentPane().add(jlImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 200, 180));

        jbReset.setText("Reset");
        jbReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbResetMouseEntered(evt);
            }
        });
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });
        getContentPane().add(jbReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 120, 46));

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, 120, 46));

        jbBackup.setText("Backup");
        jbBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackupActionPerformed(evt);
            }
        });
        getContentPane().add(jbBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 120, 46));

        jtfFiltradoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFiltradoCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(jtfFiltradoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 130, -1));

        jLabel6.setText("F. Codigo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jtfFiltradoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFiltradoDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(jtfFiltradoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 130, -1));

        jLabel7.setText("F. Descripcion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 60, 20));
        getContentPane().add(jtfCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 130, -1));

        jLabel15.setText("Categoria");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 70, 20));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 517, 40, -1));

        setBounds(0, 0, 1264, 595);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionActionPerformed

    private void jbRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarProductoActionPerformed
        // TODO add your handling code here:
        Producto producto = new Producto();
        
        producto.setCodigo(jtfCodigo.getText());
        producto.setDescripcion(jtfDescripcion.getText());
        producto.setP_dolar(Float.parseFloat(jtfPrecioDolar.getText()));
        producto.setP_costo(Float.parseFloat(jtfPrecioCosto.getText()));
        producto.setP_venta(Float.parseFloat(jtfPrecioVenta.getText()));
        producto.setOrigen(jtfOrigen.getText());
        producto.setProveedor(jtfProveedor.getText());
        producto.setStock(Integer.parseInt(jtfStock.getText()));
        producto.setCategoria(jtfCategoria.getText());   //(String) jcbCategorias.getSelectedItem() Se esta casteando que el resultado de jcbCategorias.getSelectedItem() sea del tipo Categoria
        producto.setImagen(jtfImagen.getText());
        producto.setFechaIngreso(jdcFechaIngreso.getDate());
        
        
        
        
       try {
           controladorProducto.crear(producto);
           limpiarCampos();
       } catch (Exception ex) {
           Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        controladorProducto = new ProductoControlador();
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            productos = controladorProducto.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaProducto = new GrillaProducto(productos);
        jtListadoProductos.setModel(grillaProducto);
        
        
        //Esto limpia campos
        limpiarCampos();
       
        configtable(); //Le da el tamaño personalizado a las columnas
        
        
    }//GEN-LAST:event_jbRegistrarProductoActionPerformed

    private void jtListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoProductosMouseClicked
        // TODO add your handling code here:
        int filasele = jtListadoProductos.getSelectedRow(); //Antes lo hacia con objetos pero no funciona bien cuando se aplican filtrado
        
        jtfCodigo.setText(jtListadoProductos.getValueAt(filasele, 0).toString()); // Codigo
        jtfDescripcion.setText(jtListadoProductos.getValueAt(filasele, 1).toString()); // Descripcion
        jtfPrecioDolar.setText(jtListadoProductos.getValueAt(filasele, 2).toString()); //P_Dolar
        jtfPrecioCosto.setText(jtListadoProductos.getValueAt(filasele, 3).toString()); //P_Costo
        jtfPrecioVenta.setText(jtListadoProductos.getValueAt(filasele, 4).toString()); //P_Venta
         jtfOrigen.setText(jtListadoProductos.getValueAt(filasele, 5).toString()); //Origen
         jtfProveedor.setText(jtListadoProductos.getValueAt(filasele, 6).toString()); //Proveedor
         jtfStock.setText(jtListadoProductos.getValueAt(filasele, 7).toString()); //Stock
         if(jtListadoProductos.getValueAt(filasele, 8)!=null)
         jtfCategoria.setText(jtListadoProductos.getValueAt(filasele, 8).toString()); //Categoria
         
        if(jtListadoProductos.getValueAt(filasele, 9)!=null){
        rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, jtListadoProductos.getValueAt(filasele, 9).toString());//Imagen
        jtfImagen.setText(jtListadoProductos.getValueAt(filasele, 9).toString());
        }
        else{
            Producto nulo=new Producto();
            nulo.setImagen(null);
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, nulo.getImagen());
            jtfImagen.setText("");
        }
            
        
        
       
     
       
    }//GEN-LAST:event_jtListadoProductosMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
       Producto producto = new Producto();
        producto.setCodigo(jtfCodigo.getText());
        producto.setProveedor(jtfProveedor.getText());
        
        try {
            controladorProducto.eliminar(producto);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoProductos.setModel(new GrillaProducto(controladorProducto.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        //Este refresca la grilla una vez que se hizo una modificacion de lo contrario pierde referencia la grilla con los textfield
        controladorProducto = new ProductoControlador();
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            productos = controladorProducto.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaProducto = new GrillaProducto(productos);
        jtListadoProductos.setModel(grillaProducto);
        
        
        
         //Esto limpia campos
        limpiarCampos();
        
        
        configtable(); //Le da el tamaño personalizado a las columnas
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    
    
    
    
    
    
    
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
           try {
            
            Producto producto = new Producto();
            
            
          
            producto.setCodigo( jtfCodigo.getText() );
            producto.setDescripcion( jtfDescripcion.getText() );
            producto.setP_dolar( Float.parseFloat( jtfPrecioDolar.getText() ) );
            producto.setP_costo( Float.parseFloat( jtfPrecioCosto.getText() ) );
            producto.setP_venta( Float.parseFloat( jtfPrecioVenta.getText() ) );
            producto.setOrigen( jtfOrigen.getText() );
            producto.setProveedor( jtfProveedor.getText() );
            producto.setStock(Integer.parseInt(jtfStock.getText()));
            producto.setImagen( jtfImagen.getText() );
            producto.setFechaIngreso( ( jdcFechaIngreso.getDate()) );
            producto.setCategoria(jtfCategoria.getText());
            
            
            controladorProducto.modificar(producto);
        } 
        catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoProductos.setModel( new GrillaProducto( controladorProducto.listar() ));
        } 
        catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String catsel = (String)jcbCategorias.getSelectedItem();
       
       refresh();
       
       jcbCategorias.setSelectedItem(catsel);
        
        
         //Esto limpia campos
       limpiarCampos();
       
       configtable(); //Le da el tamaño personalizado a las columnas
        
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImportarActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
        String absolutePath = null;
        
        chooser.setPreferredSize(new Dimension(600, 400));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //chooser.setSize(600, 800);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            absolutePath = chooser.getSelectedFile().getAbsolutePath();
        //JOptionPane.showMessageDialog(rootPane, "You chose to open this directory: " +absolutePath);    
        /*System.out.println("You chose to open this directory: " +
        chooser.getSelectedFile().getAbsolutePath());*/
        }
        
        
        try {
            importar.importarExcel(absolutePath);
            JOptionPane.showMessageDialog(rootPane, "Se importo la lista con exito");
        } 
        catch (Exception ex) {
            System.out.println("Error al querer importar el archivo");
        }
        
        
        refresh();
        
        
        configtable(); //Le da el tamaño personalizado a las columnas
        
    }//GEN-LAST:event_jbImportarActionPerformed

    private void jtfOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfOrigenActionPerformed

    private void jtfProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfProveedorActionPerformed

    private void jtfImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfImagenActionPerformed

    private void jbResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbResetMouseEntered
        // TODO add your handling code here:
        jbReset.setToolTipText("Esta opcion borra todos los datos de la tabla, se recomienda hacer antes un backup");
    }//GEN-LAST:event_jbResetMouseEntered

    private void jtListadoProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtListadoProductosKeyReleased
        // TODO add your handling code here:
        
         if( (evt.getKeyCode()==KeyEvent.VK_DOWN) ||(evt.getKeyCode()==KeyEvent.VK_UP) )  {
        
        int filasele = jtListadoProductos.getSelectedRow(); //Antes lo hacia con objetos pero no funciona bien cuando se aplican filtrado
        
        jtfCodigo.setText(jtListadoProductos.getValueAt(filasele, 0).toString()); // Codigo
        jtfDescripcion.setText(jtListadoProductos.getValueAt(filasele, 1).toString()); // Descripcion
        jtfPrecioDolar.setText(jtListadoProductos.getValueAt(filasele, 2).toString()); //P_Dolar
        jtfPrecioCosto.setText(jtListadoProductos.getValueAt(filasele, 3).toString()); //P_Costo
        jtfPrecioVenta.setText(jtListadoProductos.getValueAt(filasele, 4).toString()); //P_Venta
         jtfOrigen.setText(jtListadoProductos.getValueAt(filasele, 5).toString()); //Origen
         jtfProveedor.setText(jtListadoProductos.getValueAt(filasele, 6).toString()); //Proveedor
         jtfStock.setText(jtListadoProductos.getValueAt(filasele, 7).toString()); //Stock
         if(jtListadoProductos.getValueAt(filasele, 8)!=null)
         jtfCategoria.setText(jtListadoProductos.getValueAt(filasele, 8).toString()); //Categoria
         
        if(jtListadoProductos.getValueAt(filasele, 9)!=null){
        rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, jtListadoProductos.getValueAt(filasele, 9).toString());//Imagen
        jtfImagen.setText(jtListadoProductos.getValueAt(filasele, 9).toString());
        }
        else{
            Producto nulo=new Producto();
            nulo.setImagen(null);
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, nulo.getImagen());
            jtfImagen.setText("");
        }
     
        }
    }//GEN-LAST:event_jtListadoProductosKeyReleased

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
       // TODO add your handling code here:
        
        try {
          
           controladorProducto.reset();
       } catch (SQLException ex) {
           Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
        
        refresh();
        
        configtable(); //Le da el tamaño personalizado a las columnas
        
    }//GEN-LAST:event_jbResetActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackupActionPerformed
        // TODO add your handling code here:
    
        abrirarchivo("C://Users//Esteban DAlbano//Documents//NetBeansProjects//VentasDAOs//TrabajoFinalVentasDao//backup/backupDB.bat");
                        

        
    }//GEN-LAST:event_jbBackupActionPerformed

    
    
    
    
    
    
    private void jtfFiltradoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltradoDescripcionKeyTyped
        // TODO add your handling code here:

        jtfFiltradoDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + jtfFiltradoDescripcion.getText() + ". *", 1)); //El numero indica la columna
            }

        });

        trs = new TableRowSorter(jtListadoProductos.getModel());

        jtListadoProductos.setRowSorter(trs);
    }//GEN-LAST:event_jtfFiltradoDescripcionKeyTyped

    private void jtfFiltradoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltradoCodigoKeyTyped
        // TODO add your handling code here:
        
        jtfFiltradoCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                trs.setRowFilter(RowFilter.regexFilter(jtfFiltradoCodigo.getText(),0)); //El numero indica la columna
            }

        });

        trs = new TableRowSorter(jtListadoProductos.getModel());

        jtListadoProductos.setRowSorter(trs);
        
    }//GEN-LAST:event_jtfFiltradoCodigoKeyTyped

    private void jcbCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriasItemStateChanged
        // TODO add your handling code here:

        //Filtrado por categoria #######################
        jtfFiltradoDescripcion.setText(null);
        jtfFiltradoCodigo.setText(null);

        Categoria categoria = new Categoria();

        String cat_name = jcbCategorias.getSelectedItem().toString();

        if (cat_name.equals("Todos")) {

            //jtfFiltradoDescripcion.setText(null);

            ArrayList<Producto> productos;

            controladorProducto = new ProductoControlador();
            categoriaControlador = new CategoriaControlador();

            try {
                productos = controladorProducto.listar();
                grillaProducto = new GrillaProducto(productos);
                jtListadoProductos.setModel(grillaProducto);

                ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
                trs = new TableRowSorter(jtListadoProductos.getModel());
                jtListadoProductos.setRowSorter(trs);  /////

            } catch (Exception ex) {
                Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }//Fin del If (cat_name.equals("Todos"))
       
       
       
       
       
           
           else{ //If (cat_name !="Todos")
               
               jtfFiltradoDescripcion.setText(null);
                jtfFiltradoCodigo.setText(null);
              
           
           
           
           ArrayList<Producto> productos = new ArrayList<>();
           
           facturaProductoControlador = new FacturaProductoControlador();
           categoriaControlador = new CategoriaControlador();
           
         
           
           try {
               productos = (ArrayList<Producto>) facturaProductoControlador.listar(cat_name);
               grillaProducto = new GrillaProducto(productos);
               jtListadoProductos.setModel(grillaProducto);
               
              ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria 
               trs = new TableRowSorter(jtListadoProductos.getModel()); 
            jtListadoProductos.setRowSorter(trs);  /////
               
           } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            
           
      
           
           } //Fin del Else
           
           
       configtable();
        
        
    }//GEN-LAST:event_jcbCategoriasItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fc = new JFileChooser();
        
        fc.setDialogTitle("Buscar Imagen");
        
        if(fc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
            File archivo = new File(fc.getSelectedFile().toString());
            
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, fc.getSelectedFile().toString());
            
            jtfImagen.setText(fc.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
    
    
    
    
    public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

}                         
    
    
    

   public void refresh() {
        
        /*Aqui refrescamos la tabla luego de hacer el import */
        ArrayList<Producto> productos;

        controladorProducto = new ProductoControlador();
        categoriaControlador = new CategoriaControlador();

        try {
            productos = controladorProducto.listar();
            grillaProducto = new GrillaProducto(productos);
            jtListadoProductos.setModel(grillaProducto);

        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
        ArrayList<String> categorias = categoriaControlador.listar2();
        modelCombo = new DefaultComboBoxModel(categorias.toArray());
        jcbCategorias.setModel(modelCombo);
        
        } catch (Exception ex) {
        Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria 
               trs = new TableRowSorter(jtListadoProductos.getModel()); 
               jtListadoProductos.setRowSorter(trs);  /////
        
    }
    
    
    
   
   
    
    
    
    
    
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBackup;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbImportar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbRegistrarProducto;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbSalir;
    public javax.swing.JComboBox<String> jcbCategorias;
    private com.toedter.calendar.JDateChooser jdcFechaIngreso;
    private javax.swing.JLabel jlImagen;
    public javax.swing.JTable jtListadoProductos;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfFiltradoCodigo;
    private javax.swing.JTextField jtfFiltradoDescripcion;
    private javax.swing.JTextField jtfImagen;
    private javax.swing.JTextField jtfOrigen;
    private javax.swing.JTextField jtfPrecioCosto;
    private javax.swing.JTextField jtfPrecioDolar;
    private javax.swing.JTextField jtfPrecioVenta;
    private javax.swing.JTextField jtfProveedor;
    private javax.swing.JTextField jtfStock;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        
        jtfDescripcion.setText("");
        jtfCodigo.setText("");
        jtfPrecioVenta.setText("");
        jtfPrecioCosto.setText("");
        jtfPrecioDolar.setText("");
        jtfOrigen.setText("");
        jtfProveedor.setText("");
        jtfStock.setText("");
        jcbCategorias.setToolTipText("");
        jtfImagen.setText("");
        jdcFechaIngreso.setToolTipText("");
        jdcFechaIngreso.setDate(null);
    }
}
