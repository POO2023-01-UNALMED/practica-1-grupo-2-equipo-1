package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Mototaxi extends Vehiculo {
	private int cilindraje;

	public Mototaxi(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio
			, int cilindraje) {
		super(modelo, placa, conductor, capacidad, ocupado, precio);
		this.cilindraje= cilindraje;
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + super.getModelo() + '\'' +
                ", placa='" + super.getPlaca() + '\'' +
                ", conductor='" + super.getConductor() + '\'' +
                ", capacidad=" + super.getCapacidad() +
                ", ocupado=" +	super.isOcupado() +
                ", precio=" + super.getPrecio() +
                ", Cilindraje=" + cilindraje +
                '}';
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void asignarDueños(GrupoHuespedes grupo) {
		super.asignarDueños(grupo);
	}
	
	
	

	
}
