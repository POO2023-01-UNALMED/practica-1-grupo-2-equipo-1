package personas;

public class Huesped extends Persona {

    boolean tieneCarro;

    public Huesped(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "" + apellido + "Edad: " + edad;
    }

}
