import sys
from tkinter import *
import tkinter as tk
from itertools import cycle
from ui_main.ventanas.ventana_base import ventana
# from ui_main.ventanas.Ventana_principal import frame_principal, inicializar


frame_inicio = Frame(ventana)

def inicio():

    frame_inicio.pack()

    p1Frame=Frame(frame_inicio,width=530, height=650,background="grey")
    p1Frame.grid(row=0,column=0,padx=5,pady=5)
    p1Frame.grid_propagate(False)

    p2Frame=Frame(frame_inicio,width=530, height=650,bd=5, relief="solid", highlightbackground="red")
    p2Frame.grid(row=0,column=1,padx=5,pady=5)
    p2Frame.grid_propagate(False)

    p3Frame=Frame(p1Frame,width=520, height=100,bd=5, relief="solid", highlightbackground="red")
    p3Frame.grid(row=0,column=0,padx=5,pady=5)
    p3Frame.grid_propagate(False)

    p4Frame=Frame(p1Frame,width=520, height=535,bg="white")
    p4Frame.grid(row=1,column=0,padx=5,pady=0)
    p4Frame.grid_propagate(False)

    p5Frame=Frame(p2Frame,width=510, height=100,bg="white")
    p5Frame.grid(row=0,column=0,padx=5,pady=5)
    p5Frame.grid_propagate(False)

    p6Frame=Frame(p2Frame,width=510, height=525,bg="white")
    p6Frame.grid(row=1,column=0,padx=5,pady=0)
    p6Frame.grid_propagate(False)

    #Saludo de bienvenida
    saludo = "Bienvenido al sistema de gestion del hotel The Debugg Inn"

    label_bienvenida = Label(p3Frame, text=saludo, font=("Arial",12), fg="black")
    label_bienvenida.place(relx=0.5, rely=0.3, anchor="s")#esta centrado
    saludo2 = """Un lugar donde la comodidad y la tecnología se unen. Disfruten de su estancia 
    y sumérjanse en un ambiente inspirador diseñado especialmente para programadores como ustedes.
    \n¡Que tengan una estancia increíble en el Debugg Inn!"""
    label_saludo = Label(p3Frame, text=saludo2, font=("Arial",7), fg="black")
    label_saludo.place(relx=0.5, rely=0.35, anchor="n")



    descripcion = cycle(("  El sistema de The Debugg Inn permite hacer uso de funcionalidades como alojar y \n desalojar huespedes, reservar servicios extra para los clientes y generar \n una factura que refleje los gastos del huesped en su estancia", "")) # se activa al presionar el boton descripcion del menu
    label_descripcion = Label(p4Frame, font=("Arial",10), fg="black", background="white")
    label_descripcion.place(x=0, y=0)

    def mostrar_ocultar_Descripcion():
        label_descripcion.config(text=next(descripcion))

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
    uno = Label(p6Frame, width=250, height=250, bg='black', image=next(dict_imgs["arriba_izquierda"]))
    uno.grid(row=0, column=0, padx=0, pady=5)

    dos = Label(p6Frame, width=250, height=250, bg='black', image=next(dict_imgs["arriba_derecha"]))
    dos.grid(row=0, column=1, padx=0, pady=5)

    tres = Label(p6Frame, width=250, height=250, bg='black', image=next(dict_imgs["abajo_izquierda"]))
    tres.grid(row=1, column=0, padx=0, pady=5)

    cuatro = Label(p6Frame, width=250, height=250, bg='black', image=next(dict_imgs["abajo_derecha"]))
    cuatro.grid(row=1, column=1, padx=0, pady=5)

    #Breve hoja de vida de cada desarrolador
    #derecha superio (p5)

    #Cuando llega al ultimo se devuelve al inicio
    circulo = cycle(("Alejandro Feria", "Juan Miguel Márquez", "Stiven Julio Doval", "Samuel Gutierrez", "Abraham David Miguel"))

    hoja_vida = Label(p5Frame, text=next(circulo), font=("Arial", 10), fg="blue")
    hoja_vida.place(relx=0.5, rely=0.1, anchor=CENTER) #centra el texto
    hoja_vida.bind("<Button-1>", eveto_label)

    def abrir_ventana_principal():
        frame_inicio.destroy()
        ventana.config(menu=tk.Menu())
        frame_principal.pack()
        inicializar()


    #p4 abrir nueva pantalla
    boton_ventana_principal = Button(p4Frame, text="Abrir", width=5, height=1,background="lightgray", command=abrir_ventana_principal)
    boton_ventana_principal.place(relx=0.5, rely=0.98, anchor="s" )


    #Menu
    menu_inicio = tk.Menu(frame_inicio)
    ventana.config(menu=menu_inicio, height=30)

    inicio = tk.Menu(menu_inicio)
    menu_inicio.add_cascade(label="Menú", menu=inicio)
    inicio.add_command(label="Salir", command = lambda: sys.exit())
    inicio.add_command(label="Descripcion", command=mostrar_ocultar_Descripcion)


#************************************************************

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
    Archivo.add_command(label="Aplicación") #Terminar
    Archivo.add_command(label="Salir", command=salir) #terminar

    menu_inicio.add_cascade(menu=proseso_comsulta, label="Procesos y consultas")
    proseso_comsulta.add_command(label="Alojar Huésped")
    proseso_comsulta.add_command(label="Desalojar Huésped/Factura")
    proseso_comsulta.add_command(label="Restaurante y alimentación")
    proseso_comsulta.add_command(label="Transporte")
    proseso_comsulta.add_command(label="Servicios extra")
    
    menu_inicio.add_cascade(menu=ayuda, label="Ayuda")
    ayuda.add_command(label="Acerca de")

t = Label(frame_principal, text="hola", bg="orange")
t.grid()

def salir():
    frame_principal.destroy()
    frame_inicio.pack()

    
