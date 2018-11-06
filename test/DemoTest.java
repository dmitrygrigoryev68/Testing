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
    public void testCheckStringForSelf() throws Exception {
        String actual = CalcTest.checkString( "Ivanoff");
        assertEquals("stings","Ivanoff",actual);

    }
    @Test
    public void testCheckStringLength3()throws Exception{
        String actual = CalcTest.checkString ( "Iva");
        assertEquals("stings","IVA",actual);

    }
    @Test
    public void testCheckStringLength4() throws Exception{
        String actual = CalcTest.checkString( "Ivan");
        assertEquals("stings","ivan",actual);

    }
    @Test(expected = IncorrectException.class)
    public void testCheckStringIsNull() throws Exception{
       CalcTest.checkString( null);
    }
}
