package personas;

import hotel.habitaciones.Habitacion;

public class GrupoHuespedes {
    Huesped[] listaHuespeds;
    Habitacion habitacion;

    public GrupoHuespedes(Huesped[] listaHuespeds, Habitacion habitacion) {
        this.listaHuespeds = listaHuespeds;
        this.habitacion = habitacion;
    }
}
