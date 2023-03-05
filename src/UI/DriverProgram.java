package UI;

import Controller.ReadFile;
import Model.MapFactory;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Controller.ReadFile.readStoreStock;
import static Model.MapFactory.createMap;

public class DriverProgram {


    public static void main(String[] args) {

        boolean menu = true;

        Scanner in = new Scanner(System.in);
        System.out.println("Seleccione una implementación de Map: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int option = in.nextInt();

        Map<String, List<String>> map = createMap(option);
        readStoreStock(map);

        while (menu){

        }

    }
}
