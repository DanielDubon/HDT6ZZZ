package Controller;

import Model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryManager {

    public static void AddProduct(Map<String, ArrayList<Producto>> map, String categoria, String producto, int cantidad) {
        if (!map.containsKey(categoria)) {
            System.out.println("ERROR: no existe la categoria");
            return;
        }
        for (Producto prod : map.get(categoria)) {
            if (prod.getNombre().equals(producto)) {
                prod.setCantidad(prod.getCantidad() + cantidad);
                System.out.println("Producto agregador correctamente!");
            }
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

    public static String getCategory(Map<String, ArrayList<Producto>> map, String categoria) {
       return "A";

    }
}