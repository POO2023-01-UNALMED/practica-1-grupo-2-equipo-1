package hotel.habitaciones;

public class HabitacionVIP extends Habitacion {

    public HabitacionVIP(int capacidad, int precioXnoche) {
        super(capacidad, precioXnoche);
    }

    @Override
    public String toString() {
        return "Habitacion VIP [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

}
