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
              case 1: return detallefactura.getCodigo();
              case 2: return detallefactura.getDescripcion();
              case 3: return detallefactura.getP_venta();
              case 4: return detallefactura.getCantidad();
              case 5: return detallefactura.getProveedor();
              
              default: return "";
          }
        
    }

    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "CODIGO";
            case 2: return "DESCRIPCION";
            case 3: return "P_VENTA";
            case 4: return "CANTIDAD";
            case 5: return "PROVEEDOR";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public DetalleFactura getDetalleFacturaFromRow(int rowIndex){
   
            return detallefacturas.get(rowIndex);
   
   
   }
    
}
