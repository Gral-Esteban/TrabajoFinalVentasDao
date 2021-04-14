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
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventasdao.controladores.CategoriaControlador;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.ProductoControlador;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaProducto;

 import ventasdao.controladores.FacturaProductoControlador;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.DetalleFactura;
import ventasdao.ui.grilla.GrillaDetalleFactura;
import ventasdao.ui.abm.AbmFactura;
import java.util.*;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.text.DateFormat;




import java.util.Date;
import javax.swing.table.TableColumn;




public final class FacturaGetProducto extends javax.swing.JInternalFrame {
    
    

   private ProductoControlador controladorProducto;
   private CategoriaControlador categoriaControlador;
   private DefaultComboBoxModel modelCombo;
   private GrillaProducto grillaProducto;
   private GrillaDetalleFactura grillaDetalleFactura;
   
   
   DefaultTableModel modelo = new DefaultTableModel(); ////////////////////////
   private double totalD = 0; 
   private String totalS = null;
   private double cantidad =0;///////////////////////
   private String totalAnsS = null;
   
   
   
   String entradaUsuario = null;
   Integer validacion = 0; 
   String stockS = null;
   Integer stockI = 0;
   
   
   
    private DetalleFactura detallefactura;
    private FacturaProductoControlador facturaProductoControlador = new FacturaProductoControlador(); 
    
    
    TableRowSorter trs;
   
   
   //int bandera=0;
   
    
    
