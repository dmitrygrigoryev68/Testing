import static java.util.Arrays.asList;
import static  org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DemoTest {

    /*
    @Before
    public void setUp(){
    System.out.println("Init");
    }
    */
    @Test
    public void testCheckStringForSelf() {
        String actual = CalcTest.checkString( "Ivanoff");
        assertEquals("stings","Ivanoff",actual);

    }
    @Test
    public void testCheckStringLength3() {
        String actual = CalcTest.checkString ( "Iva");
        assertEquals("stings","IVA",actual);

    }
    @Test
    public void testCheckStringLength4() {
        String actual = CalcTest.checkString( "Ivan");
        assertEquals("stings","ivan",actual);

    }
    @Test(expected = IncorrectInputDataException.class)
    public void testCheckStringIsNull() {
       CalcTest.checkString( null);
    }


    @Test
    public void schouldTransformUp() {
        String actual = Functions.transform("aaa bbbb CCCC ddd XXX",str -> str.length() == 3,str -> str = str.toUpperCase());
        assertEquals("stings","AAA, bbbb, CCCC, DDD, XXX",actual);
    }

    @Test
    public void schouldTransformLow() {
        String actual = Functions.transform("aaa bbbb CCCC ddd XXX",str -> str.length() == 4,str -> str = str.toLowerCase());
        assertEquals("stings","aaa, bbbb, cccc, ddd, XXX",actual);
    }

    @Test(expected = IncorrectInputDataException.class)
    public void schouldTransformIsNull() {
        Functions.transform(null,str -> str.length() == 4,str -> str = str.toLowerCase());
    }

    @Test
    public void schouldpeopleOlderThan17() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);

        List<Person> persons = asList(p1,p2,p3);
        List<Person> actual = Functions.peopleOlderThan17(persons);
        assertEquals("List",asList(p1,p3),actual);
    }
    @Test
    public void schoulddistinctedNames() {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Maria");
        names.add("Adolf");
        names.add("Josef");
        names.add("Ivan");
        names.add("Maria");
        names.add("Stefan");
        names.add("Adam");
        List<String> actual = Functions.distinctedNames(names);
        assertEquals("List",asList("Ivan","Maria","Adolf","Josef","Stefan","Adam"),actual);
    }
    @Test
    public void schouldgroupByAge() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);

        List<Person> persons = asList(p1,p2,p3);
        Map<Integer,List<Person>> actual = Functions.groupByAge(41,persons);
        assertEquals(actual.get(41), asList(p1, p3));
    }




}
