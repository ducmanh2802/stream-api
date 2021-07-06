import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DemoStream {

  public static ArrayList<Person> people = new ArrayList<>(
      List.of(new Person("Vinh", "Vietnam", 28), new Person("Lan", "Vietnam", 24), new Person("John", "USA", 27),
          new Person("Lee", "China", 67), new Person("Kim", "Korea", 22), new Person("Long", "Vietnam", 18),
          new Person("Jungho", "Korea", 19), new Person("Tian", "China", 20), new Person("Clara", "USA", 40),
          new Person("Mikura", "Japan", 27), new Person("Sony", "Japan", 29), new Person("Xiang", "China", 78),
          new Person("Peter", "France", 18), new Person("Haloy", "Malaysia", 20), new Person("Magie", "Malaysia", 32)));

  // Bài tập thực hành

  // Lọc người từ độ tuổi 20 -> 30
  public static void filterAge() {
    System.out.println("Lọc người từ độ tuổi 20 -> 30");
    people.stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 30).sorted(Comparator.comparing(Person::getName))
        .forEach(System.out::println);
  }

  // Tuổi trung bình
  public static void avgAge() {
    Double result = people.stream().collect(Collectors.averagingInt(Person::getAge));
    System.out.println("Tuổi trung bình: " + result);
  }

  // Tuổi trung bình theo từng quốc tịch
  public static void sortAvgAgeByNation() {
    System.out.println("Tuổi trung bình theo quốc gia: ");

    Map<String, Double> result = people.stream()
        .collect(Collectors.groupingBy(Person::getNationality, Collectors.averagingInt(Person::getAge)));
    result.entrySet().stream().forEach(r -> System.out.println(r.getKey() + " " + r.getValue()));
  }
}
