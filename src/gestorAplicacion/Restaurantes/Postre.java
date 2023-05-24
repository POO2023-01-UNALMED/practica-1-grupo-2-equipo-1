package gestorAplicacion.Restaurantes;

public class Postre extends Menu {
    
    private String nombre;
    private int precio;

    public Postre(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
