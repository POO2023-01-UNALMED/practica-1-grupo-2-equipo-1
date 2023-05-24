package gestorAplicacion.hoteles;

import gestorAplicacion.Habitaciones.*;
import gestorAplicacion.Restaurantes.Restaurante;
import gestorAplicacion.transporte.Vehiculo;

import java.io.Serializable;
import java.util.*;

import baseDatos.Deserializador;
/**
 * La clase "Hotel" representa un hotel que contiene habitaciones, restaurantes y vehículos.
 * Implementa la interfaz Serializable para permitir la serialización de objetos.
 */

public class Hotel implements Serializable {
    
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<Restaurante>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
        /**
     * Crea una instancia de Hotel.
     * Realiza la deserialización de los datos almacenados previamente.
     */

    public Hotel(){
        Deserializador.deserializar(this);
    }

        /**
     * Agrega una habitación al hotel.
     * 
     * @param habitacion La habitación a agregar
     */

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

        /**
     * Agrega un restaurante al hotel.
     * 
     * @param restaurante El restaurante a agregar
     */

    public void agregarRestaurante(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

        /**
     * Agrega un vehículo al hotel.
     * 
     * @param vehiculo El vehículo a agregar
     */

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    /**
     * Devuelve una representación en forma de cadena de texto de todas las habitaciones del hotel.
     * 
     * @return La representación en forma de cadena de texto de las habitaciones del hotel
     */

    public String mostrarHabitaciones(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }

        /**
     * Devuelve una representación en forma de cadena de texto de todos los vehículos del hotel.
     * 
     * @return La representación en forma de cadena de texto de los vehículos del hotel
     */
    
    public String mostrarVehiculos(){
        String x = "";
        for (Vehiculo vehiculo : vehiculos) {
            x += vehiculo.toString() + System.lineSeparator();
        }
        return x;
    }

        /**
     * Devuelve una representación en forma de cadena de texto de las habitaciones disponibles del hotel.
     * 
     * @return La representación en forma de cadena de texto de las habitaciones disponibles del hotel
     */

    public String mostrarHabitacionesDisponibles(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            if(habitacion.getEstaOcupado() == true){continue;}
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }

    /**
     * Busca y devuelve una habitación del hotel según su ID.
     * 
     * @param id El ID de la habitación a buscar
     * @return La habitación correspondiente al ID especificado, o null si no se encuentra ninguna habitación con ese ID
     */
    
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
