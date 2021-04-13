/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import ventasdao.objetos.Producto;
import static ventasdao.ui.abm.FacturaGetProducto.jtListadoProductos;


/**
 *
 * @author Hugo Chanampe
 */
public class GrillaProducto extends AbstractTableModel{
    
    private ArrayList<Producto> productos = new ArrayList<>();
    
    
    
    public GrillaProducto(ArrayList<Producto> datos) {
        this.productos = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
         return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch(columnIndex){
              case 0: return producto.getCodigo();
              case 1: return producto.getDescripcion();
              case 2: return producto.getP_dolar();
              case 3: return producto.getP_costo();
              case 4: return producto.getP_venta();
              case 5: return producto.getOrigen();
              case 6: return producto.getProveedor();
              case 7: return producto.getStock();
              case 8: return producto.getCategoria(); 
              case 9: return producto.getImagen();
              case 10: if(producto.getFechaIngreso()!=null){  // hago esto porque al querer pasar de string a date no respeta el formato y me vi obligado a crear otro campo del objeto producto fechaAlta de tipo string
                      return producto.getFechaIngreso();}
                     else{
                          return producto.getFechaAlta();
                         }
                      
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "CODIGO";
            case 1: return "DESCRIPCION";
            case 2: return "P_DOLAR";
            case 3: return "P_COSTO";
            case 4: return "P_VENTA";
            case 5: return "ORIGEN";
            case 6: return "PROVEEDOR";
            case 7: return "STOCK";
            case 8: return "CATEGORIA";
            case 9: return "IMAGEN";
            case 10: return "FECH_ING";
           
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public Producto getProductoFromRow(int rowIndex){
   
            return productos.get(rowIndex);
   
   
   }
     
     
     /*public Dimension setColumnZize(int columnIndex){
     
     TableColumnModel columnModel = jtListadoProductos.getColumnModel();
     
     switch(columnIndex){
     case 0:columnModel.getColumn(0).setPreferredWidth(50);
     case 1: columnModel.getColumn(1).setPreferredWidth(400);
     case 2:columnModel.getColumn(2).setPreferredWidth(150);
     case 3:columnModel.getColumn(3).setPreferredWidth(200);
     case 4:columnModel.getColumn(4).setPreferredWidth(250);
     case 5: columnModel.getColumn(5).setPreferredWidth(50);
     case 6:columnModel.getColumn(6).setPreferredWidth(150);
     case 7:columnModel.getColumn(7).setPreferredWidth(200);
     case 8:columnModel.getColumn(8).setPreferredWidth(250);
     default: return null;
     }
     
     }*/
     
     
     
}