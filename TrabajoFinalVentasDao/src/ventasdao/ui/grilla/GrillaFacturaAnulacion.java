/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.ObjetoFacturaAnulacion;

/**
 *
 * @author Esteban DAlbano
 */
public class GrillaFacturaAnulacion extends AbstractTableModel {
    
    
    private ArrayList<ObjetoFacturaAnulacion> objetoFacturaAnulaciones = new ArrayList<>();
    
    
    
    public GrillaFacturaAnulacion(ArrayList<ObjetoFacturaAnulacion> datos) {
        this.objetoFacturaAnulaciones = datos;
    }
    
    

    public int getRowCount() {
        return objetoFacturaAnulaciones.size(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getColumnCount() {
         return 9;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ObjetoFacturaAnulacion objetoFacturaAnulacion = objetoFacturaAnulaciones.get(rowIndex);
        switch(columnIndex){
              case 0: return objetoFacturaAnulacion.getNumero_factura();
              case 1: return objetoFacturaAnulacion.getExpedidor();
              case 2: return objetoFacturaAnulacion.getCliente_id();
              case 3: return objetoFacturaAnulacion.getNombre();
              case 4: return objetoFacturaAnulacion.getApellido();
              case 5: return objetoFacturaAnulacion.getMonto_total();
              case 6: return objetoFacturaAnulacion.getDenominacion();
              case 7: return objetoFacturaAnulacion.getFecha_facturacion();
              case 8: return objetoFacturaAnulacion.getObservaciones();
              
              default: return "";
          }
        
    }

    public String getColumnName(int column) {
        switch(column){
            case 0: return "Num_Factura";
            case 1: return "Emitida_Por";
            case 2: return "Cliente_Id";
            case 3: return "Nombre";
            case 4: return "Apellido";
            case 5: return "Monto_Total";
            case 6: return "Forma_Pago";
            case 7: return "Fecha";
            case 8: return "Observaciones";
            
            
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public ObjetoFacturaAnulacion getObjetoFacturaAnulacionFromRow(int rowIndex){
   
            return objetoFacturaAnulaciones.get(rowIndex);
   
   
   }
    
}
