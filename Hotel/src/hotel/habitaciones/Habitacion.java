package hotel.habitaciones;

import java.io.Serializable;

public abstract class Habitacion implements Serializable{
    public int capacidad, precioXnoche;
    public boolean ocupado, estaLimpia;
    public int IdHabitacion = 1;

    protected Habitacion(int capacidad, int precioXnoche) {
        this.capacidad = capacidad;
        this.precioXnoche = precioXnoche;
        this.ocupado = false;
        this.estaLimpia = true;
        IdHabitacion++;
    }

    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

}
