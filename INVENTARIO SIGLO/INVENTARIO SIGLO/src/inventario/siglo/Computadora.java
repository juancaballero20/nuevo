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
public class Computadora {
    private String marca;
    private String modelo;
    private String serial;
    private String procesador;
    private String ram;
    private String disco;
    private String so;

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }

    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getDisco() { return disco; }
    public void setDisco(String disco) { this.disco = disco; }

    public String getSo() { return so; }
    public void setSo(String so) { this.so = so; }
}