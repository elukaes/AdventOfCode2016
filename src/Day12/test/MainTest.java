package Day12.test;

import Day12.src.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static Day12.src.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Map<Character, Integer> expected;
    @BeforeEach
    void setUp() {
        expected = new HashMap<>();
    }

    @Test
    void testAllMethods() {
        expected.put('a', 11);
        expected.put('b', 9);
        copyValue("10", "a");
        copyValue("a", "b");
        incrementValue("a");
        decrementValue("b");
        assertTrue(expected.equals(getRegister()));
    }

}