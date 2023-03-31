package personas;

public abstract class Persona {
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
