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

    @Override
    public String toString() {
        if (grupo != null){
            return "Habitacion estandar [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
            + ", grupo=" + grupo.toString() + ", Ocupado=" + estaOcupado + "]";
        }
        return "Habitacion estandar [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
                + ", Ocupado=" + estaOcupado +"]";
    }

    

}
