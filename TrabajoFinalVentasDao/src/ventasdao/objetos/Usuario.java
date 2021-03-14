/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

/**
 *
 * @author Esteban DAlbano
 */
public class Usuario {
    
    private Integer id;
    private String nombre;
    private String clave;
    private String tipo;
    private String estado;
    private String pc_mac;
    
    /*Getter and Setter*/

    public String getPc_mac() {
        return pc_mac;
    }

    public void setPc_mac(String pc_mac) {
        this.pc_mac = pc_mac;
    }

    
    public String getEstado() {
        return estado;
    }

   
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}

