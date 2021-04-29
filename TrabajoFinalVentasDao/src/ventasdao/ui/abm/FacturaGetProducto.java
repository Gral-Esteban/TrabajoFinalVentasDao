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
            jcbCategorias.setSelectedItem("Todos");
          
           
           
       } 
       
            catch (Exception ex) {
            Logger.getLogger(FacturaGetProducto.class.getName()).log(Level.SEVERE, null, ex);
             }
        
           //No funciona si lo pongo dentro de un try catch poreso esta afuera  
           //configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################

    
     
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
            columna.setPreferredWidth(564);
            break;
        case 2:
            
            
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(2));
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(2));
            jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(8));
             //jtListadoProductos.removeColumn(jtListadoProductos.getColumnModel().getColumn(7));
           
            /*jtListadoProductos.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(0);
            jtListadoProductos.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            jtListadoProductos.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);*/
            
            
               //columna.setPreferredWidth(80);
            break;
        case 3:
           columna.setPreferredWidth(90);
            break;
        case 4:
            columna.setPreferredWidth(80);
            break;
        case 5:
            columna.setPreferredWidth(50); //Stock
            break;
            /*case 6:
            columna.setPreferredWidth(90);
            break;*/
            case 7:
            columna.setPreferredWidth(0);
            break;
            /*case 8:
            columna.setPreferredWidth(80);
            break;*/
            
        default:columna.setPreferredWidth(90);     
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
        jlImagen = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(jtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 26, 170, -1));

        jtfDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(jtfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 57, 170, -1));

        jcbCategorias.setEditable(true);
        jcbCategorias.setToolTipText("");
        jcbCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriasItemStateChanged(evt);
            }
        });
        getContentPane().add(jcbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 88, 170, -1));
        getContentPane().add(jtfPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, -1));

        jdcFechaIngreso.setEnabled(false);
        getContentPane().add(jdcFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 170, -1));

        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 48, -1));

        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));

        jLabel3.setText("Precio Venta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 20));

        jLabel4.setText("Filtro categoria");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        jLabel5.setText("Fecha Ingreso");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 73, 20));

        jbRegistrarProducto.setText("Agregar a factura");
        jbRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 461, 154, 55));

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
        jtListadoProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtListadoProductosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 11, 1060, 422));
        getContentPane().add(jtfStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 170, -1));

        jLabel8.setText("Stock");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 40, 20));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 464, 100, 49));

        jLabel9.setText("Filtro descripcion");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 69, 20));

        jtfFiltradoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFiltradoDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(jtfFiltradoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 120, 170, -1));

        jButton2.setText("get.zise.table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(933, 467, -1, -1));
        getContentPane().add(jtfZiseTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(933, 496, 99, -1));

        jButton3.setText("filasele");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 467, -1, -1));
        getContentPane().add(jtfFilaSele, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 496, 74, -1));

        jButton4.setText("get.jcb.selected.item");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 467, -1, -1));
        getContentPane().add(jtfJCBSelectedItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 496, 135, -1));

        jlImagen.setBackground(new java.awt.Color(95, 178, 184));
        getContentPane().add(jlImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 367, 250, 210));

        jLabel12.setText("Origen");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 47, 20));
        getContentPane().add(jtfOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 170, -1));

        jLabel13.setText("Proveedor");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 62, 20));
        getContentPane().add(jtfProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 170, -1));
        getContentPane().add(jtfCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 170, -1));

        jLabel6.setText("Categoria");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jButton5.setText("configtable");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 461, 102, 55));

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
        
        stockS =  jtListadoProductos.getValueAt(filasele, 5).toString();
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
        registro [2] = jtListadoProductos.getValueAt(filasele, 2).toString(); //P_venta
       
        
        do{
        entradaUsuario = JOptionPane.showInputDialog("Ingrese una cantidad:");
        validacion = Integer.parseInt(entradaUsuario);
        if(validacion<=0 || validacion>stockI)
            JOptionPane.showMessageDialog(null,"Por favor ingrese un valor mayor a cero y menor al stock");
        }while(validacion<=0 || validacion>stockI);
        
        registro [3] =  entradaUsuario; //Cantidad
        
        registro [4] = jtListadoProductos.getValueAt(filasele, 4).toString(); //Proveedor
    
        
        cantidad = Double.parseDouble(entradaUsuario); // Esto lo hago para poder mas abajo multiplicar en #C1 (si no da error Integer * Double)
        
       totalAnsS = AbmFactura.jtfTotal.getText();
        
        totalS= jtListadoProductos.getValueAt(filasele, 2).toString(); //P_venta
        
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
        
            configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################
            
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
      //  if(jtListadoProductos.getValueAt(i, 2)!=null)
      //  Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
      //  if(jtListadoProductos.getValueAt(i, 3)!=null)
      //  Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        if(jtListadoProductos.getValueAt(i, 3)!=null)
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 4).toString()));
        if(jtListadoProductos.getValueAt(i, 5)!=null)
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 5).toString()));
        if(jtListadoProductos.getValueAt(i, 6)!=null)
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 6).toString()));
       // if(jtListadoProductos.getValueAt(i, 9)!=null)
       // Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
       // if(jtListadoProductos.getValueAt(i, 10)!=null)
       // Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
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
        /*  Producto producto = grillaProducto.getProductoFromRow(jtListadoProductos.getSelectedRow());  //Obtiene el objeto producto con todos sus atributos de la fila seleccionada en la grillaProducto
        categoriaControlador = new CategoriaControlador();
        
        
        //jtfId.setText( producto.getId().toString() );
        jtfCodigo.setText(producto.getCodigo());
        jtfDescripcion.setText(producto.getDescripcion());
        jtfPrecioVenta.setText(producto.getP_venta().toString());
        jtfOrigen.setText(producto.getOrigen());
        jtfProveedor.setText(producto.getProveedor());
        jtfStock.setText(producto.getStock().toString());
        jtfCategoria.setText(producto.getCategoria());
        //jcbCategorias.setSelectedItem(producto.getCategoria());
        jdcFechaIngreso.setDate(producto.getFechaIngreso());
        // jtfCategoriaId.setText(producto.getCategoria_id().toString());*/
        
        int filasele = jtListadoProductos.getSelectedRow(); //Antes lo hacia como esta arriba pero no funciona bien cuando se aplican filtrado
        
        jtfCodigo.setText(jtListadoProductos.getValueAt(filasele, 0).toString()); // Codigo
        jtfDescripcion.setText(jtListadoProductos.getValueAt(filasele, 1).toString()); // Descripcion
        jtfPrecioVenta.setText(jtListadoProductos.getValueAt(filasele, 2).toString()); //P_venta
         jtfOrigen.setText(jtListadoProductos.getValueAt(filasele, 3).toString()); //Origen
         jtfProveedor.setText(jtListadoProductos.getValueAt(filasele, 4).toString()); //Proveedor
         jtfStock.setText(jtListadoProductos.getValueAt(filasele, 5).toString()); //Stock
         if(jtListadoProductos.getValueAt(filasele, 6)!=null)
         jtfCategoria.setText(jtListadoProductos.getValueAt(filasele, 6).toString()); //Categoria
         
        if(jtListadoProductos.getValueAt(filasele, 7)!=null)
        rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, jtListadoProductos.getValueAt(filasele, 7).toString());
        else{
            Producto nulo=new Producto();
            nulo.setImagen(null);
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, nulo.getImagen());
        }
            
       
      
       
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
           
       configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################
           
           //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla
        
        ArrayList<Producto> aOproductos = new ArrayList<>();
        
        
        int filas = jtListadoProductos.getRowCount();
       
        
         for(int i=0;i<filas;i++){
            
        Producto Oproducto = new Producto();
        
       
         //Se validan todos los campos que pueden ser nulos con un if
       
        Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
      //  if(jtListadoProductos.getValueAt(i, 2)!=null)
      //  Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
      //  if(jtListadoProductos.getValueAt(i, 3)!=null)
      //  Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        if(jtListadoProductos.getValueAt(i, 3)!=null)
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 4).toString()));
        if(jtListadoProductos.getValueAt(i, 5)!=null)
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 5).toString()));
        if(jtListadoProductos.getValueAt(i, 6)!=null)
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 6).toString()));
       // if(jtListadoProductos.getValueAt(i, 9)!=null)
       // Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
       // if(jtListadoProductos.getValueAt(i, 10)!=null)
       // Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
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
           
       configtable(); //###################################### CONFIGURACION DE LA TABLA ##################################    
           
           
           //En esta parte cargo toda la tabla en un arraylist para modificar el stock y volver a poner todo en la grilla
        
        ArrayList<Producto> aOproductos = new ArrayList<>();
        
        
        int filas = jtListadoProductos.getRowCount();
       
        
         for(int i=0;i<filas;i++){
            
        Producto Oproducto = new Producto();
        
        
         //Se validan todos los campos que pueden ser nulos con un if
       
        Oproducto.setCodigo((jtListadoProductos.getValueAt(i, 0).toString()));
        Oproducto.setDescripcion((jtListadoProductos.getValueAt(i, 1).toString()));
      //  if(jtListadoProductos.getValueAt(i, 2)!=null)
      //  Oproducto.setP_dolar(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
      //  if(jtListadoProductos.getValueAt(i, 3)!=null)
      //  Oproducto.setP_costo(Float.parseFloat(jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setP_venta(Float.parseFloat(jtListadoProductos.getValueAt(i, 2).toString()));
        if(jtListadoProductos.getValueAt(i, 3)!=null)
        Oproducto.setOrigen((jtListadoProductos.getValueAt(i, 3).toString()));
        Oproducto.setProveedor((jtListadoProductos.getValueAt(i, 4).toString()));
        if(jtListadoProductos.getValueAt(i, 5)!=null)
        Oproducto.setStock(Integer.parseInt(jtListadoProductos.getValueAt(i, 5).toString()));
        if(jtListadoProductos.getValueAt(i, 6)!=null)
        Oproducto.setCategoria((jtListadoProductos.getValueAt(i, 6).toString()));
       // if(jtListadoProductos.getValueAt(i, 9)!=null)
       // Oproducto.setImagen((jtListadoProductos.getValueAt(i, 9).toString()));
       // if(jtListadoProductos.getValueAt(i, 10)!=null)
       // Oproducto.setFechaIngreso(ParseFecha(jtListadoProductos.getValueAt(i, 10).toString()));
        
      
        
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
            public void keyReleased(KeyEvent e) {

                trs.setRowFilter(RowFilter.regexFilter("(?i)" + jtfFiltradoDescripcion.getText() + ". *", 1)); //El numero indica la columna
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

    private void jtListadoProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtListadoProductosKeyReleased
        // TODO add your handling code here:
        
        if( (evt.getKeyCode()==KeyEvent.VK_DOWN) ||(evt.getKeyCode()==KeyEvent.VK_UP) )  {
        
        
            /* Producto producto = grillaProducto.getProductoFromRow(jtListadoProductos.getSelectedRow());  //Obtiene el objeto producto con todos sus atributos de la fila seleccionada en la grillaProducto
            categoriaControlador = new CategoriaControlador();
            
            
            
            //jtfId.setText( producto.getId().toString() );
            jtfCodigo.setText(producto.getCodigo());
            jtfDescripcion.setText(producto.getDescripcion());
            jtfPrecioVenta.setText(producto.getP_venta().toString());
            jtfOrigen.setText(producto.getOrigen());
            jtfProveedor.setText(producto.getProveedor());
            jtfStock.setText(producto.getStock().toString());
            jtfCategoria.setText(producto.getCategoria());
            //jcbCategorias.setSelectedItem(producto.getCategoria());
            jdcFechaIngreso.setDate(producto.getFechaIngreso());
            // jtfCategoriaId.setText(producto.getCategoria_id().toString());
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, producto.getImagen());*/
            
            int filasele = jtListadoProductos.getSelectedRow(); //Antes lo hacia como esta arriba pero no funciona bien cuando se aplican filtrado
        
        jtfCodigo.setText(jtListadoProductos.getValueAt(filasele, 0).toString()); // Codigo
        jtfDescripcion.setText(jtListadoProductos.getValueAt(filasele, 1).toString()); // Descripcion
        jtfPrecioVenta.setText(jtListadoProductos.getValueAt(filasele, 2).toString()); //P_venta
         jtfOrigen.setText(jtListadoProductos.getValueAt(filasele, 3).toString()); //Origen
         jtfProveedor.setText(jtListadoProductos.getValueAt(filasele, 4).toString()); //Proveedor
         jtfStock.setText(jtListadoProductos.getValueAt(filasele, 5).toString()); //Stock
         if(jtListadoProductos.getValueAt(filasele, 6)!=null)
         jtfCategoria.setText(jtListadoProductos.getValueAt(filasele, 6).toString()); //Categoria
         
        if(jtListadoProductos.getValueAt(filasele, 7)!=null)
        rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, jtListadoProductos.getValueAt(filasele, 7).toString());
        else{
            Producto nulo=new Producto();
            nulo.setImagen(null);
            rsscalelabel.RSScaleLabel.setScaleLabel(jlImagen, nulo.getImagen());
        }
            
            
      
        }
      
      
    }//GEN-LAST:event_jtListadoProductosKeyReleased

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
    private javax.swing.JLabel jlImagen;
    public static javax.swing.JTable jtListadoProductos;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfFilaSele;
    private javax.swing.JTextField jtfFiltradoDescripcion;
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