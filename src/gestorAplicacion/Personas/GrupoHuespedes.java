package gestorAplicacion.Personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.Habitaciones.Habitacion;
import gestorAplicacion.Restaurantes.Mesa;
import gestorAplicacion.serviciosExtra.Factura;
import gestorAplicacion.transporte.Vehiculo;

public class GrupoHuespedes implements Serializable{
    private int diasEnHotel;
    private List<Huesped> listaHuespedes;
    private Factura factura;
    private Habitacion habitacion;

    /*Los atributos mesa y vehiculo se establecen en null por defecto ya que se empiezan a 
     * modificar tras el uso de funcionalidades una vez el grupo de huespedes ya está creado
     */
    private Mesa mesaReservada = null;
    private Vehiculo vehiculoReservado = null;

    /*Sobrecarga de constructores para instanciar objetos con determinada cantidad de parametros */
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

    public GrupoHuespedes(){
        this.listaHuespedes = new ArrayList<Huesped>();
    }

    /*agrega un objeto de tipo huesped a la lista de huespedes en un determinado grupo */
    public void agregarHuesped(Huesped huesped){
        listaHuespedes.add(huesped);
    }

    /* inicializa la factura del grupo una vez se crea, solo tiene en cuenta inicialmente el 
     * precio de la habitación y la cantidad de días que se hospeda el grupo
     */
    public void inicializarFactura(){
        factura = new Factura();
        factura.setFacturaHospedaje(habitacion.getPrecioXdia() * diasEnHotel);
    }

    @Override
    public String toString() {
        String lista = "";
        if (listaHuespedes != null){
            for (Huesped huesped : listaHuespedes) {
                if (huesped != null){
                    lista += huesped.toString() + ",";
                }
            }
        }
        //quita coma (,) al final
        if (lista != null && lista.length() > 0 && lista.charAt(lista.length() - 1) == ',') {
            lista = lista.substring(0, lista.length() - 1);
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

    public Mesa getMesaReservada() {
        return mesaReservada;
    }

    public void setMesaReservada(Mesa reservaRestaurante) {
        this.mesaReservada = reservaRestaurante;
    }
    
    public Vehiculo getVehiculoReservado() {
 		return vehiculoReservado;
 	}

 	public void setVehiculoReservado(Vehiculo vehiculoReservado) {
 		this.vehiculoReservado = vehiculoReservado;
 	}
    
}
