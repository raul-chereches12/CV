package ex3;


import ex2.Author;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBook {
    @Test
    void testConstructor(){
        Book carte=new Book("Raul",new Author("Adison Wesley","adison_wesley@yahoo.com",'m'),250);

        assertEquals("Raul",carte.getName());
        assertEquals("Adison Wesley",carte.getAuthor().getName());
        assertEquals("adison_wesley@yahoo.com",carte.getAuthor().getEmail());
        assertEquals('m',carte.getAuthor().getGender());
        assertEquals(250,carte.getPrice());

    }

}
