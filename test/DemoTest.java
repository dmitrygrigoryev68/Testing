import static java.util.Arrays.asList;
import static org.junit.Assert.*;

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
        String actual = CalcTest.checkString("Ivanoff");
        assertEquals("stings", "Ivanoff", actual);

    }

    @Test
    public void testCheckStringLength3() {
        String actual = CalcTest.checkString("Iva");
        assertEquals("stings", "IVA", actual);

    }

    @Test
    public void testCheckStringLength4() {
        String actual = CalcTest.checkString("Ivan");
        assertEquals("stings", "ivan", actual);

    }

    @Test(expected = IncorrectInputDataException.class)
    public void testCheckStringIsNull() {
        CalcTest.checkString(null);
    }


    @Test
    public void schouldTransformUp() {
        String actual = Functions.transform("aaa bbbb CCCC ddd XXX", str -> str.length() == 3, str -> str = str.toUpperCase());
        assertEquals("stings", "AAA, bbbb, CCCC, DDD, XXX", actual);
    }

    @Test
    public void schouldTransformLow() {
        String actual = Functions.transform("aaa bbbb CCCC ddd XXX", str -> str.length() == 4, str -> str = str.toLowerCase());
        assertEquals("stings", "aaa, bbbb, cccc, ddd, XXX", actual);
    }

    @Test(expected = IncorrectInputDataException.class)
    public void schouldTransformIsNull() {
        Functions.transform(null, str -> str.length() == 4, str -> str = str.toLowerCase());
    }

    @Test
    public void schouldpeopleOlderThan17() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);

        List<Person> persons = asList(p1, p2, p3);
        List<Person> actual = Functions.peopleOlderThan17(persons);
        assertEquals("List", asList(p1, p3), actual);
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
        names.add(null);
        names.add("Adam");
        List<String> actual = Functions.distinctedNames(names);
        assertEquals("List", asList("Ivan", "Maria", "Adolf", "Josef", null  , "Adam"), actual);
    }

    @Test
    public void schouldgroupByAge() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);

        List<Person> persons = asList(p1, p2, p3);
        Map<Integer, List<Person>> actual = Functions.groupByAge(41, persons);
        assertEquals(actual.get(41), asList(p1, p3));
    }

    @Test
    public void schouldGroupByPeson() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);

        BankAccount b1 = new BankAccount(p1, "DE5676609876556581");
        BankAccount b2 = new BankAccount(p1, "DE5676609876556582");
        BankAccount b3 = new BankAccount(p1, "DE5676609876556583");
        BankAccount b4 = new BankAccount(p2, "DE5676609876556584");
        BankAccount b5 = new BankAccount(p2, "DE5676609876556585");
        BankAccount b6 = new BankAccount(p3, "DE5676609876556586");
        BankAccount b7 = new BankAccount(p3, "DE5676609876556587");
        BankAccount b8 = new BankAccount(p4, "DE5676609876556588");

        List<BankAccount> accounts = asList(b1, b2, b3, b4, b5, b6, b7, b8);
        Map<Person, List<BankAccount>> actual = Functions.groupByPerson(p1, accounts);
        assertEquals(actual.get(p1), asList(b1, b2, b3));
    }
    @Test
    public void schouldMapAccByPeson() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);

        BankAccount b1 = new BankAccount(p1, "DE5676609876556581");
        BankAccount b2 = new BankAccount(p1, "DE5676609876556582");
        BankAccount b3 = new BankAccount(p1, "DE5676609876556583");
        BankAccount b4 = new BankAccount(p2, "DE5676609876556584");
        BankAccount b5 = new BankAccount(p2, "DE5676609876556585");
        BankAccount b6 = new BankAccount(p3, "DE5676609876556586");
        BankAccount b7 = new BankAccount(p3, "DE5676609876556587");
        BankAccount b8 = new BankAccount(p4, "DE5676609876556588");

        List<BankAccount> accounts = asList(b1, b2, b3, b4, b5, b6, b7, b8);
        Map<Person, List<BankAccount>> actual = Functions.mapAccByPerson(accounts);
        assertEquals(actual.get(p1), asList(b1, b2, b3));
        assertEquals(actual.get(p2), asList(b4, b5));
        assertEquals(actual.get(p3), asList(b6, b7));
        assertEquals(actual.get(p4), asList(b8));
    }
    @Test
    public void schouldIbanByStars() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);

        BankAccount b1 = new BankAccount(p1, "DE5676609876556581");
        BankAccount b2 = new BankAccount(p1, "DE5676609876556582");
        BankAccount b3 = new BankAccount(p1, "DE5676609876556583");
        BankAccount b4 = new BankAccount(p2, "DE5676609876556584");
        BankAccount b5 = new BankAccount(p2, "DE5676609876556585");
        BankAccount b6 = new BankAccount(p3, "DE5676609876556586");
        BankAccount b7 = new BankAccount(p3, "DE5676609876556587");
        BankAccount b8 = new BankAccount(p4, "DE5676609876556588");

        List<BankAccount> accounts = asList(b1, b2, b3, b4, b5, b6, b7, b8);
        List<String> actual = Functions.ibanWithStars(accounts);
        assertEquals("List",asList("DE567***************","DE567***************","DE567***************"
                ,"DE567***************","DE567***************","DE567***************","DE567***************"
                ,"DE567***************"),actual);
    }
    @Test
    public void shouldSumAgePersonsOlderThan17() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);

        List<Person> users = asList(p1,p2,p3,p4);
        int sumAge = Functions.sumOfAgesPersonsOlderThan17(users);
        int assertAge = 82;
        assertEquals(sumAge, assertAge);
    }
    @Test
    public void shouldLegalageString() {
        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);

        List<Person> persons = asList(p1,p2,p3,p4);
        String legalString = Functions.legalAgeString(persons);
        assertEquals(legalString, "In Germany Ivan Draga and Oleg Braga are of legal age.");
    }
    @Test
    public void shouldFirstBooksFromSentenceCounter() {
        String sentence = "To be or not to be - that is the question!";
        long sumBooks = Functions.firstBooksFromSentenceCounter("t",sentence);
        long assertBooks = 3;
        assertEquals(sumBooks, assertBooks);
    }
    @Test
    public void shouldIsTheStringInteger() {
        String integer = "128348395298592";
        boolean result = Functions.isTheStringInteger(integer);
        assertEquals(result, true);
    }



}
