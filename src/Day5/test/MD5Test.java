package Day5.test;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static Day5.src.MD5.findPassword;
import static org.junit.jupiter.api.Assertions.*;

class MD5Test {
    @Test //first task
    void passwordShouldBeEqual18f47a30() throws NoSuchAlgorithmException {
        assertEquals("18f47a30", findPassword("abc", 1, 8));
    }

    @Test //second task
    void passwordShouldBeEqual05ace8e3() throws NoSuchAlgorithmException {
        assertEquals("05ace8e3", findPassword("abc", 2, 8));
    }

}