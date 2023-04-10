package personas;

import java.io.Serializable;

public abstract class Persona implements Serializable{
    protected String nombre, apellido;
    protected int edad;
    protected Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public abstract String toString();
}
