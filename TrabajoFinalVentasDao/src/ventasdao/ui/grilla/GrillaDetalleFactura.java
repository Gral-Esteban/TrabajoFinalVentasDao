/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.DetalleFactura;

/**
 *
 * @author Esteban DAlbano
 */
public class GrillaDetalleFactura extends AbstractTableModel {
    
    
    private ArrayList<DetalleFactura> detallefacturas = new ArrayList<>();
    
    
    
    public GrillaDetalleFactura(ArrayList<DetalleFactura> datos) {
        this.detallefacturas = datos;
    }
    
    

    public int getRowCount() {
        return detallefacturas.size(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getColumnCount() {
         return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleFactura detallefactura = detallefacturas.get(rowIndex);
        switch(columnIndex){
              case 0: return detallefactura.getId();
              case 1: return detallefactura.getNombre();
              case 2: return detallefactura.getDescripcion();
              case 3: return detallefactura.getPrecio();
              case 4: return detallefactura.getCantidad();
              
              default: return "";
          }
        
    }

    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "DESCRIPCION";
            case 3: return "PRECIO";
            case 4: return "CANTIDAD";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public DetalleFactura getDetalleFacturaFromRow(int rowIndex){
   
            return detallefacturas.get(rowIndex);
   
   
   }
    
}
