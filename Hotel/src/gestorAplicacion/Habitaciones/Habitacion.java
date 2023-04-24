package gestorAplicacion.Habitaciones;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

public abstract class Habitacion implements Serializable {
    protected static int id = 1;

    protected int capacidad;
    protected int precioXdia;
    protected int ID_Habitacion;
    protected GrupoHuespedes grupo;

    public Habitacion(int capacidad, int precioXdia, int iD_Habitacion) {
        this.capacidad = capacidad;
        this.precioXdia = precioXdia;
        ID_Habitacion = iD_Habitacion;
        this.grupo = null;
    }

    public Habitacion(int capacidad, int precioXdia){
        this(capacidad, precioXdia, id);
        this.grupo = null;
        id++;
    }



    //*setters y getters */

    @Override
    public String toString() {
        return "Habitacion [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
                + ", grupo=" + grupo.toString() + "]";
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Habitacion.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecioXdia() {
        return precioXdia;
    }

    public void setPrecioXdia(int precioXdia) {
        this.precioXdia = precioXdia;
    }

    public int getID_Habitacion() {
        return ID_Habitacion;
    }

    public void setID_Habitacion(int iD_Habitacion) {
        ID_Habitacion = iD_Habitacion;
    }

    public GrupoHuespedes getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoHuespedes grupo) {
        this.grupo = grupo;
    }

    
}
