import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    public void emptyStringThrowsException() {
        var e = assertThrows(NumberFormatException.class, () -> MyInteger.decode(""));
        var expectedMes = "Zero length string";
        var actualMes = e.getMessage();
        assertTrue(actualMes.contains(expectedMes));
    }

    @Test
    public void wrongSingPositionThrowsException() {
        var e = assertThrows(NumberFormatException.class, () -> MyInteger.decode("++1"));
        var expectedMes = "Sign character in wrong position";
        var actualMes = e.getMessage();
        assertTrue(actualMes.contains(expectedMes));
    }

    @Test
    public void decodeNotANumber() {
        var e = assertThrows(NumberFormatException.class, () -> MyInteger.decode("abc"));
        var expectedMes = "For input string: \"abc\"";
        var actualMes = e.getMessage();
        assertTrue(actualMes.contains(expectedMes));
    }

    @Test
    public void decodePositive() {
        var result = MyInteger.decode("+10");
        assertEquals(10, result);
    }


    @Test
    public void decodeNegative() {
        var result = MyInteger.decode("-10");
        assertEquals(-10, result);
    }

    @Test
    public void decodeHex() {
        var result = MyInteger.decode("0xA");
        assertEquals(10, result);
    }

    @Test
    public void decodeHex2() {
        var result = MyInteger.decode("#A");
        assertEquals(10, result);
    }

    @Test
    public void decodeOct() {
        var result = MyInteger.decode("012");
        assertEquals(10, result);
    }
}