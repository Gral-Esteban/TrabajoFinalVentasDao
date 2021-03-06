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
import ventasdao.objetos.DetalleFacturaAnulacion;
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
    
    DetalleFacturaAnulacion detalleFacturaAnulacion = new DetalleFacturaAnulacion();
    
    ArrayList<DetalleFacturaAnulacion> detalleFacturaAnulaciones = new ArrayList <> ();
    

    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    
    public boolean crear(List<DetalleFactura> detallefacturas) throws SQLException, Exception{

     
        
        int tamaño= detallefacturas.size();
        
       
        connection = Conexion.obtenerConexion ();
        
        
        String sql = "INSERT INTO detalle_factura (cantidad,factura_id,codigo,proveedor) VALUES (?,?,?,?)";
     
          //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        
        
        
        
        for(DetalleFactura detallefactura:detallefacturas)  {
            
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, detallefactura.getCantidad());
            //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
            //ps.setDate(2, fecha);
            ps.setInt(2, detallefactura.getFactura_id());
            ps.setString(3, detallefactura.getCodigo());
            ps.setString(4, detallefactura.getProveedor());
            
            ps.executeUpdate();
                 
           

        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        
       
        
        } //cierra el for
       
         connection.close();
        
        
        
        return false;
        
    }

    
    
    
    //Aqui me devuleve un ArrayList personalizado
     public ArrayList<DetalleFacturaAnulacion> listar(int num_fact) throws SQLException,Exception{
        
        
        connection = Conexion.obtenerConexion ();
        try{
            String cadena= String.valueOf(num_fact); //Esto lo hice porque para hacer una consulta no me funcionaba el signo ?
            this.stmt = connection.createStatement();
            this.sql = " SELECT df.id, p.codigo, p.descripcion, p.p_venta, df.cantidad, p.proveedor FROM detalle_factura df INNER JOIN productos1 p ON (df.codigo = p.codigo AND df.proveedor = p.proveedor) WHERE factura_id = '"+cadena+"' ORDER BY df.id";
            
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            //ArrayList<DetalleFactura> detalleFacturas = new ArrayList<>();
            
            while(rs.next()){
                
                detalleFacturaAnulacion = new DetalleFacturaAnulacion();
                
                detalleFacturaAnulacion.setId(rs.getInt("id"));
                detalleFacturaAnulacion.setCodigo(rs.getString("codigo"));
                detalleFacturaAnulacion.setDescripcion(rs.getString("descripcion"));
                detalleFacturaAnulacion.setP_venta(rs.getFloat("p_venta"));
                detalleFacturaAnulacion.setCantidad(rs.getInt("cantidad") );
                detalleFacturaAnulacion.setProveedor(rs.getString("proveedor") );
                
              
                detalleFacturaAnulaciones.add(detalleFacturaAnulacion);
                
            }
            
            return detalleFacturaAnulaciones;
            
        } catch(SQLException ex){
        }
        
        
        
        
        return null;
    

        
        
    }
     
     
     
     
     
     
     //Aqui me devuleve un ArrayList de detalle_factura para el numero de factura especificado
     
     public ArrayList<DetalleFactura> listar2(int num_fact) throws SQLException,Exception{
        
        
        connection = Conexion.obtenerConexion ();
        try{
            String cadena= String.valueOf(num_fact); //Esto lo hice porque para hacer una consulta no me funcionaba el signo ?
            this.stmt = connection.createStatement();
            this.sql = " SELECT * FROM detalle_factura WHERE factura_id = '"+cadena+"'";
            
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            //ArrayList<DetalleFactura> detalleFacturas = new ArrayList<>();
            
            while(rs.next()){
                
                detallefactura = new DetalleFactura();
                
                 detallefactura.setId(rs.getInt("id"));
                 detallefactura.setCodigo(rs.getString("codigo") );
                 detallefactura.setCantidad(rs.getInt("cantidad"));
                detallefactura.setFactura_id(rs.getInt("factura_id"));
                detallefactura.setProveedor(rs.getString("proveedor") );
               
                
              
                detallefacturas.add(detallefactura);
                
            }
            
            return detallefacturas;
            
        } catch(SQLException ex){
        }
        
        
        
        
        return null;
    

        
        
    }
     
     
     
     
     
     
     
     
    
    
    public boolean eliminar (int id)throws SQLException, Exception {
        
         connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM detalle_factura WHERE factura_id = ?";
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
    
    
    
    
    
    public boolean eliminar2 (int id)throws SQLException, Exception {
        
         connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM detalle_factura WHERE id = ?";
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

   
   
    
}






/*select * from producto
select * from detalle_factura
select * from factura



update producto set stock=stock+24 where id = 4

select p.nombre, p.descripcion, p.precio, cantidad
from detalle_factura
inner join producto p on producto_id = p.id*/