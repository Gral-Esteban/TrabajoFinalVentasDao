package ventasdao.objetos;

import java.util.Date;

public class Producto {
    
    
  // Atributos  
   private Integer id;
   
   private String codigo;
    
    private String descripcion;

    private Float p_dolar;

    private Float p_costo;

    private Float p_venta;
    
    private String origen;
    
    private String proveedor;
    
    private Integer stock;
    
    private String categoria;
    
    private Date fechaCreacion;
    
    private String fechaAlta;
    
    private String imagen;
    
    private String link;
    

    // Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getP_dolar() {
        return p_dolar;
    }

    public void setP_dolar(Float p_dolar) {
        this.p_dolar = p_dolar;
    }

    public Float getP_costo() {
        return p_costo;
    }

    public void setP_costo(Float p_costo) {
        this.p_costo = p_costo;
    }

    public Float getP_venta() {
        return p_venta;
    }

    public void setP_venta(Float p_venta) {
        this.p_venta = p_venta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
    
   
  
    
}
