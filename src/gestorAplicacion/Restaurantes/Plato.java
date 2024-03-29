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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
}
