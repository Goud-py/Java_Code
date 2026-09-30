package Chapter02;

public class java04_Operator03 {
    public static void main(String[] args) {
        // TODO 运算符 - 逻辑运算符
        // 所谓得逻辑运算符其实就是用于描述多个条件表达式之间得关系的运算符
        // TODO 基本得语法结构：
        // 变量 = （条件表达式1） 逻辑运算符 （条件表达式2）
        // 结果得变量得类型依然为布尔类型
        // 因为条件表达式的结果类型为布尔类型，所以逻辑运算符表达式的结果类型也是布尔类型，但是分几种情况：
        // true  true  => ?
        // false true  => ?
        // false false => ?
        // true  false => ?

        // TODO 逻辑运算符：&， 称之为与运算
        // 与运算，要求两个条件表达式都必须计算出结果，只有当两个结果都是true时，最终结果为true，其他情况全是false
//        int i = 10;
//        boolean result = (i > 5) & (i < 20);
//        System.out.println(result);

        // TODO 逻辑运算符：|， 称之为或运算
        // 或运算，要求两个条件表达式都必须计算出结果，只要任何一个结果为true，那么最后结果就是true
        //        两个表达式的结果都是false，那么最终的结果才是false
        // int i = 10;
        // boolean result = (i < 5) | (i > 20);
        // System.out.println(result);

        // TODO 逻辑运算符：&&， 称之为短路与运算
        // 短路与运算，会根据第一个条件表达式的结果来判断，是否执行第二个条件表达式。
        // 如果第一个表达式的结果为false，那么就无需执行第二个表达式
//        int i = 10;
//        int j = 20;
//        boolean result = (i > 10) && (++j > 30);
//        System.out.println(result);
//        System.out.println(j);

        // TODO 逻辑运算符：||， 称之为短路或运算
        // 短路或运算，会根据第一个条件表达式的结果来判断，是否执行第二个条件表达式。
//        int i = 10;
//        int j = 20;
//        boolean result = (i == 10) || (++j > 30);
//        System.out.println(result);
//        System.out.println(j);

        // TODO 逻辑运算符：!， 称之为非（相反）运算
        // true => false
        // false => true
        int i = 10;
        boolean result = i == 10;
        boolean result1 = i > 10;
        System.out.println(!result);
        System.out.println(!result1);


    }
}
