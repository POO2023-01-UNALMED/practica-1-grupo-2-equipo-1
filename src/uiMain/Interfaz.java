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
import gestorAplicacion.transporte.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;

//Muestra las opciones e invoca las funcionalidades
public class Interfaz {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Hotel hotel = new Hotel();

    //* Base de datos inicial. Solo se ejecuto una vez */


    // Habitaciones //

 /*    hotel.agregarHabitacion(new Habitacion(4, 64000, 1));
    hotel.agregarHabitacion(new Habitacion(2, 64000, 2));
    hotel.agregarHabitacion(new Habitacion(6, 64000, 3));
    hotel.agregarHabitacion(new Habitacion(8, 120000, 4));
    hotel.agregarHabitacion(new Habitacion(4, 40000, 5));
    hotel.agregarHabitacion(new Habitacion(2, 25000, 6));
    hotel.agregarHabitacion(new Habitacion(3, 34000, 7));
    hotel.agregarHabitacion(new Habitacion(1, 20000, 8));
    hotel.agregarHabitacion(new Habitacion(6, 60000, 9));
    hotel.agregarHabitacion(new Habitacion(4, 50000, 10));
    hotel.agregarHabitacion(new Habitacion(2, 25000, 11));
    hotel.agregarHabitacion(new Habitacion(3, 35000, 12));
 */
    // Restaurantes //
/* 
    hotel.agregarRestaurante(new Restaurante("Restaurante General", 20000,1));
    hotel.agregarRestaurante(new Restaurante("Restaurante Italiano", 35000,2));
    hotel.agregarRestaurante(new Restaurante("Restaurante Vegetariano", 25000,3));
    hotel.agregarRestaurante(new Restaurante("Restaurante Mexicano", 30000,4)); */

    // Vehiculos //
    /* hotel.agregarVehiculo(new Vehiculo("Renoult", "ABC123", "Conductor_1", 2, false, 580000));
    hotel.agregarVehiculo(new Vehiculo("Chevrolet", "CDT890", "Conductor_2", 4, false, 795000));
    hotel.agregarVehiculo(new Vehiculo("Toyota", "LMN321", "Conductor_3", 6, false, 1650000)); */


    int opcion;

