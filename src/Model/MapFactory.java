package Model;
import java.util.*;

public class MapFactory {


    public static Map<String, List<String>> createMap(int option) {
        switch (option) {
            case 1:
                return new HashMap<String, List<String>>();
            case 2:
                return new TreeMap<String, List<String>>();
            case 3:
                return new LinkedHashMap<String, List<String>>();
            default:
                throw new IllegalArgumentException("Opción inválida: " + option);
        }
    }
}