import sys
from tkinter import *
import tkinter as tk
from itertools import cycle
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.Ventana_principal import frame_principal, inicializar
from base_datos.Serializador import serializar
from ui_main.main import hotel



frame_inicio = Frame(ventana)
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
label_saludo = Label(p3Frame, text=saludo2, font=("Arial",8), fg="black")
label_saludo.place(relx=0.5, rely=0.35, anchor="n")



descripcion = cycle(("  El sistema de The Debugg Inn permite hacer uso de funcionalidades como alojar y \n desalojar huespedes, reservar servicios extra para los clientes y generar \n una factura que refleje los gastos del huesped en su estancia", "")) # se activa al presionar el boton descripcion del menu
label_descripcion = Label(p4Frame, font=("Arial",10), fg="black", background="white")
label_descripcion.place(x=0, y=0)

def mostrar_ocultar_Descripcion():
    label_descripcion.config(text=next(descripcion))


#Imagene3
# Imágenes
root_img = "python\\src\\ui_main\\ventanas\\imagenes\\"
dict_imgs = {
    "arriba_izquierda": cycle(
        (
            PhotoImage(file=root_img + "alejo1.png").subsample(2,2),
            PhotoImage(file=root_img + "Miguel1.png"),
            PhotoImage(file=root_img + "stiven_1.png").subsample(1,1),
            PhotoImage(file=root_img + "Samuel1.png").subsample(4,4),
            PhotoImage(file=root_img + "abraham1.png").subsample(5,5)
        )
    ),
    "arriba_derecha": cycle(
        (
            PhotoImage(file=root_img + "alejo2.png"),
            PhotoImage(file=root_img + "Miguel2.png").subsample(3,3),
            PhotoImage(file=root_img + "stiven_2.png").subsample(6,6),
            PhotoImage(file=root_img + "Samuel2.png").subsample(10,10),
            PhotoImage(file=root_img + "abraham2.png").subsample(4,4)
        )
    ),
    "abajo_izquierda": cycle(
        (
            PhotoImage(file=root_img + "alejo3.png").subsample(3,3),
            PhotoImage(file=root_img + "Miguel3.png").subsample(5,5),
            PhotoImage(file=root_img + "stiven_3.png").subsample(6,6),
            PhotoImage(file=root_img + "Samuel3.png").subsample(4,4),
            PhotoImage(file=root_img + "abraham3.png").subsample(3,3)
        )
    ),
    "abajo_derecha": cycle(
        (
            PhotoImage(file=root_img + "alejo4.png"),
            PhotoImage(file=root_img + "Miguel4.png").subsample(6,6),
            PhotoImage(file=root_img + "stiven_4.png").subsample(1,1),
            PhotoImage(file=root_img + "Samuel4.png").subsample(4,4),
            PhotoImage(file=root_img + "abraham4.png").subsample(5,5)
        )
    ),
    
    "Hotel": cycle(
        (
            PhotoImage(file=root_img + "hotel_1.png").zoom(2,2),
            PhotoImage(file=root_img + "hotel_2.png").zoom(2,2),
            PhotoImage(file=root_img + "hotel_3.png").subsample(2,2),
            PhotoImage(file=root_img + "hotel_4.png").subsample(2,2),
        )
    )
}


def evento_hotel(evento):
    cinco.config(image=next(dict_imgs["Hotel"]))


def eveto_label(evento):
    # cambio nombre
    hoja_vida.config(text=next(circulo))
    # cambio imágenes
    uno.config(image=next(dict_imgs["arriba_izquierda"]))
    dos.config(image=next(dict_imgs["arriba_derecha"]))
    tres.config(image=next(dict_imgs["abajo_izquierda"]))
    cuatro.config(image=next(dict_imgs["abajo_derecha"]))


# Cambiar imágenes


uno = Label(p6Frame, width=250, height=250, bg="white", image=next(dict_imgs["arriba_izquierda"]), bd=1, relief="solid")
uno.grid(row=0, column=0, padx=0, pady=5)


dos = Label(p6Frame, width=250, height=250, bg="white", image=next(dict_imgs["arriba_derecha"]), bd=1, relief="solid")
dos.grid(row=0, column=1, padx=0, pady=5)


tres = Label(p6Frame, width=250, height=250, bg="white", image=next(dict_imgs["abajo_izquierda"]), bd=1, relief="solid")
tres.grid(row=1, column=0, padx=0, pady=5)


cuatro = Label(p6Frame, width=250, height=250, bg="white", image=next(dict_imgs["abajo_derecha"]), bd=1, relief="solid")
cuatro.grid(row=1, column=1, padx=0, pady=5)


cinco = Label(p4Frame, width=500, height=400, bg="white", image=next(dict_imgs["Hotel"]), bd=2, relief="solid")
cinco.place(relx=0.5, rely=0.9,anchor="s")
cinco.bind("<Enter>", evento_hotel) 



#Breve hoja de vida de cada desarrollador
#derecha superior (p5)

#Cuando llega al ultimo se devuelve al inicio


circulo = cycle(("Alejandro Feria\nHoja de Vida\n\nFecha de Nacimiento:20/07/2004\nGustos: Programar y tocar musica <3"
                 , "Juan Miguel Márquez\nHoja de Vida\n\nFecha de Nacimiento:02/05/2004\nGustos: Ir al gimnasio, escuchar música y cocinar :)"
                 ,"Stiven Julio Doval\nHoja de Vida\n\nFecha de Nacimiento:09/06/2004\nGustos: Salir con amigos, cocinar, ver anime y escuchar musica"
                 ,"Samuel Gutierrez\nHoja de Vida\n\nFecha de Nacimiento: 09/03/2004\nGustos: Salir con amigos y escuchar musica"
                 , "Abraham David Miguel Cardenas\nHoja de Vida\n\nFecha de Nacimiento:10/10/2004\nGustos: Estar con mis amigos, ver series y escuchar hip hop/rap")
                 )

#Especificaciones del label


hoja_vida = Label(p5Frame, text=next(circulo), font=("Times", 10), fg="black")
hoja_vida.place(relx=0.5, rely=0.5, anchor=CENTER) #centra el texto
hoja_vida.bind("<Button-1>", eveto_label)



def abrir_ventana_principal():
    frame_inicio.pack_forget()
    ventana.config(menu=tk.Menu())
    frame_principal.pack()
    inicializar()



#p4 abrir nueva pantalla
boton_ventana_principal = Button(p4Frame, text="Abrir", width=6, height=1,background="lightgray", command=abrir_ventana_principal, font=("Helvetica", 12, "bold"))
boton_ventana_principal.place(relx=0.5, rely=0.98, anchor="s" )



#Menu
menu_inicio = tk.Menu(frame_inicio)
ventana.config(menu=menu_inicio, height=30)


def salir():
    serializar(hotel)
    sys.exit()



inicio = tk.Menu(menu_inicio)
menu_inicio.add_cascade(label="Menú", menu=inicio)
inicio.add_command(label="Salir", command = salir)
inicio.add_command(label="Descripcion", command=mostrar_ocultar_Descripcion)