    do {
      System.out.println("----------------------------------------");
      System.out.println("Bienvenidos al hotel The Debug Inn.");
      System.out.println("1. Registrar huespedes.");
      System.out.println("2. Desalojar huespedes.");
      System.out.println("3. Ver habitaciones.");
      System.out.println("4. Reserva Restaurante.");
      System.out.println("5. Reserva Transporte.");
      System.out.println("6. Servicios extra.");
      System.out.println("7. Ver factura.");
      System.out.println("0. Salir.");
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
          
        case 5: 
          // La opcion 5 llama al metodo reservar Transporte
        	reservarTransporte(hotel);
        	break;

          // La opcion 6 llama al metodo serivicos extra //
        case 6:serviciosExtra(hotel); break;

        case 7:

          // La opcion 7 muestra la factura de la habitacion dada //

          System.out.println("Seleccione el Id de su habitacion: ");
          Habitacion hab = seleccionarHabitacion(hotel);

          if (hab.getEstaOcupado() == false) {
            System.out.println("No hay huespedes aqui.");
            return;
          }


          System.out.println("\n----Hotel Debug Inn----\n");
          System.out.println("A quien se realiza la facturacion: " + hab.getGrupo().toString());
          System.out.println("");
          System.out.println(hab.getGrupo().getFactura().toString());
          System.out.println("Total: " + hab.getGrupo().getFactura().CalcularPrecioFactura());

          break;

          
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

    } while (opcion != 0);

  }

  private static int serviciosExtra(Hotel hotel) {
    /*Seleccionar habitacion, para saber a que grupo ponerle la factura 
     * despues se seleciona el servicio
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
    
    do {

      System.out.println("----------------------------------------");
      System.out.println("Seleccione una opción:");
      System.out.println("");
      System.out.println("1. Agregar servicio extra");
      System.out.println("");
      System.out.println("2. Calcular precio total");
      System.out.println("");
      System.out.println("0. Salir");
      System.out.println("----------------------------------------");
      opcionServicios = readInt();


      switch (opcionServicios) {
        case 1: //agregar servicio extra

          if (numServiciosSeleccionados < 3) {

            System.out.println("----------------------------------------");
            System.out.println("Seleccione un servicio extra:");
            System.out.println("");
            System.out.println("1. Gimnasio");
            System.out.println("Precio: $"+ServiciosExtra.GIMNASIO.getPrecio());
            System.out.println("");
            System.out.println("2. Bar");
            System.out.println("Precio: $"+ServiciosExtra.BAR.getPrecio());
            System.out.println("");
            System.out.println("3. Parqueadero");
            System.out.println("Precio: $"+ServiciosExtra.PARQUEADERO.getPrecio());
            System.out.println("----------------------------------------");
            int idServicio = readInt();
            ServiciosExtra servicio = ServiciosExtra.buscarPorId(idServicio);

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
          System.out.println("Volviendo al menú...");
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
    System.out.println("----------------------------------------");
    for (Restaurante res : hotel.getRestaurantes()) {

      System.out.println(i++ + ": " + res.toString() + System.lineSeparator());

    }
    System.out.println("----------------------------------------");

    //* Seleccionar restaurante */
    System.out.print("Opcion: ");
    int numRestaurante = readInt();
    System.out.println("");
    restaurante = hotel.getRestaurantes().get(numRestaurante-1);

    //* Mostrar mesas restaurante */
    int numMesa = 1;
    System.out.println("----------------------------------------");
    for (Mesa mesa : restaurante.getMesas()) {

      System.out.println(numMesa++ + ": " + mesa.toString());

    }
    System.out.println("----------------------------------------");

    // Se elige la mesa que se desea asignar//
    System.out.print("Seleccione mesa: ");
    int mesaSeleccionada = readInt();
    restaurante.getMesas().get(mesaSeleccionada-1).asignarDueños(hab.getGrupo());

    // Se añade el precio del restaurante a la factura del grupo de huespedes //

    hab.getGrupo().getFactura().setFacturaRestaurante(restaurante.getPrecio());

    System.out.println("");

    System.out.println(
      "Agregado el costo del " + restaurante.getNombre() + " a la factura: " + restaurante.getPrecio()
      );
    
    System.out.println("");



    return 0;



  }

  static int agregarHuesped(Hotel hotel) {
    
    //Se verifica que hayan habitaciones disponibles//
    if (hotel.mostrarHabitacionesDisponibles().isEmpty()){
      //Si la lista de habitaciones disponibles esta vacia te menciona que el hotel ya esta lleno//
      System.out.println("");
      System.out.println("El hotel esta lleno!");
      return 1;
    }

    //Se muestra la lista de las habitaciones disponibles//
    System.out.println("");
    System.out.print(hotel.mostrarHabitacionesDisponibles());
    System.out.print("Id de la habitacion: ");
    int idHab;
    // Se te pide el id de la habitacion que piensas elegir//
    Habitacion hab = seleccionarHabitacion(hotel);

    // Si la habitacion elegida ya esta ocupada te vuelve a pedir el ID// 
    while (hab.getEstaOcupado() == true) {
      System.out.println("");
      System.out.println("Esta habitacion esta ocupada, seleccione otra");
      System.out.println("");
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
    System.out.print("Dias: ");
    int dias = readInt();
    grupoHuespedes.setDiasEnHotel(dias);

    // Se pide el numero de integrantes del grupo//
    System.out.print("");
    System.out.print("Cuantas personas: ");
    int numeroPersonas = readInt();

    // Se verifica que el numero de personas del grupo sea menor al numero de personas disponibles por habitacion//
    while (numeroPersonas > hab.getCapacidad()) {
      System.out.println("");
      System.out.print("El numero sobrepasa la capacidad");
      System.out.println("");
      return 1;
    }

    // Por persona se van a pedir los datos de nombre e identificacion //
    for (int i = 0; i < numeroPersonas; i++) {
      System.out.print("");
      System.out.print("Nombre de la persona " + (i+1) + ": ");
      String nombre = readString();
      System.out.print("Identificacion de la persona " + (i+1) + ": ");
      int identificacion = readInt();
      // Se crea una instancia de huesped con los datos //
      grupoHuespedes.agregarHuesped(new Huesped(nombre, identificacion));
    }

    // Se crea la factura del registro //
    grupoHuespedes.inicializarFactura();
    // el precio es igual a = dias * precio

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
    System.out.println("\n----Hotel Debug Inn----\n");
    System.out.println("A quien se realiza la facturacion: " + grup.toString() + "\n");
    System.out.println(grup.getFactura().toString());
    System.out.println("Total: " + grup.getFactura().CalcularPrecioFactura());


    // Se borra la reserva del restaurante
    if (hab.getGrupo().getMesaReservada() != null){
      hab.getGrupo().getMesaReservada().vaciarMesa();
      hab.getGrupo().setMesaReservada(null);
      System.out.println("Reserva restaurante eliminada");
    }
    
    if(hab.getGrupo().getVehiculoReservado() != null){
    	hab.getGrupo().getVehiculoReservado().DesocuparVehiculo();
    	hab.getGrupo().setVehiculoReservado(null);
    	System.out.println("Reserva de vehiculo eliminada");
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
  
  //Reservar trasnporte

  private static int reservarTransporte(Hotel hotel) {
  // Con el ID se selecciona la habitacion
	System.out.print("Id de la habitacion: "+System.lineSeparator());
	Habitacion hab = seleccionarHabitacion(hotel);

	

  // Se verifica que la habitacion si tenga huespedes
	if (hab.getEstaOcupado() == false){
	      System.out.println("No hay personas en esta habitacion");
	      return 1; 
	      
	}
	
   // Se verifica que la habitacion no tenga vehiculo reservado
	 if (hab.getGrupo().getVehiculoReservado() != null){
	      System.out.println("Ya tienen un vehiculo reservado");
	      return 1;
	 }
	 
   //
	 Vehiculo vehiculo;
	 int i = 1;

	 for (Vehiculo veh : hotel.getVehiculos()) {
		 System.out.println(i++ + ": " + veh.toString() + System.lineSeparator()); 
	 }
	 
   // Se elige el vehiculo
	 System.out.print("Opcion: ");
	 int numVehiculo = readInt();
	 vehiculo = hotel.getVehiculos().get(numVehiculo-1);

  // Se añade el precio del restaurante a la factura del grupo de huespedes //
   hab.getGrupo().getFactura().setFacturaVehiculo(vehiculo.getPrecio());

   // Se verifica que en el vehiculo quepan los huespedes
	if (vehiculo.getCapacidad()<(hab.getGrupo().getListaHuespedes().size())) {
    System.out.println("");
		System.out.println("La capacidad del vehiculo no es suficiente para todos los huespedes");

		return 1;


	}
	
	// Se verifica que el vehiculo no este ocupado 

	if (vehiculo.isOcupado()) {
    System.out.println("");
		System.out.println("El vehiculo ya esta ocupado");

		return 1;
	}
	
	
	vehiculo.asignarDueños(hab.getGrupo());
  	return 0;
	
  }
  
}
