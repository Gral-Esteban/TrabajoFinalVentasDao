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
import ventasdao.objetos.Categoria;


public class ControladorProducto implements ICrud<Producto> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    private CategoriaControlador categoriaControlador;


    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception{

        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO producto (nombre,descripcion,precio,fecha_creacion,categoria_id) VALUES (?,?,?,?,?)";
        
        Date fecha = new Date (entidad.getFechaCreacion().getTime()); 
        
        try {
            ps = connection.prepareStatement(sql);
           
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, fecha);
            ps.setInt(5, entidad.getCategoria().getId());
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        
        
    }

    @Override
    public boolean eliminar(Producto entidad) {
        return false;
    }

    @Override
    public Producto extraer(int id) {
        return null;
    }

    @Override
    public boolean modificar(Producto entidad) {
        return false;
    }

    @Override
    public ArrayList<Producto> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM producto";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(rs.next()){
                
                Producto producto = new Producto();
                
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion") );
                producto.setPrecio (rs.getFloat("precio"));
                producto.setFechaCreacion(rs.getDate("fecha_creacion"));
                
                producto.setCategoria_id(rs.getInt("categoria_id"));
                //producto.setCategoria(getCategoria(rs.getInt("producto_id")));
                        //System.out.println(producto);
                
                
                productos.add(producto);
                
            }
            //System.out.println(cont);
            return productos;
        } catch(SQLException ex){
        }
        return null;
    

    }
    
    
    private Categoria getCategoria (Integer id) throws Exception{
    
        this.categoriaControlador = new CategoriaControlador();
        
        Categoria categoria = categoriaControlador.extraer(id);
        
        return categoria;
    }
    
    
    
}
