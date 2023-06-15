
from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.transporte.Vehiculo import Vehiculo

class Bus(Vehiculo):

    dueños: GrupoHuespedes = None

    def __init__(self,modelo:str,placa:str,conductor:str,capacidad: int,ocupado:bool,precio:int):
        super().__init__(modelo,placa,conductor,capacidad,ocupado,precio)

    def __str__(self) -> str:

        if(dueños != None):
            #dueños se debe imprimir con el metodo to string de GrupoHuespedes pero aun no esta hecho
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nDueños: "+self.dueños+"\nPrecio: "+str(self.precio)
            
        else : 
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nPrecio: "+str(self.precio)
            

    def asignarDueños(self, grupo: GrupoHuespedes):
        super().asignarDueños(grupo) #return?
    
    def setDueños(self,dueños):
        self.dueños = dueños
    
    def getDueños(self):
        return self.dueños