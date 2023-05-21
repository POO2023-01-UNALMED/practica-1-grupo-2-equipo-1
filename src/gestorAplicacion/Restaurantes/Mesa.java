package gestorAplicacion.Restaurantes;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Mesa implements Serializable {
    private boolean ocupado;
    private GrupoHuespedes dueños; // quienes tienen reservada esta mesa
    private int id;

    public Mesa(int id) {
        this.id = id;
    }

    public void asignarDueños(GrupoHuespedes grupo) {
        this.dueños = grupo;
        dueños.setMesaReservada(this);
        ocupado = true;
    }

    public void vaciarMesa() {
        dueños.setMesaReservada(null);
        this.dueños = null;
        this.ocupado = false;
    }


    @Override
    public String toString() {
        if (ocupado == true) {
            return "Mesa: " + id + ", Reservada por " + dueños.toString();
        }
        return "Disponible";
    }

    // * Getters y setters */
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public GrupoHuespedes getDueños() {
        return dueños;
    }

    public void setDueños(GrupoHuespedes dueños) {
        this.dueños = dueños;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
