package gestorAplicacion.Habitaciones;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Habitacion implements Serializable {
    protected static int id = 1;

    protected int capacidad;
    protected int precioXdia;
    protected int ID_Habitacion;
    protected GrupoHuespedes grupo;
    protected boolean estaOcupado;

    public Habitacion(int capacidad, int precioXdia, int iD_Habitacion) {
        this.capacidad = capacidad;
        this.precioXdia = precioXdia;
        ID_Habitacion = iD_Habitacion;
        this.estaOcupado = false;
    }

    public Habitacion(int capacidad, int precioXdia){
        this(capacidad, precioXdia, id);
        id++;
    }

    public void borrarGrupo(){
        this.setGrupo(null);
        this.estaOcupado = false;
    }


    //*setters y getters */

    @Override
    public String toString() {
        if (grupo != null){
            return "Habitacion [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
            + ", grupo=" + grupo.toString() + ", Ocupado=" + estaOcupado + "]";
        }
        return "Habitacion [capacidad=" + capacidad + ", precioXdia=" + precioXdia + ", ID_Habitacion=" + ID_Habitacion
                + "]";
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
        this.estaOcupado = true;
    }

    public boolean getEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    
}
