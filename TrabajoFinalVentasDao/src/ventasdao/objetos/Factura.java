/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esteban DAlbano
 */
public class Factura  extends Cliente{
    
    private Integer id;
    private Integer numero_factura;
    private Integer cliente_id;
    private Date fecha_facturacion;
    private Float monto_total;
    private FormaPago formapago;
    private String observaciones;
    private String expedidor;

    

    
    private ArrayList<DetalleFactura> detallefactura;
    
    
    
    public String getExpedidor() {
        return expedidor;
    }

    public void setExpedidor(String expedidor) {
        this.expedidor = expedidor;
    }
     
    

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

    
    
    
    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    

    public ArrayList<DetalleFactura> getDetallefactura() {
        return detallefactura;
    }

    public void setDetallefactura(ArrayList<DetalleFactura> detallefactura) {
        this.detallefactura = detallefactura;
    }
    
    
    
    
    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    

    public Integer getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(Integer numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Float monto_total) {
        this.monto_total = monto_total;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public Date getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(Date fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }
    
    
    
}
