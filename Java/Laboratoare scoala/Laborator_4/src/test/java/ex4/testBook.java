package ex4;



import ex2.Author;
import org.junit.jupiter.api.Test;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBook {
    @Test
    void testConstructor(){
        Author[] authorArray=new Author[2];
        authorArray[0]=new Author("raul","raul.chereches@yahoo.com",'m');
        authorArray[1]=new Author("moni","moni.chereches@yahoo.com",'f');

        Book carte=new Book("Lord of the Rings",authorArray,500);

        assertEquals("Lord of the Rings",carte.getName());

        assertEquals("raul",carte.getAuthors()[0].getName());
        assertEquals("moni",carte.getAuthors()[1].getName());

        assertEquals("raul.chereches@yahoo.com",carte.getAuthors()[0].getEmail());
        assertEquals("moni.chereches@yahoo.com",carte.getAuthors()[1].getEmail());

        assertEquals('m',carte.getAuthors()[0].getGender());
        assertEquals('f',carte.getAuthors()[1].getGender());

        assertEquals(500,carte.getPrice());




        Book carteCuIteme=new Book("Lord of the Rings",authorArray,500,5);

        assertEquals("Lord of the Rings",carteCuIteme.getName());

        assertEquals("raul",carteCuIteme.getAuthors()[0].getName());
        assertEquals("moni",carteCuIteme.getAuthors()[1].getName());

        assertEquals("raul.chereches@yahoo.com",carteCuIteme.getAuthors()[0].getEmail());
        assertEquals("moni.chereches@yahoo.com",carteCuIteme.getAuthors()[1].getEmail());

        assertEquals('m',carteCuIteme.getAuthors()[0].getGender());
        assertEquals('f',carteCuIteme.getAuthors()[1].getGender());

        assertEquals(500,carteCuIteme.getPrice());
        assertEquals(5,carteCuIteme.getQtyInStock());



    }

}
