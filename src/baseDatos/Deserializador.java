package baseDatos;

import java.io.*;
import java.util.List;

import gestorAplicacion.Habitaciones.Habitacion;
import gestorAplicacion.Restaurantes.Restaurante;
import gestorAplicacion.hoteles.Hotel;
import gestorAplicacion.transporte.Vehiculo;

// La clase Deserializador se encarga de deserializar (reconstruir un objeto a partir de
// una secuencia de bytes previamente serializada) los datos guardados en archivos
//  y restaurar el estado de los objetos en el sistema.

// Deserializa los datos de habitaciones, restaurantes y vehículos y los asigna a la clase "Hotel".

//* Se debe llamar en el constructor del objecto */

//@param hotel La instancia de la clase "Hotel" al que se asignarán los datos deserializados.

public class Deserializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void deserializar(Hotel hotel){
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;

        for (File file: docs){
            if (file.getAbsolutePath().contains("habitaciones")) {
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);
                    
                    hotel.setHabitaciones((List<Habitacion>) ois.readObject());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }//catch (ClassNotFoundException e){e.printStackTrace();}
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                                }
            } 
            else if (file.getAbsolutePath().contains("restaurantes")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);
                    
                    hotel.setRestaurantes((List<Restaurante>) ois.readObject());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }//catch (ClassNotFoundException e){e.printStackTrace();}
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                                }
            }
            else if (file.getAbsolutePath().contains("vehiculos")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);
                    
                    hotel.setVehiculos((List<Vehiculo>) ois.readObject());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }//catch (ClassNotFoundException e){e.printStackTrace();}
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                                }
            }
  
        }
    }
}
