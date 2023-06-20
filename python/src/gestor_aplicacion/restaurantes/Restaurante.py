from gestor_aplicacion.restaurantes import Mesa
from enum import Enum

class Restaurante(Enum):
    
    RESTAURANTE_MEXICANO = (1, 50000)
    RESTAURANTE_ITALIANO = (2, 25000)
    RESTAURANTE_GOURMET = (3, 30000)
    RESTAURANTE_VEGETARIANO = (4, 15000)

    def __init__(self, idRestaurante, precioRestaurante):
        self.idRestaurante = idRestaurante
        self.precioRestaurante = precioRestaurante
        
        
    def añadirMesa(self, mesa):
        self.mesas.append(mesa)

    def mostrarMesas(self):
        s = ""
        for mesa in self.mesas:
            s += str(mesa)
        return s

    @staticmethod
    def buscarPorId(idRestaurante):
        for restaurante in Restaurante:
            if int(restaurante.getIdRestaurante()) == int(idRestaurante):
                return restaurante

        print("no encontrado")
        return None

    @staticmethod
    def calcularPrecioRestaurantes(idsRestaurantes):
        precioTotal = 0
        for idRestaurante in idsRestaurantes:
            restaurante = Restaurante.buscarPorId(idRestaurante)
            if restaurante is not None:
                precioTotal += restaurante.getPrecioResetaurante()
        return precioTotal

    def inicializar(self):
        for i in range(1, 8):
            self.añadirMesa(Mesa(i))

    # Getters y setters
    def getMesas(self):
        return self.mesas

    def setMesas(self, mesas):
        self.mesas = mesas

    def getPrecioResetaurante(self):
        return self.precioRestaurante
    
    def getIdRestaurante(self):
        return self.idRestaurante
