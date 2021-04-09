package ventasdao.controladores;



import java.sql.Connection;

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
import ventasdao.objetos.Categoria;

import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Producto;



public class FacturaProductoControlador implements ICrud<Producto> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    private String sql1;
    
   


    
    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception{
        
    
        
        connection = Conexion.obtenerConexion ();
        
        String sql = "INSERT INTO detalle_factura (nombre,descripcion,precio,cantidad,factura_id) VALUES (?,?,?,?,?)";
        
        
        
        try {
            ps = connection.prepareStatement(sql);
           
            ps.setString(1, entidad.getCodigo());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getP_venta());
            //ps.setInt(4,entidad.getCantidad());
            //ps.setInt(5, entidad.getFactura_id());
          
            
            
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FacturaProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        
        
    }
    
    
    
    
    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception {
        
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE detalle_factura SET nombre=?, descripcion=? , precio=?,cantidad=?, factura_id=? WHERE id=?";
       
       
       
       ps = connection.prepareStatement(sql);
       ps.setString(1,entidad.getCodigo() );
       ps.setString(2,entidad.getDescripcion());
       ps.setFloat(3,entidad.getP_venta());
       //ps.setInt(4,entidad.getCantidad());
       //ps.setInt(5,entidad.getFactura_id() );
       
       ps.setInt(6, entidad.getId());
       
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
             Logger.getLogger(FacturaProductoControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
    }
    
    

    //Esto ya no se va usar
    /* public Categoria extraer(String denominacion) throws SQLException,Exception{
    
    Categoria categoria = new Categoria();
    
    
    connection = Conexion.obtenerConexion ();
    
    
    try {
    this.stmt = connection.createStatement();
    this.sql = " select id from categorias where denominacion ='"+denominacion+"'";
    
    this.rs   = stmt.executeQuery(sql);
    connection.close();
    
    
    
    while(rs.next()){
    
    categoria.setId(rs.getInt("id"));
    
    }
    
    } catch (SQLException ex) {
    Logger.getLogger(FacturaProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    
    
    return categoria;
    }*/

   

    public ArrayList<Producto> listar(String cat_Name) throws SQLException,Exception{
        
        
        connection = Conexion.obtenerConexion ();
        try{
            //String cadena= String.valueOf(Categ_id); //Esto lo hice porque para hacer una consulta no me funcionaba el signo ?
            this.stmt = connection.createStatement();
            this.sql = " SELECT * FROM productos1 WHERE categoria = '"+cat_Name+"' ORDER BY id";
            
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList<>();
            
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

 

    @Override
    public List<Producto> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}