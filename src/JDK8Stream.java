import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @date 2019-05-21 15:58
 *
 * Java 8 Stream
 *
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 *
 *
 * Stream（流）是一个来自数据源的元素队列并支持聚合操作
 *
     * 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
     * 数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
     * 聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
     * 和以前的Collection操作不同， Stream操作还有两个基础的特征：
 *
         * Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
         * 内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。


        1.生成流
            在 Java 8 中, 集合接口有两个方法来生成流：

                stream() − 为集合创建串行流。
                parallelStream() − 为集合创建并行流

                在涉及到数据库 循环单条插入时，parallelStream() 是并行的，效率高的多，要注意多线程安全

        2.forEach
        3.map
        4.filter
        5.limit   方法用于获取指定数量的流
        6.sorted
        7.parallel   并行程序


 */
public class JDK8Stream {

    public static void main(String[] args) {

        //1.并行流，处理
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(System.out::println);

        //2.forEach
        Random random = new Random();
        //random.ints().limit(10) 返回IntStream   .toArray()
        random.ints().limit(10).forEach(System.out::println);

        //3.map
        List<Integer> numbers1 = Arrays.asList(3,2,2,3,7,3,5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers1.stream().map(i -> i*i).collect(Collectors.toList());
        //去重
        List<Integer> squaresList1 = numbers1.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        //4.filter
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        //获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();

        //5.limit  limit 方法用于获取指定数量的流
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7);
        numbers2.stream().limit(3).forEach(System.out::println);

        //6.sorted  排序
        random.ints().limit(10).sorted().forEach(System.out::println);

        //7.parallel 并行处理
        // 获取空字符串的数量
        long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
    }
}
