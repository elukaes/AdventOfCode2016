package Day1.Task1.test;

import Day1.src.Direction;
import Day1.src.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {
    private Movement movement;

    @BeforeEach
    void setUp() {
        movement = new Movement();
    }

    @Test
    void turnLeftFromNorth() {
        movement.move('L', 0);
        assertEquals(Direction.WEST.toString(), movement.getCurrDirection());
    }
    @Test
    void turnRightFromNorth() {
        movement.move('R', 0);
        assertEquals(Direction.EAST.toString(), movement.getCurrDirection());
    }

    @Test
    void toWest5steps() {
        movement.move('L', 5);
        assertEquals(0, movement.getPositionY());
        assertEquals(-5, movement.getPositionX());
    }

    @Test
    void toEast8steps() {
        movement.move('R', 8);
        assertEquals(0, movement.getPositionY());
        assertEquals(8, movement.getPositionX());
    }

    @Test
    void toSouth2steps() {
        movement.move('R', 2);
        movement.move('R', 2);
        movement.move('R', 2);
        assertEquals(-2, movement.getPositionY());
        assertEquals(0, movement.getPositionX());
    }

    @Test
    void toNorth4steps() {
        movement.move('L', 4);
        movement.move('R', 4);
        movement.move('R', 4);
        assertEquals(4, movement.getPositionY());
        assertEquals(0, movement.getPositionX());
    }

    @Test
    void toNorth7StepsAndToWest3Steps() {
        movement.move('L', 3);
        movement.move('R', 7);
        assertEquals(7, movement.getPositionY());
        assertEquals(-3, movement.getPositionX());
    }

    @Test
    void toSouth1StepsAndToEast11Steps() {
        movement.move('L', 3);
        movement.move('L', 1);
        movement.move('L', 14);
        assertEquals(-1, movement.getPositionY());
        assertEquals(11, movement.getPositionX());
    }
}