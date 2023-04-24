package gestorAplicacion.hoteles;

import gestorAplicacion.Habitaciones.*;

import java.io.Serializable;
import java.util.*;

import baseDatos.Deserializador;

public class Hotel implements Serializable {
    private List<Habitacion> habitaciones = new ArrayList<>();

    public Hotel(){
        Deserializador.deserializar(this);
    }

    public void agragarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
        habitaciones.add(habitacion);
    }

    public String mostrarHabitaciones(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }

    /* getters y setters */

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    
}
