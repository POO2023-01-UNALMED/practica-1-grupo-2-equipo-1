import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.Ventana_inicio import *

frame_principal = Frame(ventana, bg="green", width=400, height=400)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

def inicializar():
    menu_inicio = tk.Menu(frame_principal)
    ventana.config(menu=menu_inicio, height=30)

    Archivo = tk.Menu(menu_inicio)
    proceso_consulta = tk.Menu(menu_inicio)
    ayuda = tk.Menu(menu_inicio)

    menu_inicio.add_cascade(menu=Archivo, label="Archivo")
    Archivo.add_command(label="Aplicación") #Terminar
    Archivo.add_command(label="Salir", command=salir) #terminar

    menu_inicio.add_cascade(menu=proceso_consulta, label="Procesos y consultas")
    proceso_consulta.add_command(label="Alojar Huésped")
    proceso_consulta.add_command(label="Desalojar Huésped/Factura")
    proceso_consulta.add_command(label="Restaurante y alimentación")
    proceso_consulta.add_command(label="Transporte")
    proceso_consulta.add_command(label="Servicios extra")
    
    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")
    ayuda.add_command(label="Acerca de")

t = Label(frame_principal, text="hola", bg="orange")
t.grid()

def salir():
    frame_principal.destroy()
    

