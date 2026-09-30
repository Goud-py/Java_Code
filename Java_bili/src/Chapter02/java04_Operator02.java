package Chapter02;

public class java04_Operator02 {
    public static void main(String[] args) {
        // TODO 运算符 - 关系运算符
        // 所谓的关系运算符其实就是用于比较两个数据之间关系的运算符
        // 关系运算符基本语法结构：
        // TODO 关系表达式： 元素1（数据1，表达式1） 关系运算符[==, !=, >, >=, <, <=] 元素2（数据2，表达式2）
        // 关系表达式的结果为布尔类型：如果表达式结果为预想相同，那么结果为true，如果表达式结果和预想不同，那么结果为false
        int i = 10;
        int j = 20;
        System.out.println( i == j ); // false 双等号表示 两个数据是否相等
        System.out.println( i != j ); // true 感叹号等号表示 两个数据是否不相等
        System.out.println( i > j ); // false
        System.out.println( i >= j ); // false, 大于等于表示 等于也可以，等于也可以
        System.out.println( i < j ); // true
        System.out.println( i <= j ); // true 小于等于表示 小于也可以，等于也可以


    }
}
