package gestorAplicacion.serviciosExtra;

public enum ServiciosExtra {
    GIMNASIO(1, 50000), BAR(2, 20000),
    PARQUEADERO(3, 30000);

    private int id;
    private int precio;

    private ServiciosExtra(final int id, final int precio) {
        this.precio = precio;
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public int getid() {
        return id;
    }

    public static ServiciosExtra buscarPorid(final int id) {
        for (ServiciosExtra servicio : ServiciosExtra.values()) {
            if (servicio.getid() == id) {
                return servicio;
            }
        }
        return null;
    }
}
