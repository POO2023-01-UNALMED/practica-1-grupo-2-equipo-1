from tkinter import *


class FieldFrame(Frame):
    def __init__(self, master ,tituloCriterios, criterios, tituloValores, valores, habilitado):
        super().__init__(master, bg="white")
        self.frame_formulario = Frame(self, bg="white")
        self.frame_output = Frame(self)
        self.frame_formulario.pack()
        self.frame_output.pack()


        self.criterios:list = criterios
        self.valores:list = valores
        self.entradas:list[Entry] = []

        self.config(width=1090, height=670)
        self.grid_propagate(False)
        #Etiquetas para los títulos de las columnas
        Label(self.frame_formulario, text=tituloCriterios,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=0, padx=10)
        Label(self.frame_formulario, text=tituloValores,bg="white",font=("Helvetica", 12, "bold")).grid(row=0, column=1, padx=10, sticky="w")

        # Etiquetas y campos de entrada para cada criterio
        for i, criterio in enumerate(criterios):
            Label(self.frame_formulario, text=criterio,bg="white", font=("Helvetica", 10, "bold")).grid(row=i+1, column=0, padx=20, pady=5, sticky="w")
            entry = Entry(self.frame_formulario,width=50)
            entry.grid(row=i+1, column=1, padx=5, pady=5)
            entry.insert(0, valores[i])
            #Para deshabilitar el entry
            if habilitado is not None and not habilitado[i]:
                entry.config(state="readonly")

            #Se guarda la referencia de ese entry
            self.entradas.append(entry)
        
        self.boton_aceptar = Button(self.frame_formulario, text="Aceptar", width=5, height=1, background="lightgray", padx=15)
        self.boton_aceptar.grid(row=10, column=0, sticky="e", padx=10)
        self.boton_borrar = Button(self.frame_formulario, text="Borrar", width=5, height=1, background="lightgray", padx=15, command=self.borrar_texto)
        self.boton_borrar.grid(row=10, column=1, sticky="w", padx=10)

        #Texto de output
        self.output = Text(self.frame_output, height=5, width=52)
        # self.output.insert(END, "tqm")
        self.output.pack()

    def borrar_texto(self):
        for entrada in self.entradas:
            entrada.delete(0, END)
        self.output.delete("1.0", END)

    def getValue(self, criterio):
        return self.entradas[criterio].get()
    
