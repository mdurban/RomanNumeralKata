import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RomanNumeralConverter {

    private static final TreeMap<Integer, String> map;

    static {
        map = new TreeMap<>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");
    }

    public static String convertArabicToRoman(int arabic) {
        StringBuilder sb = new StringBuilder();
        int iterableArabic = arabic;

        for (int key : map.descendingKeySet()) {
            int currentValue =  iterableArabic / key;

            for (int i = 0; i < currentValue; i++) {
                sb.append(map.get(key));
            }

            iterableArabic %= key;
        }

        return sb.toString();
    }
}
