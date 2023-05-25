/*La clase huespedes comprende la información base que el hotel obtiene de 
 * las personas que se van a hospedar en el hotel para luego integrar estas 
 * instancias dentro de un grupo de huespedes y asignarlas a una habitación
 * y que puedan disfrutar de todo lo que ofrece el hotel
 */
package gestorAplicacion.Personas;

import java.io.Serializable;

public class Huesped implements Serializable{
    private String nombre;
    private Integer ID;

    public Huesped(String nombre, Integer iD) {
        this.nombre = nombre;
        ID = iD;
    }

    public Huesped(){
        
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }

    @Override
    public String toString() {
        return nombre + "-" + ID;
    }
}
