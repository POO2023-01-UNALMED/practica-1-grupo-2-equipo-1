package hotel;

import personas.Encargado;

public class Factura {
    int costoXdia, dias, costoComida, costoServicios, costoTotal;
    Encargado encargado;

    

    public Factura(Encargado encargado) {
        this.encargado = encargado;
    }

    public Factura(int costoXdia, int dias,Encargado encargado) {
        this.costoXdia = costoXdia;
        this.dias = dias;
        this.encargado = encargado;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public int getCostoXdia() {
        return costoXdia;
    }

    public void setCostoXdia(int costoXdia) {
        this.costoXdia = costoXdia;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCostoComida() {
        return costoComida;
    }

    public void setCostoComida(int costoComida) {
        this.costoComida = costoComida;
    }

    public int getCostoServicios() {
        return costoServicios;
    }

    public void setCostoServicios(int costoServicios) {
        this.costoServicios = costoServicios;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Factura []";
    }

}
