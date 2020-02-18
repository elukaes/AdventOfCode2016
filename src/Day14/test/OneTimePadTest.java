package Day14.test;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static Day14.src.OneTimePad.*;
import static org.junit.jupiter.api.Assertions.*;

class OneTimePadTest {
    @Test
    void theSameCharacters() {
        assertTrue(isTheSameCharacters(new char[] {'a', 'a', 'a'}));
    }

    @Test
    void notTheSameCharacters() {
        assertFalse(isTheSameCharacters(new char[] {'c', 'b', 'a'}));
    }

    @Test
    void indexKey() throws NoSuchAlgorithmException {
        assertTrue(isIndexKey("abc", 39, 'e'));
    }

    @Test
    void notIndexKey() throws NoSuchAlgorithmException {
        assertFalse(isIndexKey("abc", 18, '8'));
    }

    @Test
    void indexProduces64thOneTimePadKeyEquals22728() throws NoSuchAlgorithmException {
        assertEquals(22728, findIndexProduces64thOneTimePadKey("abc"));
    }
}