package personas;

public class Huesped extends Persona {

    boolean tieneCarro;

    public Huesped(String nombre, String apellido, int edad, boolean tieneCarro) {
        super(nombre, apellido, edad);
        this.tieneCarro = tieneCarro;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "" + apellido + "Edad: " + edad + "Tiene carro: " + String.valueOf(tieneCarro);
    }

}
