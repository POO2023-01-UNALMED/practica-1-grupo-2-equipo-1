class Factura:
    def __init__(self) -> None:
        self._factura_Hospedaje:int = 0
        self._factura_ServiciosExtra:int = 0
        self._factura_Restaurante:int = 0
        self._factura_Vehiculo:int = 0

    def calcular_precio_factura(self) -> int:
        return self._factura_Hospedaje + self._factura_ServiciosExtra \
            + self._factura_Restaurante + self._factura_Vehiculo
