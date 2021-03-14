/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Usuario;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaUsuario extends AbstractTableModel{
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    
    public GrillaUsuario(ArrayList<Usuario> datos) {
        this.usuarios = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return usuarios.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex);
        switch(columnIndex){
              case 0: return usuario.getId();
              case 1: return usuario.getNombre();
              case 2: return usuario.getClave();
              case 3: return usuario.getTipo();
              case 4: return usuario.getEstado();
              case 5: return usuario.getPc_mac();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "CLAVE";
            case 3: return "TIPO";
            case 4: return "ESTADO";
            case 5: return "PC_MAC";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public Usuario getUsuarioFromRow(int rowIndex){
   
            return usuarios.get(rowIndex);
   
   
   }
    
}
