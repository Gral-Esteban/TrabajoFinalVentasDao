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
        String sql = "INSERT INTO productos1 (codigo,descripcion,p_dolar,p_costo,p_venta,origen,proveedor,stock,categoria,imagen) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        Date fecha = new Date (entidad.getFechaIngreso().getTime()); 
        
        try {
            ps = connection.prepareStatement(sql);
           
            ps.setString(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getP_dolar());
            ps.setFloat(4, entidad.getP_costo());
            ps.setFloat(5, entidad.getP_venta());
            ps.setString(6, entidad.getOrigen());
            ps.setString(7, entidad.getProveedor());
            ps.setInt(8,entidad.getStock());
            ps.setString(9, entidad.getCategoria());
            ps.setString(10, entidad.getImagen());
            
            
            //ps.setInt(6, entidad.getCategoria().getId());
            
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
       this.sql = "UPDATE productos1 SET codigo=?, descripcion=? , p_dolar=?, p_costo=?,p_venta=?, origen=?, proveedor=?, stock=?, categoria=?, imagen=?, fecha_ingreso=?  WHERE codigo=? AND proveedor=?";
       
       Date fecha = new Date (entidad.getFechaIngreso().getTime());
       
       ps = connection.prepareStatement(sql);
       
           
            ps.setString(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getP_dolar());
            ps.setFloat(4, entidad.getP_costo());
            ps.setFloat(5, entidad.getP_venta());
            ps.setString(6, entidad.getOrigen());
            ps.setString(7, entidad.getProveedor());
            ps.setInt(8,entidad.getStock());
            ps.setString(9, entidad.getCategoria());
            ps.setString(10, entidad.getImagen());
            ps.setDate(11, fecha);
            ps.setString(12, entidad.getCodigo());
            ps.setString(13, entidad.getProveedor());
       
       ps.executeUpdate();
       connection.close();
       return true;
    }
    
    
    
    
     @Override
    public boolean eliminar(Producto entidad) throws SQLException, ClassNotFoundException {
        
          connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM productos1 WHERE codigo=? AND proveedor =?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, entidad.getCodigo());
            ps.setString(2, entidad.getProveedor());
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
            this.sql = "SELECT * FROM productos1 ORDER BY id DESC";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(rs.next()){
                
                Producto producto = new Producto();
                
                producto.setId(rs.getInt("id"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getString("descripcion") );
                producto.setP_dolar (rs.getFloat("p_dolar"));
                producto.setP_costo (rs.getFloat("p_costo"));
                producto.setP_venta (rs.getFloat("p_venta"));
                producto.setOrigen(rs.getString("origen"));
                producto.setProveedor(rs.getString("proveedor")); 
                producto.setStock (rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setImagen(rs.getString("imagen"));
                producto.setFechaIngreso(rs.getDate("fecha_ingreso"));
                
                
               
                
                
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
