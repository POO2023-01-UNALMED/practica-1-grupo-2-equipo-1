package hotel.habitaciones;

public class HabitacionEconomica extends Habitacion {

    public HabitacionEconomica(int capacidad, int precioXnoche, boolean ocupado, boolean estaLimpia,
            String idHabitacion) {
        super(capacidad, precioXnoche, ocupado, estaLimpia, idHabitacion);
    }

    @Override
    public String toString() {
        return "Habitacion economica [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

    
}
