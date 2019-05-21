import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guofucheng
 * @email guofucheng@do1.com.cn
 * @date 2019-05-21 19:00
 */
public class MainTest {

    public static void main(String[] args) {
        List<Comment> list = new ArrayList<>();
        Comment comment1 = new Comment("111");
        Comment comment2 = new Comment("222");
        Comment comment3 = new Comment("333");
        Comment comment4 = new Comment("444");

        list.add(comment1);
        list.add(comment2);
        list.add(comment3);
        list.add(comment4);

        //list.parallelStream().m
    }
}

class Comment{
    String content;
    Date createTime;
    public Comment(String content){
        this.content = content;
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
