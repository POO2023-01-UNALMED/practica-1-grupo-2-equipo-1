import tkinter as tk
from tkinter import *
from tkinter import ttk
from ui_main.ventanas.ventana_base import ventana
from ui_main.ventanas.FieldFrame import FieldFrame
from ui_main.main import hotel
from tkinter import messagebox
from ui_main.excepciones.excepciones import CamposFaltantesError

from gestor_aplicacion.personas.GrupoHuespedes import GrupoHuespedes
from gestor_aplicacion.personas.Huesped import Huesped
from gestor_aplicacion.hoteles.Hotel import Hotel, Habitacion
from ui_main.excepciones.excepciones import *
from gestor_aplicacion.servicios_extra.Servicios_extra import ServiciosExtra
from gestor_aplicacion.restaurantes.Restaurante import Restaurante
from gestor_aplicacion.transporte.Vehiculo import Vehiculo, Vehiculos
from gestor_aplicacion.restaurantes.Mesa import Mesa


frame_principal = Frame(ventana, width=1090, height=670)
frame_principal.pack_propagate(False)
frame_principal.grid_propagate(False)


frame_alojo = FieldFrame(frame_principal,"Criterios", ["Nombre", "Id", "Cantidad", "Dias", "Habitacion"], "Datos" ,[""]*5, None)
frame_desalojo = FieldFrame(frame_principal, "Criterios", ["Id de la Habitacion"], "Datos", [""], None)
frame_transporte = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
frame_restaurante = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
frame_servExtra = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
frame_factura = FieldFrame(frame_principal, "Criterios", ["Id de la habitación"], "Datos", [""], None)
#aqui iran los demas frames...


#Lo que aparece la primera vez que se abre la ventana principal, despues se borra
frame_actual = Frame(frame_principal) #viene por defecto
frame_actual.pack()


como_usar = Label(frame_actual,text="\n\nCOMO USAR LA APLICACION\n\n\n"
                  
                  "Archivo:\n"
                  "      ▪ Aplicación: Se despliega una ventana de diálogo con la información básica de lo que hace la aplicación.\n"
                  "      ▪ Salir: retorna a la Ventana de Inicio del programa.\n\n"

                  "Procesos y Consultas:\n"
                  "      ▪ Alojar Huesped: Se llena el formulario y se registra a el/los huespede/s en una habitacion del hotel.\n"
                  "      ▪ Desalojar Huesped/Factura: Se llena el formulario, y los huespedes desalojan la habitacion recibiendo la factura total del hospedaje.\n"
                  "      ▪ Restaurante y Alimentacion: Se da la informacion de la habitacion para proceder a hacer la reserva de una mesa de algun restaurante.\n"
                  "      ▪ Transporte: Se da la informacion de la habitacion para proceder a hacer la reservacion de un transporte.\n"
                  "      ▪ Servicios Extra: Se da la informacion de la habitacion para agregar algun servicio extra que se desea usar.\n\n"

                  "Ver:\n"
                  "      ▪ Habitaciones: Muestra las habitaciones que hay en todo el hotel (Disponibles y Ocupadas).\n"
                  "      ▪ Factura: Se da la informacion de la habitacion a la que se desea ver la factura.\n\n"

                  "Ayuda:\n"
                  "      ▪ Acerca de: muestra una ventana de diálogo con los nombres de los dueños del hotel.\n"

                  , font=("Times",14)
                  , fg="black")



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
        messagebox.showerror("Campos faltantes", str(e))
        return [None for c in frame_actual.criterios]
    
        

#FUNCIONALIDAD ALOJAR HUESPEDES
def agregar_huesped(hotel:Hotel):
    nombre, id, cantidad, dias, id_habitacion = obtenerValores()
    if nombre == None:
        return 0; #salir de la apliacion
    cabeza = Huesped(nombre, id)
    
    try:
        if not isinstance(int(dias),int):
            raise TipadoNoValido
        
        if not isinstance(int(cantidad),int):
            raise TipadoNoValido

        if not isinstance(int(id),int):
            raise TipadoNoValido
        
        if not isinstance(nombre,str):
            raise TipadoNoValido
    except TipadoNoValido as e:
        messagebox.showerror("Error", e)
        return 0
    except ValueError as e:
        messagebox.showerror("Error", "Error con los tipos de datos")
        return 0
    
    try:
        habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
        if habitacion == None:
            raise HabitacionNoExiste
        
        #Si la capacidad es menor a las personas registradas
        if int(habitacion._capacidad) < int(cantidad):
            pass

        if (habitacion.isOcupado()==False):
            grupo:GrupoHuespedes = GrupoHuespedes(dias, cabeza, habitacion)
            habitacion.set_grupo_huespedes(grupo)
            HabOcupada(nombre, id_habitacion)
            frame_actual.output.insert(END,
                "Han sido agregados con exito\n" + str(grupo) + "\n" + str(habitacion)
                )
        else:
            raise habitacionOcupada(habitacion)
    except HabitacionNoExiste as e:
        messagebox.showerror("Error", e)
        return 0 #terminar funcionalidad
    except ValueError as e:
        messagebox.showerror("Error", e)#pasar letra en vez de numero
        return 0 #Salirse
    except habitacionOcupada as e:
        messagebox.showerror("Incorrecto",e)
        return 0
        
  

