

# from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
class Habitacion:

    def __init__(self, ID_HABITACION:int, capacidad:int, precioxdia:int, grupo=None, esta_ocupado:bool = False) -> None:
        self._ID_HABITACION:int = ID_HABITACION
        self._capacidad:int = capacidad
        self._precioxdia:int = precioxdia
        self.grupo = grupo #puede ser de tipo GrupoHuespedes o None
        self._esta_ocupado:bool = esta_ocupado
 

    def borrar_grupo(self) -> None:
        self.grupo = None
        self._esta_ocupado = False

    def __str__(self) -> str:
        if (self.grupo == None):
            return "Huespedes: " + "Vacio" + f", ID: {self._ID_HABITACION}, Ocupado: {self._esta_ocupado}, Capacidad: {self._capacidad}"

        return f"Huespedes:  {self.get_grupo_huespedes().cabeza}, ID: {self._ID_HABITACION}, Ocupado: {self._esta_ocupado}, Capacidad: {self._capacidad}, Factura: {self.grupo.get_factura().CalcularPrecioFactura()}"
        # return f"Huespedes: cabeza, ID: {self._ID_HABITACION}, Ocupado: {self._esta_ocupado}"
    
    def get_grupo_huespedes(self):
        return self.grupo

    def set_grupo_huespedes(self, grupo):
        self._esta_ocupado = True
        self.grupo = grupo
        self.grupo.get_factura().setFacturaHospedaje(self._precioxdia)

    def isOcupado(self):
        return self._esta_ocupado
    
    def getOcupado(self,ocupado):
        self._esta_ocupado = ocupado

    def factura(self):
        if (self.grupo == None) :
            return "No hay Factura"
        return (f"Factura Hospedaje: {self.grupo.get_factura().getFacturaHospedaje()}\n"
                f"Factura Servicios Extra: {self.grupo.get_factura().getFacturaServiciosExtra()}\n"
                f"Factura Restaurante: {self.grupo.get_factura().getFacturaRestaurante()}\n"
                f"Factura Transporte: {self.grupo.get_factura().getFacturaVehiculo()}\n\n"
                f"Factura Total: {self.grupo.get_factura().CalcularPrecioFactura()}")
    

        