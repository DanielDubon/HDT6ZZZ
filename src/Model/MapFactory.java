package Model;
import java.util.*;

public class MapFactory {


    public static Map<String, ArrayList<Producto>> createMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<String, ArrayList<Producto>>();
            case 2:
                return new TreeMap<String, ArrayList<Producto>>();
            case 3:
                return new LinkedHashMap<String, ArrayList<Producto>>();
            default:
                throw new IllegalArgumentException("Opción inválida: " + option);
        }
    }
}