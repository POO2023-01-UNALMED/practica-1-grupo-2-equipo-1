/* La clase vehiculo es la base para la funcionalidad de reserva de vehiculos que se le ofrece a los huespedes   
 * es la clase padre de 4 clases que representan tipos de vehiculos que se le ofrecen a los huespedes del hotel,
 * tambien es la clase que logra la ligadura dinámica dentro del programa. 
*/

/* */


package gestorAplicacion.transporte;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Vehiculo implements Serializable , Transporte{
	protected String modelo; 
	protected String placa;
	protected String conductor;
	protected int capacidad;
	protected boolean ocupado;
	protected int precio;
	
	private GrupoHuespedes dueños;

	public Vehiculo(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio) {
		this.modelo = modelo;
		this.placa = placa;
		this.conductor = conductor;
		this.capacidad = capacidad;
		this.ocupado = ocupado;
		this.precio = precio;
	}


	/* El método toString para mostrar la información del vehiculo según sus atributos, podemos ver que se desarrolla ligadura
	 * dinamica cuando durante la ejecución del programa este elige qué método toString llamar según el objeto
	 */

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
			""", modelo, placa, conductor, capacidad, ocupado, dueños.toString(), precio);
		}
		return String.format("""
			Vehiculo:
			Modelo = %s
			Placa = %s
			Conductor = %s
			Capacidad = %d
			Ocupado = %b
			Precio = $%d
			""", modelo, placa, conductor, capacidad, ocupado, precio);
	}
	


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getConductor() {
		return conductor;
	}


	public void setConductor(String conductor) {
		this.conductor = conductor;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public boolean isOcupado() {
		return ocupado;
	}


	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/*Este método se llama en la funcionalidad Reservar transporte y recibe un parametro de tipo GrupoHuespedes 
	 * para asignarle a este mismo un atributo de tipo vehiculo que fue reservado por ellos
	 */
	@Override
	public void asignarDueños(GrupoHuespedes grupo) {
		this.dueños = grupo;
		dueños.setVehiculoReservado(this);
		ocupado = true;
	}
	/*Este método se llama en la funcionalidad desalojar huespuedes y se encarga de que el vehiculo que fue reservado
	 * por un grupo de huespes sea liberado y vuelva a estar disponible una dichos huespedes hayan abandonado el hotel
	 */
	@Override
    public void DesocuparVehiculo() {
        dueños.setVehiculoReservado(null);
        this.dueños = null;
        this.ocupado = false;
    }


	public GrupoHuespedes getDueños() {
		return dueños;
	}


	public void setDueños(GrupoHuespedes dueños) {
		this.dueños = dueños;
	}

	
}
