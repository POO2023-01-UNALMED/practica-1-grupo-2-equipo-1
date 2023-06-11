from enum import Enum

class ServiciosExtra(Enum):
    
    GIMNASIO = (1, 50000)
    BAR = (2, 20000)
    PARQUEADERO = (3, 30000)
    EXCURSION = (4, 150000)
    CHIVA = (5, 80000)


    def __init__(self, idServicio, precioServicio):
        self.idServicio = idServicio
        self.precioServicio = precioServicio


    def getPrecio(self):
        return self.precioServicio


    def getIdServicio(self):
        return self.idServicio


    @staticmethod
    def buscarPorId(idServicio):
        for servicio in ServiciosExtra:
            if servicio.getIdServicio() == idServicio:
                return servicio
        return None


    @staticmethod
    def calcularPrecioServiciosExtras(idsServicios):
        precioTotal = 0
        for idServicio in idsServicios:
            servicio = ServiciosExtra.buscarPorId(idServicio)
            if servicio is not None:
                precioTotal += servicio.getPrecio()
        return precioTotal

