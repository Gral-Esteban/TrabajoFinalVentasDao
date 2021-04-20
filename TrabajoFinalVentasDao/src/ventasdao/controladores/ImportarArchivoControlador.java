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
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;

/**
 *
 * @author Esteban DAlbano
 */
public class ImportarArchivoControlador {
    
    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    
    public boolean importarExcel(String absolutePath)throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        
        /*Aqui se crea la tabla prodcuctos1 si no existe para cuando se la borre por reseteo*/
             String sql0 = "CREATE TABLE IF NOT EXISTS  public.productos1 (\n" +
                            "id serial not null,\n" +
                            "codigo character varying (100) not null ,\n" +
                            "descripcion character varying (100) not null,\n" +
                            "p_dolar float ,\n" +
                            "p_costo float ,\n" +
                            "p_venta float not null,\n" +
                            "origen character varying (100) ,\n" +
                            "proveedor character varying (100) not null,\n" +
                            "stock integer,\n" +
                            "categoria character varying (100),\n" +
                            "imagen character varying (200),\n" +
                            "fecha_ingreso date,\n" +
                            "UNIQUE (codigo, proveedor),\n" +  //Esto evita que se agregue un registro con codigo repetido para un mismo proveedor
                            "primary key (id)\n" +
                            ")";
        
        /*Aqui verifico si existe la tabla productos2 y si es asi la borro para luego crearla y que este limpia*/
             String  sql1 = "drop table if exists productos2; \n" +
                            "create table public.productos2 (\n" +
                            "id serial not null,\n" +
                            "codigo character varying (100) not null ,\n" +
                            "descripcion character varying (100) not null,\n" +
                            "p_dolar float ,\n" +
                            "p_costo float ,\n" +
                            "p_venta float not null,\n" +
                            "origen character varying (100) ,\n" +
                            "proveedor character varying (100) not null,\n" +
                            "stock integer,\n" +
                            "categoria character varying (100),\n" +
                            "primary key (id)\n" +
                            ")";
             
        
        /*Aqui cargo el contenido del fichero .csv que seleccione de mi equipo a la tabla productos2*/
             String  sql2 = "COPY PUBLIC.productos2 FROM '"+absolutePath+"' DELIMITER ',' CSV HEADER";  //El signo de pregunta ? se reemplazo por '"+absolutePath+"' y el error se fue
             
         
         /*Aqui actualizo los datos de la tabla productos2 a productos1*/    
             String  sql3 = "UPDATE productos1 p1 \n" +
                            "SET \n" +
                            "descripcion = p2.descripcion,\n" +
                            "p_dolar= p2.p_dolar,\n" +
                            "p_costo= p2.p_costo,\n" +
                            "p_venta= p2.p_venta,\n" +
                            "origen= p2.origen,\n" +
                            "stock= p1.stock + p2.stock,\n" +
                            "categoria = p2.categoria\n" +
                            "FROM productos2 p2\n" +
                            "WHERE p2.codigo=p1.codigo and p2.proveedor=p1.proveedor";    
             
             
        /*Aqui inserto desde productos2 a producos1 los nuevos productos o registros cuyo codigo y respectivo proveedor no figuran en la tabla productos1*/
             String  sql4 = "INSERT INTO productos1(codigo,descripcion,p_dolar,p_costo,p_venta,origen,proveedor,stock,categoria)\n" +
                            "SELECT productos2.codigo,productos2.descripcion,productos2.p_dolar,productos2.p_costo,productos2.p_venta,productos2.origen,productos2.proveedor,productos2.stock,productos2.categoria\n" +
                            "FROM productos2 \n" +
                            "WHERE productos2.codigo NOT IN (SELECT productos1.codigo FROM productos1) OR proveedor NOT IN(SELECT productos1.proveedor FROM productos1 WHERE productos1.codigo=productos2.codigo)";
         
             
        
             
             
        try {
            ps=connection.prepareStatement(sql0);
            //ps.setString(1, absolutePath);    Esto lo comente porque no funcionaba ya que va complementado con un signo de pregunta  ? en el Sring sql y dababa error
            ps.executeUpdate();
            
           } 
                catch (SQLException e) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
                         return false;
                       }      
             
        
        try {
            ps=connection.prepareStatement(sql1);
            //ps.setString(1, absolutePath);    Esto lo comente porque no funcionaba ya que va complementado con un signo de pregunta  ? en el Sring sql y dababa error
            ps.executeUpdate();
            
           } 
                catch (SQLException e) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
                         return false;
                       }  
        
        try {
            ps=connection.prepareStatement(sql2);
            
            ps.executeUpdate();
            
            
           } 
                catch (SQLException e) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
                         return false;
                       }
        
        try {
            ps=connection.prepareStatement(sql3);
            
            ps.executeUpdate();
            
           } 
                catch (SQLException e) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
                         return false;
                       }   
        
        try {
            ps=connection.prepareStatement(sql4);
            
            ps.executeUpdate();
            connection.close();
            
           } 
                catch (SQLException e) {
                        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
                         return false;
                       }   
        
        
        
        
        /*try {
        ps=connection.prepareStatement(sql2);
        //ps.setString(1, absolutePath);    Esto lo comente porque no funcionaba ya que va complementado con un signo de pregunta  ? en el Sring sql y dababa error
        ps.executeUpdate();
        }
        catch (SQLException e) {
        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
        return false;
        }
        try {
        ps=connection.prepareStatement(sql3);
        //ps.setString(1, absolutePath);    Esto lo comente porque no funcionaba ya que va complementado con un signo de pregunta  ? en el Sring sql y dababa error
        ps.executeUpdate();
        }
        catch (SQLException e) {
        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
        return false;
        }
        
        try {
        ps=connection.prepareStatement(sql4);
        //ps.setString(1, absolutePath);    Esto lo comente porque no funcionaba ya que va complementado con un signo de pregunta  ? en el Sring sql y dababa error
        ps.executeUpdate();
        connection.close();
        }
        catch (SQLException e) {
        Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, e);
        return false;
        }*/
        
        return true;
    }


}

    

