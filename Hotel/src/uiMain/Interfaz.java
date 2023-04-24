/*
1. Registrar grupo (todo el proceso hasta asignarle habitación, muestra factura temporal)
2. Desalojar huésped (desaloja habitación, calcula la factura, y los elimina de la base datos)
3. Cambiar habitacion de huesped
4. Ver habitaciones (muestrta toString de todas las habitaciones del hotel)
5. Ver Grupos (muestra todas las personas)
6. Servicios Extra
7. Salir

 */

package uiMain;

import java.util.Scanner;

import baseDatos.serializador;
import gestorAplicacion.Habitaciones.HabitacionEstandar;
import gestorAplicacion.hoteles.Hotel;

//Muestra las opciones e invoca las funcionalidades
public class Interfaz {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.agragarHabitacion(new HabitacionEstandar());

        int opcion;
        do {
            System.out.println("Que operacion desea realizar");
            opcion = readInt();

            switch (opcion) {
                case 7:
                    salirDelSistema(hotel);
                    break;
            
                default:
                    break;
            }

        } while (opcion != 7);
    }

    static int readInt(){
        return sc.nextInt();
    }

    private static void salirDelSistema(Hotel hotel){
        System.out.println("Vuelva pronto");
        serializador.serializar(hotel);
        System.exit(0);

    }
    
}
