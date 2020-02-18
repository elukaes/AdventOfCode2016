package Day15.test;

import Day15.src.Disc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscTest {
    @Test
    void discShouldBeAtPosition2() {
        Disc disc = new Disc(4, 0);
        disc.goForward(10);
        assertEquals(2, disc.getActPos());
    }

    @Test
    void discShouldBeAtPosition0() {
        Disc disc = new Disc(5, 4);
        disc.goForward(1);
        assertEquals(0, disc.getActPos());
    }
}