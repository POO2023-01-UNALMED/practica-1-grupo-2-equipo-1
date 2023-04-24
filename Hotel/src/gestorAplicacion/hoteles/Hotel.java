package gestorAplicacion.hoteles;

import gestorAplicacion.Habitaciones.*;
import java.util.*;

public class Hotel {
    private List<Habitacion> habitaciones = new ArrayList<>();

    public Hotel(){
        
    }

    public void agragarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public String mostrarHabitaciones(){
        String s = "";
        for (Habitacion habitacion : habitaciones) {
            s += habitacion.toString() + System.lineSeparator();
        }
        return s;
    }
}
