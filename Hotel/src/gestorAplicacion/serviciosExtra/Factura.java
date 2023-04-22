package gestorAplicacion.serviciosExtra;

public class Factura {
    private int FacturaHospedaje;
    private int FacturaServiciosExtra;

    public void agregarServicio(){

    }

    public int generarFactura(){
        return FacturaHospedaje + FacturaServiciosExtra;
    }

    public int getFacturaHospedaje() {
        return FacturaHospedaje;
    }

    public void setFacturaHospedaje(int facturaHospedaje) {
        FacturaHospedaje = facturaHospedaje;
    }

    public int getFacturaServiciosExtra() {
        return FacturaServiciosExtra;
    }

    public void setFacturaServiciosExtra(int facturaServiciosExtra) {
        FacturaServiciosExtra = facturaServiciosExtra;
    }
}
