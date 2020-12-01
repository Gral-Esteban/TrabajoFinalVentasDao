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
import java.util.ArrayList;
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
public class DetalleFacturaControlador implements ICrud<Factura>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    
    
    
    
    DetalleFactura detallefactura = new DetalleFactura();
    
    ArrayList<DetalleFactura> detallefacturas = new ArrayList<>();

    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    
    public boolean crear(List<DetalleFactura> detallefacturas) throws SQLException, Exception{

     
        
        
        
        
      
        
        
        int tamaño= detallefacturas.size();
        
       
  
            
              connection = Conexion.obtenerConexion ();
        
        
        String sql = "INSERT INTO detalle_factura (producto_id,cantidad,factura_id) VALUES (?,?,?)";
     
          //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        
        
        
        
        for(DetalleFactura detallefactura:detallefacturas)  {
            
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, detallefactura.getProducto_id());
            //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
            //ps.setDate(2, fecha);
            ps.setInt(2, detallefactura.getCantidad());
            ps.setInt(3, detallefactura.getFactura_id());
          
            
           
            ps.executeUpdate();
                 
           
            
         
            

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
        //detallefacturas.iterator();
        
        } //cierra el for
       
         connection.close();
        
        
        
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

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
    

   
    

   
    
public int funcione (int valor){
    
    return valor;
}
    
    
    
}
