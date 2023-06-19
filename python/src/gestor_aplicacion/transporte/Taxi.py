#from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.transporte.Vehiculo import Vehiculo

class Taxi(Vehiculo):

    

    def __init__(self, modelo: str, placa: str, conductor: str, capacidad: int, ocupado: bool, precio: int,compañia: str):
        super().__init__(modelo, placa, conductor, capacidad, ocupado, precio)
        self.compañia = compañia

        self.dueños = None
    
    def __str__(self) -> str:

        if(self.dueños != None):
            #dueños se debe imprimir con el metodo to string de GrupoHuespedes pero aun no esta hecho
            return '''  
            Vehiculo: {}
            Modelo: {}
            Conductor: {}
            Capacidad: {}
            Ocupado: {}
            Dueños: {}
            Precio: {}
            Compañia: {}
            '''.format(self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.dueños,self.precio,self.compañia)
            
        else : 
            return '''
            Vehiculo: {}
            Modelo: {}
            Conductor: {}
            Capacidad: {}
            Ocupado: {}
            Precio: {}
            Compañia: {}
            '''.format(self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.precio,self.compañia)
        
    def setCompañia(self,compañia):
        self.compañia = compañia

    def getCompañia(self):
        return self.compañia
    
    def asignarDueños(self, grupo):
        super().asignarDueños(grupo) #return?
    
    def getDueños(self):
        return super().getDueños()
    
    def setDueños(self, dueños):
        return super().setDueños(dueños)