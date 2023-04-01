package hotel.habitaciones;

public class HabitacionVIP extends Habitacion {

    public HabitacionVIP(int capacidad, int precioXnoche, boolean ocupado, boolean estaLimpia, String idHabitacion) {
        super(capacidad, precioXnoche, ocupado, estaLimpia, idHabitacion);
    }

    @Override
    public String toString() {
        return "Habitacion VIP [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

}
