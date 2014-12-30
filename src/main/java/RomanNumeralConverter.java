import java.util.TreeMap;

public class RomanNumeralConverter {

    private static final TreeMap<Integer, String> map;

    static {
        map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

    }

    public static String convertArabicToRoman(int arabic) {
        StringBuilder sb = new StringBuilder();
        final int [] currentValue = new int[] { arabic };

        map.descendingKeySet().forEach((mapKey) -> {
            int timesKeyIsFound = currentValue[0] / mapKey;

            for (int i = 0; i < timesKeyIsFound; i++) {
                sb.append(map.get(mapKey));
            }

            currentValue[0] %= mapKey;
        });

        return sb.toString();
    }

    public static int convertRomanToArabic(String roman) {
        return 1;
    }
}
