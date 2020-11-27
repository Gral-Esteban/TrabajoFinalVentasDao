package ventasdao.controladores;

//import ventasdao.objetos.Producto;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import ventasdao.dominio.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//import ventasdao.objetos.Categoria;
import ventasdao.objetos.DetalleFactura;



public class FacturaProductoControlador implements ICrud<DetalleFactura> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    private String sql1;
    
    //private CategoriaControlador categoriaControlador;

  
   
   

    
    @Override
    public boolean crear(DetalleFactura entidad) throws SQLException, Exception{
        
    //JOptionPane.showMessageDialog(null,"llega aqui B");

        connection = Conexion.obtenerConexion ();
        
          
        //Obtengo el Id de la tabla factura correspondiente
        try{
            
            this.stmt = connection.createStatement();
            this.sql1 = "SELECT * from factura where id = (SELECT MAX(id) AS id FROM factura)";
            this.rs   = stmt.executeQuery(sql1);
            connection.close();
            
          while(rs.next()){
              
                 entidad.setFactura_id(rs.getInt("id"));
                 
                 //JOptionPane.showMessageDialog(null,"llega aqui C"+ entidad.getFactura_id());
                
          } 
            
                 } catch(SQLException ex){
        }
        
        
        
        
        
        connection = Conexion.obtenerConexion ();
        
        String sql = "INSERT INTO detalle_factura (nombre,descripcion,precio,cantidad,factura_id) VALUES (?,?,?,?,?)";
        
        
        
        try {
            ps = connection.prepareStatement(sql);
           
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setInt(4,entidad.getCantidad());
            ps.setInt(5, entidad.getFactura_id());
          
            
            
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FacturaProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        
        
    }
    
    
    
    
    @Override
    public boolean modificar(DetalleFactura entidad) throws SQLException, Exception {
        
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE detalle_factura SET nombre=?, descripcion=? , precio=?,cantidad=?, factura_id=? WHERE id=?";
       
       
       
       ps = connection.prepareStatement(sql);
       ps.setString(1,entidad.getNombre() );
       ps.setString(2,entidad.getDescripcion());
       ps.setFloat(3,entidad.getPrecio());
       ps.setInt(4,entidad.getCantidad());
       ps.setInt(5,entidad.getFactura_id() );
       
       ps.setInt(6, entidad.getId());
       
       ps.executeUpdate();
       connection.close();
       return true;
    }
    
    
    
    
    @Override
    public boolean eliminar(DetalleFactura entidad) throws SQLException, ClassNotFoundException {
        
          connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM detalle_factura WHERE id = ?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
            
            
        } catch (SQLException e) {
             Logger.getLogger(FacturaProductoControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
    }
    
    

    
    public DetalleFactura extraer(int id) {
        
       
        return null;
    }

   

    public ArrayList<DetalleFactura> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = " SELECT * from detalle_factura where factura_id = (SELECT MAX(factura_id) AS id FROM detalle_factura)";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<DetalleFactura> detallefacturas = new ArrayList();
            
            while(rs.next()){
                
                DetalleFactura detalleFactura = new DetalleFactura();
                
                detalleFactura.setId(rs.getInt("id"));
                detalleFactura.setNombre(rs.getString("nombre"));
                detalleFactura.setDescripcion(rs.getString("descripcion") );
                detalleFactura.setPrecio (rs.getFloat("precio"));
                detalleFactura.setCantidad (rs.getInt("cantidad"));
                detalleFactura.setFactura_id(rs.getInt("factura_id"));
                
               // producto.setCategoria_id(rs.getInt("categoria_id"));
                //producto.setCategoria(getCategoria(rs.getInt("producto_id")));
                        //System.out.println(producto);
                
                
                detallefacturas.add(detalleFactura);
                
            }
            //System.out.println(cont);
            return detallefacturas;
            
        } catch(SQLException ex){
        }
        return null;
    

    }
   
    
    /*private Categoria getCategoria (Integer id) throws Exception{
    
        this.categoriaControlador = new CategoriaControlador();
        
        Categoria categoria = categoriaControlador.extraer(id);
        
        return categoria;
    }*/

    @Override
    public List<DetalleFactura> extraer() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  /*
public Integer ObtenerTotal()  throws SQLException, Exception{
        
    //JOptionPane.showMessageDialog(null,"llega aqui B");

        connection = Conexion.obtenerConexion ();
        
          
        //Obtengo el Id de la tabla factura correspondiente
        try{
            
            this.stmt = connection.createStatement();
            this.sql1 = "SELECT SUM(precio) FROM detalle_factura  WHERE factura_id = (SELECT MAX(factura_id) AS id FROM detalle_factura)";
            this.rs   = stmt.executeQuery(sql1);
            connection.close();
            
            Integer var;
            
            
          while(rs.next()){
              
                 
                 
                 //JOptionPane.showMessageDialog(null,"llega aqui C"+ entidad.getFactura_id());
                
          } 
            
                 } catch(SQLException ex){
        }
        
        return 
        
  }

    */
    
    
    
    
}