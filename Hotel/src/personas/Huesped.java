package personas;

import hotel.habitaciones.Habitacion;

public class Huesped extends Persona {
    private Habitacion habitacion;

    public Huesped(String nombreCompleto, int edad, Habitacion habitacion) {
        super(nombreCompleto, edad);
        this.habitacion = habitacion;
    }

    public Huesped(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + ", Edad: " + edad + ", Habitacion: " + habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
