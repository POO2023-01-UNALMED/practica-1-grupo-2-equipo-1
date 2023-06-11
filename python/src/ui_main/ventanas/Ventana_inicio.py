from tkinter import *
import tkinter as tk

class Ventana_inicio(tk.Tk):
    """docstring for Ventana_inicio."""
    def __init__(self):
        super().__init__()

        self.title("Inicio")
        # self.geometry("1080x720")

        p1Frame=Frame(self,height=450,width=425,bg="red")
        p1Frame.grid(row=0,column=0,columnspan=1,rowspan=1,padx=5,pady=5)

        p2Frame=Frame(self,height=450,width=425,bg="blue")
        p2Frame.grid(row=0,column=1,columnspan=1,rowspan=1,padx=5,pady=5)

        p3Frame=Frame(p1Frame,height=70,width=415,bg="green")
        p3Frame.grid(row=0,column=0,columnspan=1,rowspan=1,padx=5,pady=5)

        p4Frame=Frame(p1Frame,height=365,width=415,bg="green")
        p4Frame.grid(row=1,column=0,columnspan=2,rowspan=1,padx=5,pady=5)

        p5Frame=Frame(p2Frame,height=70,width=415,bg="yellow")
        p5Frame.grid(row=0,column=0,columnspan=1,rowspan=1,padx=5,pady=5)

        p6Frame=Frame(p2Frame,height=365,width=415,bg="yellow")
        p6Frame.grid(row=1,column=0,columnspan=2,rowspan=1,padx=5,pady=5)

        saludo = "Bienvenido al sistema de gestion de hotel"
        label_bienvenida = Label(p3Frame, text=saludo, font=("Arial",10), fg="blue", background="green")
        label_bienvenida.place(relx=0.5, rely=0.5, anchor=CENTER) #esta centrado