    public FacturaGetProducto() {
        initComponents();
        
       

      //Carga los productos desde la base de datos     
       ArrayList<Producto> productos;
        
       controladorProducto = new ProductoControlador();
       categoriaControlador = new CategoriaControlador();
       
       
       try {
           productos = controladorProducto.listar();
           grillaProducto = new GrillaProducto(productos);
           jtListadoProductos.setModel(grillaProducto);
           
           
   
           
       } 
       
            catch (Exception ex) {
           Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       //Cargar el JComboBox desde la base de datos
       try {
           ArrayList<String> categorias = categoriaControlador.listar2();
           modelCombo = new DefaultComboBoxModel(categorias.toArray());
           jcbCategorias.setModel(modelCombo);
           
           //Agrego la opcion de Todos al jcbCategorias
           jcbCategorias.addItem("Todos");
           
          //jcbCategorias.addItem(new ComboItem(0, "Pan"));
             //para seleccionar el de ID = 2, huevos
           //jcbCategorias.setSelectedIndex(2);
             jcbCategorias.setToolTipText("Todos");
           
           
          //para seleccionar el de valor "Todos" por defecto en el combo box (es necesario agregar la propiedad editable al JCB)
            //jcbCategorias.setSelectedItem("Todos");
          
           
           
       } 
       
            catch (Exception ex) {
            Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
             }
        
           //No funciona si lo pongo dentro de un try catch poreso esta afuera  
           configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################

    
     
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
     
    /*############### Configuracion de la tabla ##################*/
    public void configtable() {
        
        
        TableColumn columna = null;
//se hace el recorrido de tu arreglo de columnas
for (int i = 0; i < jtListadoProductos.getColumnCount(); i++) {
    columna = jtListadoProductos.getColumnModel().getColumn(i);
    switch(i){
        case 0:
            columna.setWidth(80); //el ancho de la column
            break;
        case 1:
            columna.setPreferredWidth(500);
            break;
        case 2:
            
            
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(2));
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(2));
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(7));
             jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(7));
           
               //columna.setPreferredWidth(80);
            break;
        case 3:
           columna.setPreferredWidth(90);
            break;
        case 4:
            columna.setPreferredWidth(80);
            break;
        case 5:
            columna.setPreferredWidth(80);
            break;
            /*case 6:
            columna.setPreferredWidth(90);
            break;
            case 7:
            columna.setPreferredWidth(60);
            break;
            case 8:
            columna.setPreferredWidth(80);
            break;*/
            
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
        jtfStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfFiltradoDescripcion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jtfZiseTable = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jtfFilaSele = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jtfJCBSelectedItem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfImagen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtfOrigen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfProveedor = new javax.swing.JTextField();
        jtfCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(1026, 560));
        setVisible(true);

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jtfDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionActionPerformed(evt);
            }
        });

        jcbCategorias.setEditable(true);
        jcbCategorias.setToolTipText("");
        jcbCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriasItemStateChanged(evt);
            }
        });

        jdcFechaIngreso.setEnabled(false);

        jLabel1.setText("Codigo");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Precio Venta");

        jLabel4.setText("Filtro categoria");

        jLabel5.setText("Fecha Ingreso");

        jbRegistrarProducto.setText("Agregar a factura");
        jbRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarProductoActionPerformed(evt);
            }
        });

        jtListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "P_VENTA", "ORIGEN", "PROVEEDOR", "STOCK", "CATEGORIA", "IMAGEN", "FECHA_INGRESO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtListadoProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListadoProductos.setFocusCycleRoot(true);
        jtListadoProductos.setShowGrid(true);
        jtListadoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoProductos);

        jLabel8.setText("Stock");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Filtro descripcion");

        jtfFiltradoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFiltradoDescripcionKeyTyped(evt);
            }
        });

        jButton2.setText("get.zise.table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("filasele");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("get.jcb.selected.item");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Imagen fuente");

        jLabel11.setBackground(new java.awt.Color(95, 178, 184));

        jLabel12.setText("Origen");

        jLabel13.setText("Proveedor");

        jLabel6.setText("Categoria");

        jButton5.setText("configtable");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jtfOrigen)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfFiltradoDescripcion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(jtfCodigo)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jcbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(jtfProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfCategoria)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jbRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jtfFilaSele, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jtfZiseTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jtfJCBSelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(jcbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(jtfFiltradoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(jtfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(jtfProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(jtfImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jdcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6)
                        .addComponent(jtfFilaSele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2)
                        .addGap(6, 6, 6)
                        .addComponent(jtfZiseTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton4)
                        .addGap(6, 6, 6)
                        .addComponent(jtfJCBSelectedItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        setBounds(0, 0, 1359, 618);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescripcionActionPerformed

    
    
    
    
    private void jbRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarProductoActionPerformed
        // TODO add your handling code here:
       
        
        int filasele = jtListadoProductos.getSelectedRow();
        
        stockS =  jtListadoProductos.getValueAt(filasele, 7).toString();
        stockI = Integer.parseInt(stockS);
        
        //Valido que tenga stock antes que todo
        if(stockI>0) {
        
        //Valido todo el codigo del boton (si ninguna fila esta seleccionada filasele= -1 )
        if(filasele>=0){
        
        
        //Carga el registro seleccionado y lo agrega a la tabla de facturacion 
        DefaultTableModel modelo = (DefaultTableModel) AbmFactura.jtListadoFacturacion.getModel();
        
        
        
        jtfFiltradoDescripcion.setText(null);
        
        String [] registro = new String [5];
        
        
        
        registro [0] = jtListadoProductos.getValueAt(filasele, 0).toString(); // Codigo
        registro [1] = jtListadoProductos.getValueAt(filasele, 1).toString();  //Descripcion
        registro [2] = jtListadoProductos.getValueAt(filasele, 4).toString(); //P_venta
       
        
        do{
        entradaUsuario = JOptionPane.showInputDialog("Ingrese una cantidad:");
        validacion = Integer.parseInt(entradaUsuario);
        if(validacion<=0 || validacion>stockI)
            JOptionPane.showMessageDialog(null,"Por favor ingrese un valor mayor a cero y menor al stock");
        }while(validacion<=0 || validacion>stockI);
        
        registro [3] =  entradaUsuario; //Cantidad
        
        registro [4] = jtListadoProductos.getValueAt(filasele, 6).toString(); //Proveedor
    
        
        cantidad = Double.parseDouble(entradaUsuario); // Esto lo hago para poder mas abajo multiplicar en #C1 (si no da error Integer * Double)
        
       totalAnsS = AbmFactura.jtfTotal.getText();
        
        totalS= jtListadoProductos.getValueAt(filasele, 4).toString();
        
        totalD= Double.parseDouble(totalAnsS) + Double.parseDouble(totalS) * cantidad; //#C1  [total anterior + (P_venta x Cantidad)]
        
       
        
        String totalcadena= String.valueOf(totalD);
        
        
        
        modelo.addRow(registro);
        
        
        //Estas dos lineas soluciona problema al usar el filtrado por nombre rompia en la linea siguiente
         trs = new TableRowSorter(jtListadoProductos.getModel());
            jtListadoProductos.setRowSorter(trs);  /////
        
        AbmFactura.jtListadoFacturacion.setModel(modelo); //Esta es la linea siguiente
        
        AbmFactura.jtfTotal.setText(totalcadena);
        

        //Esto limpia campos
        limpiarCampos();
        
        
        ///Voy a tener que considerar para solucionar un problema (que no mantiene el filtrado seleccionado una vez agrago un producto)
        ///en que filtrado de categoria estaba y en funcion de eso cargar todos los productos o solo de una categoria determinada
        
        
        //Este if lo pongo porque si carga siempre el modelo de "Todos" no recuerda cuando esta el filtrado por categoria
        if(jcbCategorias.getSelectedItem().toString().equals("Todos"))   {
            
            
         //Aqui cargo de la base de datos porque si no en la 2da iteracion se descuenta de nuevo el stock generando valores negativos
        
        ArrayList<Producto> productos;
        
        controladorProducto = new ProductoControlador();
        categoriaControlador = new CategoriaControlador(); //Instancio o creo un objeto de CategoriaControlador
        
        
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
        
        configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################
        
        }
        
        else {
            //Categoria categoria = new Categoria();
            
           
           String cat_name = jcbCategorias.getSelectedItem().toString();
           
            
             jtfFiltradoDescripcion.setText(null);
           
             /* try { //Aqui lo que hacia era extraer el id de la categoria
             categoria = facturaProductoControlador.extraer(cat_name);
             } catch (Exception ex) {
             Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
             }*/
           
           
           
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
        
            
            
        }
        
        
        
        
        
         //Aqui contrastaremos el stock de la factura y lo descontaremos al que se cargo anteriormente desde la base de datos
       
       int cantfilasfact = AbmFactura.jtListadoFacturacion.getRowCount();
       
       if(cantfilasfact>0){
           
           
           //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla
        
        ArrayList<Producto> aOproductos = new ArrayList<>();
        
        
        int filas = jtListadoProductos.getRowCount();
       
        
        for(int i=0;i<filas;i++){
            
        Producto Oproducto = new Producto();
        
        
        //Se validan todos los campos que pueden ser nulos con un if
       
        Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
        if(jtListadoProductos.getValueAt(i, 2)!=null)
        Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        if(jtListadoProductos.getValueAt(i, 3)!=null)
        Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 4).toString()));
        if(jtListadoProductos.getValueAt(i, 5)!=null)
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 5).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 6).toString()));
        if(jtListadoProductos.getValueAt(i, 7)!=null)
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 7).toString()));
        if(jtListadoProductos.getValueAt(i, 8)!=null)
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 8).toString()));
        if(jtListadoProductos.getValueAt(i, 9)!=null)
        Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
        if(jtListadoProductos.getValueAt(i, 10)!=null)
        Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
        for(int j=0;j<cantfilasfact;j++){
         if( Oproducto.getCodigo().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 0).toString()) && Oproducto.getProveedor().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 4).toString()) )
           Oproducto.setStock(Oproducto.getStock()-Integer.parseInt(AbmFactura.jtListadoFacturacion.getValueAt(j, 3).toString())); 
        }
            
        aOproductos.add(Oproducto);
        
        }
        
        
        
         grillaProducto = new GrillaProducto(aOproductos);
        jtListadoProductos.setModel(grillaProducto);
        
        ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
            trs = new TableRowSorter(jtListadoProductos.getModel());
            jtListadoProductos.setRowSorter(trs);  /////
        
        
        configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################    
       }
        
       
    
        
        
       
        
       
        
        //Esta linea si modifica una celda pero en este caso no porque estoy usando el modelo grillaProducto y genera problemas
        // modelo.setValueAt(totalD, 0, 0);
        
       
        }  
        
        
             else
            {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un producto");
            }
        
        
        }
        
        
        
        else {
            
            JOptionPane.showMessageDialog(null, "No hay stock disponible");
            
        }
        
        
    }//GEN-LAST:event_jbRegistrarProductoActionPerformed

    private void jtListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoProductosMouseClicked
        // TODO add your handling code here:
        Producto producto = grillaProducto.getProductoFromRow(jtListadoProductos.getSelectedRow());  //Obtiene el objeto producto con todos sus atributos de la fila seleccionada en la grillaProducto
        categoriaControlador = new CategoriaControlador();
        
         
     
       //jtfId.setText( producto.getId().toString() );
        jtfCodigo.setText(producto.getCodigo());
       jtfDescripcion.setText(producto.getDescripcion());
       jtfPrecioVenta.setText( producto.getP_venta().toString() );
       jtfOrigen.setText(producto.getOrigen());
       jtfProveedor.setText(producto.getProveedor());
        jtfStock.setText( producto.getStock().toString() );
       jtfCategoria.setText(producto.getCategoria());
       //jcbCategorias.setSelectedItem(producto.getCategoria());
       jdcFechaIngreso.setDate(producto.getFechaIngreso());
      // jtfCategoriaId.setText(producto.getCategoria_id().toString());
      
      
                
       
      
       
    }//GEN-LAST:event_jtListadoProductosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

      
    
    private void jcbCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriasItemStateChanged
      
        //Filtrado por categoria #######################
        
          
        
            
           
            
           // TODO add your handling code here:
           
           //tendria que agregar aqui las condiciones del inicio para que no rompa la tabla al usar el filtro por nombre
          
     
            //JOptionPane.showMessageDialog(null,"entro al JCB!!!"); //////////##########*********&&&&&&&&&&$$$$$$$$$$
            
          /*  if(jtfFiltradoNombre.getText().length()!=0){
            jtfFiltradoNombre.setText(jtfFiltradoNombre.getText().substring(0, jtfFiltradoNombre.getText().length()-1));
        }*/
           
          
          //String filtdesc= jtfFiltradoDescripcion.getText();
          
            jtfFiltradoDescripcion.setText(null);
            
             /*jtfFiltradoNombre.invalidate();
             jtfFiltradoNombre.repaint();
             jtfFiltradoNombre.removeAll();
             jtfFiltradoNombre.resetKeyboardActions();*/
            
           Categoria categoria = new Categoria();
           
           String cat_name = jcbCategorias.getSelectedItem().toString();
           
           if(cat_name.equals("Todos")){
               
               jtfFiltradoDescripcion.setText(null);
              
               
               
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
       
       
       
       
        //Aqui contrastaremos el stock de la factura y lo descontaremos al que se cargo anteriormente desde la base de datos
       
       int cantfilasfact = AbmFactura.jtListadoFacturacion.getRowCount();
       
       if(cantfilasfact>0){
           
           
           //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla
        
        ArrayList<Producto> aOproductos = new ArrayList<>();
        
        
        int filas = jtListadoProductos.getRowCount();
       
        
         for(int i=0;i<filas;i++){
            
        Producto Oproducto = new Producto();
        
        
        //Oproducto.setId(Integer.parseInt(jtListadoProductos.getValueAt(i, 0).toString()));
       
        Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
        Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 4).toString()));
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 5).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 6).toString()));
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 7).toString()));
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 8).toString()));
        Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
        Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
        for(int j=0;j<cantfilasfact;j++){
         if( Oproducto.getCodigo().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 0).toString()) && Oproducto.getProveedor().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 4).toString()) )
           Oproducto.setStock(Oproducto.getStock()-Integer.parseInt(AbmFactura.jtListadoFacturacion.getValueAt(j, 3).toString())); 
        }
            
        aOproductos.add(Oproducto);
        
        }
        
        
           try {
               grillaProducto = new GrillaProducto(aOproductos);
               jtListadoProductos.setModel(grillaProducto);
               
              

               ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
               trs = new TableRowSorter(jtListadoProductos.getModel());
               jtListadoProductos.setRowSorter(trs);  /////
           } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
           }
               
        
            
       } //Fin del if(cantfilasfact>0)    
                
            //Si el configtable lo pongo dentro del if(cantfilasfact>0) no le da bola por eso lo puse aqui
           configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################    
               
            }//Fin del If (cat_name.equals("Todos"))
       
       
       
       
       
           
           else{ //If (cat_name !="Todos")
               
               jtfFiltradoDescripcion.setText(null);
           
               /*try {
               categoria = facturaProductoControlador.extraer(cat_name);
               } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
               }*/
           
           
           
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
           
           
           //Aqui contrastaremos el stock de la factura y lo descontaremos al que se cargo anteriormente desde la base de datos
       
       int cantfilasfact = AbmFactura.jtListadoFacturacion.getRowCount();
       
       if(cantfilasfact>0){
           
           
           //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla
        
        ArrayList<Producto> aOproductos = new ArrayList<>();
        
        
        int filas = jtListadoProductos.getRowCount();
       
        
         for(int i=0;i<filas;i++){
            
        Producto Oproducto = new Producto();
        
        
        //Oproducto.setId(Integer.parseInt(jtListadoProductos.getValueAt(i, 0).toString()));
       
        Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
        Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 4).toString()));
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 5).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 6).toString()));
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 7).toString()));
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 8).toString()));
        Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
        Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
        for(int j=0;j<cantfilasfact;j++){
         if( Oproducto.getCodigo().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 0).toString()) && Oproducto.getProveedor().equals(AbmFactura.jtListadoFacturacion.getValueAt(j, 4).toString()) )
           Oproducto.setStock(Oproducto.getStock()-Integer.parseInt(AbmFactura.jtListadoFacturacion.getValueAt(j, 3).toString())); 
        }
            
        aOproductos.add(Oproducto);
        
        }
        
        
          
               try {
               grillaProducto = new GrillaProducto(aOproductos);
               jtListadoProductos.setModel(grillaProducto);

               ///// Estas dos lineas me solucionaron el problema que tenia al filtrar por nombre no me mostraba despues todas las filas al seleccionar una catgoria
               trs = new TableRowSorter(jtListadoProductos.getModel());
               jtListadoProductos.setRowSorter(trs);  /////
           } catch (Exception ex) {
               Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
           }
               
           
          
                 
           
       } //Fin del if(cantfilasfact>0)    
           
            //Si el configtable lo pongo dentro del if(cantfilasfact>0) no le da bola por eso lo puse aqui
           configtable(); //###################################### CONFIGURACION DE LA TABLA ################################## 
           
           //jtfFiltradoDescripcion.setText(filtdesc);
           
           } //Fin del Else
           
           
      
        
        
      
    }//GEN-LAST:event_jcbCategoriasItemStateChanged

    private void jtfFiltradoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltradoDescripcionKeyTyped
        // TODO add your handling code here:
        
         //DefaultTableModel dtm = new DefaultTableModel();
        
       jtfFiltradoDescripcion.addKeyListener(new KeyAdapter() {
           @Override
           public void keyReleased(KeyEvent e) 
            
            {
               
               trs.setRowFilter(RowFilter.regexFilter("(?i)"+jtfFiltradoDescripcion.getText(), 1)); //El numero indica la columna
           }
        
       });
       
       trs = new TableRowSorter(jtListadoProductos.getModel());
       
      
       jtListadoProductos.setRowSorter(trs);
       
       //JOptionPane.showMessageDialog(null,"que pasa aqui?");
       
       
       
    }//GEN-LAST:event_jtfFiltradoDescripcionKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jtfZiseTable.setText(String.valueOf(jtListadoProductos.getRowCount()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int filasele = jtListadoProductos.getSelectedRow();
        jtfFilaSele.setText(String.valueOf(filasele));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        jtfJCBSelectedItem.setText(jcbCategorias.getSelectedItem().toString());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        configtable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void limpiarCampos() {
        
        jtfDescripcion.setText("");
        jtfCodigo.setText("");
        jtfPrecioVenta.setText("");
        //jtfPrecioCosto.setText("");
        //jtfPrecioDolar.setText("");
        jtfOrigen.setText("");
        jtfProveedor.setText("");
        jtfStock.setText("");
        jcbCategorias.setToolTipText("");
        jtfImagen.setText("");
        jdcFechaIngreso.setToolTipText("");
        jdcFechaIngreso.setDate(null);
    }
  
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRegistrarProducto;
    public static javax.swing.JComboBox<String> jcbCategorias;
    private com.toedter.calendar.JDateChooser jdcFechaIngreso;
    public static javax.swing.JTable jtListadoProductos;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfFilaSele;
    private javax.swing.JTextField jtfFiltradoDescripcion;
    private javax.swing.JTextField jtfImagen;
    private javax.swing.JTextField jtfJCBSelectedItem;
    private javax.swing.JTextField jtfOrigen;
    private javax.swing.JTextField jtfPrecioVenta;
    private javax.swing.JTextField jtfProveedor;
    private javax.swing.JTextField jtfStock;
    private javax.swing.JTextField jtfZiseTable;
    // End of variables declaration//GEN-END:variables

   
}






