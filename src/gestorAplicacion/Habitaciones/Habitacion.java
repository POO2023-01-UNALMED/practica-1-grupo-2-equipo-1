package gestorAplicacion.Habitaciones;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

/**
 * La clase Habitacion representa una habitación en un hotel.
 * Implementa la interfaz Serializable para permitir la serialización de
 * objetos.
 */

public class Habitacion implements Serializable {
    protected static int id = 1;

    protected int capacidad;
    protected int precioXdia;
    protected int ID_Habitacion;
    protected GrupoHuespedes grupo;
    protected boolean estaOcupado;

    /**
     * Crea una instancia de Habitacion con los atributos especificados.
     * 
     * @param capacidad     Capacidad de la habitación (número de personas que puede
     *                      alojar)
     * @param precioXdia    Precio por día de la habitación
     * @param iD_Habitacion Identificador único de la habitación
     */

    public Habitacion(int capacidad, int precioXdia, int iD_Habitacion) {
        this.capacidad = capacidad;
        this.precioXdia = precioXdia;
        ID_Habitacion = iD_Habitacion;
        this.estaOcupado = false;
    }

    /**
     * Crea una instancia de Habitacion con los atributos especificados y asigna un
     * ID automáticamente.
     * 
     * @param capacidad  Capacidad de la habitación (número de personas que puede
     *                   alojar)
     * @param precioXdia Precio por día de la habitación
     */

    public Habitacion(int capacidad, int precioXdia) {
        this(capacidad, precioXdia, id);
        id++;
    }

    /**
     * Borra el grupo de huéspedes asociado a la habitación y establece el estado de
     * ocupación como desocupado.
     */

    public void borrarGrupo() {
        this.setGrupo(null);
        this.estaOcupado = false;
    }

    /**
     * Devuelve una representación en forma de cadena de texto de la habitación.
     * Si la habitación tiene un grupo de huéspedes asociado, se muestra la
     * información del grupo.
     * 
     * @return Representación en forma de cadena de texto de la habitación
     */

    @Override
    public String toString() {
        if (grupo != null) {
            return String.format("""
                    Habitacion:
                    Capacidad = %d personas
                    Precio/Dia = $%d
                    ID_Habitacion = %d
                    Grupo = %s
                    Ocupado = %b
                    """, capacidad, precioXdia, ID_Habitacion, grupo.toString(), estaOcupado);
        }
        return String.format("""
                Habitacion:
                Capacidad = %d personas
                Precio/Dia = $%d
                ID_Habitacion = %d
                """, capacidad, precioXdia, ID_Habitacion);
    }

    // *setters y getters *//
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
