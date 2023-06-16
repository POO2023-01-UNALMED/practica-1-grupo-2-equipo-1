from tkinter import Tk
from tkinter import *
import tkinter as tk

ventana = Tk()
ventana.title("Inicio")
ventana.geometry("1090x670")
ventana.pack_propagate(False)
ventana.grid_propagate(False)

frame_principal = Frame(ventana)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

# t = Label(frame_principal, text="hola", bg="orange")
# t.grid()

menu_principal = tk.Menu(frame_principal)
ventana.config(menu=menu_principal)

principal = tk.Menu(menu_principal)
menu_principal.add_cascade(label="Menu", menu=principal)

ventana.config(menu=tk.Menu())

menu_principal2 = tk.Menu(frame_principal)
ventana.config(menu=menu_principal2)

principal2 = tk.Menu(menu_principal2)
menu_principal2.add_cascade(label="Menu", menu=principal2)

ventana.mainloop()
