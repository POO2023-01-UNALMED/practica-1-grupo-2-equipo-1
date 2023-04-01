package personas;

public class Empleado extends Persona {

    //atributos

    public Empleado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    @Override
    public String toString() {
        return "Empleado ...";
    }
}
