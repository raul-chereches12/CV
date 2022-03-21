package ex5;
import ex4.MyPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFlower {


    @Test
    void testCounting() {
        Flower floare= new Flower();
        Flower floare1= new Flower();
        Flower floare2= new Flower();
        assertEquals(3,floare.numberOfConstructedObjects());

    }

}
