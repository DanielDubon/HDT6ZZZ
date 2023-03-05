package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {

    public static void readStoreStock(Map<String, List<String>> map){
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
                map.get(categoria).add(producto);
            }


            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        System.out.println(map);
    }
}

