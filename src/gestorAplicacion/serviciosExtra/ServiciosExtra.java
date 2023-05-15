package gestorAplicacion.serviciosExtra;

public enum ServiciosExtra {
    GIMNASIO(1, 50000),
    BAR(2, 20000),
    PARQUEADERO(3, 30000);

    private final int idServicio;
    private final int precioServicio;

    ServiciosExtra(final int idServicio, final int precioServicio) {
        this.idServicio = idServicio;
        this.precioServicio = precioServicio;
    }

    public int getPrecio() {
        return precioServicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public static ServiciosExtra buscarPorId(final int idServicio) {
        for (ServiciosExtra servicio : ServiciosExtra.values()) {
            if (servicio.getIdServicio() == idServicio) {
                return servicio;
            }
        }
        return null;
    }
    
    // Método para actualizar precios
    //! No sirve si la variables es final
    // public void actualizarPrecio(final int nuevoPrecio) {
    //     this.precioServicio = nuevoPrecio;
    // }
    
    //

    // Método para agregar nuevos servicios
    // public static void agregarServicioExtra(final String nombre, final int precio) {
    //     ServiciosExtra[] nuevosServicios = new ServiciosExtra[ServiciosExtra.values().length + 1];
    //     System.arraycopy(ServiciosExtra.values(), 0, nuevosServicios, 0, ServiciosExtra.values().length);
    //     nuevosServicios[nuevosServicios.length - 1] = new ServiciosExtra(nuevosServicios.length, precio);
    //     ServiciosExtra.values(nuevosServicios);
    // }
    
    public static int calcularPrecioServiciosExtras(int[] idsServicios) {
        int precioTotal = 0;
        for (int idServicio : idsServicios) {
            ServiciosExtra servicio = ServiciosExtra.buscarPorId(idServicio);
            if (servicio != null) {
                precioTotal += servicio.getPrecio();
            }
        }
        return precioTotal;
    }
    
}
