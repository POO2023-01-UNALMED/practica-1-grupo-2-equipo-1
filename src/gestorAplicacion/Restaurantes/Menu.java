package gestorAplicacion.Restaurantes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    
    private List<Plato> platos = new ArrayList<>();


    public void añadirPlato(Plato plato) {
        platos.add(plato);
    }


    public List<Plato> getPlatos() {
        return platos;
    }

}
