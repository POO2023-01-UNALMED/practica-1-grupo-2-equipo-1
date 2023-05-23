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

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public void agregarRestaurante(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public String mostrarHabitaciones(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }
    
    public String mostrarVehiculos(){
        String x = "";
        for (Vehiculo vehiculo : vehiculos) {
            x += vehiculo.toString() + System.lineSeparator();
        }
        return x;
    }


    public String mostrarHabitacionesDisponibles(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            if(habitacion.getEstaOcupado() == true){continue;}
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }

    //*Devuelve una habitaciones por ID */
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
