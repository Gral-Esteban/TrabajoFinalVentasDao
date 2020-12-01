package ventasdao.controladores;

import ventasdao.objetos.Producto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import ventasdao.dominio.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import ventasdao.objetos.Categoria;


public class ProductoControlador implements ICrud<Producto> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    private CategoriaControlador categoriaControlador;


    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception{

        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO producto (nombre,descripcion,precio,stock,fecha_creacion,categoria_id) VALUES (?,?,?,?,?,?)";
        
        Date fecha = new Date (entidad.getFechaCreacion().getTime()); 
        
        try {
            ps = connection.prepareStatement(sql);
           
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setInt(4,entidad.getStock());
            ps.setDate(5, fecha);
            ps.setInt(6, entidad.getCategoria().getId());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        
        
    }
    
    
    
    
    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE producto SET nombre=?, descripcion=? , precio=?,stock=?, fecha_creacion=? , categoria_id=?  WHERE id=?";
       
       Date fecha = new Date (entidad.getFechaCreacion().getTime());
       
       ps = connection.prepareStatement(sql);
       ps.setString(1,entidad.getNombre() );
       ps.setString(2,entidad.getDescripcion());
       ps.setFloat(3,entidad.getPrecio());
       ps.setInt(4,entidad.getStock());
       ps.setDate(5,fecha );
       ps.setInt(6, entidad.getCategoria_id());
       ps.setInt(7, entidad.getId());
       
       ps.executeUpdate();
       connection.close();
       return true;
    }
    
    
    
    
     @Override
    public boolean eliminar(Producto entidad) throws SQLException, ClassNotFoundException {
        
          connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM producto WHERE id = ?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
    }
    
    

    
    public Producto extraer(int id) {
        return null;
    }

   

    @Override
    public ArrayList<Producto> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM producto ORDER BY id";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(rs.next()){
                
                Producto producto = new Producto();
                
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion") );
                producto.setPrecio (rs.getFloat("precio"));
                 producto.setStock (rs.getInt("stock"));
                producto.setFechaCreacion(rs.getDate("fecha_creacion"));
                
                producto.setCategoria_id(rs.getInt("categoria_id"));
               
                
                
                productos.add(producto);
                
            }
           
            return productos;
        } catch(SQLException ex){
        }
        return null;
    

    }
   
    
  

    @Override
    public List<Producto> extraer() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
