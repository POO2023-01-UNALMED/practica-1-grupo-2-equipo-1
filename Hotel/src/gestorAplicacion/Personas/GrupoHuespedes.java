package gestorAplicacion.Personas;

import java.util.List;

import gestorAplicacion.Habitaciones.Habitacion;
import gestorAplicacion.serviciosExtra.Factura;

public class GrupoHuespedes {
    private int diasEnHotel;
    private List<Huesped> listaHuespedes;
    private Factura factura;
    private Habitacion habitacion;

    public GrupoHuespedes(int diasEnHotel, List<Huesped> listaHuespedes, Habitacion habitacion) {
        this.diasEnHotel = diasEnHotel;
        this.listaHuespedes = listaHuespedes;
        this.habitacion = habitacion;
    }

    public GrupoHuespedes(int diasEnHotel, List<Huesped> listaHuespedes) {
        this.diasEnHotel = diasEnHotel;
        this.listaHuespedes = listaHuespedes;
    }

    public GrupoHuespedes(List<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public void agregarHuesped(Huesped huesped){
        listaHuespedes.add(huesped);
    }

    public void inicializarFactura(){
        factura = new Factura();
        factura.setFacturaHospedaje(habitacion.getPrecioXdia() * diasEnHotel);
    }

    @Override
    public String toString() {
        String lista = "";
        for (Huesped huesped : listaHuespedes) {
            lista += huesped.toString() + "\n";
        }
        return lista;
    }

    //* Getters y setters */
    public int getDiasEnHotel() {
        return diasEnHotel;
    }

    public void setDiasEnHotel(int diasEnHotel) {
        this.diasEnHotel = diasEnHotel;
    }

    public List<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(List<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
}
