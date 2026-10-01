

# Java 基础核心笔记

## 一、 基础概念与运行机制

### 1.1 JDK、JRE、JVM 的关系
**JDK > JRE > JVM**

```mermaid
flowchart TD
    A[Java源代码 .java] -->|javac 编译| B[字节码 .class]
    B -->|java命令运行| C[JVM Java虚拟机]
    C --> D[类加载器 ClassLoader]
    D --> E[字节码校验]
    E --> F[解释器 / JIT编译器]
    F --> G[操作系统OS]
    G --> H[硬件CPU]
    
    subgraph JVM内部
        D
        E
        F
    end
```

*   **JDK（Java Development Kit）**：Java 开发工具包 = JRE + 开发工具集（javac、java、jdb 等）。给**开发者**用，用于开发 + 运行 Java 程序。安装 JDK 时会自带一份 JRE。
*   **JRE（Java Runtime Environment）**：Java 运行时环境 = JVM + Java 核心类库。给**普通用户**用，只运行 Java 程序，不含编译工具（无 javac）。不能编写代码或编译源码。
*   **JVM（Java Virtual Machine）**：Java 虚拟机，JRE 里面最核心的部分，只负责执行 `.class` 字节码文件。不同操作系统有不同版本 JVM，实现 Java“一次编译，到处运行”。

> **极简记忆**：
> * 开发程序 → 需要 **JDK**（里面自带 JRE 和 JVM）
> * 只跑程序 → 只装 **JRE**（里面自带 JVM）
> * 真正执行字节码的 → **JVM**

**JDK、JRE、JVM 包含关系图：**
```mermaid
flowchart TD
    subgraph JDK
        subgraph JRE
            C[JVM Java虚拟机]
            E[Java核心类库]
        end
        D[开发工具 javac java jar]
    end
    JDK --> JRE
    JDK --> D
    JRE --> C
    JRE --> E
```

### 1.2 注释与第一个 Java 程序
```java
package Chapeter01;

public class java01_HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        // 单行注释
        
        /*
          TODO 标记功能（不是java语法）
          多行注释
          多行注释
        */
    }
}
```

**IDEA 常用快捷键**：
* `Ctrl + D`：复制当前行
* `Ctrl + R`：替换当前文字

---

## 二、 变量与标识符

### 2.1 变量核心概念
1. **内存**：存放数据的地方。
   * 数据存储区：保存真实数据，比如字符串 `Hello Java`。
   * 变量（向量存储）：变量里面**不存真实数据**，存的是**数据的地址**（编号 xxxxx / yyyyy）。
2. **变量**：可以理解成“地址标签”，通过地址找到内存里真正的数据。
3. **CPU**：负责执行代码（如 `println()`）。CPU 读取变量里保存的地址，根据地址去内存取出数据，完成运算/打印。

> **一句话总结**：变量存地址，内存存真实数据；CPU 通过变量保存的地址，去内存读取数据。

```mermaid
flowchart TD
    subgraph 内存
        A1[Hello Java]
        A2[Hello]
        B1[xxxxx]
        B2[yyyyy]
    end
    subgraph CPU
        C1[println]
        C2[println]
        C3[println]
        C4[println]
    end

    B1 --> A1
    B2 --> A2
    B1 --> C1
    B1 --> C2
    B1 --> C3
    B1 --> C4
```

**Java 变量使用示例：**
```java
package Chapter02;

public class java01_Variable {
    public static void main(String[] args) {
        // TODO 变量
        // 所谓的变量，其实就是可以改变的向量存储
        
        // 1. 变量的声明
        String name;
        // 2. 变量的赋值
        name = "张三";
        // 3. 变量的使用
        System.out.println(name);
        
        // 将变量的声明和赋值在一行代码中完成
        String username = "李四";
        System.out.println(username);
    }
}
```

### 2.2 标识符命名规范
标识符即起名字（变量名、类名等），命名规则如下：

1. **英文拉丁字母**：如 `String username = "zhangsan";`
2. **符号**：只能采用下划线和美元 `$` 符号，如 `String _name = "wangwu";`，`String $name = "wangwu";`
3. **数字**：数字不能位于开头位置。
4. **唯一性**：在大括号范围内，标识符不能重复；严格区分大小写。
5. **关键字/保留字**：Java 语言中预先定义好了一些标识符名称（如 `public`），不能作为变量名。
6. **驼峰规范**：首字母小写，后续单词首字母大写（如 `userName`）。

```java
package Chapter02;

public class java02_Indentifer {
    public static void main(String[] args) {
        // 标识符命名示例
        String username = "zhangsan";
        String xingming = "lisi";
        
        // 符号测试
        String _name = "wangwu";
        String $name = "wangwu";
        String $na_me = "wangwu";
        System.out.println(_name);
        System.out.println($name);
        System.out.println($na_me);
        
        String Name = "GOUD";  // 区分大小写
        String userName = "lisi"; // 驼峰标识规范
    }
}
```

