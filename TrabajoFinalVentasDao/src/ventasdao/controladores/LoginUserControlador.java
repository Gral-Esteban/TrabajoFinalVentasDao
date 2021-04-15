/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.io.FileWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Usuario;
import ventasdao.ui.abm.AbmUsuario;



/**
 *
 * @author Hugo Chanampe
 */
public class LoginUserControlador implements ICrud<Usuario>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    

    
    /*Clase mac y funcion conseguirMAC para obtener la MAC del PC*/
    public class mac {

    
     public String conseguirMAC(){
            StringBuilder sb = new StringBuilder();
  NetworkInterface a; String linea;
  try {
   a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
   byte[] mac = a.getHardwareAddress();
   

   for (int i = 0; i < mac.length; i++) {
    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));  
   } 
   FileWriter fwriter = new FileWriter("mac.dat");
   fwriter.write("MAC: " + sb.toString());
   fwriter.close();
   
 //  lmac.setText("SE ha registrado la MAC exitosamente.");
  } catch (Exception e) {
   e.printStackTrace(); 
  }
  return ""+sb.toString();
 }
    
    }
    
    
    
    
    @Override
    public boolean crear(Usuario entidad) throws SQLException, Exception{

        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO usuario (nombre,clave,tipo,estado,pc_mac) VALUES (?,?,?,?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getClave());
            ps.setString(3, entidad.getTipo());
            ps.setString(4, entidad.getEstado());
            ps.setString(5, entidad.getPc_mac());
            
            
            
            
            ps.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(LoginUserControlador.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        
        
        
    }

    @Override
    public boolean eliminar(Usuario entidad) throws SQLException, ClassNotFoundException {
        
          connection = Conexion.obtenerConexion();
        
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
            
            
        } catch (SQLException e) {
             Logger.getLogger(LoginUserControlador.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
        return true;
    }

    
    public Usuario extraer(int id) throws SQLException, Exception{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Usuario entidad) throws SQLException, Exception {
        
       connection = Conexion.obtenerConexion ();
       this.sql = "UPDATE usuario SET nombre=?, clave=? , tipo=? WHERE id=?";
        
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getClave());
            ps.setString(3, entidad.getTipo());
            ps.setInt(4, entidad.getId());
            
            
            ps.executeUpdate();
            connection.close();
            return true;
    }
    

    @Override
    public ArrayList<Usuario> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM usuario";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Usuario> usuarios = new ArrayList();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo (rs.getString("tipo"));
                usuario.setEstado (rs.getString("estado"));
                usuario.setPc_mac (rs.getString("pc_mac"));
                
                        //System.out.println(usuario);
                
                
                usuarios.add(usuario);
                
            }
            //System.out.println(cont);
            return usuarios;
        } catch(SQLException ex){
        }
        return null;
    

    }

    
    
    
    @Override
    public List<Usuario> extraer() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    public Usuario consultar(Usuario entidad) throws SQLException,Exception{
        
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM usuario";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Usuario> usuarios = new ArrayList();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario(); //Instanciamos un objeto del tipo Usuario
                
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo (rs.getString("tipo"));
                
                
                        //System.out.println(cliente);
                
                
                usuarios.add(usuario);
                
            }
           
            /*Esta bandera la uso para saber si no entro al if deduciendo que no es una cuenta registrada
             para luego con un if asignarle el tipo desconocido*/
            int bandera=0;
            
            for(Usuario usuario:usuarios){
                
                if(entidad.getNombre().equals(usuario.getNombre()) && entidad.getClave().equals(usuario.getClave()) ) {
                    
                    entidad.setTipo(usuario.getTipo());
                    bandera=1;
                    
                    
                    /*Hago conexion a la BD para poner el estado en  desconectado a todos para posteriori poner
                    en conectado el que es esta logeando*/
                            //Consigo la MAC del PC y lo pongo en el java text field
        
                             mac p = new mac();
                             
                    
                            connection = Conexion.obtenerConexion ();
                            this.sql = "UPDATE usuario SET estado=? WHERE pc_mac=?";
        
                            ps = connection.prepareStatement(sql);
            
                            ps.setString(1, "desconectado");
                            ps.setString(2, p.conseguirMAC());

                            ps.executeUpdate();
                            connection.close();
                            
                    
                    /*Hago conexion a la BD para poner el estado en conectado previo haber puesto desconectado a todos*/
                            connection = Conexion.obtenerConexion ();
                            this.sql = "UPDATE usuario SET estado=? WHERE nombre=?";
        
                            ps = connection.prepareStatement(sql);
            
                            ps.setString(1, "conectado");
                            ps.setString(2, entidad.getNombre());
                            
            
            
                            ps.executeUpdate();
                            connection.close();
                    
                    break;
                }
                
            }
            if(bandera==0)
                entidad.setTipo("unknow");
            
            //System.out.println(cont);
            return entidad;
            
        } catch(SQLException ex){
        }
        return null;
    

    }


    
  
    public Usuario consultar_user_activo() throws SQLException,Exception{
        
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM usuario WHERE estado='conectado'";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Usuario> usuarios = new ArrayList();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario(); //Instanciamos un objeto del tipo Usuario
                
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setClave(rs.getString("clave"));
                usuario.setTipo (rs.getString("tipo"));
                usuario.setEstado (rs.getString("estado"));
                usuario.setPc_mac(rs.getString("pc_mac"));
                
                        //System.out.println(cliente);
                
                
                usuarios.add(usuario);
                
            }
           
           Usuario entidad =new Usuario();
            
            mac p= new mac();
            
            for(Usuario usuario:usuarios){
                
                /*Verifico que el usuario este conectado y que a su vez pertenezca al mac de este pc
                para diferenciar de otros usuarios conectados en otras pc  */
                if(usuario.getEstado().equals("conectado") && usuario.getPc_mac().equals(p.conseguirMAC()) ) {
                    
                    entidad.setNombre(usuario.getNombre());
                    

                    break;
                }
                
            }
            
            
            //System.out.println(cont);
            return entidad;
            
        } catch(SQLException ex){
            return null;
        }
        
    

    }
    
    
    
    
    
    
    
    
}
