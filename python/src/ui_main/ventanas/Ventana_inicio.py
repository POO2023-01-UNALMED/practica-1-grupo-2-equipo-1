from tkinter import *
import tkinter as tk
from itertools import cycle
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.Ventana_principal import frame_principal


frame_inicio = Frame(ventana)
frame_inicio.pack()

p1Frame=Frame(frame_inicio,width=530, height=650,bg="red")
p1Frame.grid(row=0,column=0,padx=5,pady=5)
p1Frame.grid_propagate(False)

p2Frame=Frame(frame_inicio,width=530, height=650,bg="blue")
p2Frame.grid(row=0,column=1,padx=5,pady=5)
p2Frame.grid_propagate(False)

p3Frame=Frame(p1Frame,width=520, height=100,bg="green")
p3Frame.grid(row=0,column=0,padx=5,pady=5)
p3Frame.grid_propagate(False)

p4Frame=Frame(p1Frame,width=520, height=535,bg="green")
p4Frame.grid(row=1,column=0,padx=5,pady=0)
p4Frame.grid_propagate(False)

p5Frame=Frame(p2Frame,width=520, height=100,bg="yellow")
p5Frame.grid(row=0,column=0,padx=5,pady=5)
p5Frame.grid_propagate(False)

p6Frame=Frame(p2Frame,width=520, height=535,bg="yellow")
p6Frame.grid(row=1,column=0,padx=5,pady=0)
p6Frame.grid_propagate(False)

#Saludo de bienvenida
saludo = "Bienvenido al sistema de gestion de hotel"
label_bienvenida = Label(p3Frame, text=saludo, font=("Arial",10), fg="blue", background="green")
label_bienvenida.place(relx=0.5, rely=0.5, anchor=CENTER) #esta centrado

#Imagene3
root_img = "python\\src\\ui_main\\ventanas\\imagenes\\"
dict_imgs = {
    "arriba_izquierda": cycle((PhotoImage(file=root_img + "cr7_1.png"),
                   PhotoImage(file=root_img + "cr7_2.png"),
                   PhotoImage(file=root_img + "cr7_3.png"),
                   PhotoImage(file=root_img + "cr7_4.png"))),
    "arriba_derecha": cycle((PhotoImage(file = root_img + "messi_1.png"),
                             PhotoImage(file = root_img + "messi_2.png"),
                             PhotoImage(file = root_img + "messi_3.png"),
                             PhotoImage(file = root_img + "messi_4.png"))),
    "abajo_izquierda": cycle((PhotoImage(file=root_img + "cr7_1.png"),
                            PhotoImage(file=root_img + "cr7_2.png"),
                            PhotoImage(file=root_img + "cr7_3.png"),
                            PhotoImage(file=root_img + "cr7_4.png"))),
    "abajo_derecha": cycle((PhotoImage(file = root_img + "messi_1.png"),
                             PhotoImage(file = root_img + "messi_2.png"),
                             PhotoImage(file = root_img + "messi_3.png"),
                             PhotoImage(file = root_img + "messi_4.png")))
}


def eveto_label(evento):
    #cambio nombre
    hoja_vida.config(text=next(circulo))
    #cambio imagenes

    uno.config(image=next(dict_imgs["arriba_izquierda"]))
    dos.config(image=next(dict_imgs["arriba_derecha"]))
    tres.config(image=next(dict_imgs["abajo_izquierda"]))
    cuatro.config(image=next(dict_imgs["abajo_derecha"]))


# imagen = PhotoImage(file=r"python\src\ui_main\ventanas\imagenes\cr7_3.png")
#cambiar imagenes
uno = Label(p6Frame, width=255, height=250, bg='black', image=next(dict_imgs["arriba_izquierda"]))
uno.grid(row=0, column=0, padx=0, pady=5)

dos = Label(p6Frame, width=255, height=250, bg='black', image=next(dict_imgs["arriba_derecha"]))
dos.grid(row=0, column=1, padx=0, pady=5)

tres = Label(p6Frame, width=255, height=250, bg='black', image=next(dict_imgs["abajo_izquierda"]))
tres.grid(row=1, column=0, padx=0, pady=5)

cuatro = Label(p6Frame, width=255, height=250, bg='black', image=next(dict_imgs["abajo_derecha"]))
cuatro.grid(row=1, column=1, padx=0, pady=5)

#Breve hoja de vida de cada desarrolador
#derecha superio (p5)

#Cuando lllega al ultimo se devuelve al inicio
circulo = cycle(("Alejandro", "Miguel", "Stiven", "Samuel", "Abraham"))

hoja_vida = Label(p5Frame, text=next(circulo), font=("Arial", 10), fg="blue")
hoja_vida.place(relx=0.5, rely=0.5, anchor=CENTER) #centra el texto
hoja_vida.bind("<Button-1>", eveto_label)

def abrir_ventana_principal():
    frame_inicio.destroy()
    frame_principal.place(x = 20, y=20)


#p4 abrir nueva pantalla
boton_ventana_principal = Button(p4Frame, text="Abrir", width=10, height=10, command=abrir_ventana_principal)
boton_ventana_principal.place(relx=0.5, rely=0.5, anchor=CENTER)
