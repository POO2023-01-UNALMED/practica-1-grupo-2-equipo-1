from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.servicios_extra.Factura import Factura
from gestor_aplicacion.hoteles.Habitacion import Habitacion
#from gestor_aplicacion.transporte.Vehiculo import Vehiculo


class GrupoHuespedes:
    def __init__(self, dias_en_hotel, cabeza, habitacion):
        self.dias_en_hotel = dias_en_hotel
        self.cabeza = cabeza
        self.factura = None
        self.habitacion = habitacion
        self.mesa_reservada = None
        self.vehiculo_reservado = None


    def inicializar_factura(self):
        self.factura = Factura()
        self.factura.factura_hospedaje = self.habitacion.precio_x_dia * self.dias_en_hotel

    def __str__(self):
        return 

    def get_dias_en_hotel(self):
        return self.dias_en_hotel

    def set_dias_en_hotel(self, dias_en_hotel):
        self.dias_en_hotel = dias_en_hotel

    def get_lista_huespedes(self):
        return self.lista_huespedes

    def set_lista_huespedes(self, lista_huespedes):
        self.lista_huespedes = lista_huespedes

    def get_factura(self):
        return self.factura

    def set_factura(self, factura):
        self.factura = factura

    def get_habitacion(self):
        return self.habitacion

    def set_habitacion(self, habitacion):
        self.habitacion = habitacion

    def get_mesa_reservada(self):
        return self.mesa_reservada

    def set_mesa_reservada(self, reserva_restaurante):
        self.mesa_reservada = reserva_restaurante

    def get_vehiculo_reservado(self):
        return self.vehiculo_reservado

    def set_vehiculo_reservado(self, vehiculo_reservado):
        self.vehiculo_reservado = vehiculo_reservado
