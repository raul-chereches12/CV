package ex6;


import org.junit.jupiter.api.Test;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

public class testShape {


    @Test
    void testConstructorShape() {
        Shape forma = new Shape();
        assertEquals("red",forma.getColor());
        assertTrue(forma.isFilled());



    }

    @Test
    void testConstructorCircle() {

      Circle cerc = new Circle(4.0);
       assertEquals(4.0, cerc.getRadius());


        Circle cerc1 = new Circle(4.0,"red",false);
        assertEquals(4.0, cerc1.getRadius());
        assertEquals("red",cerc1.getColor());
        assertFalse(cerc1.isFilled());




    }

    @Test
    void testConstructorRectangle() {
        Rectangle dreptunghi = new Rectangle();
        assertEquals(1.0, dreptunghi.getWidth());
        assertEquals(1.0, dreptunghi.getLength());

        Rectangle dreptunghi1 = new Rectangle(5.0,5.0);
        assertEquals(5.0, dreptunghi1.getWidth());
        assertEquals(5.0, dreptunghi1.getLength());

        Rectangle dreptunghi2 = new Rectangle(5.0,6.0,"blue",false);
        assertEquals(5.0, dreptunghi2.getWidth());
        assertEquals(6.0, dreptunghi2.getLength());
        assertEquals("blue",dreptunghi2.getColor());
        assertFalse(dreptunghi2.isFilled());

        assertEquals(2*5+2*6, dreptunghi2.getPerimeter());
        assertEquals(5*6, dreptunghi2.getArea());



    }

    @Test
    void testConstructorSquare() {

        Square patrat = new Square(3.0);
        assertEquals(3.0, patrat.getSide());


        Square patrat1 = new Square(3.0,"yellow",true);
        assertEquals(3.0, patrat1.getSide());
        assertEquals("yellow",patrat1.getColor());
        assertTrue(patrat1.isFilled());




    }



}