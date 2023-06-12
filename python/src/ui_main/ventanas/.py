from tkinter import *
import tkinter as tk
from itertools import cycle

ventana = tk.Tk()
ventana.title("Inicio")
ventana.geometry("1080x720")

p1Frame=Frame(ventana,height=450,width=425,bg="red")
p1Frame.grid(row=0,column=0,padx=5,pady=5)
p1Frame.grid_propagate(False)

p2Frame=Frame(ventana,height=450,width=425,bg="blue")
p2Frame.grid(row=0,column=1,padx=5,pady=5)
p2Frame.grid_propagate(False)

p3Frame=Frame(p1Frame,height=70,width=415,bg="green")
p3Frame.grid(row=0,column=0,padx=5,pady=5)
p3Frame.grid_propagate(False)

p4Frame=Frame(p1Frame,height=365,width=415,bg="green")
p4Frame.grid(row=1,column=0,padx=5,pady=5)
p4Frame.grid_propagate(False)

p5Frame=Frame(p2Frame,height=70,width=415,bg="yellow")
p5Frame.grid(row=0,column=0,padx=5,pady=5)

p6Frame=Frame(p2Frame,height=365,width=415,bg="yellow")
p6Frame.grid(row=1,column=0,padx=5,pady=5)

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

uno = Label(p4Frame)
uno.grid(row=0, column=0, padx=12, pady=12)
imagen = PhotoImage(file=r"python\src\ui_main\ventanas\imagenes\img1_2.png", name="je", width=100, height=100)
uno.config(image=imagen)

ventana.mainloop()
