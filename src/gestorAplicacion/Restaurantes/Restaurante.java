package gestorAplicacion.Restaurantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Serializable{

    private String nombre;
    private List<Mesa> mesas = new ArrayList<>();
    private int precio;
    private int id;


    public Restaurante(String nombre, List<Mesa> mesas, int precio, int id) {

        this.nombre = nombre;
        this.mesas = mesas;
        this.precio = precio;
        this.id = id;
    }

    public Restaurante(String nombre, int precio, int id){

        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
        inicilizar();
    }

    //TODO: implementar funcionalidad
    
    public void reservarMesa(){};

    public void añadirMesa(Mesa mesa){
        
        mesas.add(mesa);
    }

    public String mostrarMesas() {
        StringBuilder s = new StringBuilder();
        for (Mesa mesa : mesas) {
            s.append(mesa.toString() + System.lineSeparator());
        }
        return s.toString();
    }

    @Override
    public String toString() {
        //*para mostrar en la interfaz opcion 4 */
        return nombre + " ,precio: " + precio;
    }

    public void inicilizar(){

        //mesas genericas        
        for (int i = 1; i < 8; i++) {
            this.añadirMesa(new Mesa(i));
        }
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