#DESALOJAR HUESPEDES    
def desalojar_huesped(hotel:Hotel):
    #se pide el id para saber que habitacion se va a desalojar
    id_habitacion = obtenerValores()[0]
    
    try:
        habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))

        grupo = habitacion.get_grupo_huespedes()

        if (habitacion.isOcupado() == True):
            #se calcula y se muestra la factura
            frame_actual.output.insert(END,str(grupo)+
                               " El precio total de su factura es: "+str(grupo.get_factura().CalcularPrecioFactura()))
    
            #eliminar reserva del restaurante
            if (grupo.get_mesa_reservada() != None):
                grupo.get_mesa_reservada().vaciarMesa()
                grupo.set_mesa_reservada(None)
                frame_actual.output.insert(END,"\nReserva de restaurante eliminada")
            else : 
                frame_actual.output.insert(END,"\nNo se reservó ningun restaurante")
        
            #eliminar transporte  
            if (grupo.get_vehiculo_reservado() != None):
                grupo.get_vehiculo_reservado().desocuparVehiculo().get_vehiculo_reservado(None)
                frame_actual.output.insert(END,"\nReserva de vehiculo eliminada")

            else : 
                frame_actual.output.insert(END,"\nNo se reservó ningun vehiculo")  


            habitacion.borrar_grupo()
            HabDesocupada()
        
    
        else:
            messagebox.showerror("Incorrecto","Esta habitacion ya se encuentra desocupada")

    except ValueError as e:
        messagebox.showerror("Error", e)#pasar letra en vez de numero
        return 0 #Salirse


#FUNCIONALIDAD SERVICIOS EXTRA
def servicios_extra(hotel: Hotel):
    try:
        id_habitacion = obtenerValores()[0]
        habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
        if (habitacion.isOcupado() == False): #Si esta desocupada que no siga
            raise habitacionDesocupada()
        grupo:GrupoHuespedes = habitacion.get_grupo_huespedes()
    except Exception as e:
            messagebox.showerror("Error", "No hay gente en esta habitacion")
            return 0 #salir de la funcionalidad
        

    ventana_secundaria = Toplevel()
    ventana_secundaria.geometry("500x500")
    ventana_secundaria.title("Seleccion servicio extra")

    Label(ventana_secundaria, text="Seleccion un servicio").pack()
    #comboBox
    opciones = [f"{s.idServicio}:{s.name}, {s.precioServicio}" for s in ServiciosExtra]
    comboBox = ttk.Combobox(master=ventana_secundaria,values= opciones, textvariable="...")
    comboBox.pack()
    def seleccionServicio():
        servicio_seleccionado = ServiciosExtra.buscarPorId(comboBox.get()[0])  #devulve el primer caracter 1 2 3
        grupo.get_factura().FacturaServiciosExtra += servicio_seleccionado.precioServicio
        ventana_secundaria.destroy()
        frame_actual.output.insert(END,"Has seleccionado el: "+str(servicio_seleccionado))

    boton_combobox = Button(master=ventana_secundaria, text="Seleccionar", command=seleccionServicio)
    boton_combobox.pack()

    # comboBox.bind("<<ComboboxSelected>>", seleccionServicio)



#FUNCIONALIDAD RESERVAR RESTAURANTES
def reservarRestaurante(hotel:Hotel):
    try:
        id_habitacion = obtenerValores()[0]
        habitacion: Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
        if not habitacion.isOcupado():  # Si está desocupada, salir
            raise habitacionDesocupada()
        grupo: GrupoHuespedes = habitacion.get_grupo_huespedes()
    except Exception as e:
        messagebox.showerror("Error", "No hay gente en esta habitación o la mesa no está asignada")
        return 0  # Salir de la funcionalidad
    
    ventana_emergente = Toplevel()
    ventana_emergente.geometry("500x500")
    ventana_emergente.title("Seleccione un Restaurante")

    Label(ventana_emergente, text="Seleccione un Restaurante").pack()
    # ComboBox
    opciones = [f"{r.idRestaurante}:{r.name}, {r.getPrecioResetaurante()}" for r in Restaurante]
    comboBox = ttk.Combobox(master=ventana_emergente, width=40, values=opciones, textvariable="...")
    comboBox.pack()

    def seleccionRestaurante():
        restaurante_seleccionado = Restaurante.buscarPorId(comboBox.get()[0])
        
        grupo.get_factura().FacturaRestaurante += restaurante_seleccionado.precioRestaurante
        mesa= Mesa(hotel.seleccionar_habitacion_porId(int(id_habitacion)))
        mesa.asignarDueños(grupo)  # Asignar la mesa al grupo de huéspedes
        mesa.setOcupado(True)  # Marcar la mesa como ocupada
        ventana_emergente.destroy()
        frame_actual.output.delete("1.0", END)  # Borrar el contenido existente
        frame_actual.output.insert(END, "Has seleccionado el: " + str(restaurante_seleccionado.name))

    boton_combobox = Button(master=ventana_emergente, text="Seleccionar", command=seleccionRestaurante)
    boton_combobox.pack()


    


