from tkinter import *


class FieldFrame(Frame):
    def __init__(self, master ,tituloCriterios, criterios, tituloValores, valores, habilitado):
        super().__init__(master, bg="white")
        self.config(width=400, height=200)
        self.grid_propagate(False)
        #Etiquetas para los títulos de las columnas
        Label(self, text=tituloCriterios,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=0, padx=10, columnspan=1)
        Label(self, text=tituloValores,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=1, padx=10, columnspan=1)

        # Etiquetas y campos de entrada para cada criterio
        for i, criterio in enumerate(criterios):
            Label(self, text=criterio,bg="white", font=("Helvetica", 10, "bold")).grid(row=i, column=0, padx=20, pady=5, sticky="w")
            entry = Entry(self,width=100)
            entry.grid(row=i, column=1, padx=5, pady=5)
            # Se inserta los valores por defecto que queramos
            if valores is not None:
                #el número 0 indica que se inserta desde el inicio del string
                entry.insert(0, valores[i])
            #Para deshabilitar el entry
            if habilitado is not None and not habilitado[i]:
                entry.config(state='readonly')

            #Se guarda la referencia de ese entry
            valores.append(entry)

    def habilitarEntry(self, indice, habilitar):
        if habilitar:
            return self.valores[indice - 1].config(state="normal")
        else:
            return self.valores[indice - 1].config(state="readonly")

    def getValue(self, criterio):
        return self.valores[criterio-1].get()
