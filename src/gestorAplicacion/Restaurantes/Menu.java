package gestorAplicacion.Restaurantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    
    private List<Plato> platos = new ArrayList<>();
    private List<Bebida> bebidas = new ArrayList<>();
    private List<Postre> postres = new ArrayList<>();

    public void añadirPlato(Plato plato) {
        platos.add(plato);
    }

    public void añadirBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void añadirPostre(Postre postre) {
        postres.add(postre);
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public List<Postre> getPostres() {
        return postres;
    }
}
