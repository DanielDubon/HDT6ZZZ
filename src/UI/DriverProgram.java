package UI;

import Controller.ReadFile;
import Model.MapFactory;
import Model.Producto;
import Controller.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Controller.InventoryManager.AddProduct;
import static Controller.InventoryManager.SearchCategory;
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

        Map<String, ArrayList<Producto>> map = createMap(option);
        readStoreStock(map);

        while (menu){
            System.out.println("¿Que desea realizar?");
            System.out.println("1. Agregar producto.");
            System.out.println("2. Mostrar categoria de producto.");
            System.out.println("3. Mostrar datos del producto.");
            System.out.println("4. Mostrar datos del producto, categoria y cantidad de cada articulo por tipo.");
            System.out.println("5. Mostrar producto y catewgoria de todo el inventario");
            System.out.println("6. Mostrar producto y categoria ordenada por tipo.");
            option = in.nextInt();

            switch (option){
                case 1:
                    System.out.println("Ingrese nombre de categoria a buscar:");
                    in.nextLine();
                    String categoria = in.nextLine();
                    System.out.println("Ingrese nombre de producto a ingresar:");

                    String producto = in.nextLine();
                    System.out.println("Ingrese cantidad de producto a ingresar:");

                    int cantidad = in.nextInt();
                    in.nextLine();

                    AddProduct(map,categoria,producto,cantidad);

                    break;


                case 2:
                    System.out.println("Ingrese nombre de producto a buscar categoria: ");
                    in.nextLine();
                    producto = in.nextLine();
                    System.out.println( SearchCategory(map, producto));

                    break;

                case 3:
                    System.out.println("Ingrese nombre del producto que desea obtener datos");
                    in.nextLine();
                    producto = in.nextLine();
            }
        }

    }
}
