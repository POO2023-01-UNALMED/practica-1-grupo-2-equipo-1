from pathlib import Path
import pickle

docs = Path(r"python\src\base_datos\temp")

def serializar(hotel):
    for file in docs.iterdir():
        if ("habitaciones" in file.name):
            with open(r"python\src\base_datos\temp\habitaciones.pickle", "wb") as archivo_habitaciones:
                pickle.dump(hotel.get_habitaciones, archivo_habitaciones)
        elif("otra cosa" in file.name):
            pass
