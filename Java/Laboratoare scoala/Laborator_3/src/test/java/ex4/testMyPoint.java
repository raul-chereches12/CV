package ex4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class testMyPoint {

    @Test
    void testConstructor() {
        MyPoint punct= new MyPoint();
        assertEquals(0,punct.getX());
        assertEquals(0,punct.getY());

    }

    @Test
    void testConstructor1() {
        MyPoint punct1= new MyPoint(4,6);
        assertEquals(4,punct1.getX());
        assertEquals(6,punct1.getY());

    }

    @Test

    void testAfisare() {
        MyPoint punct2= new MyPoint(4,6);
        assertEquals("(4,6)",punct2.toString());


    }

}
