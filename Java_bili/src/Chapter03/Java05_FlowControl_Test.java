package Chapter03;

public class Java05_FlowControl_Test {
    public static void main(String[] args) {

        System.out.println("========== 阶段一：手动逐层打印（未优化） ==========");
        {
            // TODO 流程控制 - 小练习
            // 九层妖塔
            /*
                  *
                 ***
                *****
               *******

               4 => 0 -> 3
               4 => 1 -> 2
               4 => 2 -> 1
            */

            // 打印第一层的数据
            for (int i = 0; i < 1; i++) {
                System.out.print("*");
            }
            System.out.println("");

            // 打印第二层的数据
            // println方法打印字符串之后，会自动添加换行符
            // print方法打印字符串后，不换行
            for (int i = 0; i < 3; i++) {
                System.out.print("*");
            }
            System.out.println("");

            // 打印第三层的数据
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
            }
            System.out.println("");

            // 打印第四层的数据
            for (int i = 0; i < 7; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        System.out.println("\n========== 阶段二：使用嵌套循环优化（打印出带空格的三角形） ==========");
        {
            // 规律分析：
            // 0 -> 1
            // 1 -> 3
            // 2 -> 5
            // 3 -> 7
            // 4 -> 9
            // 星号数量公式：j * 2 + 1
            // 空格数量公式：(level - 1) - j

            int level = 3; // 可以修改此变量改变塔的层数
            for ( int j = 0; j < level; j++ ) {

                // 打印每一层前面的空格
                for ( int i = 0; i < (level - 1) - j; i++ ) {
                    System.out.print(" ");
                }

                // 打印每一层的星号
                for (int i = 0; i < j * 2 + 1; i++) {
                    System.out.print("*");
                }

                // 换行
                System.out.println("");
            }
        }
    }
}