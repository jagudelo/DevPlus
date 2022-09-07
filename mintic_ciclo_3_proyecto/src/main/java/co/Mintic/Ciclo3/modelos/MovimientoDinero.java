package co.Mintic.Ciclo3.modelos;

import javax.persistence.*;

@Entity
@Table(name="movimientos")
public class MovimientoDinero {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private long monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, String concepto, Empleado empleado) {
        this.monto = monto;
        this.concepto = concepto;
        this.empleado = empleado;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


}
