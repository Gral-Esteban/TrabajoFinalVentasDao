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
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;

/**
 *
 * @author Esteban DAlbano
 */
public class ImportarArchivoControlador {
    
    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    
    
    public boolean importarExcel(String absolutePath)throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
               sql = "CEATE TABLE PUBLIC";
        String sql = "DELETE FROM producto WHERE id = ?";
        try {
            ps=connection.prepareStatement(sql);
            //ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
    }


}

    

