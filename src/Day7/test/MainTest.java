package Day7.test;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static Day7.src.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void divideTextFor3Groups() {
        List<String> list = new LinkedList<>();
        list.add("abba");
        list.add("mnop");
        list.add("qrst");
        assertTrue(list.equals(divideText("abba[mnop]qrst")));
    }

    @Test
    void divideTextFor5Groups() {
        List<String> list = new LinkedList<>();
        list.add("ioxxoj");
        list.add("asdfgh");
        list.add("zxcvbn");
        list.add("abcdef");
        list.add("fedcba");
        assertTrue(list.equals(divideText("ioxxoj[asdfgh]zxcvbn[abcdef]fedcba")));
    }

    @Test
    void oneKindOfLetterInText() {
        assertTrue(isLettersInRowAreTheSame("aaaa"));
    }

    @Test
    void fewKindOfLetterInText() {
        assertFalse(isLettersInRowAreTheSame("bbab"));
    }

    @Test
    void palindrome() {
        assertTrue(checkText("abba", false, 4, 3));
    }

    @Test
    void notPalindrome() {
        assertFalse(checkText("abcd", false, 4, 3));
    }

    @Test
    void IPSupportTLS1() {
        assertTrue(isIPSupportTLS("abba[mnop]qrst"));
    }

    @Test
    void IPSupportTLS2() {
        assertTrue(isIPSupportTLS("ioxxoj[asdfgh]zxcvbn"));
    }

    @Test
    void IPNotSupportTLS1() {
        assertFalse(isIPSupportTLS("abcd[bddb]xyyx"));
    }

    @Test
    void IPNotSupportTLS2() {
        assertFalse(isIPSupportTLS("aaaa[qwer]tyui"));
    }

    @Test
    void IPSupportSSL1() {
        assertTrue(isIPSupportSSL("aba[bab]xyz"));
    }

    @Test
    void IPSupportSSL2() {
        assertTrue(isIPSupportSSL("aaa[kek]eke"));
    }

    @Test
    void IPSupportSSL3() {
        assertTrue(isIPSupportSSL("zazbz[bzb]cdb"));
    }

    @Test
    void IPNotSupportSSL() {
        assertFalse(isIPSupportSSL("xyx[xyx]xyx"));
    }

}