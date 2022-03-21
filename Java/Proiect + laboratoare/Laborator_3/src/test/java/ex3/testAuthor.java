package ex3;
import ex2.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAuthor {

    @Test

    void testConstructor() {
        Author autor = new Author("Dan", "dan.silvasan@yahoo.com", 'm');
assertEquals("Dan",autor.getName());
        assertEquals("dan.silvasan@yahoo.com",autor.getEmail());
        assertEquals('m',autor.getGender());

    }

    @Test

    void testAfisare() {
        Author autor = new Author("Dan", "dan.silvasan@yahoo.com", 'm');
        assertEquals("Dan (m) at dan.silvasan@yahoo.com",autor.toString());


    }


}
