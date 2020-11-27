/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import ventasdao.objetos.TipoCliente;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Esteban DAlbano
 */
public class GrillaTipoCliente extends AbstractTableModel{
    
     private ArrayList<TipoCliente> tipoClientes = new ArrayList<>();
    
    
    
    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.tipoClientes = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return tipoClientes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoCliente tipoCliente = tipoClientes.get(rowIndex);
        switch(columnIndex){
              case 0: return tipoCliente.getId();
              case 1: return tipoCliente.getNombre();
              case 2: return tipoCliente.getDescripcion();
             
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "DESCRIPCION";
           
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public TipoCliente getTipoClienteFromRow(int rowIndex){
   
            return tipoClientes.get(rowIndex);
   
   
   }
    
}