---

## 三、 数据类型与转换

### 3.1 数据类型分类
```mermaid
graph LR
    A["Java数据类型"] --> B["基本数据类型"]
    A --> C["引用数据类型"]

    B --> B1["数值类型"]
    B1 --> B11["整数类型：byte, short, int, long"]
    B1 --> B12["浮点类型：float, double"]
    B --> B2["字符类型：char"]
    B --> B3["布尔类型：boolean"]

    C --> C1["类，String"]
    C --> C2["接口"]
    C --> C3["数组"]
    C --> C4["枚举"]
    C --> C5["特殊类型值：null"]
```

**基本数据类型示例代码：**
```java
package Chapter02;

public class java03_Datetype01 {
    public static void main(String[] args) {
        // TODO 整数类型
        // byte：8bit; short:16bit; int:32bit; long:64bit
        
        // TODO 浮点类型
        // 根据计算精度分为：
        // float：单精度，数据需要使用F（f）结尾
        float f = 1.0f;
        // double：双精度
        double d = 2.0;
        
        // TODO 字符类型
        char c = '&';  // 单引号
        
        // TODO 布尔类型
        boolean bln = true;
    }
}
```

### 3.2 数据类型转换
Java 中范围小的数据可以直接转换范围大的数据（自动类型提升），但是范围大的数据无法直接转换范围小的数据（需要强制转换）。

**转换顺序**：`byte --> short --> int --> long --> float --> double`

```java
package Chapter02;

public class java03_Datetype02 {
    public static void main(String[] args) {
        // 自动类型提升
        byte b = 10;
        short s = b;
        int i = s;
        long lon = i;
        float f = lon;
        double d = f;
        
        // 强制类型转换：将范围大的数据转换为范围小的数据，需要使用小括号
        int i1 = (int) d;
    }
}
```

---

## 四、 运算符详解

```mermaid
graph LR
    root((Java运算符))
    
    root --> A[算术运算符]
    A --> A1["二元运算符: + - * / %"]
    A --> A2["一元运算符: ++ --"]
    
    root --> B[赋值运算符]
    B --> B1["= += -= *= /= %="]
    
    root --> C[关系运算符]
    C --> C1["== != > >= < <="]
    
    root --> D[逻辑运算符]
    D --> D1["逻辑运算符: & | ^ !"]
    D --> D2["短路运算符: && ||"]
    
    root --> E[三元运算符]
    E --> E1["(关系表达式 ? 表达式1 : 表达式2)"]
```

### 4.1 算术运算符
> **概念**：所谓运算符就是参与数据运算的符号。表达式 = 元素1 + 运算符 + 元素2。
> 表达式的结果类型是元素中类型最大的那一种。

**二元运算符**：`+`、`-`、`*`、`/`、`%`
**一元运算符**：`++`、`--`

```java
package Chapter02;

public class java04_Operator {
    public static void main(String[] args) {
        // TODO 算术运算符 - 二元
        System.out.println(1 + 2); // 3
        System.out.println(2 - 2); // 0
        System.out.println(3 * 2); // 6
        System.out.println(4 / 2); // 2
        System.out.println(1 / 2); // 0 (int, int) => int
        System.out.println(1.0 / 2); // 0.5 (double, int) => double
        System.out.println(5 % 2); // 1 (取余, 模运算)

        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte)(b1 + b2); // (int, int) => int (需要强制转换)

        System.out.println( 1 + 2 * 3 ); // 7 (乘法优先级高于加法)
        System.out.println( (1 + 2) * 3 ); // 9 (括号优先级最高)

        // TODO 算术运算符 - 一元 (++, --)
        // 前置递增/递减：先运算，后赋值
        int i = 1;
        int j = --i; // i先减1变成0，再赋值给j
        System.out.println("i = " + i); // 0
        System.out.println("j = " + j); // 0

        // 后置递增/递减：先赋值，后运算 (展开代码逻辑)
        int i2 = 0;
        int j2 = i2++; // 等价于：j2 = i2; i2 = i2 + 1;
        System.out.println("i2 = " + i2); // 1
        System.out.println("j2 = " + j2); // 0
    }
}
```

### 4.2 赋值运算符
* 基础赋值：`=`（将等号右边表达式的结果赋值给等号左边的变量，需要考虑类型关系）。
* 复合赋值：`+=`、`-=`、`*=`、`/=`、`%=`。
* **核心特性**：如果使用了复合赋值运算符，那么数据的类型不会发生变化（隐含了强制类型转换）。

