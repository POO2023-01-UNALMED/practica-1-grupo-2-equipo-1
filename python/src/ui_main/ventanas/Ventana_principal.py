import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana

frame_principal = Frame(ventana, bg="green", width=400, height=400)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

def inicializar():
    menu_inicio = tk.Menu(frame_principal)
    ventana.config(menu=menu_inicio, height=30)

    Archivo = tk.Menu(menu_inicio)
    proseso_comsulta = tk.Menu(menu_inicio)
    ayuda = tk.Menu(menu_inicio)

    menu_inicio.add_cascade(menu=Archivo, label="Archivo")
    menu_inicio.add_cascade(menu=proseso_comsulta, label="Procesos y consultas")
    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")

t = Label(frame_principal, text="hola", bg="orange")
t.grid()



