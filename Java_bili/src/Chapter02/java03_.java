package Chapter02;

public class java03_ {
    public static void main(String[] args) {
        // TODO 标识符
        // 所谓的标识符，其实就是起名字
        //标识数据的符号，称之为标识符
        //变量名称就是标识符
        //标识符主要用于起名

        // TODO 标识符的命名规则
        // 1.英文拉丁字母
        String username = "zhangsan";
        String xingming = "lisi";
        // 2.符号
        // 标识符只能采用下划线和美元$符号
        String _name = "wangwu";
        String $name = "wangwu";
        String $na_me = "wangwu";
        System.out.println(_name);
        System.out.println($name);
        System.out.println($na_me);
        //3.数字
        // 数字不能位于开头位置
        //4.在大括号范围内，标识符不能重复
        //标识符区分大小写
        String Name = "GOUD";
        //5.Java 语言中预先定义好了一些标识符名称，称之为关键字或保留字
        //String public="goud"    报错
        //6.驼峰标识 规范
        String userName="lisi";


    }
}