```java
package Chapter02;

public class java04_Operator01 {
    public static void main(String[] args) {
        int i = 1;
        i *= 2; // 等价于 i = i * 2;
        System.out.println(i); // 2

        byte b1 = 10;
        // b1 = b1 + 20; // 报错：int 不能直接赋值给 byte
        b1 += 20; // 不报错，等价于 b1 = (byte)(b1 + 20);
        System.out.println(b1); // 30
    }
}
```

### 4.3 关系运算符
关系运算符用于比较两个数据之间的关系，**结果一定是布尔类型（`true` 或 `false`）**。
包含：`==`（相等）、`!=`（不相等）、`>`、`>=`、`<`、`<=`。

```java
package Chapter02;

public class java04_Operator02 {
    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        System.out.println( i == j ); // false
        System.out.println( i != j ); // true
        System.out.println( i > j );  // false
        System.out.println( i >= j ); // false
        System.out.println( i < j );  // true
        System.out.println( i <= j ); // true
    }
}
```

### 4.4 逻辑运算符
用于描述多个条件表达式之间的关系，结果依然是布尔类型。

* **`&` (与运算)**：两个条件都必须计算，只有都是 `true`，结果才为 `true`。
* **`|` (或运算)**：两个条件都必须计算，只要有一个 `true`，结果就是 `true`。
* **`&&` (短路与)**：如果第一个条件为 `false`，则**不再执行**第二个条件（短路）。
* **`||` (短路或)**：如果第一个条件为 `true`，则**不再执行**第二个条件（短路）。
* **`!` (非运算)**：取反，`true` 变 `false`，`false` 变 `true`。

```java
package Chapter02;

public class java04_Operator03 {
    public static void main(String[] args) {
        // 1. 逻辑与 & 
        int i = 10;
        boolean result1 = (i > 5) & (i < 20); // true & true = true
        System.out.println(result1);

        // 2. 短路与 && (常用)
        int j = 20;
        boolean result2 = (i > 10) && (++j > 30); // 左侧false，右侧不执行
        System.out.println(result2); // false
        System.out.println(j);       // 20 (j未自增)

        // 3. 短路或 || (常用)
        int k = 20;
        boolean result3 = (i == 10) || (++k > 30); // 左侧true，右侧不执行
        System.out.println(result3); // true
        System.out.println(k);       // 20 (k未自增)

        // 4. 逻辑非 !
        boolean result4 = i == 10;
        boolean result5 = i > 10;
        System.out.println(!result4); // false
        System.out.println(!result5); // true
    }
}
```

### 4.5 三元运算符
* **语法**：`变量 = (条件表达式) ? (表达式1) : (表达式2);`
* **运算规则**：条件表达式为 `true`，执行表达式1；为 `false`，执行表达式2。

```java
package Chapter02;

public class java04_Operator04 {
    public static void main(String[] args) {
        int i = 15;
        int j = 20;

        // i == 10 为 false，因此执行冒号后面的表达式 2 + 2
        int k = ( i == 10 ) ? 1 + 1 : 2 + 2;
        System.out.println(k); // 4
    }
}
```



## 五、 流程控制

> **概念**：所谓的流程控制，其实就是计算机在执行代码时，对指令代码执行顺序的控制。Java 中的流程控制主要分为 3 种：顺序执行、分支执行、重复执行。

### 5.1 顺序执行

* 代码出现的先后顺序以及语法的先后顺序。
* **注意**：变量在使用之前，必须声明并进行了初始化。

```java
package chapter03;

public class Java01_FlowControl {
    public static void main(String[] args) {
        // 变量在使用之前，必须声明并进行了初始化
        int i = 10;
        int j = 15;
        System.out.println( i + j );
    }
}
```

### 5.2 分支执行

分支结构主要包括 `if` 系列和 `switch` 结构。

#### 5.2.1 if 分支结构
* **单分支结构（可选分支）**：条件为 `true` 时执行，否则跳过。
* **双分支结构（必选分支）**：使用 `if ... else`，二选一。
* **多分支结构（多重判断）**：使用 `if ... else if ... [else]`。

```java
package Chapter03;

public class Java02_FlowControl {
    public static void main(String[] args) {
        // 1. 可选分支：单分支结构
        System.out.println("第一步");
        System.out.println("第二步");
        {
            int i = 20;
            if (i == 10) {
                System.out.println("分支");
            }
        }

        // 2. 必选分支：双分支结构（二选一）
        {
            int i = 20;
            if ( i == 10 ) {
                System.out.println("分支1");
            } else {
                System.out.println("分支2");
            }
            System.out.println("第三步");
        }

        // 3. 多分支：多重判断 if ... else if ... [else]
        {
            int i = 30;
            if ( i == 10 ) {
                System.out.println("分支1");
            } else if (i == 20) {
                System.out.println("分支2");
            } else {
                System.out.println("分支3");
            }
            System.out.println("第三步");
        }
    }
}
```

