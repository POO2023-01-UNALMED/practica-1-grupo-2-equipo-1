from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.servicios_extra.Factura import Factura

class GrupoHuespedes:
    def __init__(self, dias_en_hotel:int, lista_huespedes:list[Huesped], factura:Factura = Factura()) -> None:
        self._dias_en_hotel:int = dias_en_hotel
        self._lista_huespedes:list[Huesped] = lista_huespedes
        self._factura:Factura = factura

    def __str__(self) -> str:
        s = ""
        for p in self._lista_huespedes:
            s +=  str(p)
        return s

    @property
    def get_factura(self):
        return self._factura

    @get_factura.setter
    def set_factura(self, factura):
        self._factura:Factura = factura
