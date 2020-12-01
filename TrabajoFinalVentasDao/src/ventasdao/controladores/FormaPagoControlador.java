/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;

/**
 *
 * @author Esteban DAlbano
 */
public class FormaPagoControlador implements ICrud<FormaPago>{
    
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    
  
    
    public ArrayList<FormaPago> listar() throws SQLException, Exception{
    
    
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM forma_pago";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<FormaPago> formapagos = new ArrayList();
            
            
            while(rs.next()){
                
                FormaPago formapago = new FormaPago();
                
                formapago.setDenominacion(rs.getString("denominacion"));
                
                formapago.setId(rs.getInt("id"));
                
                   
                
                
                formapagos.add(formapago);
                
            }
           
            return formapagos;
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    

    
    
    }

    @Override
    public boolean crear(FormaPago entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(FormaPago entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FormaPago> extraer() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(FormaPago entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
