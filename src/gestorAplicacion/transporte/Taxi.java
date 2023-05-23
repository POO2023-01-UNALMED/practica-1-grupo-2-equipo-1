package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Taxi extends Vehiculo {
	private String compania;

	public Taxi(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio,
			String compania) {
		super(modelo, placa, conductor, capacidad, ocupado, precio);
		this.compania= compania;
		
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
                ", Compañia=" + compania +
                '}';
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	public void asignarDueños(GrupoHuespedes grupo) {
		super.asignarDueños(grupo);
	}
}
