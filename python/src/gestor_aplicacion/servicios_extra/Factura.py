from gestor_aplicacion.servicios_extra.Servicios_extra import ServiciosExtra

class Factura:
    
    def __init__(self):
        self.FacturaHospedaje = 0
        self.FacturaServiciosExtra = 0
        self.FacturaRestaurante = 0
        self.FacturaVehiculo = 0
        self.idsServicios = [0] * 5

    def mostrarListaServiciosExtra(self):
        return '''
            ========Servicios disponible tiene valor extra en la factura==========
            1. Gimnasio
            2. Bar
            3. Parqueadero
        '''

    def seleccionarServicio(self, id):
        servicio = ServiciosExtra.buscarPorId(id)
        self.FacturaServiciosExtra += servicio.getPrecio()
        return True

    def CalcularPrecioFactura(self):
        return self.FacturaHospedaje + self.FacturaServiciosExtra + self.FacturaRestaurante + self.FacturaVehiculo

    def contains(self, arr, key):
        return key in arr

    def __str__(self):
        return '''
            Factura por hospedaje: {}
            Factura por servicios extra: {}
            Factura por restaurante: {}
            Factura por alquiler de vehiculo: {}
        '''.format(self.FacturaHospedaje, self.FacturaServiciosExtra, self.FacturaRestaurante, self.FacturaVehiculo)

    # Getters y setters
    def getFacturaHospedaje(self):
        return self.FacturaHospedaje

    def setFacturaHospedaje(self, facturaHospedaje):
        self.FacturaHospedaje = facturaHospedaje

    def getFacturaServiciosExtra(self):
        return self.FacturaServiciosExtra

    def setFacturaServiciosExtra(self, facturaServiciosExtra):
        self.FacturaServiciosExtra = facturaServiciosExtra

    def getIdsServicios(self):
        return self.idsServicios

    def setIdsServicios(self, idsServicios):
        self.idsServicios = idsServicios

    def getFacturaRestaurante(self):
        return self.FacturaRestaurante

    def setFacturaRestaurante(self, facturaRestaurante):
        self.FacturaRestaurante = facturaRestaurante

    def getFacturaVehiculo(self):
        return self.FacturaVehiculo

    def setFacturaVehiculo(self, facturaVehiculo):
        self.FacturaVehiculo = facturaVehiculo
