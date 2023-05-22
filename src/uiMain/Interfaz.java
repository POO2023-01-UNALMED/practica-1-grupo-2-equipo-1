package uiMain;

import baseDatos.serializador;
import gestorAplicacion.Habitaciones.Habitacion;
// import gestorAplicacion.Habitaciones.HabitacionEstandar; //no quitar
// import gestorAplicacion.Habitaciones.HabitacionVIP;
import gestorAplicacion.Personas.GrupoHuespedes;
import gestorAplicacion.Personas.Huesped;
import gestorAplicacion.Restaurantes.Mesa;
import gestorAplicacion.Restaurantes.Restaurante;
import gestorAplicacion.hoteles.Hotel;
import gestorAplicacion.serviciosExtra.Factura;
import gestorAplicacion.serviciosExtra.ServiciosExtra;

import java.util.Arrays;
import java.util.Scanner;

//Muestra las opciones e invoca las funcionalidades
public class Interfaz {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Hotel hotel = new Hotel();

    //* Base de datos inicial. Solo se ejecuto una vez */
    // hotel.agragarHabitacion(new Habitacion(4, 64000, 1));
    // hotel.agragarHabitacion(new Habitacion(2, 64000, 2));
    // hotel.agragarHabitacion(new Habitacion(6, 64000, 3));

    //hotel.agregarRestaurante(new Restaurante("Restaurante General", 20000,1));
    //hotel.agregarRestaurante(new Restaurante("Restaurante Italiano", 30000,2));
    //hotel.agregarRestaurante(new Restaurante("Restaurante Vegetariano", 25000,3));



    int opcion;

