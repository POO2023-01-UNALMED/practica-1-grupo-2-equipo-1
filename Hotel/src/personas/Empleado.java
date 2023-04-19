package personas;

public class Empleado extends Persona {

    //atributos

    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String toString() {
        return "Empleado ...";
    }
}
