

from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
class Habitacion:

    def __init__(self, ID_HABITACION:int, capacidad:int, precioxdia:int, grupo=None, esta_ocupado:bool = False) -> None:
        self._ID_HABITACION:int = ID_HABITACION
        self._capacidad:int = capacidad
        self._precioxdia:int = precioxdia
        self._grupo_huespedes:GrupoHuespedes = grupo #puede ser de tipo GrupoHuespedes o None
        self._esta_ocupado:bool = esta_ocupado


    def borrar_grupo(self) -> None:
        self._grupo_huespedes = None
        self._esta_ocupado = False

    def __str__(self) -> str:
        if (self._grupo_huespedes == None):
            return "Huespedes: " + "Vacio" + f", ID: {self._ID_HABITACION}, Ocupado: {self._esta_ocupado}"

        return "Huespedes: " + str(self._grupo_huespedes) + f", ID: {self._ID_HABITACION}, Ocupado: {self._esta_ocupado}, Factura: {self._grupo_huespedes.get_factura.calcular_precio_factura()}"
    
    @property
    def get_grupo_huespedes(self):
        return self._grupo_huespedes

    @get_grupo_huespedes.setter
    def set_grupo_huespedes(self, grupo):
        self._esta_ocupado = True
        self._grupo_huespedes = grupo
        self._grupo_huespedes.get_factura._factura_Hospedaje = self._precioxdia
        