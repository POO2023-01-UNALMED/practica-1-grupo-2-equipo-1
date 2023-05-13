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

import baseDatos.serializador;
import gestorAplicacion.Habitaciones.Habitacion;
// import gestorAplicacion.Habitaciones.HabitacionEstandar; //no quitar
// import gestorAplicacion.Habitaciones.HabitacionVIP;
import gestorAplicacion.Personas.GrupoHuespedes;
import gestorAplicacion.Personas.Huesped;
import gestorAplicacion.hoteles.Hotel;
import gestorAplicacion.serviciosExtra.ServiciosExtra;
import java.util.Scanner;

//Muestra las opciones e invoca las funcionalidades
public class Interfaz {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Hotel hotel = new Hotel();

    //* Base de datos inicial. Solo se ejecuto una vez */
    // hotel.agragarHabitacion(new HabitacionEstandar());
    // hotel.agragarHabitacion(new HabitacionEstandar());
    // hotel.agragarHabitacion(new HabitacionVIP());

    int opcion;
    do {
      System.out.println("Bienvenidos al hotel The Debug Inn");
      System.out.println("1. Registar huespedes");
      System.out.println("2. Desalojar huespedes");
      System.out.println("3. Ver habitaciones");
      System.out.println("5. Ver huespedes");
      System.out.println("6. Servicios extra");
      System.out.println("7. Salir");
      opcion = readInt();

      switch (opcion) {
        case 1:
          agregarHuesped(hotel);
          break;
        case 2:
          desalojarGrupo(hotel);
          break;
        case 3:
          mostrarListaHabitaciones(hotel);
          break;
        case 6:
          int opcionServicios;
          int[] idsServicios = new int[3];
          int numServiciosSeleccionados = 0;

          do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar servicio extra");
            System.out.println("2. Calcular precio total");
            System.out.println("0. Salir");
            opcionServicios = sc.nextInt();

            switch (opcionServicios) {
              case 1:
                if (numServiciosSeleccionados < 3) {
                  System.out.println("Seleccione un servicio extra:");
                  System.out.println("1. Gimnasio");
                  System.out.println("2. Bar");
                  System.out.println("3. Parqueadero");
                  int idServicio = sc.nextInt();
                  ServiciosExtra servicio = ServiciosExtra.buscarPorId(
                    idServicio
                  );
                  if (servicio != null) {
                    idsServicios[numServiciosSeleccionados] = idServicio;
                    numServiciosSeleccionados++;
                    System.out.println("Servicio extra agregado.");
                  } else {
                    System.out.println("El servicio seleccionado no existe.");
                  }
                } else {
                  System.out.println(
                    "Ya ha seleccionado el máximo de servicios extras permitidos."
                  );
                }
                break;
              case 2:
                int precioTotal = ServiciosExtra.calcularPrecioServiciosExtras(
                  idsServicios
                );
                System.out.println(
                  "Precio total de los servicios extras seleccionados: $" +
                  precioTotal
                );
                break;
              case 0:
                System.out.println("Saliendo...");
                break;
              default:
                System.out.println("Opción inválida.");
                break;
            }

            System.out.println();
          } while (opcionServicios != 0);

          break;
        case 0:
          System.out.println("Saliendo...");
          break;
        case 7:
          salirDelSistema(hotel);
          break;
        default:
          salirDelSistema(hotel);
          break;
      }
    } while (opcion != 7);
  }

  static void agregarHuesped(Hotel hotel) {
    mostrarListaHabitaciones(hotel);
    System.out.print("Id de la habitacion: ");
    int idHab = readInt();
    Habitacion hab = hotel.seleccionarHabitacionPorId(idHab);
    hab = verificarHabitaciaNoSeaNull(hotel, hab);

    while (hab.getEstaOcupado() == true) {
      System.out.println("Esta habitacion esta ocupada, seleccione otra");
      System.out.print("Id de la habitacion: ");
      idHab = readInt();
      hab = hotel.seleccionarHabitacionPorId(idHab);
    }

    /* Definimos el grupo que ocupara la habitacion
     * dias que se quedan:
     * cuantas personas:
     *      nombre:
     *      identificacion:
     */
    GrupoHuespedes grupoHuespedes = new GrupoHuespedes();
    grupoHuespedes.setHabitacion(hab);

    System.out.println("Dias: ");
    int dias = readInt();
    grupoHuespedes.setDiasEnHotel(dias);

    System.out.println("Cuantas personas");
    int numeroPersonas = readInt();

    while (numeroPersonas > hab.getCapacidad()) {
      System.out.println("El numero sobrepasa la capacidad");
      numeroPersonas = readInt();
    }

    for (int i = 0; i < numeroPersonas; i++) {
      System.out.print("Nombre: ");
      String nombre = readString();
      System.out.print("Identificacion: ");
      int identificacion = readInt();
      grupoHuespedes.agregarHuesped(new Huesped(nombre, identificacion));
    }

    grupoHuespedes.inicializarFactura();
    // el precio es igual a = dias * precio
    System.out.println("precio: " + grupoHuespedes.getFactura());

    //* Fin definicion del grupo */

    hab.setGrupo(grupoHuespedes);
  }

  static int desalojarGrupo(Hotel hotel) {
    System.out.print("Id de la habitacion: ");
    int idHab = readInt();
    Habitacion hab = hotel.seleccionarHabitacionPorId(idHab);

    hab = verificarHabitaciaNoSeaNull(hotel, hab);

    while (hab.getEstaOcupado() == false) {
      System.out.println("La habitacion ya esta desocupada");
      return 1;
    }

    GrupoHuespedes grup = hab.getGrupo();

    System.out.println(grup.getFactura().toString());
    System.out.println("Total: " + grup.getFactura().CalcularPrecioFactura());

    hab.borrarGrupo();
    return 0;
  }

  private static Habitacion verificarHabitaciaNoSeaNull(
    Hotel hotel,
    Habitacion hab
  ) {
    int idHab;
    while (hab == null) {
      System.out.println("No existe esa habitacion seleccione otra");
      System.out.print("Id de la habitacion: ");
      idHab = readInt();
      hab = hotel.seleccionarHabitacionPorId(idHab);
    }
    return hab;
  }

  static int readInt() {
    return sc.nextInt();
  }

  static String readString() {
    sc.nextLine();
    return sc.nextLine();
  }

  static void mostrarListaHabitaciones(Hotel hotel) {
    System.out.println(hotel.mostrarHabitaciones());
  }

  private static void salirDelSistema(Hotel hotel) {
    System.out.println("Vuelva pronto");
    serializador.serializar(hotel);
    System.exit(0);
  }
}
