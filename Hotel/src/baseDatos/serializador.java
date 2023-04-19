package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class serializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void serializar(Object algo){
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles();
        PrintWriter pw;

        //*borra los archivos antes de guardar */
        for (File file: docs){
            try {
                //*Borra lo que haya en ellos automaticamente */
                pw = new PrintWriter(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (File file: docs){
            if (file.getAbsolutePath().contains("habitacion")){
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(algo);   //?habitacion

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("huesped")){
                //!sin terminar
            }
        }

    }
}
