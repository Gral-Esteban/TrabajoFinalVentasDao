/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Producto;


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
         return 10;
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
              case 8: return producto.getImagen();
              case 9: if(producto.getFechaIngreso()!=null){  // hago esto porque al querer pasar de string a date no respeta el formato y me vi obligado a crear otro campo del objeto producto fechaAlta de tipo string
                      return producto.getFechaIngreso();}
                     else{
                          return producto.getFechaAlta();
                         }
              case 10: return producto.getCategoria();         
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
            case 8: return "IMAGEN";
            case 9: return "FECH_ING";
            case 10: return "CATEGORIA";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public Producto getProductoFromRow(int rowIndex){
   
            return productos.get(rowIndex);
   
   
   }
    
}