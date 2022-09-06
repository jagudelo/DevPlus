package co.Mintic.Ciclo3.modulos;

import net.minidev.json.JSONUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.plaf.synth.SynthOptionPaneUI;
@Entity
@Table(name="empresa")
public class Empresa {
    @Id
    private String nombre_empresa;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private int telefono;
    @Column(name="nit")
    private int nit;

    public Empresa(String nombre_empresa, String direccion, int telefono, int nit) {
        this.nombre_empresa = nombre_empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Empresa() {
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }




}
