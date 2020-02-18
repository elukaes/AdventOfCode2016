package Day6.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static Day6.src.Main.*;

class MainTest {
    //task 1
    /*@Test
    void shouldFindIndex3WithTheHighestValue() {
        int[] counter = new int[]{5, 1, 7, 8, 2, 5};
        assertEquals(3, findIndex(counter));
    }

    @Test
    void shouldReturnR() {
        String str = "ederatsrnnstvvde";
        assertEquals('e', findLetterInColumn(str));
    }

    @Test
    void shouldReturnEaster() {
        String[] array = new String[]{"eedadn", "drvtee", "eandsr", "raavrd", "atevrs", "tsrnev", "sdttsa", "rasrtv",
                "nssdts" ,"ntnada" ,"svetve", "tesnvt", "vntsnd", "vrdear", "dvrsen" ,"enarar"};
        assertEquals("easter", findMessage(array));
    }*/

    //task 2
    @Test
    void shouldFindIndex1WithTheLowestValue() {
        int[] counter = new int[]{5, 1, 7, 8, 2, 5};
        assertEquals(1, findIndex(counter));
    }

    @Test
    void shouldReturnA() {
        String str = "ederatsrnnstvvde";
        assertEquals('a', findLetterInColumn(str));
    }

    @Test
    void shouldReturnAdvent() {
        String[] array = new String[]{"eedadn", "drvtee", "eandsr", "raavrd", "atevrs", "tsrnev", "sdttsa", "rasrtv",
                "nssdts" ,"ntnada" ,"svetve", "tesnvt", "vntsnd", "vrdear", "dvrsen" ,"enarar"};
        assertEquals("advent", findMessage(array));
    }
}