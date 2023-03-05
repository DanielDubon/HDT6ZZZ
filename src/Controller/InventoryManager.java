package Controller;

import Model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryManager {

    public static void AddProduct(Map<String, ArrayList<Producto>> map, String categoria , String producto, int cantidad){
        if (!map.containsKey(categoria)){
            System.out.println("ERROR: no existe la categoria");
            return;
        }





    }
}
