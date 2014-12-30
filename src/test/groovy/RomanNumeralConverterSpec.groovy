import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralConverterSpec extends Specification {

    @Unroll
    def "arabic to roman should convert #input to #expected properly"() {
        expect:
        expected == RomanNumeralConverter.convertArabicToRoman(input)

        where:
        expected | input
        "I"      | 1
        "II"     | 2
        "III"    | 3
        "IV"     | 4
        "V"      | 5
        "VIII"   | 8
        "IX"     | 9
        "X"      | 10
        "XV"     | 15
        "L"      | 50
        "LXXV"   | 75
        "LXXXV"  | 85
        "XCIX"   | 99
        "C"      | 100
        "D"      | 500
        "CMXCIX" | 999
        "M"      | 1000
        "MMM"    | 3000
    }

    @Unroll
    def "roman to arabic should convert #input to #expected properly"() {
        expect:
        expected == RomanNumeralConverter.convertRomanToArabic(input)

        where:
        expected | input
        1        | "I"
        2        | "II"
        3        | "III"
        4        | "IV"
        5        | "V"
        8        | "VIII"
        9        | "IX"
        10       | "X"
        15       | "XV"
        50       | "L"
        75       | "LXXV"
        85       | "LXXXV"
        99       | "XCIX"
        100      | "C"
        500      | "D"
        999      | "CMXCIX"
        1000     | "M"
        3000     | "MMM"
    }

}