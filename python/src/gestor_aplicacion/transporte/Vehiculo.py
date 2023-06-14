from gestor_aplicacion.personas.GrupoHuespedeses import GrupoHuespedes

class Vehiculo: 

    dueños: GrupoHuespedes = None


    def __init__(self,modelo:str,placa:str,conductor:str,capacidad: int,ocupado:bool,precio:int):
        self.modelo = modelo
        self.placa = placa
        self.conductor = conductor
        self.capacidad = capacidad
        self.ocupado = ocupado
        self.precio = precio

    #to string
    def __str__(self) -> str:
        if(dueños != None):
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nDueños: "+self.dueños+"\nPrecio: "+str(self.precio)
        else : 
            return "Vehiculo: \nModelo: "+self.modelo+"\nPlaca: "+self.placa+"\nConductor: "+self.conductor+"\nCapacidad: "+str(self.capacidad)+"\nOcupado: "+str(self.ocupado)+"\nPrecio: "+str(self.precio)
            
    

    #getters and setters
    def setModelo(self,modelo):
        self.modelo = modelo
    
    def getModelo(self):
        return self.modelo
    
    def setPlaca(self,placa):
        self.placa = placa
    
    def getPlaca(self):
        return self.placa
    
    def setConductor(self,conductor):
        self.conductor = conductor

    def getConductor(self):
        return self.conductor 
    
    def setCapacidad(self,capacidad):
        self.capacidad = capacidad
    
    def getCapacidad(self):
        return self.capacidad
    
    def setOcupado(self,ocupado):
        self.ocupado = ocupado

    def isOcupado(self):
        return self.ocupado
    
    #metodos
    #Este método se llama en la funcionalidad Reservar transporte y recibe un parametro de tipo GrupoHuespedes 
	# para asignarle a este mismo un atributo de tipo vehiculo que fue reservado por ellos
	 
    def asignarDueños(self,grupo:GrupoHuespedes):
        self.dueños = grupo
        dueños.setVehiculoReservado(self)
        self.ocupado = True

    #Este método se llama en la funcionalidad desalojar huespuedes y se encarga de que el vehiculo que fue reservado
	#por un grupo de huespes sea liberado y vuelva a estar disponible una dichos huespedes hayan abandonado el hotel
	
    def desocuparVehiculo(self):
        dueños.setVehiculoReservado(None)
        self.dueños = None
        self.ocupado = False

    def setDueños(self,dueños):
        self.dueños = dueños
    
    def getDueños(self):
        return self.dueños


        