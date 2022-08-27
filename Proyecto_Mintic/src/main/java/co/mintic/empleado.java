package co.mintic;

public class empleado {

    private String nombreEmpleado;
    private String correoEmpleado;
    private String empresaEmpleado;
    private String empleadoRol;

    public empleado (String nombreEmpleado, String correoEmpleado, String empresaEmpleado, String empleadoRol){

        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.empleadoRol = empleadoRol;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(String empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public String getEmpleadoRol() {
        return empleadoRol;
    }

    public void setEmpleadoRol(String empleadoRol) {
        this.empleadoRol = empleadoRol;
    }
}


