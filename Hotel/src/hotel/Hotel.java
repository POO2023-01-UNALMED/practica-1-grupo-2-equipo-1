package hotel;

import java.util.ArrayList;
import java.util.Scanner;

import hotel.habitaciones.*;

public class Hotel {

    ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

    public void mostarHabitaciones(){
        for (Habitacion habitacion : listaHabitaciones) {
            System.out.println(habitacion + "\n");
        }
    }

    public static void main(String[] args) {

        Hotel miHotel = new Hotel();
        miHotel.listaHabitaciones.add(new HabitacionEconomica(2, 50000, false, false, "A101"));
        miHotel.listaHabitaciones.add(new HabitacionVIP(6, 100000, false, true, "P800"));

        Scanner inputOpcion = new Scanner(System.in);
        System.out.println("Administrador de hotel");

        boolean estado = true;
        while (estado) {
            System.out.println("1. Alojar husped");
            System.out.println("2. Desalojar huesped");
            System.out.println("3. Modificar habitacion de huesped");
            System.out.println("4. Ver habitaciones"); // ocupadas y desocupadas
            System.out.println("5. Parqueadero");
            System.out.println("0. Parqueadero");


            System.out.println("Opcion: ");
            int opcion = inputOpcion.nextInt();
            switch (opcion) {
                case 1:
                //alojarHuesped()
                    break;
                case 2:
                //desalojarHuesped()
                    break;
                case 3:
                //modificarHabitacionHuesped()
                    break;
                case 4:
                miHotel.mostarHabitaciones();
                    break;
                case 5:
                //verParqueadero
                    break;
                case 0:
                    //*salir
                estado = false;
                System.out.println("Saliendo");
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        inputOpcion.close();
    }
}
