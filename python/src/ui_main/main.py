import pickle
import sys
sys.path.append(r"python\src") #para poder importar nuestros modulos

from gestor_aplicacion.hoteles.Habitacion import Habitacion
from gestor_aplicacion.hoteles.Hotel import Hotel
from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.servicios_extra.Factura import Factura
from base_datos.Serializador import serializar

hotel = Hotel()
hotel.añadir_habitacion(Habitacion(1, 4, 400000))
hotel.añadir_habitacion(Habitacion(2, 2, 200000))
hotel.añadir_habitacion(Habitacion(3, 4, 400000))

# set_grupohuespedes es una funcion pero nose porque lo pone como una variable
# buesque en google y se supone que asi es

hotel.get_habitaciones[0].set_grupo_huespedes = GrupoHuespedes(2, [Huesped()], Factura())

hotel.get_habitaciones[0].borrar_grupo()
print(hotel.get_habitaciones[0])


serializar(hotel)
