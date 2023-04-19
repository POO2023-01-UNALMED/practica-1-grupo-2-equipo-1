package personas;

import hotel.servicios.Factura;

public class Encargado extends Huesped {
    boolean tieneCarro;

    public Encargado(String nombreCompleto, int edad, boolean tieneCarro) {
        super(nombreCompleto, edad);
        this.tieneCarro = tieneCarro;
    }

    Factura factura = new Factura(this);

    public Factura getFactura() {
        return factura;
    }
    
}
