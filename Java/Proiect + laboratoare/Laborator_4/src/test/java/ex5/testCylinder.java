package ex5;



import org.junit.jupiter.api.Test;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCylinder {
    @Test
    void testConstructor() {
        Cylinder cilindru = new Cylinder();
        assertEquals(1.0, cilindru.getHeight());
    }

    @Test
    void testConstructor2() {
        Cylinder cilindru = new Cylinder(5.0);
        assertEquals(1.0, cilindru.getHeight());
        assertEquals(PI*5*5*cilindru.getHeight(),cilindru.getVolume());
        assertEquals(2*PI*5*cilindru.getHeight()+2*PI*5*5,cilindru.getArea());
    }
        @Test
        void testConstructor3 () {
            Cylinder cilindru = new Cylinder(5.0, 5.0);
            assertEquals(5.0, cilindru.getHeight());
            assertEquals(PI * 5 * 5 * cilindru.getHeight(), cilindru.getVolume());
            assertEquals(2 * PI * 5 * cilindru.getHeight() + 2 * PI * 5 * 5, cilindru.getArea());

        }



}

