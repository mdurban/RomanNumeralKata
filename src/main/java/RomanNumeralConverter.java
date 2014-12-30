import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RomanNumeralConverter {

    private static final TreeMap<Integer, String> map;
    private static final TreeMap<Integer, String> cheatersMap;

    static {
        map = new TreeMap<>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");

        cheatersMap = new TreeMap<>();
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static String convertArabicToRoman(int arabic) {
        StringBuilder sb = new StringBuilder();
        final int [] currentValue = new int[] { arabic };

        map.descendingKeySet().forEach((key) -> {
            int multipleOfKey = currentValue[0] / key;

            for (int i = 0; i < multipleOfKey; i++) {
                sb.append(map.get(key));

                if (multipleOfKey > 3) {
                    sb.replace(0, sb.length(), cheatersMap.get(arabic));
                }
            }

            currentValue[0] %= key;
        });

        return sb.toString();
    }
}
