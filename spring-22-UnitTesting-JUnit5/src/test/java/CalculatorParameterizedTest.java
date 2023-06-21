import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty());  // ^^ tests run for each String
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase2(int num) {
        Assertions.assertEquals(0, num % 3);
        // are all provided ints {3, 6, 9} evenly divisible by 3 (expected remainder 0)
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource    // adds Empty arg to ^^ above list
//    @NullSource     // adds Null arg to above list ^^
    @NullAndEmptySource     // adds Null AND Empty arg to above list ^^
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());
        // tests run for each String in stringProvider Factory Method
    }

    static String[] stringProvider() {
        return new String[]{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100",
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",
            numLinesToSkip = 1)
    // skip # of lines ^^ in source file (1st line is the headers: num1, num2, result)
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    // maven-surefire-plugin
    // ^^ allows us to run Maven commands through Terminal

}
