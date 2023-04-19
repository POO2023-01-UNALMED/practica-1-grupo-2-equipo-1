package personas;

import java.io.Serializable;

public abstract class Persona implements Serializable{
    protected String nombreCompleto;
    protected int edad;
    protected Persona(String nombreCompleto, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    @Override
    public abstract String toString();
}
