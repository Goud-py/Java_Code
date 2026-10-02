package Chapter02;

public class java03_Datetype02 {
    public static void main(String[] args) {

        // TODO 数据类型的转换
        String name ="zhangsan";
        int age = 30;
        //java中范围小的数据可以直接转换范围大的数据，但是范围大的数据无法直接转换范围小的数据

         //byte-->short-->int-->long-->float-->double
        byte b = 10;
        short s = b;
        int i = s;
        long lon =i;
        float f = lon;
        double d = f;
        //如果想要将范围大的数据转换为范围小的数据，那么需要使用小括号进行强制转换
        int i1 = (int)d;

    }
}
