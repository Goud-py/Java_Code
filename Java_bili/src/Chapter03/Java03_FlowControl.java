package Chapter03;

public class Java03_FlowControl {
    public static void main(String[] args) {

        // ---------------- 第一段代码：无 break 的 switch 穿透现象 ----------------
        {
            // TODO 流程控制 - 分支执行
            // 特殊的分支结构
            // switch ( 数据 ) {}
            System.out.println("第一步");
            System.out.println("第二步");
            int i = 20;

            switch (i) {
                case 10 :
                    System.out.println("分支1");
                case 20 :
                    System.out.println("分支2");
                case 30 :
                    System.out.println("分支3");
            }

            System.out.println("第三步");
        }

        System.out.println("\n========== 分割线 ==========\n");

        // ---------------- 第二段代码：使用 break 和 default 的 switch ----------------
        {
            // 如果执行某一个分支后，不想继续执行其他分支，那么可以使用break关键字，跳出分支结构
            System.out.println("第一步");
            System.out.println("第二步");
            int i = 10;

            switch (i) {
                case 10 :
                    System.out.println("分支1");
                    //break;
                case 20 :
                    System.out.println("分支2");
                    break;
                case 30 :
                    System.out.println("分支3");
                default:
                    System.out.println("其他分支");
            }

            System.out.println("第三步");
        }

    }
}