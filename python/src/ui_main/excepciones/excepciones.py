from tkinter import messagebox

class Error(Exception): 
    def __init__(self, error):
        self._error = f"Manejo de excepciones {error}"
        super().__init__(self._error)
    
    def printExcepcion(self):
        messagebox.showerror("Excepción", self._error)

class habitacionOcupada(Error):
    def __init__(self, error):
        self._error = error
        super().__init__(f"La habitación ya se encuentra ocupada {error}")
    
class CamposFaltantesError(Error):
    def __init__(self, campos):
        self.campos = campos
    
    def __str__(self):
        return f"Faltan llenar el campos: {self.campos}"
