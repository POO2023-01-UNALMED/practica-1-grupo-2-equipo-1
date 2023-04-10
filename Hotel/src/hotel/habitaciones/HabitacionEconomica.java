package hotel.habitaciones;

public class HabitacionEconomica extends Habitacion {

    public HabitacionEconomica(int capacidad, int precioXnoche) {
        super(capacidad, precioXnoche);
    }

    @Override
    public String toString() {
        return "Habitacion economica [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

    
}
