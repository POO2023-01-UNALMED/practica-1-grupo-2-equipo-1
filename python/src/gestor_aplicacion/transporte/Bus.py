
#from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.transporte.Vehiculo import Vehiculo

class Bus(Vehiculo):

    

    def __init__(self,modelo:str,placa:str,conductor:str,capacidad: int,ocupado:bool,precio:int):
        super().__init__(modelo,placa,conductor,capacidad,ocupado,precio)

        self.dueños= None

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
            '''.format(self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.dueños,self.precio)
            
        else : 
            return '''
            Vehiculo: {}
            Modelo: {}
            Conductor: {}
            Capacidad: {}
            Ocupado: {}
            Precio: {}
            '''.format(self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.precio)

    def asignarDueños(self, grupo):
        super().asignarDueños(grupo) #return?
    
    def setDueños(self,dueños):
        self.dueños = dueños
    
    def getDueños(self):
        return self.dueños
