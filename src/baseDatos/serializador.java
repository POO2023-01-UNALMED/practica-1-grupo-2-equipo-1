package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.hoteles.Hotel;

/**
 * La clase `serializador` se encarga de serializar( convertir un objeto en una
 * secuencia de bytes, de modo que se pueda almacenar en un archivo) los datos
 * de un objeto `Hotel` y guardarlos en archivos.
 */

public class serializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    /**
     * Serializa los datos de un objeto `Hotel` y los guarda en archivos.
     *
     * @param hotel El objeto `Hotel` cuyos datos se van a serializar.
     */

    public static void serializar(Hotel hotel) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles();
        PrintWriter pw;

        // *borra los archivos antes de guardar */
        for (File file : docs) {
            try {
                // *Borra lo que haya en ellos automaticamente */
                pw = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : docs) {
            if (file.getAbsolutePath().contains("habitaciones")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(hotel.getHabitaciones());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (file.getAbsolutePath().contains("restaurantes")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(hotel.getRestaurantes());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (file.getAbsolutePath().contains("vehiculos")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(hotel.getVehiculos());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
