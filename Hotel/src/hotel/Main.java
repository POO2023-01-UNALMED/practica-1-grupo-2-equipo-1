package hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputOpcion = new Scanner(System.in);
        System.out.println("Administrador de hotel");

        boolean estado = true;
        while (estado) {
            System.out.println("1. Alojar husped");
            System.out.println("2. Desalojar huesped");
            System.out.println("3. Modificar habitacion de huesped");
            System.out.println("4. Ver habitaciones"); // ocupadas y desocupadas
            System.out.println("5. Parqueadero");

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
                //verHabitaciones
                    break;
                case 5:
                    break;
                //verParqueadero
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        inputOpcion.close();
    }
}
