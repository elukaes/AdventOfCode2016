package Day15.test;

import Day15.src.Disc;
import org.junit.jupiter.api.Test;

import static Day15.src.Main.isCapsuleFallsThroughSlot;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void capsuleFallsThroughSlot() {
        Disc disc = new Disc(5, 2);
        assertTrue(isCapsuleFallsThroughSlot(disc, 3));
    }

    @Test
    void capsuleNotFallsThroughSlot() {
        Disc disc = new Disc(2, 1);
        assertFalse(isCapsuleFallsThroughSlot(disc, 2));
    }
}