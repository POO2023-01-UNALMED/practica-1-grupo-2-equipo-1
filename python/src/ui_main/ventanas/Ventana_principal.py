import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.FieldFrame import FieldFrame
from ui_main.main import hotel
from tkinter import messagebox

from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.hoteles.Hotel import Hotel, Habitacion
from ui_main.excepciones.excepciones import *

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

    try:
        for i, nombre_criterio in enumerate(frame_actual.criterios):
            if frame_actual.getValue(i) == "":
                raise CamposFaltantesError(nombre_criterio)
            l.append(frame_actual.getValue(i))
        return l
            # frame_actual.output.insert(
            #     END, nombre_criterio + ": " + frame_actual.getValue(i) + "\n"
            #     )
    except CamposFaltantesError as e:
        print(e)

def agregar_huesped(hotel:Hotel):
    nombre, id, cantidad, dias, id_habitacion = obtenerValores()
    cabeza = Huesped(nombre, id)
    habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
    grupo:GrupoHuespedes = GrupoHuespedes(dias, cabeza, habitacion)
    habitacion.set_grupo_huespedes(grupo)
    frame_actual.output.insert(END,
        "Han sido agregados con exito\n" + str(grupo) + "\n" + str(habitacion)
        )
    
def desalojar_huesped(hotel:Hotel):
    #se pide el id para saber que habitacion se va a desalojar
    id_habitacion = obtenerValores()[0]
    habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))

    grupo = habitacion.get_grupo_huespedes()

    #se calcula y se muestra la factura
    frame_actual.output.insert(END,str(grupo)+
                               " El precio total de su factura es: "+str(grupo.get_factura().CalcularPrecioFactura()))
    
    #eliminar reserva del restaurante

    #eliminar transporte    


    habitacion.borrar_grupo()



def reservarRestaurante(hotel:Hotel):
    return None

def generar_alojar_huesped():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_alojo
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command=lambda: agregar_huesped(hotel))

 
def generar_desalojarHuesped():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_desalojo
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command=lambda: desalojar_huesped(hotel))

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
    Archivo.add_command(label="Aplicación", command= aplicacion) #Terminar
    Archivo.add_command(label="Salir", command=salir) #terminar

    menu_inicio.add_cascade(menu=proceso_consulta, label="Procesos y consultas")
    proceso_consulta.add_command(label="Alojar Huésped", command= generar_alojar_huesped)
    proceso_consulta.add_command(label="Desalojar Huésped/Factura", command= generar_desalojarHuesped)
    proceso_consulta.add_command(label="Restaurante y alimentación", command= generar_alimentacion)
    proceso_consulta.add_command(label="Transporte", command= generar_transporte)
    proceso_consulta.add_command(label="Servicios extra", command= generar_servExtra)

    
    menu_inicio.add_cascade(menu=estado, label="Ver")
    estado.add_command(label="Habitaciones",  command=hotel.mostrar_habitaciones)
    estado.add_command(label="Factura")

    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")
    ayuda.add_command(label="Acerca de", command= acercaDe)



def salir():
    from ui_main.ventanas.Ventana_inicio import frame_inicio, menu_inicio
    ventana.config(menu=tk.Menu())
    frame_principal.pack_forget()
    frame_inicio.pack()
    ventana.config(menu=menu_inicio, height=30)

def aplicacion(): 
    descripcion = "El sistema de The Debugg Inn permite hacer uso de funcionalidades como alojar y desalojar huespedes, reservar servicios extra para los clientes y generar una factura que refleje los gastos del huesped en su estancia"
    messagebox.showinfo("Descripción de la aplicación", descripcion)

def acercaDe(): 
    descripcion = "Aplicación desarrollada por:\nAlejandro Feria\nAbraham David Miguel\nJuan Miguel Márquez\nSamuel Gutierrez\nStiven Julio Doval"
    messagebox.showinfo("Acerda de", descripcion)
