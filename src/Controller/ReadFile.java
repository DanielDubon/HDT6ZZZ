package Controller;

import Model.Producto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {

    public static void readStoreStock(Map<String, ArrayList<Producto>> map){
        try {

            File archivo = new File("C:\\Users\\danie\\Downloads\\ListadoProducto (2).txt");
            Scanner in = new Scanner(archivo);

            while (in.hasNextLine()) {
                String linea = in.nextLine();
                String[] partes = linea.split("\\|");
                String categoria = partes[0].trim();
                String producto = partes[1].trim();
                if (!map.containsKey(categoria)) {
                    map.put(categoria, new ArrayList<>());
                }

                map.get(categoria).add(new Producto(producto,1));
            }


            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }


    }
}

