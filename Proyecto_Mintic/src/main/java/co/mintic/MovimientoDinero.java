package co.mintic;

public class MovimientoDinero {

    private String Concepto_Movimiento;
    private int Monto_Movimiento;

    public MovimientoDinero(String concepto_Movimiento, int monto_Movimiento) {
        this.Concepto_Movimiento = concepto_Movimiento;
        this.Monto_Movimiento = monto_Movimiento;
    }

    public String getConcepto_Movimiento() {
        return Concepto_Movimiento;
    }

    public void setConcepto_Movimiento(String concepto_Movimiento) {

        Concepto_Movimiento = concepto_Movimiento;
    }

    public int getMonto_Movimiento() {

        return Monto_Movimiento;
    }

    public void setMonto_Movimiento(int monto_Movimiento) {

        Monto_Movimiento = monto_Movimiento;
    }

    public int Valor_Monto(){
        return 0;
    }


    public String Usuario_Movimiento(){
        return "";
    }



}