import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JUnit5ExampleTests {
    @Test
    void shouldAddOneAndOne() {
        var actual = 1 + 1;
        var expected = 2;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ "1, 1, 2", "2, 2, 4", "5, 109, 114" })
    void shouldAddOtherNumbers(int left, int right, int expectedResult) {
        assertEquals(expectedResult, left + right);
    }

    // Things I remember being painful about JUnit 5:
    // - They expected things like formatting results to be handled by gradle plugins, not the framework - it looks like this has been fixed now though
    // - It didn't used to output the results in XML format, so it was a pain to show the tests in Jenkins etc. - also looks fixed
    // - Customizing the console output (in our case to add some colours) was a pain - this may be better now though.
    // - IntelliJ support was shitty, but this also looks a lot better now.

    // Things that are cool:
    // - It's much better at dynamic tests
}
