import static  org.junit.Assert.*;
import org.junit.Test;


public class DemoTest {

    /*
    @Before
    public void setUp(){
    System.out.println("Init");
    }
    */
    @Test
    public void testCheckStringForSelf() throws IncorrectException {
        String actual = CalcTest.checkString( "Ivanoff");
        assertEquals("stings","Ivanoff",actual);

    }
    @Test
    public void testCheckStringLength3()throws IncorrectException{
        String actual = CalcTest.checkString ( "Iva");
        assertEquals("stings","IVA",actual);

    }
    public void testCheckStringLength4() throws IncorrectException{
        String actual = CalcTest.checkString( "Ivan");
        assertEquals("stings","ivan",actual);

    }
    public void testCheckStringIsNull() throws IncorrectException{
        String actual = CalcTest.checkString( null);
    }
}