#FUNCIONALIDAD RESERVAR TRANSPORTE
def reservarTransporte(hotel: Hotel):
    try: 
        id_habitacion = obtenerValores()[0]
        habitacion: Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
        if (habitacion.isOcupado() == False):
            raise habitacionDesocupada()
        grupo: GrupoHuespedes = habitacion.get_grupo_huespedes()
    except Exception as e:
        messagebox.showerror("Error", "No hay gente en esta habitacion")
        return 0
    ventana_emergente = Toplevel()
    ventana_emergente.geometry("500x500")
    ventana_emergente.title("Seleccione un vehiculo")
    Label(ventana_emergente, text="Seleccione un vehiculo").pack()
    opciones = [f"Id: {v.id}, Modelo: {v.modelo}, Capacidad: {v.capacidad}, Precio: {v.precio}" for v in Vehiculos]
    comboBox = ttk.Combobox(master=ventana_emergente, values= opciones, textvariable="...")
    comboBox.config(width=50, height=10)
    comboBox.pack()

    def seleccionarVehiculo():
        vehiculo_seleccionado = Vehiculo.buscarPorId(comboBox.get()[4])
        if vehiculo_seleccionado.isOcupado() == True: 
            raise messagebox.showerror("Excepción", "EL vehiculo ya está ocupado")
        else: 
            vehiculo_seleccionado.asignarDueños(grupo)
            grupo.get_factura().FacturaVehiculo += vehiculo_seleccionado.precio
            ventana_emergente.destroy()
            frame_actual.output.delete("1.0", END)  # Borrar el contenido existente
            frame_actual.output.insert(END,"Has seleccionado el vehiculo: "+str(vehiculo_seleccionado.modelo))


    boton_combobox = Button(master=ventana_emergente, text="Seleccionar", command= seleccionarVehiculo)
    boton_combobox.pack()


def generar_alojar_huesped():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_alojo
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command=lambda: agregar_huesped(hotel))
    

def generar_reservaRestaurante():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_restaurante
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command=lambda: reservarRestaurante(hotel))
    

 

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
    frame_actual.boton_aceptar.config(command= lambda: reservarTransporte(hotel))

def generar_alimentacion():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_restaurante
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command = lambda: reservarRestaurante(hotel))


def generar_servExtra():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_servExtra
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command = lambda: servicios_extra(hotel))


def generar_factura():
    global frame_actual
    frame_actual.pack_forget()
    frame_actual = frame_factura
    frame_actual.pack()
    frame_actual.boton_aceptar.config(command = lambda: verFactura(hotel))


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
    estado.add_command(label="Factura", command=generar_factura)

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


def verFactura(hotel:Hotel):
    id_habitacion = obtenerValores()[0]

    try:

        habitacion:Habitacion = hotel.seleccionar_habitacion_porId(int(id_habitacion))
        if habitacion == None:
            raise HabitacionNoExiste
        if (habitacion.isOcupado()==True):
            ventana_datos= Toplevel()
            ventana_datos.geometry("200x150")
            ventana_datos.title("Factura")
            label = Label(ventana_datos, text=habitacion.factura())
            label.pack()
        elif (habitacion.isOcupado()==False):
            raise habitacionDesocupada(habitacion)

    except ValueError as e:
        
        messagebox.showerror("Error", e)#pasar letra en vez de numero
        return 0 #Salirse
    
    except HabitacionNoExiste as e:

        messagebox.showerror("Error", e)
        return 0 #terminar funcionalidad
    
    except habitacionDesocupada as e:
        messagebox.showerror("Incorrecto",e)
        return 0
    




def HabDesocupada():
    descripcion = "Habitación desalojada satisfactoriamente"
    messagebox.showinfo("Mensaje", descripcion)


def HabOcupada(cabeza, IDhabitacion):
    descripcion = f"Se han alojado los huespedes con la cabeza de grupo {cabeza} en la habitación {IDhabitacion} correctamente"
    messagebox.showinfo("Mensaje", descripcion)


