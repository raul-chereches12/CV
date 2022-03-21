package ex2;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testAuthor {


    @Test
    void testConstructor(){
        Author autor=new Author("raul","raul.chereches@yahoo.com",'m');
        assertEquals("raul",autor.getName());
        assertEquals("raul.chereches@yahoo.com",autor.getEmail());
        assertEquals('m',autor.getGender());
    }




}
