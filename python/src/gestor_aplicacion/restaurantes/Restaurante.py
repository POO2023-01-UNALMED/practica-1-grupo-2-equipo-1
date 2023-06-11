from gestor_aplicacion.restaurantes import Menu,Mesa

class Restaurante:
    def __init__(self, nombre, precio, id):
        self.nombre = nombre
        self.mesas = []
        self.precio = precio
        self.id = id
        self.menu = Menu()
        self.inicializar()

    def añadirMesa(self, mesa):
        self.mesas.append(mesa)

    def mostrarMesas(self):
        s = ""
        for mesa in self.mesas:
            s += str(mesa)
        return s

    def __str__(self):
        return self.nombre + ", precio: " + str(self.precio)

    def inicializar(self):
        for i in range(1, 8):
            self.añadirMesa(Mesa(i))

    def getMenu(self):
        return self.menu

    def setMenu(self, menu):
        self.menu = menu

    # Getters y setters
    def getMesas(self):
        return self.mesas

    def setMesas(self, mesas):
        self.mesas = mesas

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getPrecio(self):
        return self.precio

    def setPrecio(self, precio):
        self.precio = precio

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id
