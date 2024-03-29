from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes


class Mesa:
    def __init__(self, id):
        self.ocupado = False
        self.dueños:GrupoHuespedes = None  # quienes tienen reservada esta mesa
        self.id = id

    def asignarDueños(self, dueños:GrupoHuespedes ):
        self.dueños = dueños
        dueños.set_mesa_reservada(self)
        self.ocupado = True

    def vaciarMesa(self,dueños:GrupoHuespedes):
        dueños.set_mesa_reservada(None)
        self.dueños = None
        self.ocupado = False

    def __str__(self):
        if self.ocupado:
            return "Mesa: " + str(self.id) + ", Reservada por " + str(self.dueños)
        return "Disponible"

    # Getters y setters
    def isOcupado(self):
        return self.ocupado

    def setOcupado(self, ocupado):
        self.ocupado = ocupado

    def getDueños(self):
        return self.dueños

    def setDueños(self, dueños):
        self.dueños = dueños

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id
