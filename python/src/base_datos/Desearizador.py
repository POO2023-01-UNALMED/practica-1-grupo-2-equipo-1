from pathlib import Path
import pickle
import os

docs = Path(r"python\src\base_datos\temp")

def deserializar(hotel):
    with open(r"python\src\base_datos\temp\habitaciones.pickle", "rb") as archivo_habitaciones:
        #si esta vacio el archivo
        if (os.stat(r"python\src\base_datos\temp\habitaciones.pickle").st_size == 0):
            hotel.set_habitaciones = []
        else:
            #Desearizando
            hotel.set_habitaciones = pickle.load(archivo_habitaciones)
