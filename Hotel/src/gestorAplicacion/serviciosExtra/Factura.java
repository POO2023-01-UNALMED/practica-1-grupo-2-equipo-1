package gestorAplicacion.serviciosExtra;

public class Factura {
    private int FacturaHospedaje;
    private int FacturaServiciosExtra;


    public String mostrarListaServiciosExtra(){
        return """
            ========Servicios disponible tiene valor extra en la factura==========\n
            1. Gimnasio\n
            2. Bar\n
            3. Parqueadero\n
                """;
    }

    public void seleccionarServicio(int id){
        ServiciosExtra servicio = ServiciosExtra.buscarPorid(id);
        FacturaServiciosExtra += servicio.getPrecio();
    }

    public int CalcularPrecioFactura(){
        return FacturaHospedaje + FacturaServiciosExtra;
    }

    @Override
    public String toString() {
        return String.format("""
            Factura por hospedaje: %d\n
            Factura por servicios extra: %d
            """,FacturaHospedaje, FacturaServiciosExtra);
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
}
