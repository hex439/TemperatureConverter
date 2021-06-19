package au.edu.jcu.cp3406.assignment1_converterapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void toFahrenheit_isCorrect() { assertEquals(33.80, Conversion.toFahrenheit(1), 0.001); }

    @Test
    public void toCelsius_isCorrect() {assertEquals(1, Conversion.toCelsius(33.8), 0.001);}

}