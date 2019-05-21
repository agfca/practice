/**
 * @date 2019-05-21 15:53
 *
 * Java 8 接口 可以添加默认实现方法
 */
public interface JDK8InterfaceDefaultMethod {
    default void printMsg(){
        System.out.println("测试");
    }
}
class Test implements JDK8InterfaceDefaultMethod{
    //默认实现了 printMsg

    public static void main(String[] args) {
        Test test = new Test();
        test.printMsg();
    }
}
