from tkinter import *


class FieldFrame(Frame):
    def __init__(self, master ,tituloCriterios, criterios, tituloValores, valores, habilitado):
        super().__init__(master, bg="white")
        self.valores = valores
        self.config(width=500, height=200)
        self.grid_propagate(False)
        #Etiquetas para los títulos de las columnas
        Label(self, text=tituloCriterios,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=0, padx=10)
        Label(self, text=tituloValores,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=1, padx=10, sticky="w")

        # Etiquetas y campos de entrada para cada criterio
        for i, criterio in enumerate(criterios):
            Label(self, text=criterio,bg="white", font=("Helvetica", 10, "bold")).grid(row=i+1, column=0, padx=20, pady=5, sticky="w")
            entry = Entry(self,width=50)
            entry.grid(row=i+1, column=1, padx=5, pady=5)
            # Se inserta los valores por defecto que queramos
            if valores is not None:
                #el número 0 indica que se inserta desde el inicio del string
                entry.insert(0, valores[i])
            #Para deshabilitar el entry
            if habilitado is not None and not habilitado[i]:
                entry.config(state='readonly')

            #Se guarda la referencia de ese entry
            valores.append(entry)
        
        Button(self, text="Aceptar", width=5, height=1, background="lightgray", padx=15).grid(row=99, column=0, sticky="e", padx=10)
        Button(self, text="Borrar", width=5, height=1, background="lightgray", padx=15).grid(row=99, column=1, sticky="w", padx=10)


    def habilitarEntry(self, indice, habilitar):
        if habilitar:
            return self.valores[indice].config(state="normal")
        else:
            return self.valores[indice].config(state="readonly")

    def getValue(self, criterio):
        return self.valores[criterio].get()
    
