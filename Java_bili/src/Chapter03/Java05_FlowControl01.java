package Chapter03;

public class Java05_FlowControl01 {
    public static void main(String[] args) {
        System.out.println("--- 写法一：使用 if-else 结构 ---");
        // TODO 流程控制 - 重复执行（循环执行）
        for ( int i = 0; i < 10; i++ ) {
            if ( i == 4 ) {
                // 当 i == 4 时，什么都不做（空代码块）
            } else {
                System.out.println(i);
            }
        }

        System.out.println("\n--- 写法二：使用 continue 关键字 ---");
        // break关键字直接会跳出循环，不再执行循环后续的操作
        // continue关键字直接会跳过当前循环，执行下一次循环
        for ( int i = 0; i < 10; i++ ) {
            if ( i == 4 ) {
                // 切断，跳出循环
                //break;
                continue;
            }
            System.out.println(i);
        }
    }
}