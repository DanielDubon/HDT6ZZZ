package Controller;

import Model.Producto;

import java.util.*;

import static Controller.ReadFile.readStoreStock;
import static Model.MapFactory.createMap;

public class InventoryManager {
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
            System.out.println("7. Salir.");
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
                    showInventory(map);
                    break;
                case 4:
                    showInventoryORD(map);
                    break;
                case 5:
                    showALLInventory(map);
                    break;
                case 6:
                    showALLInventoryORD(map);
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    System.out.println("ERROR");
            }
        }

    }

    public static void AddProduct(Map<String, ArrayList<Producto>> map, String categoria, String producto, int cantidad) {
        if (!map.containsKey(categoria)) {
            System.out.println("ERROR: no existe la categoria");
            return;
        }

        ArrayList<Producto> prodA = map.get(categoria);

        for (Producto prod : map.get(categoria)) {
            if (prod.getNombre().equals(producto)) {
                prod.setCantidad(prod.getCantidad() + cantidad);
                System.out.println("Producto existente añadido correctamente!");
                return;
            }
        }
        prodA.add(new Producto(producto, cantidad));
        System.out.println("Producto nuevo agregado!");

        for (Producto prodS : map.get(categoria)) {
            System.out.println(prodS.getNombre() + " " + prodS.getCantidad() + " ");
        }
    }


    public static String SearchCategory(Map<String, ArrayList<Producto>> map, String producto) {

        for (Map.Entry<String, ArrayList<Producto>> entry : map.entrySet()) {
            for (Producto prod : entry.getValue()) {
                if (prod.getNombre().equals(producto)) {
                    return entry.getKey();
                }
            }
        }
        return "Error: No se encontro categoria";
    }

    public static void showInventory(Map<String, ArrayList<Producto>> map) {
        System.out.println("Datos del producto, categoría y cantidad:");


        for (String tipo : map.keySet()) {
            ArrayList<Producto> productos = map.get(tipo);
            System.out.println("\n" + tipo + ":");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre() + " | Cantidad: " + producto.getCantidad());

            }
        }
    }

    public static void showInventoryORD(Map<String, ArrayList<Producto>> map) {
        System.out.println("Datos del producto, categoría y cantidad:");


            // Ordenar por tipo
            for (String tipo : map.keySet()) {
                ArrayList<Producto> productos = map.get(tipo);
                if (productos != null && !productos.isEmpty()) {
                    System.out.println("\n" + tipo + ":");
                    for (Producto producto : productos) {
                        System.out.println("- " + producto.getNombre()+ " | Cantidad: " + producto.getCantidad());
                    }
                }
            }

    }

    public static void  showALLInventory(Map<String, ArrayList<Producto>> map){
        System.out.println("Inventario de productos y categorías:");
        for (String categoria : map.keySet()) {
            ArrayList<Producto> productos = map.get(categoria);
            System.out.println("\n" + categoria + ":");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre());
            }
        }
    }


    public static void  showALLInventoryORD(Map<String, ArrayList<Producto>> map){
        System.out.println("Inventario de productos y categorías ordenado por tipo:");
        List<String> tiposOrdenados = new ArrayList<>(map.keySet());
        Collections.sort(tiposOrdenados);
        for (String categoria : tiposOrdenados) {
            ArrayList<Producto> productos = map.get(categoria);
            System.out.println("\n" + categoria + ":");
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre());
            }
        }
    }

}