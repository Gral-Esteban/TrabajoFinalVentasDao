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
//import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;



import ventasdao.dominio.Conexion;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Factura;
import ventasdao.ui.abm.AbmFactura;
//import ventasdao.ui.abm.Factura;


/**
 *
 * @author Hugo Chanampe
 */
public class FacturaControlador implements ICrud<Factura>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private String sql1;
    
    
    
    DetalleFactura detallefactura = new DetalleFactura();

    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    
    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception{

     
        //JOptionPane.showMessageDialog(null,"llega aqui C");
        
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO factura (cliente_id,monto_total,forma_pago_id,observaciones) VALUES (?,?,?,?)";
        
       
          //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getCliente_id());
            //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
            //ps.setDate(2, fecha);
            ps.setFloat(2, entidad.getMonto_total());
            ps.setInt(3, entidad.getFormapago().getId());
            ps.setString(4, entidad.getObservaciones());
            
           
            ps.executeUpdate();
            connection.close();
            
            //JOptionPane.showMessageDialog(null,"llega aqui 345555");
            //return true;

        } catch (SQLException ex) {
            Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
        
        // aqui traer el numero de factura y setar en el form de factura
        
        
         connection = Conexion.obtenerConexion();
        
          
        //Obtengo el Id de la tabla factura correspondiente
        try{
            
            this.stmt = connection.createStatement();
            this.sql1 = "SELECT * from factura where id = (SELECT MAX(id) AS id FROM factura)";
            this.rs   = stmt.executeQuery(sql1);
            connection.close();
            
          while(rs.next()){
              //JOptionPane.showMessageDialog(null,"llega aqui C");
              
                 detallefactura.setFactura_id(rs.getInt("id"));
                 
                 //JOptionPane.showMessageDialog(null,"llega aqui C"+ detallefactura.getFactura_id());
                
          } 
            
                 } catch(SQLException ex){
                     ex.printStackTrace();
        }
        
           
        AbmFactura.jtfNumeroFactura.setText(detallefactura.getFactura_id().toString());
        
        
        
        
       //Aqui obtengo la fecha de la base de datos y la seteo en la grilla
       
       
        
         connection = Conexion.obtenerConexion();
        
          
       
        try{
            
            this.stmt = connection.createStatement();
            this.sql1 = "SELECT * from factura where id = (SELECT MAX(id) AS id FROM factura)";
            this.rs   = stmt.executeQuery(sql1);
            connection.close();
            
          while(rs.next()){
              //JOptionPane.showMessageDialog(null,"llega aqui C");
              
                 AbmFactura.jtfFecha.setText(rs.getDate("fecha_facturacion").toString());
                 
                 //JOptionPane.showMessageDialog(null,"llega aqui C"+ detallefactura.getFactura_id());
                
          } 
            
                 } catch(SQLException ex){
                     ex.printStackTrace();
        }
        
           
       
       
        
        
        
        
        
        
        
        
        
        return false;
        
    }

    
    
    
    
    
    
    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Factura> extraer() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
    

   
    

   
    

    
    
    
}
