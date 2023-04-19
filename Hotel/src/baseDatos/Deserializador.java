package baseDatos;

import java.io.*;

//* Se debe llamar en el constructor del objecto */
public class Deserializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void deserializar(Object algo){
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;

        for (File file: docs){
            if (file.getAbsolutePath().contains("habitacion")) {
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);
                    
                    //Habitaciones.setHabitaciones((Habitacion ois.readObject()))

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }//catch (ClassNotFoundException e){e.printStackTrace();}
            } else {
                
            }
        }
    }
}
