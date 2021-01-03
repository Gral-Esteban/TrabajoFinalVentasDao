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
import ventasdao.objetos.ObjetoFacturaAnulacion;
import ventasdao.objetos.Producto;
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
    Factura factura = new Factura();
    ObjetoFacturaAnulacion objetoFacturaAnulacion = new ObjetoFacturaAnulacion();

  
    
    
    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception{

     
     
        
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
            
              
                 detallefactura.setFactura_id(rs.getInt("id"));
                 
                 factura.setFecha_facturacion(rs.getDate("fecha_facturacion"));
                
                
          } 
            
                 } catch(SQLException ex){
                     ex.printStackTrace();
        }
        
         //Seteo el numero de factura y la fecha en el formulario  
        AbmFactura.jtfNumeroFactura.setText(detallefactura.getFactura_id().toString());
        AbmFactura.jtfFecha.setText(factura.getFecha_facturacion().toString());
        
        
        
      
           

        
        return false;
        
    }

    
    
    
    
    
    
    
   
    public ArrayList<ObjetoFacturaAnulacion> listar2() throws SQLException,Exception{
        
        
        connection = Conexion.obtenerConexion ();
        
        try{
            
            this.stmt = connection.createStatement();
            
            //JOptionPane.showMessageDialog(null, "Entra a listar2");
            
            this.sql = "SELECT numero_factura, cliente_id, c.nombre, c.apellido, monto_total,  fp.denominacion, fecha_facturacion, observaciones FROM factura INNER JOIN cliente c ON cliente_id = c.id INNER JOIN forma_pago fp ON forma_pago_id = fp.id ORDER BY numero_factura";
          
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<ObjetoFacturaAnulacion> objetoFacturaAnulaciones = new ArrayList<>();
            
            while(rs.next()){
                
           objetoFacturaAnulacion = new ObjetoFacturaAnulacion();
                
                 objetoFacturaAnulacion.setNumero_factura(rs.getInt("numero_factura"));
                 objetoFacturaAnulacion.setCliente_id(rs.getInt("cliente_id"));
                 objetoFacturaAnulacion.setNombre(rs.getString("nombre") );
                 objetoFacturaAnulacion.setApellido(rs.getString("apellido") );
                 objetoFacturaAnulacion.setMonto_total(rs.getFloat("monto_total"));
                 objetoFacturaAnulacion.setDenominacion(rs.getString("denominacion") );
                 objetoFacturaAnulacion.setFecha_facturacion(rs.getDate("fecha_facturacion"));
                 objetoFacturaAnulacion.setObservaciones(rs.getString("observaciones") );
               
                
              
                objetoFacturaAnulaciones.add(objetoFacturaAnulacion);
                
            }
            
            return objetoFacturaAnulaciones;
            
        } catch(SQLException ex){
        }
        
      
        
        
        return null;
    

        
        
    }
    
    
    
    public boolean eliminar(int id) throws SQLException, Exception {
        
         connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM factura WHERE id = ?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.close();
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
        
        
    }
    
    
    
    public boolean modificar_Monto(float decStock,int fact_Id) throws SQLException, Exception {
        
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE factura SET monto_total=monto_total-?  WHERE numero_factura=?";
       
       
       
       ps = connection.prepareStatement(sql);
       ps.setFloat(1,decStock );
       ps.setInt(2,fact_Id );
       
       ps.executeUpdate();
       connection.close();
       return true;
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
