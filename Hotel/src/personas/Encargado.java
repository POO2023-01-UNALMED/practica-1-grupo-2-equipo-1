package personas;

import hotel.servicios.Factura;

public class Encargado extends Huesped {
    boolean tieneCarro;

    public Encargado(String nombre, String apellido, int edad, boolean tieneCarro) {
        super(nombre, apellido, edad);
        this.tieneCarro = tieneCarro;
    }

    Factura factura = new Factura(this);

    public Factura getFactura() {
        return factura;
    }
    
}
