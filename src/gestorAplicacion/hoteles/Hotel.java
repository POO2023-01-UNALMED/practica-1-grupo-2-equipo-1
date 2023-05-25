/*la clase hotel es el corazón del programa y de la serialización del mismo,
 * se encarga de guardar en arraylists la información de las habitaciones, restaurantes
 * y vehiculos del hotel para ser serializada e interpretada cada vez que se abre el programa.
 * Todas las funcionalidades del programa se invocan junto con un parametro de tipo hotel para 
 * su correcto funcionamiento
 */


package gestorAplicacion.hoteles;

import gestorAplicacion.Habitaciones.*;
import gestorAplicacion.Restaurantes.Restaurante;
import gestorAplicacion.transporte.Vehiculo;

import java.io.Serializable;
import java.util.*;

import baseDatos.Deserializador;

public class Hotel implements Serializable {
    
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<Restaurante>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
    public Hotel(){
        Deserializador.deserializar(this);
    }

    /*Los siguientes 3 métodos son los que se encargan de crear instancias de habitación,
     * restaurante y vehiculo para su posterior uso dentro del programa
     */
    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public void agregarRestaurante(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    /*Este método imprime la información de todas las habitaciones del hotel 
     * haciendo uso de su método toString
     */
    public String mostrarHabitaciones(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }
    /*Este método imprime la información de todos los vehiculos del hotel 
     * haciendo uso de su método toString
     */
    public String mostrarVehiculos(){
        String x = "";
        for (Vehiculo vehiculo : vehiculos) {
            x += vehiculo.toString() + System.lineSeparator();
        }
        return x;
    }

    /*Este método imprime la información de todas las habitaciones que 
     * estén disponibles dentro del hotel
     */
    public String mostrarHabitacionesDisponibles(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            if(habitacion.getEstaOcupado() == true){continue;}
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }

    //*Devuelve la información de una habitación determinada por su atributo Id */
    public Habitacion seleccionarHabitacionPorId(int id){
        // Habitacion hab;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getID_Habitacion() == id){
                return habitacion;
            }
        }
        return null;
    }

    /* getters y setters */

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

    
}
