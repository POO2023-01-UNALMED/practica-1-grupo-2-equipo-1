import pickle
from gestor_aplicacion.hoteles.Habitacion import Habitacion
import os
from base_datos.Desearizador import deserializar
from tkinter import Tk, Menu, Toplevel, Label



class Hotel:
    def __init__(self) -> None:
        self._habitaciones:list[Habitacion] = []
        deserializar(self)


    @property
    def get_habitaciones(self):
        return self._habitaciones

    @get_habitaciones.setter
    def set_habitaciones(self, lista_habitaciones):
        self._habitaciones = lista_habitaciones

    def añadir_habitacion(self, habitacion:Habitacion) -> None:
        self.get_habitaciones.append(habitacion)

    def mostrar_habitaciones(self):
        ventana_datos= Toplevel()
        ventana_datos.geometry("400x300")
        ventana_datos.title("Habitaciones")
        for habitacion in self._habitaciones:
            label = Label(ventana_datos, text=habitacion)
            label.pack()
        

 