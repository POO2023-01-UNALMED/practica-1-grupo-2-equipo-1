package gestorAplicacion.serviciosExtra;

import java.io.Serializable;
import java.util.Arrays; //static import


public class Factura implements Serializable{

    private int FacturaHospedaje;
    private int FacturaServiciosExtra;
    private int FacturaRestaurante;
    private int FacturaVehiculo;
    private int[] idsServicios = new int[3];

    public String mostrarListaServiciosExtra(){
        return """
            ========Servicios disponible tiene valor extra en la factura==========\n
            1. Gimnasio\n
            2. Bar\n
            3. Parqueadero\n
                """;
    }

    public boolean seleccionarServicio(int id){
        ServiciosExtra servicio = ServiciosExtra.buscarPorId(id);
        FacturaServiciosExtra += servicio.getPrecio();
        return true;
    }

    public int CalcularPrecioFactura(){
        return FacturaHospedaje + FacturaServiciosExtra + FacturaRestaurante + FacturaVehiculo;
    }

    public boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    @Override
    public String toString() {
        return String.format("""
            Factura por hospedaje: %d
            Factura por servicios extra: %d
            Factura por restaurante: %d
            Factura por alquiler de vehiculo: %d
            """,FacturaHospedaje, FacturaServiciosExtra, FacturaRestaurante, FacturaVehiculo);
    }

    //* Getters y setteres */
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

    public int[] getIdsServicios() {
        return idsServicios;
    }

    public void setIdsServicios(int[] idsServicios) {
        this.idsServicios = idsServicios;
    }

    public int getFacturaRestaurante() {
        return FacturaRestaurante;
    }

    public void setFacturaRestaurante(int facturaRestaurante) {
        FacturaRestaurante = facturaRestaurante;
    }

    public int getFacturaVehiculo() {
        return FacturaVehiculo;
    }

    public void setFacturaVehiculo(int facturaVehiculo) {
        FacturaVehiculo = facturaVehiculo;
    }
    

    
}
