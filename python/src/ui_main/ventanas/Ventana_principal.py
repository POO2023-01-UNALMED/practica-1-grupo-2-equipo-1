import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.FieldFrame import FieldFrame
from ui_main.main import hotel

frame_principal = Frame(ventana, width=1090, height=670)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

frame_alojo = FieldFrame(frame_principal,"Criterios", ["Nombre", "Id", "Cantidad", "Dias", "Habitacion"], "Datos" ,[""]*5, None)
frame_desalojo = FieldFrame(frame_principal, "Criterios", ["Id de la Habitacion"], "Datos", [""], None)
frame_transporte = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
frame_restaurante = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
frame_servExtra = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
#aqui iran los demas frames...

#Lo que aparece la primera vez que se abre la ventana principal, despues se borra
frame_actual = Frame(frame_principal) #viene por defecto
frame_actual.pack()
como_usar = Label(frame_actual,text="Como usar la aplicacion")
como_usar.pack()

def obtenerValores() -> list:
    l = []
    for i, nombre_criterio in enumerate(frame_actual.criterios):
        l.append(frame_actual.getValue(i))
    return l
        # frame_actual.output.insert(
        #     END, nombre_criterio + ": " + frame_actual.getValue(i) + "\n"
        #     )


def generar_alojar_huesped():
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
    frame_actual.boton_aceptar.config(command=obtenerValores)

def generar_transporte():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_transporte
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command= obtenerValores)

def generar_alimentacion():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_restaurante
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command = obtenerValores)

def generar_servExtra():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_servExtra
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command = obtenerValores)

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
    proceso_consulta.add_command(label="Alojar Huésped", command= generar_alojar_huesped)
    proceso_consulta.add_command(label="Desalojar Huésped/Factura", command= generar_desalojarHuesped)
    proceso_consulta.add_command(label="Restaurante y alimentación", command= generar_alimentacion)
    proceso_consulta.add_command(label="Transporte", command= generar_transporte)
    proceso_consulta.add_command(label="Servicios extra", command= generar_servExtra)
    
    menu_inicio.add_cascade(menu=estado, label="Ver")
    estado.add_command(label="Habitaciones",  command=hotel.mostrar_habitaciones)

    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")
    ayuda.add_command(label="Acerca de")



def salir():
    from ui_main.ventanas.Ventana_inicio import frame_inicio, menu_inicio
    ventana.config(menu=tk.Menu())
    frame_principal.pack_forget()
    frame_inicio.pack()
    ventana.config(menu=menu_inicio, height=30)
