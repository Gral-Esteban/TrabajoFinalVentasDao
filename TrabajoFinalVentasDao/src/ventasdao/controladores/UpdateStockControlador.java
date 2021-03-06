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
import ventasdao.objetos.Producto;
import ventasdao.ui.abm.AbmFactura;
//import ventasdao.ui.abm.Factura;


/**
 *
 * @author Hugo Chanampe
 */
public class UpdateStockControlador implements ICrud<Factura>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private String sql2;
    
    
    
    DetalleFactura detallefactura = new DetalleFactura();
    
    ArrayList<DetalleFactura> detallefacturas = new ArrayList<>();

    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    
    
    
    public boolean decrementar(List<DetalleFactura> detallefacturas) throws SQLException, Exception {

        connection = Conexion.obtenerConexion();

        String sql = "UPDATE productos1 SET stock=stock - ? WHERE codigo = ? AND proveedor = ?";

        //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        for (DetalleFactura detallefactura : detallefacturas) {

            try {
                ps = connection.prepareStatement(sql);

                ps.setInt(1, detallefactura.getCantidad());
                ps.setString(2, detallefactura.getCodigo());
                ps.setString(3, detallefactura.getProveedor());
                //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
                //ps.setDate(2, fecha);

                //ps.setInt(3, detallefactura.getFactura_id());
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(UpdateStockControlador.class.getName()).log(Level.SEVERE, null, ex);

                //return false;
            }

        } //cierra el for

        connection.close();

        return true;

    }

    
    
    
    
    
    public boolean incrementar(ArrayList<DetalleFactura> detalleFacturas) throws SQLException, Exception {

        //int tamaño= detallefacturas.size();
        connection = Conexion.obtenerConexion();

        String sql2 = "UPDATE productos1 SET stock=stock + ? WHERE codigo = ? AND proveedor = ?";

        //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        for (DetalleFactura detalleFactura : detalleFacturas) {

            try {
                ps = connection.prepareStatement(sql2);

                ps.setInt(1, detalleFactura.getCantidad());
                ps.setString(2, detalleFactura.getCodigo());
                ps.setString(3, detalleFactura.getProveedor());
                //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
                //ps.setDate(2, fecha);

                //ps.setInt(3, detallefactura.getFactura_id());
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(UpdateStockControlador.class.getName()).log(Level.SEVERE, null, ex);

                //return false;
            }

        } //cierra el for

        connection.close();

        return true;

    }
    
    
    
    public boolean incrementar2(DetalleFactura articuloEliminado) throws SQLException, Exception {

        //int tamaño= detallefacturas.size();
        connection = Conexion.obtenerConexion();

        String sql2 = "UPDATE productos1 SET stock=stock + ? WHERE codigo = ? AND proveedor = ?";

        //java.sql.Date fecha = new java.sql.Date (entidad.getFecha_facturacion().getTime());
        try {
            ps = connection.prepareStatement(sql2);

            ps.setInt(1, articuloEliminado.getCantidad());
            ps.setString(2, articuloEliminado.getCodigo());
            ps.setString(3, articuloEliminado.getProveedor());
            //ps.setDate(2, (java.sql.Date) entidad.getFecha_facturacion());
            //ps.setDate(2, fecha);

            //ps.setInt(3, detallefactura.getFactura_id());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UpdateStockControlador.class.getName()).log(Level.SEVERE, null, ex);

            //return false;
        }

        connection.close();

        return true;

    }
    
    
    
    
    
    public boolean validar(List<DetalleFactura> detallefacturas) throws SQLException, Exception{

        Producto objetoConsulta = new Producto();

        connection = Conexion.obtenerConexion();

        for (DetalleFactura detallefactura : detallefacturas) {

            //Verifico que la cantidad no sea mayor al stock disponible antes de actualizarlo
            try {

                this.stmt = connection.createStatement();
                this.sql2 = "SELECT stock FROM productos1 WHERE codigo = '" + detallefactura.getCodigo() + "' AND proveedor = '" + detallefactura.getProveedor() + "' ";
                this.rs = stmt.executeQuery(sql2);

                while (rs.next()) {
                    
                    
                    objetoConsulta.setStock(rs.getInt("stock"));

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (detallefactura.getCantidad() > objetoConsulta.getStock()) {

                JOptionPane.showMessageDialog(null, "No hay stock suficiente para el producto cuyo codigo=" + detallefactura.getCodigo() + " y proveedor es:" + detallefactura.getProveedor() + " Elimine este producto de la factura o reponga el stock e intente nuevamente");
                return false;

            } //cierra if

        } //cierra el for

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

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
}
