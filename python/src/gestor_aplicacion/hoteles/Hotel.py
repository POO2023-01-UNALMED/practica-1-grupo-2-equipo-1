import pickle
from gestor_aplicacion.hoteles.Habitacion import Habitacion
import os


class Hotel:
    def __init__(self) -> None:
        
        with open(r"python\src\base_datos\temp\habitaciones.pickle", "rb") as archivo_habitaciones:

            #Verifica si el archivo donde se guarda esta vacio
            if (os.stat(r"python\src\base_datos\temp\habitaciones.pickle").st_size == 0):
                self._habitaciones = []
            else:
                #Desearizando
                self._habitaciones = pickle.load(archivo_habitaciones)


    @property
    def set_habitaciones(self):
        return self._habitaciones

    @set_habitaciones.setter
    def get_habitaciones(self, lista_habitaciones):
        self._habitaciones = lista_habitaciones

    def añadir_habitacion(self, habitacion:Habitacion) -> None:
        self.get_habitaciones.append(habitacion)