//BORRADOR ######################################################################


/*
        modelo = new DefaultTableModel();
      
      modelo.addColumn("id");
      modelo.addColumn("categoria_id");
      modelo.addColumn("nombre");
      modelo.addColumn("descripcion");
      modelo.addColumn("precio");
      modelo.addColumn("stock");
      modelo.addColumn("fecha_crea");
      
      this.jtListadoProductos.setModel(modelo);
      
      
        
       int filasele = jtListadoProductos.getSelectedRow();
       
       String [] registro2 = new String [6];
        
        
        
        registro2 [0] = jtListadoProductos.getValueAt(filasele, 0).toString();
        registro2 [1] = jtListadoProductos.getValueAt(filasele, 1).toString();
        registro2 [2] = jtListadoProductos.getValueAt(filasele, 2).toString();
        registro2 [3] = jtListadoProductos.getValueAt(filasele, 3).toString();
        registro2 [4] = jtListadoProductos.getValueAt(filasele, 4).toString();
        
          String newstockS=  jtListadoProductos.getValueAt(filasele, 5).toString();
          Integer newstockI= Integer.parseInt(newstockS);
          Integer newvalorI = newstockI +10;
          String newvalorS = String.valueOf(newvalorI);
          
        registro2 [5] = newvalorS;
        registro2 [6] = jtListadoProductos.getValueAt(filasele, 6).toString();
        
        
        for(int i=0;i<jtListadoProductos.getColumnCount();i++){
            
            modelo.setValueAt(registro2[i], filasele, i); 
        
        
            
        }
           */


//Convertir de String a Date (si funciona pero tiene un formato "WED Nov 18 hs:mm:ss ART 2020" que no me sirve)
        /*  
            String stringFecha = jtListadoProductos.getValueAt(i, 6).toString();
        
            try {
                 DateFormat fecha = new SimpleDateFormat("yyyy-M-d");
			 Date convertido = fecha.parse(stringFecha);
                         
			System.out.println(convertido);
                        
                        Oproducto.setFechaCreacion(convertido);
                
                
            } catch (ParseException ex) {
                Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
			
        */