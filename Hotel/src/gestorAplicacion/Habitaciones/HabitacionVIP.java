package gestorAplicacion.Habitaciones;

public class HabitacionVIP extends Habitacion {

    public HabitacionVIP(int capacidad, int precioXdia, int iD_Habitacion) {
        super(capacidad, precioXdia, iD_Habitacion);
    }
    
    public HabitacionVIP(int capacidad, int precioXdia){
        super(capacidad, precioXdia);
    }

    public HabitacionVIP(){
        super(6, 500000);
    }

    @Override
    public String toString() {
        if (grupo != null){
            return "Habitacion VIP [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
            + ", grupo=" + grupo.toString() + ", Ocupado=" + estaOcupado + "]";
        }
        return "Habitacion VIP [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
                + "]";
    }

    
}
