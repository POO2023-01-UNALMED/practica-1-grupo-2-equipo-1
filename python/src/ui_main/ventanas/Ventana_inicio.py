from tkinter import *
import tkinter as tk
from itertools import cycle
from ui_main.ventanas.ventana_base import ventana


label_inicio = Label(ventana)
label_inicio.pack()

p1Frame=Frame(label_inicio,width=530, height=650,bg="red")
p1Frame.grid(row=0,column=0,padx=5,pady=5)
p1Frame.grid_propagate(False)

p2Frame=Frame(label_inicio,width=530, height=650,bg="blue")
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

#Breve hoja de vida de cada desarrolador
#derecha superio (p5)

#Cuando lllega al ultimo se devuelve al inicio
circulo = cycle(("Alejandro", "Miguel", "Stiven", "Samuel", "Abraham"))

hoja_vida = Label(p5Frame, text=next(circulo), font=("Arial", 10), fg="blue")
hoja_vida.place(relx=0.5, rely=0.5, anchor=CENTER) #centra el texto
hoja_vida.bind("<Button-1>", lambda _: hoja_vida.config(text=next(circulo)))

#Imagenes
dict_imgs = {
    "Alejandro": ("img1", "img2"),
    "M": ("img3", "img4")
}

#cambiar imagenes
# uno = Label(p4Frame, width=200, height=180)
# uno.grid(row=0, column=0, padx=0, pady=0)
# imagen = PhotoImage(file=r"python\src\ui_main\ventanas\imagenes\img1_2.png", name="je")
# uno.config(image=imagen)

# dos = Label(p4Frame, height=200, width=180, bg="black", image=imagen)
# dos.grid(row=0, column=1, padx=0, pady=0)

# tres = Label(p4Frame, height=200, width=180, bg="black", image=imagen)
# tres.grid(row=1, column=0, padx=0, pady=0)

# cuatro = Label(p4Frame, height=200, width=180, bg="black", image=imagen)
# cuatro.grid(row=1, column=1, padx=0, pady=0)

