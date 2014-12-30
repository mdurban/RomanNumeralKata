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

}