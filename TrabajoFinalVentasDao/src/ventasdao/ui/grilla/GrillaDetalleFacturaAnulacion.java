/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.DetalleFacturaAnulacion;

/**
 *
 * @author Esteban DAlbano
 */
public class GrillaDetalleFacturaAnulacion extends AbstractTableModel {
    
    
    private ArrayList<DetalleFacturaAnulacion> detalleFacturaAnulaciones = new ArrayList<>();
    
    
    
    public GrillaDetalleFacturaAnulacion(ArrayList<DetalleFacturaAnulacion> datos) {
        this.detalleFacturaAnulaciones = datos;
    }
    
    

    public int getRowCount() {
        return detalleFacturaAnulaciones.size(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getColumnCount() {
         return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleFacturaAnulacion detallefactura = detalleFacturaAnulaciones.get(rowIndex);
        switch(columnIndex){
              
              case 0: return detallefactura.getNombre();
              case 1: return detallefactura.getDescripcion();
              case 2: return detallefactura.getPrecio();
              case 3: return detallefactura.getCantidad();
              
              default: return "";
          }
        
    }

    public String getColumnName(int column) {
        switch(column){
            
            case 0: return "NOMBRE";
            case 1: return "DESCRIPCION";
            case 2: return "PRECIO";
            case 3: return "CANTIDAD";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public DetalleFacturaAnulacion getDetalleFacturaFromRow(int rowIndex){
   
            return detalleFacturaAnulaciones.get(rowIndex);
   
   
   }
    
}
