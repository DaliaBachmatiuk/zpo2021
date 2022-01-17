import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgrammingGeekTest {

    private final IProgrammingGeek geek = new ProgrammingGeek();

    @Test
    void shouldCalculateFactorial() throws Exception {
        assertEquals(120, geek.getFactorial(5));
        assertEquals(362880, geek.getFactorial(9));
        assertEquals(1, geek.getFactorial(1));
        assertEquals(1, geek.getFactorial(0));
        assertThrows(Exception.class, () -> {geek.getFactorial(-10);});
    }

    @Test
    void shouldConvertToCamelCase() throws Exception {
        assertEquals("jestemSobieZdanie", geek.changeToCamelCase("Jestem sobie zdanie"));
        assertEquals("terazNamieszane", geek.changeToCamelCase("teRAz NamieSzane"));
        assertEquals("iTezSaCyferki123", geek.changeToCamelCase("I tez Sa CyFerki 123"));
        assertEquals("iMamTezKilkaSpacji", geek.changeToCamelCase("i mam tez  kilka   spacji "));
        assertEquals("iMamTezPewneZnaki", geek.changeToCamelCase("i mam tez ,,,, pewne znaki... "));
        assertThrows(Exception.class, () -> {geek.changeToCamelCase("  ");});
        assertThrows(Exception.class, () -> {geek.changeToCamelCase(null);});
    }

    @Test
    void shouldReturnFalseForNonPerfectNumber(){
        assertFalse(geek.isPerfect(-123));
        assertFalse(geek.isPerfect(0));
        assertFalse(geek.isPerfect(1));
        assertFalse(geek.isPerfect(5243));
    }

    @Test
    void shouldReturnTrueForPerfectNumber(){
        assertTrue(geek.isPerfect(6));
        assertTrue(geek.isPerfect(28));
        assertTrue(geek.isPerfect(496));
        assertTrue(geek.isPerfect(8128));
    }
}
