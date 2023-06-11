class Menu:
    def __init__(self):
        self.platos = []

    def añadirPlato(self, plato):
        self.platos.append(plato)

    def getPlatos(self):
        return self.platos
