package gestorAplicacion.Restaurantes;

public class Bebida extends Menu {
    
    private String nombre;
    private int precio;

    public Bebida(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
