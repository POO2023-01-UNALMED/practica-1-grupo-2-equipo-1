/*Clase mototaxi, hereda de la clase Vehiculo y tiene un método toString en el cual se presenta ligadura dinámica
 * a la hora de ejecutar el programa
 */
package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Mototaxi extends Vehiculo {

	private GrupoHuespedes dueños;

	private int cilindraje;

	public Mototaxi(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio
			, int cilindraje) {
		super(modelo, placa, conductor, capacidad, ocupado, precio);
		this.cilindraje= cilindraje;
		// TODO Auto-generated constructor stub
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
			Cilindraje = %d
			""", modelo, placa, conductor, capacidad, ocupado, dueños.toString(), precio, cilindraje);
		}
		return String.format("""
			Vehiculo:
			Modelo = %s
			Placa = %s
			Conductor = %s
			Capacidad = %d
			Ocupado = %b
			Precio = $%d
			Cilindraje = %d
			""", modelo, placa, conductor, capacidad, ocupado, precio, cilindraje);
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

	public GrupoHuespedes getDueños() {
		return dueños;
	}

	public void setDueños(GrupoHuespedes dueños) {
		this.dueños = dueños;
	}
	
	
	

	
}
