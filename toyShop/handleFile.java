package toyShop;

import toyShop.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class handleFile {
    public static ArrayList<Toy> readFromFile(String file) throws Exception {
        ArrayList<Toy> toys = new ArrayList<>();
        try (
                FileInputStream inputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            while (inputStream.available() > 0) {
                Toy toy = (Toy) objectInputStream.readObject();
                toys.add(toy);
            }
        }

        return toys;
    }

    public static void saveToFile(String file, Toy toy) {
        try (
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            objectOutputStream.writeObject(toy);
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void saveToFile(String file, ArrayList<Toy> toys) {
        try (
                FileOutputStream outputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ) {
            for (Toy toy : toys) {
                objectOutputStream.writeObject(toy);
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }



    public void removeFromFile() {

    }
}
