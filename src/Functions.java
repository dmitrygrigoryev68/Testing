import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functions {

    public static String transform  (String sentence, Predicate<String> checkWordLenght, Function<String, String> transfornationMethod) {
        String words[] = sentence.split(" ");

        return Stream.of(words)
                .map(s -> checkWordLenght.test(s) ? transfornationMethod.apply(s) : s)
                .collect(Collectors.joining(", "));
    }

    public static List<Person> peopleOlderThan17(List<Person> persons) {
        return persons
                .stream()
                .filter(p -> p.getAge() > 17)
                .collect(Collectors.toList());
    }

    public static List<String> distinctedNames(List<String> names) {
        return names
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<Person>> groupByAge(int age, List<Person> persons) {
        return persons
                .stream().filter(a -> a.getAge() == age)
                .collect(Collectors.groupingBy(Person::getAge));
    }

    public static Map<Person, List<BankAccount>> groupByPerson(Person person, List<BankAccount> accounts) {
        return accounts
                .stream().filter(acc -> acc.getPerson().equals(person))
                .collect(Collectors.groupingBy(BankAccount::getPerson));
    }

    public static Map<Person, List<BankAccount>> mapAccByPerson(List<BankAccount> accounts) {
        return accounts
                .stream()
                .collect(Collectors.groupingBy(BankAccount::getPerson));
    }

    public static List<String> ibanWithStars(List<BankAccount> accounts) {
        return accounts.stream()
                .map(s -> s.getIban().substring(0, 5) + "***************")
                .collect(Collectors.toList());
    }

    public static Integer sumOfAgesPersonsOlderThan17(List<Person> users) {
        return users
                .stream()
                .filter(s -> s.getAge() > 17)
                .map(Person::getAge)
                .reduce((x, y) -> x + y).get();
    }

    public static String legalAgeString(List<Person> users) {
        return users
                .stream()
                .filter(s -> s.getAge() > 17)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
    }

    public static Long firstBooksFromSentenceCounter(String book, String sentence) {
        String[] arr = sentence.split(" ");
        List<String> list = Arrays.asList(arr);
        return list
                .stream()
                .filter(s -> s.startsWith(book))
                .count();
    }

    public static boolean isTheStringInteger(String string) {
        return string.chars().allMatch((Character::isDigit));
    }

}
