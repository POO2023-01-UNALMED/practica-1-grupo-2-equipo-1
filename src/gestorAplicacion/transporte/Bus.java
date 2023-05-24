package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;

public class Bus extends Vehiculo{

    private GrupoHuespedes dueños;

    public Bus(String modelo, String placa, String conductor, int capacidad, boolean ocupado, int precio) {
        super(modelo, placa, conductor, capacidad, ocupado, precio);
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
