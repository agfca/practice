/**
 * @date 2019-05-17 13:02
 *
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 * 重要特征:
 *
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 *
 *
 * Lambda 变量作用域。引用的外部变量必须是 final 或者 隐式final
 *
 */
public class JDK8Lambda {
    public static void main(String[] args) {
        //类型声明
        MathOperation add = (int a,int b)->a+b;
        //不用类型声明
        MathOperation sub = (a,b)->a-b;
        //大括号中的返回语句
        MathOperation mul = (a, b) -> {return a*b;};
        //没有大括号和返回语句
        MathOperation div = (a,b) -> a/b;


        int result = add.operation(1,2);
        int subResult = sub.operation(3,2);


        JDK8Lambda jdk8Lambda = new JDK8Lambda();
        System.out.println("2 x 3 = "+jdk8Lambda.operation(2,3,add));



    }
    interface MathOperation{
        int operation(int a,int b);
    }
    private int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
