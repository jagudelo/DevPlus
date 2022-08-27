package co.mintic;

public class Empresa {

    private String nombre_empresa;
    private String direccion;
    private int telefono;
    private int nit;

    public Empresa(String nombre_empresa, String direccion, int telefono, int nit) {
        this.nombre_empresa = nombre_empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }


    public void obtener_datos() {
        System.out.println("La direccion de la empresa es " + " " + getDireccion());
        System.out.println("El nombre de la empresa" + " " + getNombre_empresa());
        System.out.println("El telefono de la empresa" + " " + getTelefono());
        System.out.println("El NIT de la empresa es: " + " " + getNit());
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




