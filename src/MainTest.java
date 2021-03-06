import org.omg.CORBA.UNKNOWN;
import org.omg.CORBA.UserException;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author guofucheng
 * @email guofucheng@do1.com.cn
 * @date 2019-05-21 19:00
 */
public class MainTest {

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(new Integer[]{1,2,3,4});
        List<Integer> test1 = Arrays.asList(1,2,3,4);
        List<Number> results = test.stream()
                .filter(n -> n> 5)
                .collect(Collectors.toList());



        List<Comment> list = new ArrayList<>();

        list.stream().peek(comment -> System.out.println(comment.getContent())).collect(Collectors.toList());

        Comment comment1 = new Comment("111");
        Comment comment2 = new Comment("222");
        Comment comment3 = new Comment("333");
        Comment comment4 = new Comment("444");

        list.add(comment1);
        list.add(comment2);
        list.add(comment3);
        list.add(comment4);


        //通知对象
        List<Comment> noticeIdList =new ArrayList<Comment>(list);

noticeIdList.stream().peek(comment ->
        System.out.println(comment.getContent()));

        list.removeIf(comment -> comment.getContent().equals("111"));



        for(int i = 0; i <1000; i++){
            Comment comment = new Comment(Integer.toString(i));
            list.add(comment);
        }

        Integer i = null;
        System.out.println(i instanceof Integer);
        //list.parallelStream().m

        String[] arr = new String[2];
        arr[0] = "2";
        arr[1] = "3";
        List<String> list1 = new ArrayList<>(Arrays.asList(arr));

        list1.add("22");

        System.out.println(new String[0].length);

        List<Comment> commentList = Collections.synchronizedList(new ArrayList<>());

        AtomicInteger atomicInteger = new AtomicInteger();
        list.parallelStream().forEach(item ->{

            item.setCreateTime(new Date());
            //commentList.add(item);
        });

        System.out.println("---");

        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(1,2,3));
        IntSummaryStatistics a = integerList.stream().mapToInt(Integer::intValue).summaryStatistics();

    }
}

class Comment{

    public static void main(String[] args) {
        Optional<Comment> commentOpt = Optional.empty();

        Optional<Comment> opt = Optional.ofNullable(null);
        String name = "test";
        Optional<String> StringOpt = Optional.ofNullable(name);
        //System.out.println("test".equals(StringOpt.toString()));
        StringOpt.get();

        opt.ifPresent(System.out::println);

        Consumer<Comment> commentConsumer = comment -> comment.setContent("33");

        String ss = opt.flatMap(str -> Optional.of("33")).orElse("232");


    }

    String content;
    Date createTime;
    public Comment(String content){
        this.content = content;
    }
    public Comment(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
