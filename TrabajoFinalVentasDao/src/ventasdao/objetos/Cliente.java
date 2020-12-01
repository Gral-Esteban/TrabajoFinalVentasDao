/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

/**
 *
 * @author Hugo Chanampe
 */
public class Cliente {
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private Integer tipoCliente;
    
    private Integer documento;
    
    private TipoCliente tipocliente;  //esta es la clave foranea que relaciona la tabla cliente con tipocliente
    
    
    

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    

    /*public String getCuil() {
        return documento;
    }

    public void setCuil(String cuil) {
        this.documento = cuil;
    }
*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDocumento() { return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

 
    
}
