import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    public static void main(String[] args) {

        String sentence = "To be or not to be - that is the question!";

        String integer = "1283483985298592";

        Address a1 = new Address("Lenin", "101");
        Address a2 = new Address("Libknecht", "95");
        Address a3 = new Address("Marx", "16");
        Address a4 = new Address("Engels", "34");
        Address a5 = new Address("Luxemburg", "210");
        Address a6 = new Address("Zetkin", "322");

        Person p1 = new Person("Ivan Draga", 41, a1);
        Person p2 = new Person("Stepan Praga", 16, a2);
        Person p3 = new Person("Oleg Braga", 41, a3);
        Person p4 = new Person("Bogdan Wlaga", 17, a4);
        Person p5 = new Person("Roman Schpaga", 28, a5);
        Person p6 = new Person("Feodor Saga", 14, a6);
        Person p7 = new Person("Natalia Draga", 38, a1);

        BankAccount b1 = new BankAccount(p1, "DE5676609876556581");
        BankAccount b2 = new BankAccount(p1, "DE5676609876556582");
        BankAccount b3 = new BankAccount(p1, "DE5676609876556583");
        BankAccount b4 = new BankAccount(p2, "DE5676609876556584");
        BankAccount b5 = new BankAccount(p2, "DE5676609876556585");
        BankAccount b6 = new BankAccount(p3, "DE5676609876556586");
        BankAccount b7 = new BankAccount(p3, "DE5676609876556587");
        BankAccount b8 = new BankAccount(p4, "DE5676609876556588");
        BankAccount b9 = new BankAccount(p4, "DE5676609876556589");
        BankAccount b10 = new BankAccount(p4, "DE5676609876556590");
        BankAccount b11 = new BankAccount(p4, "DE5676609876556591");
        BankAccount b12 = new BankAccount(p5, "DE5676609876556592");

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        persons.add(p7);

        List<Address> addresses = persons
                .stream()
                .map(t -> t.getAddress())
                .collect(Collectors.toList());

        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Maria");
        names.add("Adolf");
        names.add("Josef");
        names.add("Ivan");
        names.add("Maria");
        names.add("Stefan");
        names.add("Adam");

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(b1);
        accounts.add(b2);
        accounts.add(b3);
        accounts.add(b4);
        accounts.add(b5);
        accounts.add(b6);
        accounts.add(b7);
        accounts.add(b8);
        accounts.add(b9);
        accounts.add(b10);
        accounts.add(b11);
        accounts.add(b12);


    }
}

