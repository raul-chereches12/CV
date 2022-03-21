package ex1;
import static java.lang.Math.PI;
import ex1.Circle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCircle {


    @Test
    void testConstructor(){
        Circle cerc=new Circle();
        assertEquals(1,cerc.getRadius());


    }
    @Test
    void testConstructor1(){
        Circle cerc=new Circle(1);
        assertEquals(1,cerc.getRadius());


    }

   @Test
    void testGetArea(){
        Circle cerc=new Circle(1);
        assertEquals(PI,cerc.getArea());


    }

}
