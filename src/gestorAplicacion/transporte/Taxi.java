package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;



public class Taxi extends Vehiculo {

	private GrupoHuespedes dueños;
	private String compania;

	public Taxi(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio,
			String compania) {
		super(modelo, placa, conductor, capacidad, ocupado, precio);
		this.compania= compania;
		
	}

	@Override
	  public String toString() {
		if (dueños != null) {
			return String.format("""
			Vehiculo:
			Modelo = %s
			Placa = %s
			Conductor = %s
			Capacidad = %d
			Ocupado = %b
			Dueños = %s
			Precio = $%d
			Compañia = %s 
			""", modelo, placa, conductor, capacidad, ocupado, dueños.toString(), precio, compania);
		}
		return String.format("""
			Vehiculo:
			Modelo = %s
			Placa = %s
			Conductor = %s
			Capacidad = %d
			Ocupado = %b
			Precio = $%d
			Compañia = %s
			""", modelo, placa, conductor, capacidad, ocupado, precio, compania);
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
