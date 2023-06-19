import pickle
import sys
from tkinter import *
sys.path.append(r"python\src") #para poder importar nuestros modulos

from gestor_aplicacion.hoteles.Habitacion import Habitacion
from gestor_aplicacion.hoteles.Hotel import Hotel
from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.servicios_extra.Factura import Factura
from ui_main.ventanas.Ventana_inicio import ventana



hotel = Hotel()
# hotel.añadir_habitacion(Habitacion(1, 4, 400000))
# hotel.añadir_habitacion(Habitacion(2, 2, 200000))
# hotel.añadir_habitacion(Habitacion(3, 4, 400000))

if __name__ == "__main__":
    ventana.mainloop()


# tests

# set_grupohuespedes es una funcion pero nose porque lo pone como una variable
# buesque en google y se supone que asi es

# hotel.get_habitaciones[0].set_grupo_huespedes = GrupoHuespedes(2, [Huesped()], Factura())

# hotel.get_habitaciones[0].borrar_grupo()
# print(hotel.get_habitaciones[0])


