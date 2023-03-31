package hotel.habitaciones;

public abstract class Habitacion {
    protected int capacidad, precioXnoche; // precio PORNOche jajajja
    protected boolean ocupado, estaLimpia;
    protected String IdHabitacion;

    protected Habitacion(int capacidad, int precioXnoche, boolean ocupado, boolean estaLimpia, String idHabitacion) {
        this.capacidad = capacidad;
        this.precioXnoche = precioXnoche;
        this.ocupado = ocupado;
        this.estaLimpia = estaLimpia;
        IdHabitacion = idHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", precioXnoche=" + precioXnoche + ", ocupado=" + ocupado
                + ", estaLimpia=" + estaLimpia + ", IdHabitacion=" + IdHabitacion + "]";
    }

}
