/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.siglo;

/**
 *
 * @author jcaballero
 */
public class Empleado {
    private String id;
    private String nombre;
    private String cargo;
    private String area;
    private String estado;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
