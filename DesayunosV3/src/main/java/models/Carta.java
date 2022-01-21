package models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author AlejandroVicenteJarn
 */
@Entity
public class Carta implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private float precio;
    private String estado;
    
    @OneToMany(mappedBy="carta", fetch=FetchType.EAGER)
    private List<Pedidos> pedido;

    public Carta() {
    }

    public Carta(Integer id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Pedidos> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedidos> pedido) {
        this.pedido = pedido;
    }
    

    @Override
    public String toString() {
        return "carta{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + '}';
    }

    
    
}