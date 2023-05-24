package gestorAplicacion.transporte;

import gestorAplicacion.Personas.GrupoHuespedes;

public interface Transporte {
    void DesocuparVehiculo();
    void asignarDueños(GrupoHuespedes grupoHuespedes);
    String toString();
}
