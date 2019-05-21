import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019-05-21 15:01
 *
 * Java 8 方法引用 ::
 *
 */
public class JDK8FunctionQuote {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

        List<Person> people = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("张三");
        p1.setYear("12");
        Person p2 = new Person();
        p2.setName("张三");
        p2.setYear("12");

        people.add(p1);people.add(p2);

        people.forEach(System.out::println);
        people.forEach(System.out::print);

    }
}
class Person{
    String name;
    String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}