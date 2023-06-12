import tkinter as tk
from tkinter import *
from ui_main.ventanas.ventana_base import ventana

frame_principal = Frame(ventana, bg="green", width=400, height=400)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)

t = Label(frame_principal, text="hola", bg="orange")
t.grid()
