from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.servicios_extra.Factura import Factura
from gestor_aplicacion.hoteles.Habitacion import Habitacion

class GrupoHuespedes:
    def __init__(self, dias_en_hotel:int, lista_huespedes:list[Huesped], factura:Factura = Factura()) -> None:
        self._dias_en_hotel = dias_en_hotel
        self._lista_huespedes = lista_huespedes
        self._factura = factura

    def __str__(self) -> str:
        s = ""
        for p in self._lista_huespedes:
            s +=  str(p)
        return s
