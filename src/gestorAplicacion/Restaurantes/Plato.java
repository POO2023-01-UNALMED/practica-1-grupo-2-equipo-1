package gestorAplicacion.Restaurantes;

public class Plato extends Menu {
    
    private String nombre;
    private int precio;

    public Plato(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
