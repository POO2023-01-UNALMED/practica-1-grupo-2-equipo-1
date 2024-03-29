#from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
Vehiculos = []
class Vehiculo: 

    def __init__(self,id:int,modelo:str,placa:str,conductor:str,capacidad: int,ocupado:bool,precio:int):
        self.id = id
        self.modelo = modelo
        self.placa = placa
        self.conductor = conductor
        self.capacidad = capacidad
        self.ocupado = ocupado
        self.precio = precio
        dueños = None
        Vehiculos.append(self)


    #to string
    def __str__(self) -> str:
        if(self.dueños != None):

            #dueños se debe imprimir con el metodo to string de GrupoHuespedes pero aun no esta hecho
            return '''
            id: {}
            Vehiculo: {}
            Modelo: {}
            Conductor: {}
            Capacidad: {}
            Ocupado: {}
            Dueños: {}
            Precio: {}
            '''.format(self.id,self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.dueños,self.precio)
        
        else : 
            return '''
            id: {}
            Vehiculo: {}
            Modelo: {}
            Conductor: {}
            Capacidad: {}
            Ocupado: {}
            Precio: {}
            '''.format(self.id, self.modelo,self.placa,self.conductor,self.capacidad,self.ocupado,self.precio)
    

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
	 
    def asignarDueños(self,grupo):
        self.dueños = grupo
        self.dueños.set_vehiculo_reservado(self)
        self.ocupado = True

    #Este método se llama en la funcionalidad desalojar huespuedes y se encarga de que el vehiculo que fue reservado
	#por un grupo de huespes sea liberado y vuelva a estar disponible una dichos huespedes hayan abandonado el hotel
	
    def desocuparVehiculo(self):
        self.dueños.setVehiculoReservado(None)
        self.dueños = None
        self.ocupado = False

    def setDueños(self,dueños):
        self.dueños = dueños
    
    def getDueños(self):
        return self.dueños
    
    def getId(self):
        return self.id

    @staticmethod
    def buscarPorId(idVehiculo):
        for vehiculo  in Vehiculos:
            if int(vehiculo.getId()) == int(idVehiculo):
                return vehiculo


Vehiculo(1,"Corola","AAA111", "Gerardo", 4, False, 55000)
Vehiculo(2,"Chevy","GPL069", "Gerardo", 4, False, 50000)
Vehiculo(3,"Mercho","PNK318", "Ricardo", 4, False, 75000)
Vehiculo(4,"GWA","ABC123", "Alberto", 4, False, 80000)