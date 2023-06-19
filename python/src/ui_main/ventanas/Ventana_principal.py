import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.FieldFrame import FieldFrame

frame_principal = Frame(ventana, width=1090, height=670)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

frame_alojo = FieldFrame(frame_principal,"Criterios", ["Nombre", "Id", "Cantidad", "Dias", "Habitacion"], "Datos" ,[""]*5, None)
frame_desalojo = FieldFrame(frame_principal, "Criterios", ["Id de la Habitacion"], "Datos", [""], None)

def obtenerValores():
    for i, nombre_criterio in enumerate(frame_actual.criterios):
        print(nombre_criterio + ": " + frame_actual.getValue(i))


frame_actual = frame_alojo #viene por defecto
frame_actual.pack()
frame_actual.boton_aceptar.config(command=obtenerValores)


def alojar_huesped():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_alojo
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command=obtenerValores)


def desalojarHuesped():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_desalojo
    frame_actual.pack()


def comando_boton_aceptar():
    for i, nombre_criterio in enumerate(frame_actual.criterios):
        print(nombre_criterio + ": " + frame_actual.getValue(i))


def inicializar():
    menu_inicio = tk.Menu(frame_principal)
    ventana.config(menu=menu_inicio, height=30)

    Archivo = tk.Menu(menu_inicio)
    proceso_consulta = tk.Menu(menu_inicio)
    ayuda = tk.Menu(menu_inicio)
    estado = tk.Menu(menu_inicio)

    menu_inicio.add_cascade(menu=Archivo, label="Archivo")
    Archivo.add_command(label="Aplicación") #Terminar
    Archivo.add_command(label="Salir", command=salir) #terminar

    menu_inicio.add_cascade(menu=proceso_consulta, label="Procesos y consultas")
    proceso_consulta.add_command(label="Alojar Huésped", command=alojar_huesped)
    proceso_consulta.add_command(label="Desalojar Huésped/Factura", command=desalojarHuesped)
    proceso_consulta.add_command(label="Restaurante y alimentación")
    proceso_consulta.add_command(label="Transporte")
    proceso_consulta.add_command(label="Servicios extra")
    
    menu_inicio.add_cascade(menu=estado, label="ver")
    estado.add_command(label="Habitaciones",  command=lambda: print("habitaciones"))

    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")
    ayuda.add_command(label="Acerca de")



def salir():
    from ui_main.ventanas.Ventana_inicio import frame_inicio, menu_inicio
    ventana.config(menu=tk.Menu())
    frame_principal.pack_forget()
    frame_inicio.pack()
    ventana.config(menu=menu_inicio, height=30)


    

print(frame_principal.children)
