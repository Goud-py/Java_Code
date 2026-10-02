package Chapter02;

public class java04_Operator {
    public static void main(String[] args) {
       //TODO 引用数据类型
        String name = "zhangsan";
        //TODO 运算符
        // TODO 运算符
        // 所谓得运算符就是参与数据运算得符号，Java定义得，无法执行定义

        // TODO 表达式
        // 所谓得表达式就是采用运算符和数据连接在一起形成符合Java语法规则得指令代码，称之为表达式

        // TODO 算术运算符
        // 1. 二元运算符 ： 两个元素参与运算得运算符， 1 + 2
        //    TODO 算术表达式 = 元素1 二元运算符 元素2
        // 这个表达式是有结果得，就需要有类型，这里得类型是元素种类型最大的那一种
        System.out.println(1 + 2); // 3
        System.out.println(2 - 2); // 0
        System.out.println(3 * 2); // 6
        System.out.println(4 / 2); // 2
        System.out.println(1 / 2); // 0 (int, int) => int
        System.out.println(1.0 / 2); // 0.5 (double, int) => double
        System.out.println(5 % 2); // 1 (取余, 模运算)

        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte)(b1 + b2); // (int, int) => int

        System.out.println( 1 + 2 * 3 ); // 7
        System.out.println( (1 + 2) * 3 ); // 9

        // 2. 一元运算符 ： 一个元素参与运算得运算符

        // ++, --
        // ++ 运算符的本质其实就是加1操作的简化版本, 自增运算符

        // int i = 0;
        // int j = ++i;
        // System.out.println("i = " + i);
        // System.out.println("j = " + j);

        // int i = 1;
        //// int j = i; // j = 1
        //// i = i - 1; // i = 0
        // int j = i--;
        // System.out.println("i = " + i);
        // System.out.println("j = " + j);

        // 前置递减 (--i) 运行代码
//       int i = 1;
//        // i = i - 1; // i = 0
//        // int j = i; // j = 0
//       int j = --i;
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);

        // int i = 0;
        // int j = i++;
        // System.out.println("i = " + i);
        // System.out.println("j = " + j);

        // 后置递增 (i++) 展开代码
        int i = 0;
        i = i + 1; // i = 1
        int j = i; // j = 1
        System.out.println("i = " + i);
        System.out.println("j = " + j);

    }
}
