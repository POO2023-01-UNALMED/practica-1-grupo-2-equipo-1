package personas;

import hotel.Factura;

public class Encargado extends Huesped {


    public Encargado(String nombre, String apellido, int edad, boolean tieneCarro) {
        super(nombre, apellido, edad, tieneCarro);
    }

    Factura factura = new Factura(this);

    public Factura getFactura() {
        return factura;
    }
    
}
