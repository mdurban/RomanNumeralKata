import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralConverterSpec extends Specification {

    @Unroll
    def "should convert #input to #expected properly"() {
        expect:
        expected == RomanNumeralConverter.convertArabicToRoman(input)

        where:
        expected | input
        "I"      | 1
//        "II"     | 2
//        "III"    | 3
        "V"      | 5
        "X"      | 10
        "XV"     | 15
        "L"      | 50
        "C"      | 100
        "D"      | 500
        "M"      | 1000
    }

}