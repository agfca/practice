import java.util.*;
import java.util.stream.Collectors;

public class NewPointOfJDK8 {

    /**
     * JDK8 新特性
     * @Date: 2019/5/17 10:22
     */

    /**
     * Lambda 表达式 Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
     * @Date: 2019/5/17 10:30
     *
     *
     * Collections.sort could be replaced with List.sort
     * inspection 视察，审视
     * comparator
     * anonymous 匿名的
     * expression
     * syntax
     * reference
     * natural 自然的
     * chain 链子
     */
    public static void main(String[] args) {

        String[] arr = new String[6];
        arr[0] = "000000";
        arr[1] = "111111";
        arr[2] = "22222";
        arr[3] = "33";

        String a = null;
        /*if (s == null) {
            s = "null";
        }*/
        System.out.println(a.toString()+"dssd");

        Arrays.asList(arr).forEach(s -> {
            if (s!=null&&s.length() < 3) {
                return;     //  这个return语句并不能终止loop循环。
            }else{
                System.out.println("-----------"+s+"-----------");
            }
        });


        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> temp = Arrays.asList(Arrays.copyOf(names1.toArray(new String[names1.size()]),names1.size()));
        List<String> names2 = new ArrayList<>(temp);
        //UnsupportedOperationException  克隆异常  Arrays$ArrayList
        names2.add("Gaoogle ");
        names2.add("Sina ");
        names2.add("Sana ");

        sortUsingJava7(names1);

        //sortUsingJava8_1(names2);

        sortUsingJava8_4(names2);

        System.out.printf("sssss/t/n\t22");

        Msg msg = word -> System.out.println(word);
        Msg msg1 = word -> System.out.println("test"+word);

        msg.sayMsg("test");
        msg1.sayMsg("test");
    }

    private static void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
    private static void sortUsingJava8_1(List<String> names){
        Collections.sort(names,(s1,s2)-> s1.compareTo(s2));
    }
    /*String.compareTo 方法：
    compareTo() 的返回值是int, 它是先比较对应字符的大小(ASCII码顺序)*/
    private void sortUsingJava8_2_1(List<String> names){
        Collections.sort(names,Comparator.comparing(String::toString));
    }
    //判断 年龄
    //return (x < y) ? -1 : ((x == y) ? 0 : 1);
    private void sortUsingJava8_2(List<Person> people){
        Collections.sort(people,Comparator.comparingInt(Person::getAge));
    }
    //多重判断   判断年龄，工作年龄
    private void sortUsingJava8_3(List<Person> people){
        Collections.sort(people,Comparator
                        .comparing(Person::getAge)
                        .thenComparingInt(Person::getWorkYear));
    }
    //TODO
    private static void sortUsingJava8_4(List<String> names){
        names = names.stream().sorted(Comparator.comparing(String::toString)).collect(Collectors.toList());
    }

    /**
     * int res = o1.first.compareTo(o2.first);
     * if(res == 0) res = o1.second.compareTo(o2.second);
     * if(res == 0) res = o1.third - o2.third;
     * return res;
     *
     * will be replaced with
     * objs.sort(Comparator.comparing((Obj o) -> o.first)
     * .thenComparing(o -> o.second).thenComparingInt(o -> o.third));
     */

    interface Msg{
        void sayMsg(String msg);

    }

    class Person{
        private String name;
        private Integer age;
        private Integer workYear;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getWorkYear() {
            return workYear;
        }

        public void setWorkYear(Integer workYear) {
            this.workYear = workYear;
        }
    }
}
