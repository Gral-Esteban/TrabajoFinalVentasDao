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
         return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch(columnIndex){
              case 0: return producto.getId();
              case 1: return producto.getCategoria_id();
              case 2: return producto.getNombre();
              case 3: return producto.getDescripcion();
              case 4: return producto.getPrecio();
              case 5: return producto.getStock();
              case 6: return producto.getFechaCreacion();
              
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "CATEGORIA_ID";
            case 2: return "NOMBRE";
            case 3: return "DESCRIPCION";
            case 4: return "PRECIO";
            case 5: return "STOCK";
            case 6: return "FECHA_CREACION";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public Producto getProductoFromRow(int rowIndex){
   
            return productos.get(rowIndex);
   
   
   }
    
}