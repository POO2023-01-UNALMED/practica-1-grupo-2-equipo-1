package gestorAplicacion.Habitaciones;

public class HabitacionEstandar extends Habitacion {

    public HabitacionEstandar(int capacidad, int precioXdia, int ID_Habitacion) {
        super(capacidad, precioXdia, ID_Habitacion);
    }

    public HabitacionEstandar(int capacidad, int precioXdia) {
        super(capacidad, precioXdia);
    }

    public HabitacionEstandar(){
        this(2, 350000);
    }

}
