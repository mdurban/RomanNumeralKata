import java.util.HashMap;
import java.util.TreeMap;

public class RomanNumeralConverter {

    private static final TreeMap<Integer, String> map;
    private static final HashMap<String, Integer> valueMap;

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

        valueMap = new HashMap<>();
        valueMap.put("I", 1);
        valueMap.put("V", 5);
        valueMap.put("X", 10);
        valueMap.put("L", 50);
        valueMap.put("C", 100);
        valueMap.put("D", 500);
        valueMap.put("M", 1000);
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
        int returnVal = 0;

        for (int i = 0; i < roman.length(); i++) {
            int currentDigit = getValueFromMap(roman, i);
            int nextDigit = 0;

            if(i < (roman.length() - 1)) {
                nextDigit = getValueFromMap(roman, i + 1);
            }

            if (currentDigit < nextDigit) {
                returnVal += nextDigit - currentDigit;
                i++;
            } else {
                returnVal += currentDigit;
            }
        }

        return returnVal;
    }

    private static Integer getValueFromMap(String roman, int i) {
        return valueMap.get(roman.substring(i, i + 1));
    }
}
