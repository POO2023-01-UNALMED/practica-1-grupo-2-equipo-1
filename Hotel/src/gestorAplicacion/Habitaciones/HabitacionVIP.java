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
}