#### 5.2.2 switch 分支结构
* **语法**：`switch (数据) { case 值: 逻辑; break; ... default: 逻辑; }`
* **穿透现象（break 的作用）**：如果没有写 `break`，程序会继续向下执行其他 `case` 分支。`break` 关键字用于跳出整个 `switch` 结构。
* **default 分支**：当所有 case 都不匹配时执行。

```java
package Chapter03;

public class Java03_FlowControl {
    public static void main(String[] args) {
        // ---------------- 第一段代码：无 break 的 switch 穿透现象 ----------------
        {
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
```

#### 5.2.3 分支小练习：年龄区间判断
根据年龄判断阶段：儿童 (0~6)，少年 (7~17)，青年 (18~40)，中年 (41~65)，老年 (66+)。

```java
package Chapter03;

public class Java04_FlowControl_Test {
    public static void main(String[] args) {
        int age = 45;
        
        // ----------------- 写法一：完整区间判断 -----------------
        if ( age < 7 ) {
            System.out.println("儿童");
        } else if ( age >= 7 && age < 18 ) {
            System.out.println("少年");
        } else if ( age >= 18 && age < 41 ) {
            System.out.println("青年");
        } else if ( age >= 41 && age < 66 ) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }

        // ----------------- 写法二：优化后的区间判断 -----------------
        // 利用了 else if 的特性：只要走到后面的分支，说明前面的条件必然不成立，因此无需重复写下限
        if ( age < 7 ) {
            System.out.println("儿童");
        } else if ( age < 18 ) {
            System.out.println("少年");
        } else if ( age < 41 ) {
            System.out.println("青年");
        } else if ( age < 66 ) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }
}
```

### 5.3 循环执行

#### 5.3.1 while 循环（有条件循环）
* **语法**：`while (条件表达式) { 需要循环的代码 }`
* **执行原理**：条件为 `true` 时执行循环体，执行完毕后重新判断条件；为 `false` 时跳出循环结构。

```java
// while 循环示例
int age = 30;
while ( age < 40 ) {
    System.out.println("循环的代码");
    age++; // 需要更新条件表达式中的变量，否则会死循环
}
```

#### 5.3.2 do...while 循环
* **语法**：`do { 循环代码 } while (条件表达式);`
* **与 while 的区别**：
    * `while` 循环可能执行，也可能不执行（先判断后执行）。
    * `do...while` 循环语法中的循环代码**至少执行一次**（先执行后判断）。

```java
int age = 30;
do {
    System.out.println("循环的代码");
    age++; 
} while ( age < 40 );
```

#### 5.3.3 for 循环
* **语法**：`for (初始化表达式; 条件表达式; 更新表达式) { 循环的代码 }`
* **执行流程**：初始化 -> 判断条件 -> 执行循环体 -> 更新表达式 -> 再次判断条件...

```java
for ( int i = 0; i < 40; i++) {
    System.out.println("循环的代码");
}
System.out.println("第二步");
```

#### 5.3.4 循环控制：break 与 continue
* **`break`**：直接跳出整个循环，不再执行循环后续的操作。
* **`continue`**：跳过当前这一次循环，直接进入下一次循环。

```java
package Chapter03;

public class Java05_FlowControl01 {
    public static void main(String[] args) {
        System.out.println("--- 写法一：使用 if-else 结构 ---");
        for ( int i = 0; i < 10; i++ ) {
            if ( i == 4 ) {
                // 当 i == 4 时，什么都不做（空代码块）
            } else {
                System.out.println(i);
            }
        }

        System.out.println("\n--- 写法二：使用 continue 关键字 ---");
        for ( int i = 0; i < 10; i++ ) {
            if ( i == 4 ) {
                //break;   // 如果使用 break，循环在 i=4 时直接结束
                continue;  // 跳过 i=4 的打印，继续执行 i=5
            }
            System.out.println(i);
        }
    }
}
```

#### 5.3.5 循环小练习：九层妖塔

**阶段一：手动逐层打印（未优化）**
思路：固定层数，手动用四个 `for` 循环分别打印 `1、3、5、7` 个星号（注意：此处未打印前导空格，实际效果为左对齐直角三角形）。

```java
package Chapter03;

public class Java05_FlowControl_Test {
    public static void main(String[] args) {
        System.out.println("========== 阶段一：手动逐层打印（未优化） ==========");
        {
            // 打印第一层的数据
            for (int i = 0; i < 1; i++) {
                System.out.print("*");
            }
            System.out.println("");

            // 打印第二层的数据
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

        System.out.println("\n========== 阶段二：使用嵌套循环优化 ==========");
        {
            // 规律分析：
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
```

