package gestorAplicacion.Restaurantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Serializable {

    private String nombre;
    private List<Mesa> mesas = new ArrayList<>();
    private int precio;
    private int id;
    private Menu menu;

    public Restaurante(String nombre, int precio, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        this.menu = new Menu();
        inicializar();
    }

    public void añadirMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public String mostrarMesas() {
        StringBuilder s = new StringBuilder();
        for (Mesa mesa : mesas) {
            s.append(mesa.toString());
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return nombre + ", precio: " + precio;
    }

    public void inicializar() {
        for (int i = 1; i < 8; i++) {
            this.añadirMesa(new Mesa(i));
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    //*Getters y setters */
    
    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
