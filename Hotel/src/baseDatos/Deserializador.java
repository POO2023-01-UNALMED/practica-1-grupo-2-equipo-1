package baseDatos;

import java.io.*;
import java.util.List;

import gestorAplicacion.Habitaciones.Habitacion;
import gestorAplicacion.hoteles.Hotel;

//* Se debe llamar en el constructor del objecto */
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
            } else {
                
            }
        }
    }
}