    do {
      System.out.println("----------------------------------------");
      System.out.println("Bienvenidos al hotel The Debug Inn");
      System.out.println("1. Registar huespedes");
      System.out.println("2. Desalojar huespedes");
      System.out.println("3. Ver habitaciones");
      System.out.println("4. Reserva Restaurate");
      System.out.println("5. Servicios extra");
      System.out.println("0. Salir");
      System.out.println("----------------------------------------");

      System.out.print("Opcion: ");

      opcion = readInt();

      switch (opcion) {

        case 1:
          //La opcion 1 llama al metodo agregarHuesped// 
          agregarHuesped(hotel);
          break;

        case 2:
          //La opcion 2 llama al metodo desalojarGrupo//
          //Accede a la base de datos y a la habitacion que este ocupada se le borran los datos//
          desalojarGrupo(hotel);
          break;

        case 3:
          //La opcion 3 llama al metodo mostrarListaHabitaciones//
          //Imprime la informacion de habitaciones//
          mostrarListaHabitaciones(hotel);
          break;

        case 4:
          //La opcion 4 llama al metodo reservarMesaRestaurante//
          reservarMesaRestaurante(hotel);
          break;

        case 5:serviciosExtra(hotel); break;

        case 0:
          //La opcion 0 es para Salir del sistema y terminar la ejecucion//
          System.out.println("Saliendo...");
          salirDelSistema(hotel);
          break;

        default:
          //Si se da un numero no relacionado a una opcion se saldra del sistema terminando la ejecucion//
          System.out.println("No hay una opcion relacionada con ese numero");
          salirDelSistema(hotel);
          break;

      }

    } while (opcion != 7);

  }

  private static int serviciosExtra(Hotel hotel) {
    /*Seleccionar habitacion, para saber a que grupo ponerle la factura 
     * despues se selleciona el servicio
    */

    int opcionServicios;
    int numServiciosSeleccionados = 0;

    System.out.print("Seleccione el Id de su habitacion: ");
    Habitacion hab = seleccionarHabitacion(hotel);

    //verifica que no esta vacia la habitacion, si esta vacia vuelve a menu
    if (hab.getEstaOcupado() == false) {
      System.out.println("No hay huespedes aqui");
      return 1;//esto es para regrasar a menu, nunca se le asigna a nada
    }

    //aqui seleccionamos la factura del grupo
    Factura factura = hab.getGrupo().getFactura();
    System.out.println(Arrays.toString(factura.getIdsServicios()));


    do {
      System.out.println("Seleccione una opción:");
      System.out.println("1. Agregar servicio extra");
      System.out.println("2. Calcular precio total");
      System.out.println("0. Salir");
      opcionServicios = readInt();


      switch (opcionServicios) {
        case 1: //agregar servicio extra
          if (numServiciosSeleccionados < 3) {
            System.out.println("Seleccione un servicio extra:");
            System.out.println("1. Gimnasio");
            System.out.println("2. Bar");
            System.out.println("3. Parqueadero");
            int idServicio = readInt();
            ServiciosExtra servicio = ServiciosExtra.buscarPorId(idServicio);

            System.out.println(servicio != null);
            System.out.println(!factura.contains(factura.getIdsServicios(), idServicio));
            System.out.println(Arrays.toString(factura.getIdsServicios()));
            // verifica si el servicio ya fue comprado
            if (servicio != null && !factura.contains(factura.getIdsServicios(), idServicio)) {
              // idsServicios[numServiciosSeleccionados] = idServicio;
              factura.seleccionarServicio(idServicio);
              factura.getIdsServicios()[numServiciosSeleccionados] = idServicio;
              numServiciosSeleccionados++;
              System.out.println("Servicio extra agregado.");
            } else {
              System.out.println("El servicio seleccionado no existe o ya fue comprado.");
            }
          } else {
            System.out.println(
              "Ya ha seleccionado el máximo de servicios extras permitidos."
            );
          }
          break;
        case 2: //Calcular Precio total
          // int precioTotal = ServiciosExtra.calcularPrecioServiciosExtras(factura.getIdsServicios());
          System.out.println(
            "Precio total de los servicios extras seleccionados: $" +
            factura.getFacturaServiciosExtra()
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
    return 0;
  }


  private static int reservarMesaRestaurante(Hotel hotel){

    //Se pide el Id de la habitacion para poder relacionar la mesa con un grupo de huespedes//
    System.out.print("Id de la habitacion: ");
    Habitacion hab = seleccionarHabitacion(hotel);
  
    //Se verifica si la habitacion tiene un registro para continuar con la reserva//
    if (hab.getEstaOcupado() == false){
      System.out.println("No hay personas en esta habitacion");
      return 1; 
      //sale del programa
    }
    
    //Se verifica que no tengan ya una mesa reservada//
    if (hab.getGrupo().getMesaReservada() != null){
      System.out.println("Ya tienen una mesa reservada");
      return 1;
    }

    //--------------
    Restaurante restaurante;
    //* Mostrar los restaurantes disponibles *//
    int i = 1;
    for (Restaurante res : hotel.getRestaurantes()) {

      System.out.println(i++ + ": " + res.toString() + System.lineSeparator());

    }

    //* Seleccionar restaurante */
    System.out.print("Opcion: ");
    int numRestaurante = readInt();
    restaurante = hotel.getRestaurantes().get(numRestaurante-1);

    //* Mostrar mesas restaurante */
    int numMesa = 1;
    for (Mesa mesa : restaurante.getMesas()) {

      System.out.println(numMesa++ + ": " + mesa.toString());

    }
    // Se elige la mesa que se desea asignar//
    System.out.print("Seleccione mesa: ");
    int mesaSeleccionada = readInt();
    restaurante.getMesas().get(mesaSeleccionada-1).asignarDueños(hab.getGrupo());
    return 0;



  }

  static int agregarHuesped(Hotel hotel) {
    
    //Se verifica que hayan habitaciones disponibles//
    if (hotel.mostrarHabitacionesDisponibles().isEmpty()){
      //Si la lista de habitaciones disponibles esta vacia te menciona que el hotel ya esta lleno//
      System.out.println("El hotel esta lleno!");
      return 1;
    }

    //Se muestra la lista de las habitaciones disponibles//
    System.out.println(hotel.mostrarHabitacionesDisponibles());
    System.out.print("Id de la habitacion: ");
    int idHab;
    // Se te pide el id de la habitacion que piensas elegir//
    Habitacion hab = seleccionarHabitacion(hotel);

    // Si la habitacion elegida ya esta ocupada te vuelve a pedir el ID// 
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

    // Piden los dias y los asigna al grupo de huespedes //
    System.out.println("Dias: ");
    int dias = readInt();
    grupoHuespedes.setDiasEnHotel(dias);

    // Se pide el numero de integrantes del grupo//
    System.out.println("Cuantas personas");
    int numeroPersonas = readInt();

    // Se verifica que el numero de personas del grupo sea menor al numero de personas disponibles por habitacion//
    while (numeroPersonas > hab.getCapacidad()) {
      System.out.println("El numero sobrepasa la capacidad");
      numeroPersonas = readInt();
    }

    // Por persona se van a pedir los datos de nombre e identificacion //
    for (int i = 0; i < numeroPersonas; i++) {
      System.out.print("Nombre: ");
      String nombre = readString();
      System.out.print("Identificacion: ");
      int identificacion = readInt();
      // Se crea una instancia de huesped con los datos //
      grupoHuespedes.agregarHuesped(new Huesped(nombre, identificacion));
    }

    // Se crea la factura del registro //
    grupoHuespedes.inicializarFactura();
    // el precio es igual a = dias * precio
    System.out.println("precio: " + grupoHuespedes.getFactura());

    //* Fin definicion del grupo */

    hab.setGrupo(grupoHuespedes);
    return 0;
  }


  static int desalojarGrupo(Hotel hotel) {

    // Se pide el ID de la habitacion que se deasea desalojar //
    System.out.print("Id de la habitacion: ");
    Habitacion hab = seleccionarHabitacion(hotel);

    // Se verifica que la habitacion si este ocupada //
    while (hab.getEstaOcupado() == false) {
      System.out.println("La habitacion ya esta desocupada");
      return 1;
    }

    GrupoHuespedes grup = hab.getGrupo();

    // Se calcula y se muestra la factura del grupo que va a ser desalojado //
    System.out.println(grup.getFactura().toString());
    System.out.println("Total: " + grup.getFactura().CalcularPrecioFactura());


    // Se borra la reserva del restaurante
    if (hab.getGrupo().getMesaReservada() != null){
      hab.getGrupo().getMesaReservada().vaciarMesa();
      hab.getGrupo().setMesaReservada(null);
      System.out.println("Reserva restaurante eliminada");
    }

    // Se borra el grupo //
    hab.borrarGrupo();
    return 0;
  }

  // 
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

  // 
  private static Habitacion seleccionarHabitacion(Hotel hotel) {
    int idHab = readInt();
    Habitacion hab = hotel.seleccionarHabitacionPorId(idHab);
    hab = verificarHabitaciaNoSeaNull(hotel, hab);
    return hab;
  }

  // Terminar ejecucion //
  private static void salirDelSistema(Hotel hotel) {
    System.out.println("Vuelva pronto");
    serializador.serializar(hotel);
    System.exit(0);

  }
  
}
