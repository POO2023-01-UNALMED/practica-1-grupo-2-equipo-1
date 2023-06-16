
#from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.transporte.Vehiculo import Vehiculo

class Mototaxi(Vehiculo):

    

    def __init__(self, modelo: str, placa: str, conductor: str, capacidad: int, ocupado: bool, precio: int,cilindraje: int):
        super().__init__(modelo, placa, conductor, capacidad, ocupado, precio)
        self.cilindraje = cilindraje

        self.dueños = None

    def __str__(self) -> str:

        if(self.dueños != None):
            #dueños se debe imprimir con el metodo to string de GrupoHuespedes pero aun no esta hecho
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nDueños: "+self.dueños+"\nPrecio: "+str(self.precio)+"\nCilindraje: "+str(self.cilindraje)
            
        else : 
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nPrecio: "+str(self.precio)+"\nCilindraje: "+str(self.cilindraje)
        
    def setCilindraje(self,cilindraje):
        self.cilindraje = cilindraje
    
    def getCilindraje(self):
        return self.cilindraje
    
    def asignarDueños(self, grupo):
        super().asignarDueños(grupo) #return?
    
    def getDueños(self):
        return super().getDueños()
    
    def setDueños(self, dueños):
        return super().setDueños(dueños)
