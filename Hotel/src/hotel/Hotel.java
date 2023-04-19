package hotel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import hotel.habitaciones.*;
import personas.*;

public class Hotel {
    public static int habitacionesHotel = 30;
    public static int maxPorHabitacion = 6;

    // array. lista de los grupos de personas que viven en
    // una misma habitacion.
    public static GrupoHuespedes[] listaGrupos = new GrupoHuespedes[habitacionesHotel];
    // array con todas la habitaciones del hotel
    public static Habitacion[] listaHabitaciones = new Habitacion[habitacionesHotel];

    public void mostarHabitaciones() {
        int i = 1;
        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion != null) {
                System.out.println((i) + ". " + habitacion + "\n"); // uotput: 1. datos habitacion
                i++;
            }
        }
    }

    public void nuevoCliente() {
        String nombre, apellido;
        int edad;
        Scanner input = new Scanner(System.in);

        System.out.println("Cuantas personas son?");
        int npersonas = Integer.parseInt(input.nextLine());
        Huesped[] grupo = new Huesped[npersonas];

        for (int i = 0; i < npersonas; i++) {
            if (i == 0) {
                System.out.println("!La primera persona en pagar es a quien se le encargara la Factura!");
            }

            System.out.println("Nombre: ");
            nombre = input.nextLine();
            System.out.println("apellidos: ");
            apellido = input.nextLine();
            System.out.println("edad: ");
            edad = Integer.parseInt(input.nextLine());

            // agregando Personas al array
            if (i == 0) {
                System.out.println("¿Nesecitan Parqueadero? (si/no)");
                String respuesta = input.nextLine();

                // operador ternario: true si la respuesta es "si"
                Boolean tieneCarro = (respuesta.equals("si") ? true : false);
                Encargado encargado = new Encargado(nombre, edad, tieneCarro);
                grupo[0] = encargado;
            } else {
                Huesped huesped = new Huesped(nombre, edad);
                // lo agregamos a la ultima posicion disponible en el array.
                for (int j = 0; j < grupo.length; j++) {
                    if (grupo[j] == null) {
                        grupo[j] = huesped;
                        break;
                    }
                }

            }

            System.out.println("Elija una habitacion");
            mostarHabitaciones();
            int habitacionSeleccionada = Integer.parseInt(input.nextLine()) - 1;//en el array empieza en 0

            if (listaHabitaciones[habitacionSeleccionada].ocupado == true || listaHabitaciones[habitacionSeleccionada] == null) {
                do {
                    System.out.println("Elija una habitacion");
                    mostarHabitaciones();
                    habitacionSeleccionada = Integer.parseInt(input.nextLine()) - 1;

                } while (listaHabitaciones[habitacionSeleccionada].ocupado == true || listaHabitaciones[habitacionSeleccionada] == null);
            } else {
                GrupoHuespedes grupoHuespedes = new GrupoHuespedes(grupo, listaHabitaciones[habitacionSeleccionada]);
                for (int j = 0; j < listaGrupos.length; j++) {
                    if (listaGrupos[j] == null) {
                        listaGrupos[j] = grupoHuespedes;
                        break;
                    }
                }
            }
        }
        // input.close();//toca quitarlo porque si no se daña por alguna razon
    }

    public static void crearHabitacion(int tipoHabitacion, int capacidad, int precioXnoche) {

        switch (tipoHabitacion) {
            case 1:
                for (int i = 0; i < listaHabitaciones.length; i++) {
                    if (listaHabitaciones[i] == null) {
                        listaHabitaciones[i] = new HabitacionEconomica(capacidad, precioXnoche);
                        break;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < listaHabitaciones.length; i++) {
                    if (listaHabitaciones[i] == null) {
                        listaHabitaciones[i] = new HabitacionVIP(capacidad, precioXnoche);
                        break;
                    }
                }

                break;

            default:
                break;
        }

        // serializar habitacion
        try {
            ObjectOutputStream escribiendoHabitaciones = new ObjectOutputStream(
                    new FileOutputStream("Hotel\\src\\basedatos\\temp\\grupos_huespedes.txt"));
            escribiendoHabitaciones.writeObject(listaHabitaciones);
            escribiendoHabitaciones.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // carga la base de datos
        try {

            ObjectInputStream leerHabitaciones = new ObjectInputStream(
                    new FileInputStream("Hotel\\src\\basedatos\\temp\\grupos_huespedes.txt"));
            listaHabitaciones = (Habitacion[]) leerHabitaciones.readObject();
            leerHabitaciones.close();

            System.out.println(listaHabitaciones);

        } catch (Exception e) {
            System.out.println(e);
        }

        Hotel miHotel = new Hotel();
        Scanner input = new Scanner(System.in);

        boolean estado = true;
        while (estado) {
            System.out.println("Administrador de hotel");

            System.out.println("1. Alojar husped");
            System.out.println("2. Desalojar huesped");
            System.out.println("3. Modificar habitacion de huesped");
            System.out.println("4. Ver habitaciones"); // ocupadas y desocupadas
            System.out.println("5. Parqueadero");
            System.out.println("6. CrearHabitacion");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            int opcion = Integer.parseInt(input.nextLine());
            switch (opcion) {
                case 1:
                miHotel.nuevoCliente();
                    break;
                case 2:
                    // desalojarHuesped()
                    break;
                case 3:
                    // modificarHabitacionHuesped()
                    break;
                case 4:
                    miHotel.mostarHabitaciones();
                    break;
                case 5:
                    // verParqueadero
                    break;
                case 6:
                    System.out.println("De que tipo es la habitacion");
                    System.out.println("1. Economica");
                    System.out.println("2. VIP");
                    int tipo = Integer.parseInt(input.nextLine());

                    System.out.println("Capacidad de la habitacion: ");
                    habitacionesHotel = Integer.parseInt(input.nextLine());
                    System.out.println("Precio por noche de la habitacion");
                    int precioXnoche = Integer.parseInt(input.nextLine());
                    crearHabitacion(tipo, habitacionesHotel, precioXnoche);

                    break;
                case 0:
                    // *salir
                    input.close();
                    estado = false;
                    System.out.println("Saliendo");
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }

    }
}
