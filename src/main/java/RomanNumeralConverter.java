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
        final int [] currentValue = new int[] { arabic };

        map.descendingKeySet().forEach((key) -> {
            int multipleOfKey = currentValue[0] / key;

            for (int i = 0; i < multipleOfKey; i++) {
                sb.append(map.get(key));
            }

            currentValue[0] %= key;
        });

        return sb.toString();
    }
}
