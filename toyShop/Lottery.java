package toyShop;

import toyShop.Toy;

import java.util.ArrayList;
import java.util.Random;


public class Lottery {
    ArrayList<Toy> toys;
    static final String toyShopList = "toyShopList.bin";
    static final String toyWinList = "toyWinList.bin";

    public Lottery(int toysAmount) {
        try {
            System.out.println("Поиск базы данных");
            this.toys = handleFile.readFromFile(toyShopList);
            this.toys.addAll(createToyList(toysAmount));
            System.out.println("Добавление новых данных");
        } catch (Exception e) {
            System.out.println("Создание новой базы данных");
            this.toys = createToyList(toysAmount);
        }
    }

    public void start() {
        Toy prize = chooseToy(toys);
        System.out.println("Выпала игрушка " + prize);
        givePrize(prize);
    }

    public void stop() {
        handleFile.saveToFile(toyShopList, toys);
        System.out.println("База даных сохранена");
    }


    public Toy chooseToy(ArrayList<Toy> toys) {
        int listSize = toys.size();
        int randNum = new Random().nextInt(listSize);
        Toy prize = toys.get(randNum);
        toys.remove(randNum);
        return prize;
    }

    public void givePrize(Toy prize){
        try {
            ArrayList<Toy> prizeList = handleFile.readFromFile(toyWinList);
            prizeList.add(prize);
            handleFile.saveToFile(toyWinList, prizeList);
            System.out.println("Данные о выигрыше записаны в файл");
        } catch (Exception e) {
            handleFile.saveToFile(toyWinList, prize);
            System.out.println("Создан новый файл. Данные добавлены");
        }

    }

    public static ArrayList<Toy> createToyList(int amount) {
        ArrayList<Toy> toys  = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Toy toy = new Toy("toy" + i);
            toys.add(toy);
        }
        handleFile.saveToFile(toyShopList, toys);
        return toys;
    }
}