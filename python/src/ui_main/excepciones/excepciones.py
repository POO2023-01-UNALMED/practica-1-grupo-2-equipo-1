from tkinter import messagebox

class Error(Exception): 
    def __init__(self, error):
        self._error = f"Manejo de excepciones: {error}"
        super().__init__(self._error)
    
    def printExcepcion(self):
        messagebox.showerror("Excepción", self._error)

class habitacionOcupada(Error):
    def __init__(self, error):
        self._error = error
        super().__init__(f"La habitación ya se encuentra ocupada {error}")

class habitacionDesocupada(Error):
    def __init__(self,error):
        self.error = error
        super().__init__(f"La habitación está desocupada")

class HabitacionNoExiste(Error):
    def __init__(self):
        super().__init__(f"La habitacion no existe")
    def __str__(self) -> str:
        return "No existe una habitacion con ese Id"
    
class CamposFaltantesError(Error):
    def __init__(self, campos):
        self.campos = campos
    
    def __str__(self):
        return f"Faltan campos por llenar"
    
class TipadoNoValido(Error):
    def __init__(self):
        super().__init__(f"Tipo de dato no aceptado")

class VehiculoOcupado(Error):
    def __init__(self, error):
        self.error = error
        super().__init__("El vehículo ya está ocupado")

class CapacidadInsuficiente(Error):
    def __init__(self, error):
        super().__init__(error)
