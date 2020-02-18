package Day4.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static Day4.src.Room.*;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Map<Character, Integer> name;

    @BeforeEach
    void setUp() {
        name = new LinkedHashMap<>();
    }

    @Test
    void sTimes3aTimes5() {
        name.put('a', 5);
        name.put('s', 3);
        String s = "asasaasa";
        assertEquals(name, lettersCounter(s));
    }

    @Test
    void rTimes1zTimes1() {
        name.put('r', 1);
        name.put('z', 1);
        String s = "zr";
        assertEquals(name, lettersCounter(s));
    }

    @Test
    void roomShouldBeReal() {
        name = lettersCounter("atbgczzcgtagazag");
        String checkSum = "agzct";
        assertTrue(isRealRoom(name, checkSum));
    }

    @Test
    void roomShouldNotBeReal() {
        name = lettersCounter("ewtiojsdntwe");
        String checkSum = "unywe";
        assertFalse(isRealRoom(name, checkSum));
    }

    @Test
    void nameRoomEqualsGoodChoice() {
        String encrypt = "weet-sxeysu-";
        String decrypt = "good choice";
        int shift = 10;
        assertEquals(decrypt, decryptNameRoom(encrypt, shift));
    }

    @Test
    void nameRoomEqualsAttack() {
        String encrypt = "zsszbj-";
        String decrypt = "attack";
        int shift = 1;
        assertEquals(decrypt, decryptNameRoom(encrypt, shift));
    }
}