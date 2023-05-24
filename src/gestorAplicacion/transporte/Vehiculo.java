package gestorAplicacion.transporte;

import java.io.Serializable;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Vehiculo implements Serializable , Transporte{
	private String modelo; 
	private String placa;
	private String conductor;
	private int capacidad;
	private boolean ocupado;
	private int precio;
	
	private GrupoHuespedes dueños;

	public Vehiculo(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio) {
		this.modelo = modelo;
		this.placa = placa;
		this.conductor = conductor;
		this.capacidad = capacidad;
		this.ocupado = ocupado;
		this.precio = precio;
	}


	//metodo toString para mostrar la info del vehiculo

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
	
	@Override
	public void asignarDueños(GrupoHuespedes grupo) {
		this.dueños = grupo;
		dueños.setVehiculoReservado(this);
		ocupado = true;
	}
	
	@Override
    public void DesocuparVehiculo() {
        dueños.setVehiculoReservado(null);
        this.dueños = null;
        this.ocupado = false;
    }

}
