

class Huesped:
    """docstring for Huesped."""
    def __init__(self, nombre="alejandro", ID=1):
        self._nombre = nombre
        self._ID = ID

    def __str__(self) -> str:
        return f"{self._nombre}-{self._ID}"
    
    #getter
    @property
    def get_nombre(self):
        return self._nombre
    
    #setter
    @get_nombre.setter
    def set_nombre(self, nuevo_nombre):
        self._nombre = nuevo_nombre
    