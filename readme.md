# Java进阶学习笔记

## 一、Java面向对象

### 1.1 面向对象的特征

1. 封装：将属性和方法封装到类中，隐藏具体实现细节，对外提供访问方式
2. 继承：子类继承父类的属性和方法，提高代码的复用性
3. 多态：同一个方法，不同的表现形式，提高代码的扩展性

### 1.2 类和对象

1. 类：具有相同属性和行为的对象的集合，是对象的抽象
2. 对象：是类的具体实例，具有属性和行为

### 1.3 类的定义

1. 类的定义格式：

    ```java
    public class 类名 {
        // 类的属性
        // 类的方法
    }
    ```

2. 类的属性和方法：

    - 属性：类的属性是描述类的特征
    - 方法：类的方法是描述类的行为

### 1.4 对象的创建和使用

1. 对象的创建：

    ```java
    类名 对象名 = new 类名();
    ```

2. 对象的使用：

    ```java
    对象名.属性名 =值
    对象名.

    方法名()
    ```

3. 对象的访问方式：

    ```java
    对象名.属性名
    对象名.
    
    方法名()
    ```

### 1.5 封装

1. 封装的优点：

    - 隐藏对象的属性和方法，仅对外提供访问方式
    - 提高代码的安全性
    - 提高代码的复用性

2. 封装的实现：

    - 属性私有化
    - 提供公共的 set 和 get 方法

### 1.6 构造方法

1. 构造方法是一种特殊的方法，用来初始化对象
2. 构造方法格式：

    ```java
    public 类名() {
        // 构造方法的具体实现
    }
    ```

3. 构造方法的注意事项：

    - 构造方法的方法名必须和类名一致
    - 构造方法没有返回值类型，连 void 都不能写

## Day01

### 一、继承

#### 1.1. 继承的概念

答： 继承发生前提：当多个类中有相同的属性和行为时，就可以把这些属性和行为抽取到一个独立的类当中。
在Java中使用继承（extends），来继承这些封装了公共属性和行为的类（父类） 继承：有父类有子类 让子类继承父类

#### 1.2. 继承解决程序中的什么问题

答：1. 提高程序中代码的复用性和可维护性（重复的代码抽取出来，封装到子类当中，子类继承后就可以直接使用） 2.建立类与类之间的关系（多态的前提）

#### 1.3. 继承怎么使用的

```java
public class son extends father {
    // 子类可以使用父类中的公共属性及方法
}

public class father {
    // 公共属性及方法
}
```

#### 1.4. 继承在使用中的有哪些注意细节

答：

- Java中只支持**单继承**，不支持**多继承**，但支持**多层继承**
- 子类继承父类后成员变量的访问特点：就近原则
  - 先在子类局部范围内查找；
  - 然后子类成员范围查找；
  - 最后父类成员范围内查找，如果父类范围内还没有找到则报错。
- 局部变量，本类成员变量，父类成员变量重名时区分方法：
  - 局部变量直接访问
  - 本类成员变量：使用this关键字访问 例如 this.name
  - 父类成员变量：使用super关键字访问 例如 super.name

#### 1.5. 继承中方法的重写

1. 什么是方法重写？ 和重载的区别是什么 方法重写就是子类和父类出现了一模一样的方法（方法名，参数列表）
   方法重写发生在子类和父类之间，方法名和参数列表完全一样；而方法重载发生在同一个类当中，通常是方法名相同，参数列表不同且方法重载与方法返回值无关。

2. 什么时候需要用到方法重写

    当子类需要父类的功能，但是父类的功能不能完全满足自己的需求时，子类就可以重写父类中的方法。这样既沿袭了父类的功能，又定义了子类特有内容。

3. 如何快速重写一个方法

    声明不变，重新实现； 重写时方法名及参数列表需要和父类保持一致，对方法体进行重新定义。

4. @Override注解是做什么的？有什么用？

    @Override注解是放在重写后的方法上，作为重写是否正确的校验注解。 加上该注解后如果重写错误，编译阶段会出现错误提示。建议重写方法都加@Override注解，代码安全。

5. 方法重写的注意事项和要求是什么？

    - 重写方法的名称和形参列表必须与被重写方法名称和参数列表保持一致
    - 私有方法不能被重写
    - 子类重写父类方法时，子类方法访问权限必须大于等于父类方法权限（public > protected > default > private)

#### 1。6 继承中构造方法的使用

Q:子类中所有的构造方法默认都会访问父类中的无参构造方法，为什么？ A:子类在初始化的时候，有可能会用到父类中的数据，如果父类没有完成初始化，子类无法使用父类中的数据。
Q:怎么初始化？ A:构造方法中的第一条默认语句都是:suoer()
注意:如果我们编写的类没有手动指定父类，系统也会自动继承Object（Java继承体系中的最顶层父类） 继承中构造方法方法的访问特点 Q:
如果父类中没有空参构造，只有带参构造，会出现什么现象？ A:子类通过super()
，手动调用父类的带参构造方法（推荐）；子类通过this()调用本类的其他构造方法，本类其他构造方法再通过super()去调用父类的带参构造方法（不推荐）

#### 1.7 总结

- 构造方法总结

子类的所有构造方法，默认都会通过super()访问父类中的无参构造方法，每一个子类构造方法的第一条默认语句都是: super()
this(...) super(...)必须放在构造方法的第一行有效语句，并且二者不能共存。

### 二、抽象类

#### 2.1 什么是抽象类

使用 **abstract** 关键字修饰的类称为 **抽象类**
抽象类格式：

```java
public abstract class 类名 {
}
```

#### 2.2 什么是抽象方法

使用 **abstract** 关键字修饰且没有具体实现的方法就是一个**抽象方法**
抽象方法的具体格式

```java
public abstract 返回值类型 方法名(参数列表);
```

#### 2.3 使用场景

1. 当父类定义一个方法时，每个子类对该方法的具体实现逻辑都不一样，那么父类定义该方法时就可以定义成抽象的方法，这个类就必须是抽象类了
2. 抽象类也是类，也能定义类中的五大成分（成员变量、成员方法、构造方法、代码块和内部类）
3. 注意：有抽象方法的类一定是抽象类。抽象类不能实例化（不能创建对象）
4. 既然抽象类不能实例化，为什么还有构造方法？ 答： 抽象类通常是用于父类创建子类对象时需要先初始化父类（抽象方法中构造方法的作用就是用于父类初始化使用）
5. 抽象类中的抽象方法，必须由子类重写。抽象类中可以有抽象方法也可以由非抽象方法，抽象方法必须存在抽象类中。
6. 抽象类的子类要么重写抽象类中的所有抽象方法，要么子类是一个抽象类。

### 三、设计模式

#### 3.1 什么是设计模式

设计模式（design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。
简单来说，设计模式就是一套良好的编码风格，通过众多开发人员长时间测试及开发经验总结而来，不同的设计模式有不同的好处。就是一种解决方案（解决开发中某个问题的方案）

#### 3.2 设计模式解决什么问题

使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性以及程序的重用性。 在开发中一些常见问题，可以用设计模式解决

1. 模板设计模式

把抽象类整体看成一个模板，模板中不能决定的东西定义成抽象方法，让使用模板的类（继承抽象类的类）去重写抽象方法实现需求.

### 四、匿名对象

#### 4.1 什么是匿名对象

- 没有对象名接收的对象，我们称为匿名对象
- 有对象名接收的对象，我们称为有名对象

#### 4.2 匿名对象使用方式

匿名对象可以像有名对象一样使用，但是只能使用一次。具体场景如下：

1. 匿名对象直接调用成员方法
2. 匿名对象直接当作方法传递参数
3. 匿名对象直接当作返回值

## Day02

### 一、static

#### 1.1 什么是static

`static`关键字是**静态的**意思,是Java中的一个 **修饰符**,可以修饰**成员变量**,**成员方法**

- 被 `static` 关键字修饰的变量,一般叫做静态变量
- 被 `static` 关键字修饰的方法,一般叫做静态方法

`startic` 修饰的特点

- 被所在类的所有对象共享 ---是我们判断是否使用静态关键字的条.
- 随着类的加载而加载,优先于对象存在 ---对象需要类被加载后,才能创建.
- 可以通过类名调用;也可以通过对象名调用. **推荐使用类名调用**

#### 1.2 static 解决程序中的什么问题

1. 当程序中的某个数据需要共享时使用static 修饰

#### 1.3 static 怎么使用

```java
public class Student {
    // 成员变量
    private String name;
    private static String city;

    // 静态成员方法
    public static void method() {
        // TODO
    }
}
```

#### 1.4 static使用时的注意事项

1. 静态内容是随着类的加载就存在了(早于对象创建);
2. 静态内容通常是使用 类名.成员变量 类名.成员方法() 来访问的;
3. 静态方法只能访问静态的成员(成员变量、成员方法);
4. 非静态方法既可以访问静态的成员又可以访问非静态的成员;
5. 静态方法中是不能使用 `this` 关键字的;
6. static 适用场景一般是在工具类当中.

总结: 静态方法中只能访问静态成员,静态中没有 `this` 关键字

#### 1.5 JVM 内存划分

1. 栈
2. 堆
3. 方法区
    1. 是由N个不同功能的小区域组成的
        1. 静态区域:存放静态内容
        2. 非静态区域:存放非静态内容
        3. 字符串常量池:存放字符串常量
4. 寄存器
5. 本地方法区

### 二、final

#### 2.1 什么是final

`final` 是 Java语言中的修饰符关键字---用来修饰:类、变量还有方法
`final` 关键字的含义: 最终的、不了改变的

#### 2.2 final解决程序中的什么问题

1. 当某个变量不允许修改数据值时,可以使用final修饰.
2. 当某个方法不允许被子类重写时,可以使用final修饰.
3. 当某个类不允许被继承时,可以使用final修饰

#### 2.3 final怎么使用

```java
public final class 类名 {
    private final int COUNT = 1000;

    public final void method() {
        // TODO
    }
}
```

#### 2.3 final使用的注意事项

abstract关键字不可以和final关键字共存使用 在类中 abstract关键字是希望子类继承,而final关键字是组织继承 在方法中
abstract关键字是希望子类重写,而final关键字是阻止重写

### 三、权限修饰符关键字

#### 3.1 什么是权限修饰符

权限修饰符是Java语言中的关键字,用于修饰:类、变量和方法 权限修饰符有:private、public、protected还有默认(什么都不写)

#### 3.2 权限修饰符解决什么问题

限制程序中的访问权限(类、变量还有方法的访问权限)

#### 3.3 权限修饰符怎么使用

```java
// 类(权限: 公开的[没有限制的])
public class 类 {
    // 成员变量 (私有)
    private String name;

    // 默认权限 (权限: 当前包下的任意类)
    void show() {
    }

    // protected(权限: 子类)
    protected void method() {
    }
}
```

适用范围从小到大排序:

1. private //访问范围: 仅限本类中访问
2. 默认 //访问范围: 只能在同一个包下的类
3. protected //访问范围: 同一包下的任意类,或不同包下的子类
4. public //访问范围: 没有限制

#### 3.4 权限修饰符使用的注意事项

1. 方法重写时,必须保证子类重写方法的访问权限必须大于等于 父类中的方法权限;

#### 3.5 工具类的书写规则

工具类的特点:

- 不能被继承: final关键字
- 不能让其他类创建对象: private关键字
- 提供静态方法: public static关键字

```java
// final关键字 保证类不能被继承
public final class 工具类 {
    // private 关键字修饰构造方法保证 不能被创建对象
    private 工具类() {
    }

    // public static 关键字 提供外部访问的静态方法
    public static 返回值 静态方法(参数列表) {

    }
}
```

### 四、代码块

Q: 在一个类中可以书写哪些内容

A:

```java
public class 类 {
    // 成员变量: 静态、非静态

    // 成员方法: 静态、非静态、抽象

    // 构造方法

    // 代码块
}
```

#### 4.0 代码块的划分

1. 静态代码块 (开发中使用最多)
    1. 书写位置: 在类方法外(和成员变量、成员方法属于同一级);
    2. 特点: 随着类的加载执行一次静态代码块(类只会被加载一次);
    3. 用于对静态成员数据进行初始化.
2. 构造代码块
    1. 书写位置: 在类方法外(和成员变量、成员方法属于同一级);
    2. 特点: 在每个构造方法执行前,都会先执行构造代码块;
    3. 作用: 当类中多个构造方法中有共性内容时,可以抽取到构造代码块.
3. 局部代码块
    1. 书写位置: 写在方法体中
    2. 特点: 在方法执行时才会调用
    3. 作用: 用于作用域

#### 4.1 构造代码块

1. 怎么写构造代码块

    在类中方法外定义一个大括号

    ```java
    public class Student {
        {
            // 构造代码块
        }
    }
    ```

2. 构造代码块的执行特点

    执行特点: 会在每一个构造方法执行前,执行一次

    作用: 如果每个构造方法有重复的逻辑时,可以抽取到构造代码块.

#### 4.2 静态代码块

1. 怎么写静态代码块

    直接在构造代码块前加 `static` 关键字

    ```java
    public class Student {
        static {
            // 构造代码块
        }
    }
    ```

2. 静态代码块的执行特点及作用

    执行特点: 随着类加载到内存,会执行一次.(类加载到方法区初始化的时候会执行静态代码块)

    作用: 可以对静态数据进行初始化

#### 4.3 局部代码块

1. 怎么写局部代码块

    任何局部代码位置都可以定义局部代码块, 就是一对大括号

    静态代码块、构造代码块、成员方法还有构造方法中均可定义局部代码块;相比之下方法中定义局部代码块稍多些

    ```java
    public class Student {
        public void test() {
            int a = 10;
            {
                // 局部代码块
            }
        }
    }
    ```

2. 局部代码块的执行特点及作用

    执行特点: 在任何局部代码位置都可以定义局部代码块; 作用: 可以限定变量的作用域,在代码执行完毕时及时释放内存

### 五、 接口

#### 5.1 接口介绍

当一个类中的所有方法都是抽象方法时, 此类就是定义规则的类, 我们就可以称其为****
接口 也是一种引用型数据类型,比抽象类还要抽象

- 接口存在两个重要意义
  - **规则**的制定
  - 程序的 **扩展性**

#### 5.2 接口的定义和特点

- 接口用 `interface` 关键字来定义

    ```java
    public interface 接口名 {
        // 抽象方法
    }
    ```

- 接口不能实例化(不能创建对象)
- 接口中没有构造方法(接口只能通过子类来实现对象创建)
- 类与接口之间是实现关系,通过 `implements` 关键字表示

  ```java
  public class 类名 implements 接口名 {}
  ```

- 接口的子类(实现类): 要么重写接口中的所有抽象方法; 要么是抽象类
- **类与接口的关系**: 可以是单实现也可以是多实现(一个类可以实现多个接口)

    ```java
      public class 类名 implements 接口1, 接口2, 接口3 {
        // 重写所实现接口中所有抽象方法
      }
    ```

- 接口中可以实现的内容

    ```java
    public interface 接口名 {
        // 抽象方法
    
        // 静态常量
        public static final int NUMBER = 10;
    }
    ```

#### 5.3 接口成员特点

- 成员变量 用于定义一些可以确定的变量
  - 只能是常量
  - 默认修饰符: public static final
- 构造方法
  - 没有
- 成员方法
  - 只能是抽象方法
  - 默认修饰符 public abstract

#### 5.4 JDK8和9中接口方法的变化

##### 5.4.1 JDK8版本接口

- JDK8版本之后,Java只对接口的成员方法进行了改造: 允许接口中定义带有方法体的方法
- JDK8版本新增: 默认方法和静态方法.
- 默认方法: 允许在接口中定义非抽象方法，但是需要使用关键字 default 修饰，这些方法就是默认方法;作用:解决接口升级问题
  - 定义格式: public default 返回值类型 方法名(参数列表) { }
  - 注意事项:
    - 默认方法不是抽象方法，所以不强制被重写。但是可以被重写，重写的时候去掉default关键字
    - public可以省略，default不能省略
    - 如果实现了多个接口，多个接口中存在相同的方法声明，子类就必须对该方法进行重写
- 静态方法: 作用 方法调用更加简洁
  - 定义格式: public static 返回值类型 方法名(参数列表) { }
  - 注意事项:
    - 静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
    - public可以省略，default不能省略

##### 5.4.2 JDK9版本接口

- JDK8版本新增: 私有方法.
- 私有方法:
  - 定义格式1: private 返回值类型 方法名(参数列表) { }
  - 定义格式2: private static 返回值类型 方法名(参数列表) { }
  - 作用: 作用 : 接口中的方法出现了重复的代码，还不想被其他类访问 , 可以考虑抽取出一个私有方法

#### 5.5 类与接口的关系

- 类与类的关系
  - 继承关系: 只能单继承,但是可以多层继承
- 类与接口的关系
  - 实现接口: 可以单实现也可以多实现,还可以在继承一个类的同时实现多个接口
- 接口和接口的关系
  - 继承关系: 可以单继承, 也可以多继承

#### 5.6 接口和抽象类的使用区别

事物的共性内容(属性,行为),抽取到父类中(可以是抽象类)
特有的行为,可以抽象到接口中

1. 接口和抽象类的相同之处
    1. 接口和抽象类,都不能实例化(不能创建对象)
    2. 接口和抽象类,都具有抽象方法
    3. 接口和抽象类,都是作为父类型存在的
2. 接口和抽象类的不同之处
    1. 抽象类: 除了抽象方法外还具有成员变量、构造方法还有非抽象方法;
    2. 接口: 除了抽象方法外,只有 常量(JDK8: 默认方法和静态方法) (JDK9: 私有方法)

### 六、枚举

#### 6.1 什么是枚举

1. 枚举介绍

    在 Java中 枚举是一种数据类型,枚举用来表示: 固定且仅有几种取值范围的数据 例如: 性别

    枚举在日常生活中很常见，例如一个人的性别只能是男或者女，一周的星期只能是 7 天中的一个等。类似这种当一个变量有几种固定可能的取值时，就可以将它定义为枚举类型。在JDK 1.5 之前没有枚举类型，那时候一 般用接口常量来替代。而使用Java 枚举类型 enum 可以更贴近地表示这种常量。

2. 枚举定义 声明枚举时 必须使用 enum 关键字, 语法如下

    ```java
    权限修饰符
    
    enum 枚举名称 {
        枚举项1, 枚举项2...;
    }
    ```

#### 6.2 枚举解决程序中的什么问题

当程序中有数据固定且仅有几种取值范围的数据时,使用枚举类型强制设置值的范围(赋值数据有保障)

#### 6.3 枚举怎么使用

```java
权限修饰符

enum 枚举名称 {
    枚举项1, 枚举项2...;
}
// 枚举之间使用 `,` 分割,最后使用 `;` 结束 

// eg:
public enum Sex {
    BOY, GIRL;
}
```

使用方式: 通过枚举名直接引用枚举项即可; 如: Sex.BOY 注意: **每个枚举项都相当于枚举的对象**

#### 6.4 枚举定义的其他成分

探索枚举的本质: 枚举其实本质上是一个类，每一个枚举项是本枚举类类型的一个对象。

- 枚举类都是继承了枚举类型：java.lang.Enum;
- 枚举都是最终类，不可以被继承;
- 构造器的构造器都是私有的，枚举对外不能创建对象;
- 枚举类的第一行默认都是罗列枚举对象的名称的;
- 枚举类相当于是多例模式.

#### 6.5 枚举在使用中的注意事项

1. 枚举本质上是一个类;
2. 在枚举中除了可以书写固定选项值外,还可以书写:成员变量、私有构造方法和成员方法;

## Day03

### 一、多态

#### 1.1 什么是多态

同一个对象,在不同时刻表现出来的不同形态,我们称之为多态 eg:

```java
class Animal {
}

class Cat extends Animal {
}

public class Demo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal cat1 = new Cat();
    }
}
```

#### 1.2 多态解决程序中的什么问题

1. 提高代码的复用性
2. 提高代码的扩展性

#### 1.3 多态的使用

```java
// 多态的代码体现格式
夫类型 对象 = new 子类();      // 大类型包含 小类型: int a = 10 ; long b = a;
```

#### 1.4 多态在使用时的注意细节

1. 多态中: 父类和子类拥有一摸一样的成员变量时:
    1. 编译时: 以父类中的成员变量为主
    2. 运行时: 使用父类中的成员变;
2. 多态中: 父类和子类拥有一摸一样的成员方法时:
    1. 编译时: 以父类中的成员方法为主(检查父类中有没有这个成员方法, 没有的话就报错)
    2. 运行时: 以子类中的成员方法为主(调用子类对象中重写后的方法)

#### 1.5 多态的优缺点

##### 1.5.1 多态的优点

1. 提高了程序的扩展性和灵活性

多态形式体现(使用方向)

1. 定义方法的时候, 使用父类作为参数, 该方法就可以接收此父类的任意子类对象;
2. 定义方法的时候, 使用父类作为方法的返回值类型, 该方法就可以返回此父类的任意子类对象;
3. 定义变量时, 用父类类型变量接收子类类型对象.

##### 1.5.2 多态的缺点

1. 不能使用子类的特有功能

#### 1.6 多态的转型

##### 1.6.1 向上转型(自动类型提升)

子类型数据，转换为父类型的数据，就是向上转型。因此多态的书写格式本身就是使用了向上转型。

如：`Animal a = new Cat();`

类型虽做了转换，但是在堆中的对象，本质上还是原来创建对象所用的类型。如上举例，猫对象虽然转换为动物类型，但是堆中的对象本质上还是猫的对象。

##### 1.6.2 向下转型(强制类型转换)

父类型的数据转换为子类型数据称为向下转型，和基本数据类型的强转一样

格式: 目标类型 变量名 = (目标类型)(被转换的数据)

例如:

`Animal a = new Cat(); // a变量的类型是父类型Animal Cat c = (Cat) a; // 将Animal父类型的数据转换为子类型Cat`

Q: 向下转型能带来什么作用呢? A: 解决多态中不能调用子类特有成员的弊端。

`Animal a = new Cat(); a.eat(); a.catchMouse(); //多态中不能调用子类特有方法 Cat c = (Cat) a ; c.eat(); c.catchMouse(); //向下转型后解决了弊端`

向下转型注意细节:

- 容易发生: `java.lang.ClassCastException` (类型转换异常)
  - 解决方案: 使用 `instanceof` 关键字 来判断类型

#### 1.7 接口的多态实现

Q: 接口中的多态是怎样的? A: 接口的多态和类继承的多态是一样, 前提也是一样的.

代码实现如下:

```java
interface Player {
    void play();
}

class Mp3Player implements Player {
    @Override
    public void play() {
        System.out.println("播放音乐");
    }
}

class Test {
    public static void main(String[] args) {
        Player player = new Mp3Player();
        player.play();
    }
}
```

多态代码的书写:

1. 创建对象

    ```java
    // 夫类型 父引用 = new 子类()
    Father father = new Son();

    ```

2. 作为参数

    ```java
    public void method(Father father) {
        f.方法();
    }
    ```

3. 作为返回值

    ```java
    public Ainimal getInstance() {
        return new Cat();
    }
    ```

### 二、内部类

#### 2.1 什么是内部类

一个类A内部定义了一个类B, 那么B就是A的内部类. A可以称为外部类. Q: 如何访问某个类中的成员变量 or 成员方法? A: 创建类的对象,
通过 `对象名.成员`的方式访问

#### 2.2 成员内部类

##### 2.2.1 定义

类中方法外定义的类, 我们称为成员内部类, 例如:

```java
class Outer {
    class Inner {

    }
}
```

如果要描述两个事物，这两个事物存在包含关系，就可以使用成员内部类。 如: 人与心的关系；汽车与引擎的关系。

##### 2.2.2 成员内部类对象实例化

内部类的类型表示：外部类名.内部类名 成员内部类创建对象，需要借助外部类的对象，如下：

`外部类名.内部类名 变量 = 外部类对象.new 内部类构造方法(参数);`

代码实例: 定义一个人类, 内部类心脏. 调用心脏内部类的方法;

```java
class Person {
    //心脏    
    class Heart {
        //变量-频率        
        private int rate;//60~75

        //跳动方法        
        public void beats() {
            System.out.println("咚咚咚~~");
        }
    }
}

```

创建内部类Heart对象，并调用方法beats，如下：

```java
Person.Heart heart = new Person().new Heart();
        heart.

beats();
```

##### 2.2.3 内部类访问外部类成分

成员内部类的方法中默认存在一个外部类对象： 外部类名.this 。可用此格式来调用外部类成员，访问时如果没有冲突,格式可省略，如果有冲突就不能省略了。

对于外部类来讲，没有默认的内部类对象的，如果要访问内部类的成员，需要创建内部类对象

```java
class Person {
    private String name = "张三";
    int num = 30;

    class Heart {
        private int rate; //60-75
        int num = 20;

        public void beats() {
            int num = 30;
            System.out.println(num);                // 30
            System.out.println(this.num);           // 20
            System.out.println(Person.this.num);    // 10
        }
    }
}
```

#### 2.3 匿名内部类

##### 2.3.1 匿名内部类的介绍

- 匿名内部类是一个非常特殊的内部类，从命名可以看出，匿名内部类是没有类名，因此这个内部类只能用一次。
- 有什么场景可以使用呢？匿名内部类一般用于简化代码，当要快速实现一个抽象类或者接口的抽象方法时，我们就可以使用匿名内部类来简化，可以不用专门定义一个有名类来操作。
- 由上述可知，要使用匿名内部类，必须要有一个父类或者父接口。

##### 2.3.2 匿名内部类的定义格式

```java
new 类名/

接口() {
    //如果父类型有抽象方法，需要全部重写
}

```

特点分析：

- 该匿名内部类大括号就是某一个类或者接口的实现类。
- 该格式体现的不仅是一个类，同时还是一个对象

##### 2.3.2 匿名内部类的使用

1. 使用父类型变量多态接收该匿名子类对象。
2. 以匿名对象的方式使用
    1. 直接调用方法使用
    2. 当做方法的参数传递
    3. 当做方法的返回值使用

实例: 定义一个接口 Flyable 含有飞的功能, 用匿名内部类实现并使用

```java
// interface

interface Flyable {
    void fly();
}

// 1. 使用父类型变量多态接收该匿名子类对象。
class Demo {
    public static void main(String[] args) {
        Flyable f1 = new Flyable() {
            @Override
            public void fly() {
                System.out.println("我在飞");
            }
        };
        f1.fly();
    }
}

// 2. 以匿名对象的方式使用
// 2.1 直接调用方法使用
class Demo {
    public static void main(String[] args) {
        new Flyable() {
            @Override
            public void fly() {
                System.out.println("我在飞");
            }
        }.fly();
    }
}

// 2.2 当作方法的参数传递
class Demo {
    public static void main(String[] args) {
        showFlyable(new Flyable() {
            @Override
            public void fly() {
                System.out.println("我在飞");
            }
        });
    }

    public static void showFlyable(Flyable flyable) {
        flyable.fly();
    }
}

// 2.3 当作方法的返回值使用
class Demo {
    public static void main(String[] args) {
        Flyable flyable = getFlyable();
        flyable.fly();
    }

    public static Flyable getFlyable() {
        return new Flyable() {
            @Override
            public void fly() {
                System.out.println("我在飞");
            }
        };
    }
}
```

#### 2.4 匿名内部类的注意事项

1. 匿名内部类使用有什么前提条件

    答: 有一个父类或者父接口

2. 匿名内部类的使用场景

    匿名内部类一般用于简化代码，当要快速实现一个抽象类或者接口的抽象方法时，我们就可以使用匿名内部类来简化

3. 匿名内部类的定义格式

    ```java
    new 类名/

    接口() {
        //如果父类型有抽象方法，需要全部重写
    }

    ```

4. 匿名内部类有什么特点

    - 该匿名内部类其实就是某一个类或者接口的子类;
    - 该格式体现的不仅是一个类，同时还是一个对象.


5. 匿名内部类该怎么使用

    - 使用父类型变量多态接收该匿名子类对象。
    - 一般匿名内部类作为方法的参数传递 , 方法的返回值

### 三、常用API

#### 3.1 Object类

介绍:
类Object是类层次结构的根，每个类都把Object作为超类。 所有对象（包括数组）都实现了这个类的方法

- 在Java语言中, 程序员自定义的类或者 jdk 中存在的类, 直接或间接都要继承 Object
- 继承了Object类 后 就可以使用Object提供的相关方法
- Object类中的方法:

| 方法签名                              | 说明                                    |
|-----------------------------------|---------------------------------------|
| public String toString()          | 返回该对象的字符串表示。                          |
| public boolean equals(Object obj) | 指示其他某个对象是否与此对象“相等”。                   |
| protected Object clone()          | 创建并返回此对象的一个副本。                        |
| public Class getClass()           | 返回此 Object 的运行时类。                     |
| public int hashCode()             | 返回该对象的哈希码值。                           |
| public void finalize()            | 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。 |

##### 3.1.1 toString()方法

1. toString()方法的作用:

    - toString()方法是Object类的一个方法，当我们打印引用数据类型的对象时，打印的是该对象的地址值，而不是实际内容。
    - 我们可以重写toString()方法，返回对象的属性值，这样我们在打印引用数据类型的对象时，打印的是实际内容。

2. 重写toString()方法的步骤:

    - 在类中重写toString()方法
    - 在toString()方法中使用return返回需要显示的属性值即可

    ```java
    class Person {
        private String name;
        private int age;
    
        public Person() {
        }
    
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    ```

##### 3.1.2 equals()方法

1. equals()方法的作用:

    - equals()方法是Object类的一个方法，用来比较两个对象是否相等。
    - 在Object类中，equals()方法比较的是两个对象的地址值，即比较两个对象是否是同一个对象。

2. 重写equals()方法的步骤:

    - 在类中重写equals()方法
    - 在equals()方法中使用return返回需要比较的属性值即可

    ```java 
    class Person {
        private String name;
        private int age;
    
        public Person() {
        }
    
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }
    }
    ```

##### 3.1.3 getClass()方法

1. getClass()方法的作用:

    - getClass()方法是Object类的一个方法，用来返回对象的运行时类。
    - 通过getClass()方法我们可以获取对象的运行时类，然后我们可以通过运行时类获取对象的属性、方法等。

    ```java
    class Person {
        public void show() {
            System.out.println("show");
        }
    }
    
    class Demo {
        public static void main(String[] args) {
            Person p = new Person();
            Class c = p.getClass();
            System.out.println(c);
        }
    }
    ```

##### 3.1.4 hashCode()方法

1. hashCode()方法的作用:

    - hashCode()方法是Object类的一个方法，用来获取对象的哈希码值。
    - 通过哈希码值我们可以快速找到对象在哈希表中的位置。

2. hashCode()方法的特点:

    - hashCode()方法返回的是一个哈希码值，不是一个具体的地址值。
    - 如果两个对象相等，那么两个对象的哈希码值一定相等。
    - 如果两个对象的哈希码值相等，这两个对象不一定相等。

    ```java
    class Person {
        private String name;
        private int age;
    
        public Person() {
        }
    
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
    ```

##### 3.1.5 finalize()方法

1. finalize()方法的作用:

    - finalize()方法是Object类的一个方法，当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
    - finalize()方法是在垃圾回收器删除对象之前调用的。

2. finalize()方法的特点:

    - finalize()方法是Object类的一个方法，我们可以重写finalize()方法，当对象被垃圾回收器回收时，我们可以在finalize()
      方法中释放对象占用的资源。
    - finalize()方法是一个protected修饰的方法，我们可以重写finalize()方法，但是我们不应该手动调用finalize()方法，finalize()
      方法是由垃圾回收器调用的。

    ```java
    class Person {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("对象被回收了");
        }
    }
    ```

##### 3.1.6 小结

- Object类是Java中的根类，每个类都是Object的子类。
- Object类中有一些常用的方法，如toString()、equals()、getClass()、hashCode()、finalize()等。
- toString()方法是Object类的一个方法，用来返回对象的字符串表示。
- equals()方法是Object类的一个方法，用来比较两个对象是否相等。
- getClass()方法是Object类的一个方法，用来返回对象的运行时类。
- hashCode()方法是Object类的一个方法，用来获取对象的哈希码值。

- finalize()方法是Object类的一个方法，当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。

#### 3.2 System类

介绍:
System类是Java中的一个final类，提供了一系列静态方法，这些方法和系统有关，主要有标准输入、标准输出、错误输出、系统属性、环境变量、系统时间等功能。

##### 3.2.1 System类的常用方法

| 方法签名                                                                                       | 说明                 |
|--------------------------------------------------------------------------------------------|--------------------|
| public static void exit(int status)                                                        | 终止当前运行的Java虚拟机。    |
| public static void gc()                                                                    | 运行垃圾回收器。           |
| public static long currentTimeMillis()                                                     | 返回以毫秒为单位的当前时间。     |
| public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) | 将数组中指定数据拷贝到另一个数组中。 |

##### 3.2.2 System类的常用方法使用

1. exit()方法

    - exit()方法是System类的一个方法，用来终止当前运行的Java虚拟机。
    - exit()方法的参数是一个整数，表示退出状态码，一般情况下，0表示正常退出，非0表示异常退出。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println("开始");
            System.exit(0);
            System.out.println("结束");
        }
    }
    ```

2. gc()方法

    - gc()方法是System类的一个方法，用来运行垃圾回收器。
    - gc()方法会运行垃圾回收器，对于垃圾回收器的调用是一个建议，垃圾回收器可以不立即执行。

    ```java
    public class Demo {
        public static void main(String[] args) {
            for (int i = 0; i < 10000; i++) {
                new Demo();
                System.gc();
            }
        }
    }
    ```

3. currentTimeMillis()方法

    - currentTimeMillis()方法是System类的一个方法，用来返回以毫秒为单位的当前时间。
    - currentTimeMillis()方法返回的是一个long类型的数据，表示从1970年1月1日00:00:00到当前时间的毫秒数。

    ```java

    public class Demo {
        public static void main(String[] args) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                System.out.println(i);
            }
            long end = System.currentTimeMillis();
            System.out.println("共耗时: " + (end - start) + "毫秒");
        }
    }
    ```

4. arraycopy()方法

    - arraycopy()方法是System类的一个方法，用来将数组中指定数据拷贝到另一个数组中。
    - arraycopy()方法有5个参数，分别是：源数组、源数组起始位置、目标数组、目标数组起始位置、拷贝的长度。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] src = {1, 2, 3, 4, 5};
            int[] dest = new int[5];
            System.arraycopy(src, 0, dest, 0, 5);
            for (int i = 0; i < dest.length; i++) {
                System.out.println(dest[i]);
            }
        }
    }
    ```

##### 3.2.3 小结

- System类是Java中的一个final类，提供了一系列静态方法，这些方法和系统有关，主要有标准输入、标准输出、错误输出、系统属性、环境变量、系统时间等功能。
- System类中有一些常用的方法，如exit()、gc()、currentTimeMillis()、arraycopy()等。
- exit()方法是System类的一个方法，用来终止当前运行的Java虚拟机。
- gc()方法是System类的一个方法，用来运行垃圾回收器。
- currentTimeMillis()方法是System类的一个方法，用来返回以毫秒为单位的当前时间。
- arraycopy()方法是System类的一个方法，用来将数组中指定数据拷贝到另一个数组中。

#### 3.3 Math类

介绍:
Math类是Java中的一个final类，提供了一系列静态方法，这些方法用来进行数学运算，如绝对值、开方、次方、三角函数等。

##### 3.3.1 Math类的常用方法

| 方法签名                                         | 说明                                  |
|----------------------------------------------|-------------------------------------|
| public static double abs(double a)           | 返回double类型参数的绝对值。                   |
| public static double ceil(double a)          | 返回大于等于参数的最小整数。                      |
| public static double floor(double a)         | 返回小于等于参数的最大整数。                      |
| public static double round(double a)         | 返回最接近参数的 long。                      |
| public static double pow(double a, double b) | 返回a的b次幂。                            |
| public static double sqrt(double a)          | 返回参数的平方根。                           |
| public static double random()                | 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。 |

##### 3.3.2 Math类的常用方法使用

1. abs()方法

    - abs()方法是Math类的一个方法，用来返回double类型参数的绝对值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.abs(-10.5));
        }
    }
    ```

2. ceil()方法

    - ceil()方法是Math类的一个方法，用来返回大于等于参数的最小整数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.ceil(10.5));
        }
    }
    ```

3. floor()方法

    - floor()方法是Math类的一个方法，用来返回小于等于参数的最大整数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.floor(10.5));
        }
    }
    ```

4. round()方法

    - round()方法是Math类的一个方法，用来返回最接近参数的 long。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.round(10.5));
        }
    }
    ```

5. pow()方法

    - pow()方法是Math类的一个方法，用来返回a的b次幂。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.pow(2, 3));
        }
    }
    ```

6. sqrt()方法

    - sqrt()方法是Math类的一个方法，用来返回参数的平方根。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.sqrt(4));
        }
    }
    ```

7. random()方法

    - random()方法是Math类的一个方法，用来返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。

    ```java
    public class Demo {
        public static void main(String[] args) {
            System.out.println(Math.random());
        }
    }
    ```

##### 3.3.3 小结

- Math类是Java中的一个final类，提供了一系列静态方法，这些方法用来进行数学运算，如绝对值、开方、次方、三角函数等。
- Math类中有一些常用的方法，如abs()、ceil()、floor()、round()、pow()、sqrt()、random()等。
- abs()方法是Math类的一个方法，用来返回double类型参数的绝对值。
- ceil()方法是Math类的一个方法，用来返回大于等于参数的最小整数。
- floor()方法是Math类的一个方法，用来返回小于等于参数的最大整数。
- round()方法是Math类的一个方法，用来返回最接近参数的 long。
- pow()方法是Math类的一个方法，用来返回a的b次幂。
- sqrt()方法是Math类的一个方法，用来返回参数的平方根。
- random()方法是Math类的一个方法，用来返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。

#### 3.4 Random类

介绍:
Random类是Java中的一个类，用来生成伪随机数。Random类提供了一系列方法，用来生成不同类型的随机数。

##### 3.4.1 Random类的常用方法

| 方法签名                       | 说明                                 |
|----------------------------|------------------------------------|
| public int nextInt()       | 返回一个随机数。                           |
| public int nextInt(int n)  | 返回一个大于等于 0 且小于 n 的随机数。             |
| public long nextLong()     | 返回一个 long 类型的随机数。                  |
| public double nextDouble() | 返回一个 [0.0, 1.0) 之间的随机 double 类型的数。 |

##### 3.4.2 Random类的常用方法使用

1. nextInt()方法

    - nextInt()方法是Random类的一个方法，用来返回一个随机数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Random random = new Random();
            System.out.println(random.nextInt());
        }
    }
    ```

2. nextInt(int n)方法

    - nextInt(int n)方法是Random类的一个方法，用来返回一个大于等于 0 且小于 n 的随机数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Random random = new Random();
            System.out.println(random.nextInt(10));
        }
    }
    ```

3. nextLong()方法

    - nextLong()方法是Random类的一个方法，用来返回一个 long 类型的随机数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Random random = new Random();
            System.out.println(random.nextLong());
        }
    }
    ```

4. nextDouble()方法

    - nextDouble()方法是Random类的一个方法，用来返回一个 [0.0, 1.0) 之间的随机 double 类型的数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Random random = new Random();
            System.out.println(random.nextDouble());
        }
    }
    ```

##### 3.4.3 小结

- Random类是Java中的一个类，用来生成伪随机数。
- Random类中有一些常用的方法，如nextInt()、nextInt(int n)、nextLong()、nextDouble()等。
- nextInt()方法是Random类的一个方法，用来返回一个随机数。
- nextInt(int n)方法是Random类的一个方法，用来返回一个大于等于 0 且小于 n 的随机数。
- nextLong()方法是Random类的一个方法，用来返回一个 long 类型的随机数。

- nextDouble()方法是Random类的一个方法，用来返回一个 [0.0, 1.0) 之间的随机 double 类型的数。

#### 3.5 StringBuilder类

介绍:
StringBuilder类是Java中的一个类，用来进行字符串的拼接。StringBuilder类提供了一系列方法，用来进行字符串的拼接，如append()
、insert()、delete()、reverse()等。

##### 3.5.1 StringBuilder类的常用方法

| 方法签名                                            | 说明                             |
|-------------------------------------------------|--------------------------------|
| public StringBuilder append(...)                | 添加任意类型数据的字符串形式，并返回当前对象自身。      |
| public StringBuilder insert(int offset, ...)    | 在指定位置插入任意类型数据的字符串形式，并返回当前对象自身。 |
| public StringBuilder delete(int start, int end) | 删除从指定位置开始到指定位置结束的内容，并返回当前对象自身。 |
| public StringBuilder reverse()                  | 将当前字符序列逆序，并返回当前对象自身。           |
| public String toString()                        | 返回此序列中数据的字符串表示形式。              |

##### 3.5.2 StringBuilder类的常用方法使用

1. append()方法

    - append()方法是StringBuilder类的一个方法，用来添加任意类型数据的字符串形式，并返回当前对象自身。

    ```java
    public class Demo {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            sb.append("world");
            sb.append(100);
            System.out.println(sb);
        }
    }
    ```

2. insert()方法

    - insert()方法是StringBuilder类的一个方法，用来在指定位置插入任意类型数据的字符串形式，并返回当前对象自身。

    ```java
    public class Demo {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            sb.insert(2, "world");
            System.out.println(sb);
        }
    }
    ```

3. delete()方法

    - delete()方法是StringBuilder类的一个方法，用来删除从指定位置开始到指定位置结束的内容，并返回当前对象自身。

    ```java
    public class Demo {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            sb.delete(2, 4);
            System.out.println(sb);
        }
    }
    ```

4. reverse()方法

    - reverse()方法是StringBuilder类的一个方法，用来将当前字符序列逆序，并返回当前对象自身。

    ```java
    public class Demo {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            sb.reverse();
            System.out.println(sb);
        }
    }
    ```

5. toString()方法

    - toString()方法是StringBuilder类的一个方法，用来返回此序列中数据的字符串表示形式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder();
            sb.append("hello");
            String s = sb.toString();
            System.out.println(s);
        }
    }
    ```

##### 3.5.3 小结

- StringBuilder类是Java中的一个类，用来进行字符串的拼接。
- StringBuilder类中有一些常用的方法，如append()、insert()、delete()、reverse()、toString()等。
- append()方法是StringBuilder类的一个方法，用来添加任意类型数据的字符串形式，并返回当前对象自身。
- insert()方法是StringBuilder类的一个方法，用来在指定位置插入任意类型数据的字符串形式，并返回当前对象自身。
- delete()方法是StringBuilder类的一个方法，用来删除从指定位置开始到指定位置结束的内容，并返回当前对象自身。
- reverse()方法是StringBuilder类的一个方法，用来将当前字符序列逆序，并返回当前对象自身。
- toString()方法是StringBuilder类的一个方法，用来返回此序列中数据的字符串表示形式。
- StringBuilder类的优点：StringBuilder类的方法都是返回当前对象自身，所以可以进行链式编程。StringBuilder类的方法都是在原字符串上进行修改，不会创建新的字符串对象
  、效率高。 、占用内存小。
- StringBuilder类的缺点：StringBuilder类的方法都是在原字符串上进行修改，所以线程不安全、适合单线程使用。

#### 3.6 Date类

介绍:
Date类是Java中的一个类，用来表示时间。Date类提供了一系列方法，用来获取时间、设置时间、格式化时间等。

##### 3.6.1 Date类的常用方法

| 方法签名                                   | 说明                         |
|----------------------------------------|----------------------------|
| public Date()                          | 创建一个当前时间的Date对象。           |
| public Date(long date)                 | 创建一个指定毫秒数的Date对象。          |
| public long getTime()                  | 获取当前时间的毫秒数。                |
| public void setTime(long time)         | 设置当前时间的毫秒数。                |
| public String toString()               | 将当前时间转换为字符串。               |
| public long getTime()                  | 获取当前时间的毫秒数。                |
| public void setTime(long time)         | 设置当前时间的毫秒数。                |
| public boolean before(Date when)       | 判断当前时间是否在when时间之前。         |
| public boolean after(Date when)        | 判断当前时间是否在when时间之后。         |
| public boolean equals(Object obj)      | 判断当前时间是否与obj时间相等。          |
| public int compareTo(Date anotherDate) | 比较当前时间与anotherDate时间的先后关系。 |
| public int compareTo(Object o)         | 比较当前时间与o时间的先后关系。           |
| public long getTime()                  | 获取当前时间的毫秒数。                |
| public void setTime(long time)         | 设置当前时间的毫秒数。                |
| public String toString()               | 将当前时间转换为字符串。               |

##### 3.6.2 Date类的常用方法使用

1. Date类的构造方法

    - Date类有两个构造方法，一个是无参构造方法，用来创建一个当前时间的Date对象；一个是有参构造方法，用来创建一个指定毫秒数的Date对象。
    - 无参构造方法创建的Date对象表示当前时间；有参构造方法创建的Date对象表示从1970年1月1日00:00:00到指定毫秒数的时间。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date1 = new Date();
            System.out.println(date1);
            Date date2 = new Date(1000);
            System.out.println(date2);
        }
    }
    ```

2. Date类的getTime()方法

    - getTime()方法是Date类的一个方法，用来获取当前时间的毫秒数。
    - getTime()方法返回的是一个long类型的数据，表示从1970年1月1日00:00:00到当前时间的毫秒数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date = new Date();
            long time = date.getTime();
            System.out.println(time);
        }
    }
    ```

3. Date类的setTime()方法

    - setTime()方法是Date类的一个方法，用来设置当前时间的毫秒数。
    - setTime()方法的参数是一个long类型的数据，表示要设置的毫秒数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date = new Date();
            date.setTime(1000);
            System.out.println(date);
        }
    }
    ```

4. Date类的before()方法

    - before()方法是Date类的一个方法，用来判断当前时间是否在when时间之前。
    - 如果当前时间在when时间之前，返回true；否则返回false。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date1 = new Date();
            Date date2 = new Date(1000);
            System.out.println(date1.before(date2));
        }
    }
    ```

5. Date类的after()方法

    - after()方法是Date类的一个方法，用来判断当前时间是否在when时间之后。
    - 如果当前时间在when时间之后，返回true；否则返回false。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date1 = new Date();
            Date date2 = new Date(1000);
            System.out.println(date1.after(date2));
        }
    }
    ```

6. Date类的equals()方法

    - equals()方法是Date类的一个方法，用来判断当前时间是否与obj时间相等。
    - 如果当前时间与obj时间相等，返回true；否则返回false。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date1 = new Date();
            Date date2 = new Date();
            System.out.println(date1.equals(date2));
        }
    }
    ```

7. Date类的compareTo()方法

    - compareTo()方法是Date类的一个方法，用来比较当前时间与anotherDate时间的先后关系。
    - 如果当前时间在anotherDate时间之前，返回-1；如果当前时间在anotherDate时间之后，返回1；如果当前时间与anotherDate时间相等，返回0。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Date date1 = new Date();
            Date date2 = new Date(1000);
            System.out.println(date1.compareTo(date2));
        }
    }
    ```

##### 3.6.3 小结

- Date类是Java中的一个类，用来表示时间。
- Date类中有一些常用的方法，如getTime()、setTime()、before()、after()、equals()、compareTo()等。
- Date类的构造方法：Date类有两个构造方法，一个是无参构造方法，用来创建一个当前时间的Date对象；一个是有参构造方法，用来创建一个指定毫秒数的Date对象。
- getTime()方法是Date类的一个方法，用来获取当前时间的毫秒数。
- setTime()方法是Date类的一个方法，用来设置当前时间的毫秒数。
- before()方法是Date类的一个方法，用来判断当前时间是否在when时间之前。
- after()方法是Date类的一个方法，用来判断当前时间是否在when时间之后。
- equals()方法是Date类的一个方法，用来判断当前时间是否与obj时间相等。
- compareTo()方法是Date类的一个方法，用来比较当前时间与anotherDate时间的先后关系。

#### 3.7 SimpleDateFormat类

介绍:
SimpleDateFormat类是Java中的一个类，用来格式化时间。SimpleDateFormat类提供了一系列方法，用来格式化时间、解析时间等。

##### 3.7.1 SimpleDateFormat类的常用方法

| 方法签名                                                                 | 说明                                       |
|----------------------------------------------------------------------|------------------------------------------|
| public SimpleDateFormat(String pattern)                              | 用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。 |
| public String format(Date date)                                      | 格式化日期。                                   |
| public Date parse(String source)                                     | 解析日期。                                    |
| public void applyPattern(String pattern)                             | 更改日期和时间格式模式。                             |
| public String toPattern()                                            | 返回当前日期和时间格式模式。                           |
| public void setTimeZone(TimeZone zone)                               | 设置给定的 TimeZone，用来解释格式化和解析日期。             |
| public void setLenient(boolean lenient)                              | 将解析过程设置为宽松。                              |
| public void set2DigitYearStart(Date startDate)                       | 设置用两位数年份解释日期字符串的开始日期。                    |
| public DateFormatSymbols getDateFormatSymbols()                      | 获取 DateFormatSymbols 的副本，用于格式化日期。        |
| public void setDateFormatSymbols(DateFormatSymbols newFormatSymbols) | 设置用于格式化日期的 DateFormatSymbols。            |

##### 3.7.2 SimpleDateFormat类的常用方法使用

1. SimpleDateFormat类的构造方法

    - SimpleDateFormat类有一个构造方法，用来用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
    - SimpleDateFormat类的构造方法的参数是一个字符串，表示日期格式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf);
        }
    }
    ```

2. SimpleDateFormat类的format()方法

    - format()方法是SimpleDateFormat类的一个方法，用来格式化日期。
    - format()方法的参数是一个Date对象，表示要格式化的日期。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String s = sdf.format(date);
            System.out
        }
    }
    ```

3. SimpleDateFormat类的parse()方法

    - parse()方法是SimpleDateFormat类的一个方法，用来解析日期。
    - parse()方法的参数是一个字符串，表示要解析的日期。

    ```java
    public class Demo {
        public static void main(String[] args) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = "2021-01-01 12:12:12";
            Date date = sdf.parse(s);
            System.out.println(date);
        }
    }
    ```

4. SimpleDateFormat类的applyPattern()方法

    - applyPattern()方法是SimpleDateFormat类的一个方法，用来更改日期和时间格式模式。
    - applyPattern()方法的参数是一个字符串，表示要更改的日期格式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");
            System.out.println(sdf);
        }
    }
    ```

5. SimpleDateFormat类的toPattern()方法

    - toPattern()方法是SimpleDateFormat类的一个方法，用来返回当前日期和时间格式模式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String pattern = sdf.toPattern();
            System.out.println(pattern);
        }
    }
    ```

6. SimpleDateFormat类的setTimeZone()方法

    - setTimeZone()方法是SimpleDateFormat类的一个方法，用来设置给定的 TimeZone，用来解释格式化和解析日期。
    - setTimeZone()方法的参数是一个TimeZone对象，表示要设置的时区。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            System.out.println(sdf);
        }
    }
    ```

7. SimpleDateFormat类的setLenient()方法

    - setLenient()方法是SimpleDateFormat类的一个方法，用来将解析过程设置为宽松。
    - setLenient()方法的参数是一个boolean类型的数据，表示是否设置为宽松。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setLenient(false);
            System.out.println(sdf);
        }
    }
    ```

8. SimpleDateFormat类的set2DigitYearStart()方法

    - set2DigitYearStart()方法是SimpleDateFormat类的一个方法，用来设置用两位数年份解释日期字符串的开始日期。
    - set2DigitYearStart()方法的参数是一个Date对象，表示要设置的开始日期。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            sdf.set2DigitYearStart(date);
            System.out.println(sdf);
        }
    }
    ```

9. SimpleDateFormat类的getDateFormatSymbols()方法

    - getDateFormatSymbols()方法是SimpleDateFormat类的一个方法，用来获取 DateFormatSymbols 的副本，用于格式化日期。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormatSymbols dfs = sdf.getDateFormatSymbols();
            System.out.println(dfs);
        }
    }
    ```

10. SimpleDateFormat类的setDateFormatSymbols()方法

    - setDateFormatSymbols()方法是SimpleDateFormat类的一个方法，用来设置用于格式化日期的 DateFormatSymbols。
    - setDateFormatSymbols()方法的参数是一个DateFormatSymbols对象，表示要设置的DateFormatSymbols。

    ```java
    public class Demo {
        public static void main(String[] args) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormatSymbols dfs = new DateFormatSymbols();
            sdf.setDateFormatSymbols(dfs);
            System.out.println(sdf);
        }
    }
    ```

##### 3.7.3 小结

- SimpleDateFormat类是Java中的一个类，用来格式化时间。
- SimpleDateFormat类中有一些常用的方法，如format()、parse()、applyPattern()、toPattern()、setTimeZone()、setLenient()
  、set2DigitYearStart()、getDateFormatSymbols()、setDateFormatSymbols()等。
- SimpleDateFormat类的构造方法：SimpleDateFormat类有一个构造方法，用来用给定的模式和默认语言环境的日期格式符号构造
  SimpleDateFormat。
- format()方法是SimpleDateFormat类的一个方法，用来格式化日期。
- parse()方法是SimpleDateFormat类的一个方法，用来解析日期。
- applyPattern()方法是SimpleDateFormat类的一个方法，用来更改日期和时间格式模式。
- toPattern()方法是SimpleDateFormat类的一个方法，用来返回当前日期和时间格式模式。
- setTimeZone()方法是SimpleDateFormat类的一个方法，用来设置给定的 TimeZone，用来解释格式化和解析日期。
- setLenient()方法是SimpleDateFormat类的一个方法，用来将解析过程设置为宽松。
- set2DigitYearStart()方法是SimpleDateFormat类的一个方法，用来设置用两位数年份解释日期字符串的开始日期。
- getDateFormatSymbols()方法是SimpleDateFormat类的一个方法，用来获取 DateFormatSymbols 的副本，用于格式化日期。
- setDateFormatSymbols()方法是SimpleDateFormat类的一个方法，用来设置用于格式化日期的 DateFormatSymbols。
- `SimpleDateFormat`类的模式是一个字符串，用于定义日期格式。
- 模式中的字母表示日期的各个部分，例如：`yyyy`表示年份，`MM`表示月份，`dd`表示日期，`HH`表示小时，`mm`表示分钟，`ss`表示秒。
- 字母的个数决定了日期部分的长度，例如：`yyyy`表示4位年份，`MM`表示2位月份。
- 模式中的符号用作日期部分的分隔符，例如：`yyyy-MM-dd HH:mm:ss`中的`-`和`:`。
- 符号的位置决定了日期部分的位置，例如：`yyyy-MM-dd HH:mm:ss`中，分隔符的位置在年月、月日、日时、时分之间。
- 符号的种类决定了日期格式的分隔符的种类，例如：`yyyy-MM-dd HH:mm:ss`中，分隔符有`-`和`:`两种。
- 符号的大小写表示日期格式的大小写，例如：`yyyy`表示4位年份，`YYYY`表示2位年份，`MM`表示2位月份，`mm`表示2位分钟。

#### 3.8 Calendar类

介绍:
Calendar类是Java中的一个类，用来操作日期。Calendar类提供了一系列方法，用来获取日期、设置日期、计算日期等。

##### 3.8.1 Calendar类的常用方法

| 方法签名                                                   | 说明                                           |
|--------------------------------------------------------|----------------------------------------------|
| public static Calendar getInstance()                   | 返回一个默认语言环境的 Calendar 实例。                     |
| public int get(int field)                              | 返回给定日历字段的值。                                  |
| public void set(int field, int value)                  | 设置给定日历字段的值。                                  |
| public void add(int field, int amount)                 | 根据日历的规则，为给定的日历字段添加或减去指定的时间量。                 |
| public final Date getTime()                            | 返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。 |
| public final void setTime(Date date)                   | 用给定的 Date 设置此 Calendar 的时间。                  |
| public final void setTimeZone(TimeZone value)          | 设置此 Calendar 的时区。                            |
| public final TimeZone getTimeZone()                    | 获取此 Calendar 的时区。                            |
| public final void setLenient(boolean lenient)          | 将此 Calendar 置于宽松模式。                          |
| public final boolean isLenient()                       | 测试此 Calendar 是否为宽松模式。                        |
| public final void setFirstDayOfWeek(int value)         | 设置每周的第一天是星期几。                                |
| public final int getFirstDayOfWeek()                   | 获取每周的第一天是星期几。                                |
| public final void setMinimalDaysInFirstWeek(int value) | 设置一年中的最小天数，以确定第一周的最小天数。                      |
| public final int getMinimalDaysInFirstWeek()           | 获取一年中的最小天数，以确定第一周的最小天数。                      |

##### 3.8.2 Calendar类的常用方法使用

1. Calendar类的getInstance()方法

    - getInstance()方法是Calendar类的一个静态方法，用来返回一个默认语言环境的 Calendar 实例。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar);
        }
    }
    ```

2. Calendar类的get()方法

    - get()方法是Calendar类的一个方法，用来返回给定日历字段的值。
    - get()方法的参数是一个int类型的数据，表示日历字段。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            System.out.println(year);
            System.out.println(month);
            System.out.println(date);
            System.out.println(hour);
            System.out.println(minute);
            System.out.println(second);
        }
    }
    ```

3. Calendar类的set()方法

    - set()方法是Calendar类的一个方法，用来设置给定日历字段的值。
    - set()方法有两个参数，第一个参数是一个int类型的数据，表示日历字段；第二个参数是一个int类型的数据，表示要设置的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2021);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR, 12);
            calendar.set(Calendar.MINUTE, 12);
            calendar.set(Calendar.SECOND, 12);
            System.out.println(calendar);
        }
    }
    ```

4. Calendar类的add()方法

    - add()方法是Calendar类的一个方法，用来根据日历的规则，为给定的日历字段添加或减去指定的时间量。
    - add()方法有两个参数，第一个参数是一个int类型的数据，表示日历字段；第二个参数是一个int类型的数据，表示要添加或减去的时间量。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 1);
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, 1);
            calendar.add(Calendar.HOUR, 1);
            calendar.add(Calendar.MINUTE, 1);
            calendar.add(Calendar.SECOND, 1);
            System.out.println(calendar);
        }
    }
    ```

5. Calendar类的getTime()方法

    - getTime()方法是Calendar类的一个方法，用来返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            System.out.println(date);
        }
    }
    ```

6. Calendar类的setTime()方法

    - setTime()方法是Calendar类的一个方法，用来用给定的 Date 设置此 Calendar 的时间。
    - setTime()方法的参数是一个Date对象，表示要设置的时间。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            System.out.println(calendar);
        }
    }
    ```

7. Calendar类的setTimeZone()方法

    - setTimeZone()方法是Calendar类的一个方法，用来设置此 Calendar 的时区。
    - setTimeZone()方法的参数是一个TimeZone对象，表示要设置的时区。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            System.out.println(calendar);
        }
    }
    ```

8. Calendar类的getTimeZone()方法

    - getTimeZone()方法是Calendar类的一个方法，用来获取此 Calendar 的时区。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            TimeZone timeZone = calendar.getTimeZone();
            System.out.println(timeZone);
        }
    }
    ```

9. Calendar类的setLenient()方法

    - setLenient()方法是Calendar类的一个方法，用来将此 Calendar 置于宽松模式。
    - setLenient()方法的参数是一个boolean类型的数据，表示是否设置为宽松。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            System.out.println(calendar);
        }
    }
    ```

10. Calendar类的isLenient()方法

    - isLenient()方法是Calendar类的一个方法，用来测试此 Calendar 是否为宽松模式。
    - 如果此 Calendar 为宽松模式，返回true；否则返回false。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar.isLenient());
        }
    }
    ```

11. Calendar类的setFirstDayOfWeek()方法

    - setFirstDayOfWeek()方法是Calendar类的一个方法，用来设置每周的第一天是星期几。
    - setFirstDayOfWeek()方法的参数是一个int类型的数据，表示星期几。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            System.out.println(calendar);
        }
    }
    ```

12. Calendar类的getFirstDayOfWeek()方法

    - getFirstDayOfWeek()方法是Calendar类的一个方法，用来获取每周的第一天是星期几。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            System.out.println(firstDayOfWeek);
        }
    }
    ```

13. Calendar类的setMinimalDaysInFirstWeek()方法

    - setMinimalDaysInFirstWeek()方法是Calendar类的一个方法，用来设置一年中的最小天数，以确定第一周的最小天数。
    - setMinimalDaysInFirstWeek()方法的参数是一个int类型的数据，表示最小天数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            calendar.setMinimalDaysInFirstWeek(1);
            System.out.println(calendar);
        }
    }
    ```

14. Calendar类的getMinimalDaysInFirstWeek()方法

    - getMinimalDaysInFirstWeek()方法是Calendar类的一个方法，用来获取一年中的最小天数，以确定第一周的最小天数。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            int minimalDaysInFirstWeek = calendar.getMinimalDaysInFirstWeek();
            System.out.println(minimalDaysInFirstWeek);
        }
    }
    ```

##### 3.8.3 小结

- Calendar类是Java中的一个类，用来操作日期。
- Calendar类中有一些常用的方法，如getInstance()、get()、set()、add()、getTime()、setTime()、setTimeZone()、getTimeZone()
  、setLenient()、isLenient()、setFirstDayOfWeek()、getFirstDayOfWeek()、setMinimalDaysInFirstWeek()
  、getMinimalDaysInFirstWeek()等。
- getInstance()方法是Calendar类的一个静态方法，用来返回一个默认语言环境的 Calendar 实例。
- get()方法是Calendar类的一个方法，用来返回给定日历字段的值。
- set()方法是Calendar类的一个方法，用来设置给定日历字段的值。
- add()方法是Calendar类的一个方法，用来根据日历的规则，为给定的日历字段添加或减去指定的时间量。
- getTime()方法是Calendar类的一个方法，用来返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
- setTime()方法是Calendar类的一个方法，用来用给定的 Date 设置此 Calendar 的时间。
- setTimeZone()方法是Calendar类的一个方法，用来设置此 Calendar 的时区。
- getTimeZone()方法是Calendar类的一个方法，用来获取此 Calendar 的时区。
- setLenient()方法是Calendar类的一个方法，用来将此 Calendar 置于宽松模式。
- isLenient()方法是Calendar类的一个方法，用来测试此 Calendar 是否为宽松模式。
- setFirstDayOfWeek()方法是Calendar类的一个方法，用来设置每周的第一天是星期几。
- getFirstDayOfWeek()方法是Calendar类的一个方法，用来获取每周的第一天是星期几。
- setMinimalDaysInFirstWeek()方法是Calendar类的一个方法，用来设置一年中的最小天数，以确定第一周的最小天数。
- getMinimalDaysInFirstWeek()方法是Calendar类的一个方法，用来获取一年中的最小天数，以确定第一周的最小天数。

#### 3.9 BigDecimal类

介绍:
BigDecimal类是Java中的一个类，用来进行高精度的数学计算。BigDecimal类提供了一系列方法，用来进行高精度的数学计算，如加法、减法、乘法、除法等。

##### 3.9.1 BigDecimal类的常用方法

| 方法签名                                                                    | 说明              |
|-------------------------------------------------------------------------|-----------------|
| public BigDecimal add(BigDecimal value)                                 | 加法。             |
| public BigDecimal subtract(BigDecimal value)                            | 减法。             |
| public BigDecimal multiply(BigDecimal value)                            | 乘法。             |
| public BigDecimal divide(BigDecimal value)                              | 除法。             |
| public BigDecimal divide(BigDecimal value, int scale, int roundingMode) | 除法，指定小数位数和舍入模式。 |
| public BigDecimal setScale(int newScale, int roundingMode)              | 设置小数位数和舍入模式。    |
| public BigDecimal abs()                                                 | 返回绝对值。          |
| public BigDecimal negate()                                              | 返回相反数。          |
| public int compareTo(BigDecimal value)                                  | 比较大小。           |
| public double doubleValue()                                             | 返回 double 类型的值。 |
| public float floatValue()                                               | 返回 float 类型的值。  |
| public int intValue()                                                   | 返回 int 类型的值。    |
| public long longValue()                                                 | 返回 long 类型的值。   |
| public String toString()                                                | 返回字符串表示形式。      |

##### 3.9.2 BigDecimal类的常用方法使用

1. BigDecimal类的add()方法

    - add()方法是BigDecimal类的一个方法，用来进行加法运算，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            BigDecimal bd3 = bd1.add(bd2);
            System.out.println(bd3);
        }
    }
    ```

2. BigDecimal类的subtract()方法

    - subtract()方法是BigDecimal类的一个方法，用来进行减法运算，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            BigDecimal bd4 = bd1.subtract(bd2);
            System.out.println(bd4);
        }
    }
    ```

3. BigDecimal类的multiply()方法

    - multiply()方法是BigDecimal类的一个方法，用来进行乘法运算，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            BigDecimal bd5 = bd1.multiply(bd2);
            System.out.println(bd5);
        }
    }
    ```

4. BigDecimal类的divide()方法

    - divide()方法是BigDecimal类的一个方法，用来进行除法运算，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            BigDecimal bd6 = bd1.divide(bd2);
            System.out.println(bd6);
        }
    }
    ```

5. BigDecimal类的divide()方法

    - divide()方法是BigDecimal类的一个方法，用来进行除法运算，并返回一个新的BigDecimal对象。
    - divide()方法有三个参数，第一个参数是一个BigDecimal对象，表示除数；第二个参数是一个int类型的数据，表示小数位数；第三个参数是一个RoundingMode枚举类型的数据，表示舍入模式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            BigDecimal bd7 = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
            System.out.println(bd7);
        }
    }
    ```

6. BigDecimal类的setScale()方法

    - setScale()方法是BigDecimal类的一个方法，用来设置小数位数和舍入模式，并返回一个新的BigDecimal对象。
    - setScale()方法有两个参数，第一个参数是一个int类型的数据，表示小数位数；第二个参数是一个RoundingMode枚举类型的数据，表示舍入模式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd8 = bd1.setScale(2, RoundingMode.HALF_UP);
            System.out.println(bd8);
        }
    }
    ```

7. BigDecimal类的abs()方法

    - abs()方法是BigDecimal类的一个方法，用来返回绝对值，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("-1.1");
            BigDecimal bd9 = bd1.abs();
            System.out.println(bd9);
        }
    }
    ```

8. BigDecimal类的negate()方法

    - negate()方法是BigDecimal类的一个方法，用来返回相反数，并返回一个新的BigDecimal对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd10 = bd1.negate();
            System.out.println(bd10);
        }
    }
    ```

9. BigDecimal类的compareTo()方法

    - compareTo()方法是BigDecimal类的一个方法，用来比较大小。
    - 如果当前BigDecimal对象小于value，返回-1；如果当前BigDecimal对象等于value，返回0；如果当前BigDecimal对象大于value，返回1。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            BigDecimal bd2 = new BigDecimal("2.2");
            int i = bd1.compareTo(bd2);
            System.out.println(i);
        }
    }
    ```

10. BigDecimal类的doubleValue()方法

    - doubleValue()方法是BigDecimal类的一个方法，用来返回double类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            double d = bd1.doubleValue();
            System.out.println(d);
        }
    }
    ```

11. BigDecimal类的floatValue()方法

    - floatValue()方法是BigDecimal类的一个方法，用来返回float类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            float f = bd1.floatValue();
            System.out.println(f);
        }
    }
    ```

12. BigDecimal类的intValue()方法

    - intValue()方法是BigDecimal类的一个方法，用来返回int类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            int i = bd1.intValue();
            System.out.println(i);
        }
    }
    ```

13. BigDecimal类的longValue()方法

    - longValue()方法是BigDecimal类的一个方法，用来返回long类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            long l = bd1.longValue();
            System.out.println(l);
        }
    }
    ```

14. BigDecimal类的toString()方法

    - toString()方法是BigDecimal类的一个方法，用来返回字符串表示形式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigDecimal bd1 = new BigDecimal("1.1");
            String s = bd1.toString();
            System.out.println(s);
        }
    }
    ```

##### 3.9.3 小结

- BigDecimal类是Java中的一个类，用来进行高精度的数学计算。
- BigDecimal类中有一些常用的方法，如add()、subtract()、multiply()、divide()、setScale()、abs()、negate()、compareTo()
  、doubleValue()、floatValue()、intValue()、longValue()、toString()等。
- add()方法是BigDecimal类的一个方法，用来进行加法运算，并返回一个新的BigDecimal对象。
- subtract()方法是BigDecimal类的一个方法，用来进行减法运算，并返回一个新的BigDecimal对象。
- multiply()方法是BigDecimal类的一个方法，用来进行乘法运算，并返回一个新的BigDecimal对象。
- divide()方法是BigDecimal类的一个方法，用来进行除法运算，并返回一个新的BigDecimal对象。
- setScale()方法是BigDecimal类的一个方法，用来设置小数位数和舍入模式，并返回一个新的BigDecimal对象。
- abs()方法是BigDecimal类的一个方法，用来返回绝对值，并返回一个新的BigDecimal对象。
- negate()方法是BigDecimal类的一个方法，用来返回相反数，并返回一个新的BigDecimal对象。
- compareTo()方法是BigDecimal类的一个方法，用来比较大小。
- doubleValue()方法是BigDecimal类的一个方法，用来返回double类型的值。
- floatValue()方法是BigDecimal类的一个方法，用来返回float类型的值。
- intValue()方法是BigDecimal类的一个方法，用来返回int类型的值。
- longValue()方法是BigDecimal类的一个方法，用来返回long类型的值。
- toString()方法是BigDecimal类的一个方法，用来返回字符串表示形式。

#### 3.10 BigInteger类

介绍:
BigInteger类是Java中的一个类，用来进行任意精度的整数运算。BigInteger类提供了一系列方法，用来进行任意精度的整数运算，如加法、减法、乘法、除法等。

##### 3.10.1 BigInteger类的常用方法

| 方法签名                                                         | 说明            |
|--------------------------------------------------------------|---------------|
| public BigInteger add(BigInteger value)                      | 加法。           |
| public BigInteger subtract(BigInteger value)                 | 减法。           |
| public BigInteger multiply(BigInteger value)                 | 乘法。           |
| public BigInteger divide(BigInteger value)                   | 除法。           |
| public BigInteger divide(BigInteger value, int roundingMode) | 除法，指定舍入模式。    |
| public BigInteger setScale(int newScale, int roundingMode)   | 设置舍入模式。       |
| public BigInteger abs()                                      | 返回绝对值。        |
| public BigInteger negate()                                   | 返回相反数。        |
| public int compareTo(BigInteger value)                       | 比较大小。         |
| public int intValue()                                        | 返回 int 类型的值。  |
| public long longValue()                                      | 返回 long 类型的值。 |
| public String toString()                                     | 返回字符串表示形式。    |

##### 3.10.2 BigInteger类的常用方法使用

1. BigInteger类的add()方法

    - add()方法是BigInteger类的一个方法，用来进行加法运算，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            BigInteger bi3 = bi1.add(bi2);
            System.out.println(bi3);
        }
    }
    ```

2. BigInteger类的subtract()方法

    - subtract()方法是BigInteger类的一个方法，用来进行减法运算，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            BigInteger bi4 = bi1.subtract(bi2);
            System.out.println(bi4);
        }
    }
    ```

3. BigInteger类的multiply()方法

    - multiply()方法是BigInteger类的一个方法，用来进行乘法运算，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            BigInteger bi5 = bi1.multiply(bi2);
            System.out.println(bi5);
        }
    }
    ```

4. BigInteger类的divide()方法

    - divide()方法是BigInteger类的一个方法，用来进行除法运算，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            BigInteger bi6 = bi1.divide(bi2);
            System.out.println(bi6);
        }
    }
    ```

5. BigInteger类的divide()方法

    - divide()方法是BigInteger类的一个方法，用来进行除法运算，并返回一个新的BigInteger对象。
    - divide()方法有两个参数，第一个参数是一个BigInteger对象，表示除数；第二个参数是一个int类型的数据，表示舍入模式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            BigInteger bi7 = bi1.divide(bi2, RoundingMode.HALF_UP);
            System.out.println(bi7);
        }
    }
    ```

6. BigInteger类的setScale()方法

    - setScale()方法是BigInteger类的一个方法，用来设置舍入模式，并返回一个新的BigInteger对象。
    - setScale()方法有两个参数，第一个参数是一个int类型的数据，表示舍入模式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi8 = bi1.setScale(RoundingMode.HALF_UP);
            System.out.println(bi8);
        }
    }
    ```

7. BigInteger类的abs()方法

    - abs()方法是BigInteger类的一个方法，用来返回绝对值，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("-1");
            BigInteger bi9 = bi1.abs();
            System.out.println(bi9);
        }
    }
    ```

8. BigInteger类的negate()方法

    - negate()方法是BigInteger类的一个方法，用来返回相反数，并返回一个新的BigInteger对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi10 = bi1.negate();
            System.out.println(bi10);
        }
    }
    ```

9. BigInteger类的compareTo()方法

    - compareTo()方法是BigInteger类的一个方法，用来比较大小。
    - 如果当前BigInteger对象小于value，返回-1；如果当前BigInteger对象等于value，返回0；如果当前BigInteger对象大于value，返回1。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            BigInteger bi2 = new BigInteger("2");
            int i = bi1.compareTo(bi2);
            System.out.println(i);
        }
    }
    ```

10. BigInteger类的intValue()方法

    - intValue()方法是BigInteger类的一个方法，用来返回int类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            int i = bi1.intValue();
            System.out.println(i);
        }
    }
    ```

11. BigInteger类的longValue()方法

    - longValue()方法是BigInteger类的一个方法，用来返回long类型的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            long l = bi1.longValue();
            System.out.println(l);
        }
    }
    ```

12. BigInteger类的toString()方法

    - toString()方法是BigInteger类的一个方法，用来返回字符串表示形式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            BigInteger bi1 = new BigInteger("1");
            String s = bi1.toString();
            System.out.println(s);
        }
    }
    ```

##### 3.10.3 小结

- BigInteger类是Java中的一个类，用来进行任意精度的整数运算。
- BigInteger类中有一些常用的方法，如add()、subtract()、multiply()、divide()、setScale()、abs()、negate()、compareTo()、intValue()
  、longValue()、toString()等。
- add()方法是BigInteger类的一个方法，用来进行加法运算，并返回一个新的BigInteger对象。
- subtract()方法是BigInteger类的一个方法，用来进行减法运算，并返回一个新的BigInteger对象。
- multiply()方法是BigInteger类的一个方法，用来进行乘法运算，并返回一个新的BigInteger对象。
- divide()方法是BigInteger类的一个方法，用来进行除法运算，并返回一个新的BigInteger对象。
- setScale()方法是BigInteger类的一个方法，用来设置舍入模式，并返回一个新的BigInteger对象。
- abs()方法是BigInteger类的一个方法，用来返回绝对值，并返回一个新的BigInteger对象。
- negate()方法是BigInteger类的一个方法，用来返回相反数，并返回一个新的BigInteger对象。
- compareTo()方法是BigInteger类的一个方法，用来比较大小。
- intValue()方法是BigInteger类的一个方法，用来返回int类型的值。
- longValue()方法是BigInteger类的一个方法，用来返回long类型的值。
- toString()方法是BigInteger类的一个方法，用来返回字符串表示形式。

#### 3.11 Arrays类

介绍:
Arrays类是Java中的一个类，用来操作数组。Arrays类提供了一系列方法，用来操作数组，如排序、查找、复制等。

##### 3.11.1 Arrays类的常用方法

| 方法签名                                                             | 说明                                                                                                 |
|------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| public static void sort(array)                                   | 对指定的数组按数字升序进行排序。 (数组类型可以是：int long short char byte double float Object)                            |
| public static void sort(array, int fromIndex, int toIndex)       | 对指定的数组的指定范围按数字升序进行排序 (数组类型可以是：int long short char byte double float Object)                        |
| public static int binarySearch(array, value)                     | 使用二分搜索算法搜索指定的数组，以获得指定的值。 (数组类型可以是：int long short char byte double float Object)                    |
| public static int binarySearch(array, fromIndex, toIndex, value) | 使用二分搜索算法搜索指定的数组的指定范围，以获得指定的值。 (数组类型可以是：int long short char byte double float Object)               |
| public static void fill(array, value)                            | 使用指定的值填充指定的数组。 (数组类型可以是：int long short char byte double float Object)                              |
| public static void fill(array, fromIndex, toIndex, value)        | 使用指定的值填充指定的数组的指定范围。 (数组类型可以是：int long short char byte double float Object)                         |
| public static void copyOf(array, newLength)                      | 复制指定的数组，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。 (数组类型可以是：int long short char byte double float Object)      |
| public static void copyOfRange(array, from, to)                  | 复制指定的数组的指定范围，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。 (数组类型可以是：int long short char byte double float Object) |
| public static boolean equals(array1, array2)                     | 如果两个指定的数组相等，则返回 true。 (数组类型可以是：int long short char byte double float Object)                       |
| public static String toString(array)                             | 返回指定数组的字符串表示形式。 (数组类型可以是：int long short char byte double float Object)                             |

##### 3.11.2 Arrays类的常用方法使用

1. Arrays类的sort()方法

    - sort()方法是Arrays类的一个方法，用来对指定的数组按数字升序进行排序。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {3, 1, 2};
            Arrays.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }
    ```

2. Arrays类的sort(array, fromIndex, toIndex)方法

    - sort(array, fromIndex, toIndex)方法是Arrays类的一个方法，用来对指定的数组的指定范围按数字升序进行排序。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {3, 1, 2};
            Arrays.sort(array, 0, 2);
            System.out.println(Arrays.toString(array));
        }
    }
    ```

3. Arrays类的binarySearch()方法

    - binarySearch()方法是Arrays类的一个方法，用来使用二分搜索算法搜索指定的数组，以获得指定的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            int index = Arrays.binarySearch(array, 2);
            System.out.println(index);
        }
    }
    ```

4. Arrays类的binarySearch(array, fromIndex, toIndex, value)方法

    - binarySearch(array, fromIndex, toIndex, value)方法是Arrays类的一个方法，用来使用二分搜索算法搜索指定的数组的指定范围，以获得指定的值。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            int index = Arrays.binarySearch(array, 0, 2, 2);
            System.out.println(index);
        }
    }
    ```

5. Arrays类的fill()方法

    - fill()方法是Arrays类的一个方法，用来使用指定的值填充指定的数组。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = new int[3];
            Arrays.fill(array, 1);
            System.out.println(Arrays.toString(array));
        }
    }
    ```

6. Arrays类的fill(array, fromIndex, toIndex, value)方法

    - fill(array, fromIndex, toIndex, value)方法是Arrays类的一个方法，用来使用指定的值填充指定的数组的指定范围。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = new int[3];
            Arrays.fill(array, 0, 2, 1);
            System.out.println(Arrays.toString(array));
        }
    }
    ```

7. Arrays类的copyOf()方法

    - copyOf()方法是Arrays类的一个方法，用来复制指定的数组，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            int[] newArray = Arrays.copyOf(array, 2);
            System.out.println(Arrays.toString(newArray));
        }
    }
    ```

8. Arrays类的copyOfRange()方法

    - copyOfRange()方法是Arrays类的一个方法，用来复制指定的数组的指定范围，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            int[] newArray = Arrays.copyOfRange(array, 0, 2);
            System.out.println(Arrays.toString(newArray));
        }
    }
    ```

9. Arrays类的equals()方法

    - equals()方法是Arrays类的一个方法，用来如果两个指定的数组相等，则返回 true。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array1 = {1, 2, 3};
            int[] array2 = {1, 2, 3};
            boolean b = Arrays.equals(array1, array2);
            System.out.println(b);
        }
    }
    ```

10. Arrays类的toString()方法

    - toString()方法是Arrays类的一个方法，用来返回指定数组的字符串表示形式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            int[] array = {1, 2, 3};
            String s = Arrays.toString(array);
            System.out.println(s);
        }
    }
    ```

##### 3.11.3 小结

- Arrays类是Java中的一个类，用来操作数组。
- Arrays类中有一些常用的方法，如sort()、binarySearch()、fill()、copyOf()、copyOfRange()、equals()、toString()等。
- sort()方法是Arrays类的一个方法，用来对指定的数组按数字升序进行排序。
- binarySearch()方法是Arrays类的一个方法，用来使用二分搜索算法搜索指定的数组，以获得指定的值。
- fill()方法是Arrays类的一个方法，用来使用指定的值填充指定的数组。
- copyOf()方法是Arrays类的一个方法，用来复制指定的数组，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。
- copyOfRange()方法是Arrays类的一个方法，用来复制指定的数组的指定范围，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。
- equals()方法是Arrays类的一个方法，用来如果两个指定的数组相等，则返回 true。
- toString()方法是Arrays类的一个方法，用来返回指定数组的字符串表示形式。
- sort(array, fromIndex, toIndex)方法是Arrays类的一个方法，用来对指定的数组的指定范围按数字升序进行排序。
- binarySearch(array, fromIndex, toIndex, value)方法是Arrays类的一个方法，用来使用二分搜索算法搜索指定的数组的指定范围，以获得指定的值。
- fill(array, fromIndex, toIndex, value)方法是Arrays类的一个方法，用来使用指定的值填充指定的数组的指定范围。
- copyOf(array, newLength)方法是Arrays类的一个方法，用来复制指定的数组，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。
- copyOfRange(array, from, to)方法是Arrays类的一个方法，用来复制指定的数组的指定范围，截取或用零填充（如有必要）的新数组，以使副本具有指定的长度。
- equals(array1, array2)方法是Arrays类的一个方法，用来如果两个指定的数组相等，则返回 true。
- toString(array)方法是Arrays类的一个方法，用来返回指定数组的字符串表示形式。
- Arrays类中的数组类型可以是：int long short char byte double float Object。

#### 3.12 包装类

介绍:
包装类是Java中的一个类，用来将基本数据类型转换为对象。包装类提供了一系列方法，用来将基本数据类型转换为对象，如int转换为Integer、long转换为Long、short转换为Short、char转换为Character、byte转换为Byte、double转换为Double、float转换为Float、boolean转换为Boolean。

##### 3.12.1 包装类的常用方法

| 方法签名                                         | 说明                      |
|----------------------------------------------|-------------------------|
| public static int parseInt(String s)         | 将字符串转换为int类型。           |
| public static long parseLong(String s)       | 将字符串转换为long类型。          |
| public static short parseShort(String s)     | 将字符串转换为short类型。         |
| public static char parseChar(String s)       | 将字符串转换为char类型。          |
| public static byte parseByte(String s)       | 将字符串转换为byte类型。          |
| public static double parseDouble(String s)   | 将字符串转换为double类型。        |
| public static float parseFloat(String s)     | 将字符串转换为float类型。         |
| public static boolean parseBoolean(String s) | 将字符串转换为boolean类型。       |
| public static Integer valueOf(int i)         | 将int类型转换为Integer类型。     |
| public static Long valueOf(long l)           | 将long类型转换为Long类型。       |
| public static Short valueOf(short s)         | 将short类型转换为Short类型。     |
| public static Character valueOf(char c)      | 将char类型转换为Character类型。  |
| public static Byte valueOf(byte b)           | 将byte类型转换为Byte类型。       |
| public static Double valueOf(double d)       | 将double类型转换为Double类型。   |
| public static Float valueOf(float f)         | 将float类型转换为Float类型。     |
| public static Boolean valueOf(boolean b)     | 将boolean类型转换为Boolean类型。 |
| public static String toString(int i)         | 将int类型转换为String类型。      |
| public static String toString(long l)        | 将long类型转换为String类型。     |
| public static String toString(short s)       | 将short类型转换为String类型。    |
| public static String toString(char c)        | 将char类型转换为String类型。     |
| public static String toString(byte b)        | 将byte类型转换为String类型。     |
| public static String toString(double d)      | 将double类型转换为String类型。   |
| public static String toString(float f)       | 将float类型转换为String类型。    |
| public static String toString(boolean b)     | 将boolean类型转换为String类型。  |
| public int intValue()                        | 将Integer类型转换为int类型。     |
| public long longValue()                      | 将Long类型转换为long类型。       |
| public short shortValue()                    | 将Short类型转换为short类型。     |
| public char charValue()                      | 将Character类型转换为char类型。  |
| public byte byteValue()                      | 将Byte类型转换为byte类型。       |
| public double doubleValue()                  | 将Double类型转换为double类型。   |
| public float floatValue()                    | 将Float类型转换为float类型。     |
| public boolean booleanValue()                | 将Boolean类型转换为boolean类型。 |

##### 3.12.2 包装类的常用方法使用

1. 包装类的parseInt()方法
   
    - parseInt()方法是包装类的一个方法，用来将字符串转换为int类型。
    
    ```java
    public class Demo {
        public static void main(String[] args) {
            int i = Integer.parseInt("1");
            System.out.println(i);
        }
    }
    ```

2. 包装类的parseLong()方法

    - parseLong()方法是包装类的一个方法，用来将字符串转换为long类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            long l = Long.parseLong("1");
            System.out.println(l);
        }
    }
    ```

3. 包装类的parseShort()方法

    - parseShort()方法是包装类的一个方法，用来将字符串转换为short类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            short s = Short.parseShort("1");
            System.out.println(s);
        }
    }
    ```

4. 包装类的parseChar()方法

    - parseChar()方法是包装类的一个方法，用来将字符串转换为char类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            char c = Character.parseChar("a");
            System.out.println(c);
        }
    }
    ```

5. 包装类的parseByte()方法

    - parseByte()方法是包装类的一个方法，用来将字符串转换为byte类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            byte b = Byte.parseByte("1");
            System.out.println(b);
        }
    }
    ```

6. 包装类的parseDouble()方法

    - parseDouble()方法是包装类的一个方法，用来将字符串转换为double类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            double d = Double.parseDouble("1.1");
            System.out.println(d);
        }
    }
    ```

7. 包装类的parseFloat()方法

    - parseFloat()方法是包装类的一个方法，用来将字符串转换为float类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            float f = Float.parseFloat("1.1");
            System.out.println(f);
        }
    }
    ```

8. 包装类的parseBoolean()方法

    - parseBoolean()方法是包装类的一个方法，用来将字符串转换为boolean类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            boolean b = Boolean.parseBoolean("true");
            System.out.println(b);
        }
    }
    ```

9. 包装类的valueOf()方法

    - valueOf()方法是包装类的一个方法，用来将基本数据类型转换为对象。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Integer i = Integer.valueOf(1);
            System.out.println(i);
        }
    }
    ```

10. 包装类的toString()方法

    - toString()方法是包装类的一个方法，用来将基本数据类型转换为字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = Integer.toString(1);
            System.out.println(s);
        }
    }
    ```

11. 包装类的intValue()方法

    - intValue()方法是包装类的一个方法，用来将Integer类型转换为int类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Integer i = 1;
            int j = i.intValue();
            System.out.println(j);
        }
    }
    ```

12. 包装类的longValue()方法

    - longValue()方法是包装类的一个方法，用来将Long类型转换为long类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Long l = 1L;
            long m = l.longValue();
            System.out.println(m);
        }
    }
    ```

13. 包装类的shortValue()方法

    - shortValue()方法是包装类的一个方法，用来将Short类型转换为short类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Short s = 1;
            short t = s.shortValue();
            System.out.println(t);
        }
    }
    ```

14. 包装类的charValue()方法

    - charValue()方法是包装类的一个方法，用来将Character类型转换为char类型。

    ```java

    public class Demo {
        public static void main(String[] args) {
            Character c = 'a';
            char d = c.charValue();
            System.out.println(d);
        }
    }
    ```

15. 包装类的byteValue()方法

    - byteValue()方法是包装类的一个方法，用来将Byte类型转换为byte类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Byte b = 1;
            byte c = b.byteValue();
            System.out.println(c);
        }
    }
    ```

16. 包装类的doubleValue()方法

    - doubleValue()方法是包装类的一个方法，用来将Double类型转换为double类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Double d = 1.1;
            double e = d.doubleValue();
            System.out.println(e);
        }
    }
    ```

17. 包装类的floatValue()方法

    - floatValue()方法是包装类的一个方法，用来将Float类型转换为float类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Float f = 1.1f;
            float g = f.floatValue();
            System.out.println(g);
        }
    }
    ```

18. 包装类的booleanValue()方法

    - booleanValue()方法是包装类的一个方法，用来将Boolean类型转换为boolean类型。

    ```java
    public class Demo {
        public static void main(String[] args) {
            Boolean b = true;
            boolean c = b.booleanValue();
            System.out.println(c);
        }
    }
    ```

##### 3.12.3 包装类的作用

- Java中的基本数据类型是不能直接参与面向对象的操作的，因此需要将基本数据类型转换为对象。
- Java中的基本数据类型没有方法和属性，而包装类就是为了让基本数据类型具有方法和属性，实现对象化交互。
- 字符串和基本数据类型做转换

##### 3.12.4 自动装箱和拆箱

- 自动装箱：将基本数据类型转换为包装类。
- 自动拆箱：将包装类转换为基本数据类型。

```java
public class Demo {
    public static void main(String[] args) {
        Integer i = 1; // 自动装箱
        int j = i; // 自动拆箱
        System.out.println(j);
    }
}
```

##### 3.12.5 小结

- 包装类是Java中的一个类，用来将基本数据类型转换为对象。
- 包装类中有一些常用的方法，如parseInt()、parseLong()、parseShort()、parseChar()、parseByte()、parseDouble()、parseFloat()
  、parseBoolean()
  、valueOf()、toString()、intValue()、longValue()、shortValue()、charValue()、byteValue()、doubleValue()、floatValue()
  、booleanValue()等。
- parseInt()方法是包装类的一个方法，用来将字符串转换为int类型。
- parseLong()方法是包装类的一个方法，用来将字符串转换为long类型。
- parseShort()方法是包装类的一个方法，用来将字符串转换为short类型。
- parseChar()方法是包装类的一个方法，用来将字符串转换为char类型。
- parseByte()方法是包装类的一个方法，用来将字符串转换为byte类型。
- parseDouble()方法是包装类的一个方法，用来将字符串转换为double类型。
- parseFloat()方法是包装类的一个方法，用来将字符串转换为float类型。
- parseBoolean()方法是包装类的一个方法，用来将字符串转换为boolean类型。
- valueOf()方法是包装类的一个方法，用来将基本数据类型转换为对象。
- toString()方法是包装类的一个方法，用来将基本数据类型转换为字符串。
- intValue()方法是包装类的一个方法，用来将Integer类型转换为int类型。
- longValue()方法是包装类的一个方法，用来将Long类型转换为long类型。
- shortValue()方法是包装类的一个方法，用来将Short类型转换为short类型。
- charValue()方法是包装类的一个方法，用来将Character类型转换为char类型。
- byteValue()方法是包装类的一个方法，用来将Byte类型转换为byte类型。
- doubleValue()方法是包装类的一个方法，用来将Double类型转换为double类型。
- floatValue()方法是包装类的一个方法，用来将Float类型转换为float类型。
- booleanValue()方法是包装类的一个方法，用来将Boolean类型转换为boolean类型。
- 包装类中的基本数据类型有：int long short char byte double float boolean。
- 包装类中的对象类型有：Integer Long Short Character Byte Double Float Boolean。
- 包装类中的基本数据类型和对象类型之间可以相互转换。

#### 3.13 String类

介绍:
String类是Java中的一个类，用来操作字符串。String类提供了一系列方法，用来操作字符串，如拼接、查找、替换、分割等。

##### 3.13.1 String类的常用方法

| 方法签名                                                                        | 说明                                                    |
|-----------------------------------------------------------------------------|-------------------------------------------------------|
| public int length()                                                         | 返回字符串的长度。                                             |
| public char charAt(int index)                                               | 返回指定索引处的字符。                                           |
| public int indexOf(String str)                                              | 返回指定子字符串第一次出现在该字符串中的索引。                               |
| public int indexOf(String str, int fromIndex)                               | 返回指定子字符串第一次出现在该字符串中的索引，从指定的索引开始。                      |
| public int lastIndexOf(String str)                                          | 返回指定子字符串最后一次出现在该字符串中的索引。                              |
| public int lastIndexOf(String str, int fromIndex)                           | 返回指定子字符串最后一次出现在该字符串中的索引，从指定的索引开始。                     |
| public String substring(int beginIndex)                                     | 返回一个新的字符串，它是此字符串的一个子字符串。                              |
| public String substring(int beginIndex, int endIndex)                       | 返回一个新的字符串，它是此字符串的一个子字符串。                              |
| public String replace(char oldChar, char newChar)                           | 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。     |
| public boolean startsWith(String prefix)                                    | 测试此字符串是否以指定的前缀开始。                                     |
| public boolean endsWith(String suffix)                                      | 测试此字符串是否以指定的后缀结束。                                     |
| public boolean isEmpty()                                                    | 当且仅当 length() 为 0 时返回 true。                           |
| public String toLowerCase()                                                 | 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。                    |
| public String toUpperCase()                                                 | 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。                    |
| public String trim()                                                        | 返回字符串的副本，忽略前导空白和尾部空白。                                 |
| public char[] toCharArray()                                                 | 将此字符串转换为一个新的字符数组。                                     |
| public static String valueOf(char[] data)                                   | 返回 char 数组参数的字符串表示形式。                                 |
| public static String valueOf(int i)                                         | 返回 int 参数的字符串表示形式。                                    |
| public static String valueOf(long l)                                        | 返回 long 参数的字符串表示形式。                                   |
| public static String valueOf(float f)                                       | 返回 float 参数的字符串表示形式。                                  |
| public static String valueOf(double d)                                      | 返回 double 参数的字符串表示形式。                                 |
| public static String valueOf(boolean b)                                     | 返回 boolean 参数的字符串表示形式。                                |
| public String[] split(String regex)                                         | 根据给定正则表达式的匹配拆分此字符串。                                   |
| public String concat(String str)                                            | 将指定字符串连接到此字符串的结尾。                                     |
| public boolean contains(CharSequence s)                                     | 当且仅当此字符串包含指定的 char 值序列时，返回 true。                      |
| public boolean equals(Object anObject)                                      | 将此字符串与指定的对象比较。                                        |
| public boolean equalsIgnoreCase(String anotherString)                       | 将此 String 与另一个 String 比较，不考虑大小写。                      |
| public String format(String format, Object... args)                         | 使用指定的格式字符串和参数返回一个格式化字符串。                              |
| public byte[] getBytes()                                                    | 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。 |
| public int hashCode()                                                       | 返回此字符串的哈希码。                                           |
| public boolean matches(String regex)                                        | 告知此字符串是否匹配给定的正则表达式。                                   |
| public String replaceAll(String regex, String replacement)                  | 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。            |
| public String replaceFirst(String regex, String replacement)                | 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。           |
| public String[] split(String regex, int limit)                              | 根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个子字符串。                |
| public CharSequence subSequence(int beginIndex, int endIndex)               | 返回一个新的字符序列，它是此序列的一个子序列。                               |
| public String toString()                                                    | 返回此对象本身（它已经是一个字符串！）。                                  |
| public static String join(CharSequence delimiter, CharSequence... elements) | 使用指定的定界符和元素数组返回一个字符串。                                 |

##### 3.13.2 String类的常用方法使用

1. String类的length()方法

    - length()方法是String类的一个方法，用来返回字符串的长度。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.length();
            System.out.println(i);
        }
    }
    ```

2. String类的charAt()方法

    - charAt()方法是String类的一个方法，用来返回指定索引处的字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            char c = s.charAt(0);
            System.out.println(c);
        }
    }
    ```

3. String类的indexOf()方法

    - indexOf()方法是String类的一个方法，用来返回指定子字符串第一次出现在该字符串中的索引。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.indexOf("e");
            System.out.println(i);
        }
    }
    ```

4. String类的indexOf(String str, int fromIndex)方法

    - indexOf(String str, int fromIndex)方法是String类的一个方法，用来返回指定子字符串第一次出现在该字符串中的索引，从指定的索引开始。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.indexOf("e", 1);
            System.out.println(i);
        }
    }
    ```

5. String类的lastIndexOf()方法

    - lastIndexOf()方法是String类的一个方法，用来返回指定子字符串最后一次出现在该字符串中的索引。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.lastIndexOf("l");
            System.out.println(i);
        }
    }
    ```

6. String类的lastIndexOf(String str, int fromIndex)方法

    - lastIndexOf(String str, int fromIndex)方法是String类的一个方法，用来返回指定子字符串最后一次出现在该字符串中的索引，从指定的索引开始。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.lastIndexOf("l", 2);
            System.out.println(i);
        }
    }
    ```

7. String类的substring()方法

    - substring()方法是String类的一个方法，用来返回一个新的字符串，它是此字符串的一个子字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.substring(1);
            System.out.println(t);
        }
    }
    ```

8. String类的substring(int beginIndex, int endIndex)方法

    - substring(int beginIndex, int endIndex)方法是String类的一个方法，用来返回一个新的字符串，它是此字符串的一个子字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.substring(1, 3);
            System.out.println(t);
        }
    }
    ```

9. String类的replace()方法

    - replace()方法是String类的一个方法，用来返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.replace("l", "w");
            System.out.println(t);
        }
    }
    ```

10. String类的startsWith()方法

    - startsWith()方法是String类的一个方法，用来测试此字符串是否以指定的前缀开始。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.startsWith("h");
            System.out.println(b);
        }
    }
    ```

11. String类的endsWith()方法

    - endsWith()方法是String类的一个方法，用来测试此字符串是否以指定的后缀结束。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.endsWith("o");
            System.out.println(b);
        }
    }
    ```

12. String类的isEmpty()方法

    - isEmpty()方法是String类的一个方法，用来当且仅当 length() 为 0 时返回 true。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "";
            boolean b = s.isEmpty();
            System.out.println(b);
        }
    }
    ```

13. String类的toLowerCase()方法

    - toLowerCase()方法是String类的一个方法，用来使用默认语言环境的规则将此 String 中的所有字符都转换为小写。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "HELLO";
            String t = s.toLowerCase();
            System.out.println(t);
        }
    }
    ```

14. String类的toUpperCase()方法

    - toUpperCase()方法是String类的一个方法，用来使用默认语言环境的规则将此 String 中的所有字符都转换为大写。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.toUpperCase();
            System.out.println(t);
        }
    }
    ```

15. String类的trim()方法

    - trim()方法是String类的一个方法，用来返回字符串的副本，忽略前导空白和尾部空白。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = " hello ";
            String t = s.trim();
            System.out.println(t);
        }
    }
    ```

16. String类的toCharArray()方法

    - toCharArray()方法是String类的一个方法，用来将此字符串转换为一个新的字符数组。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            char[] c = s.toCharArray();
            System.out.println(Arrays.toString(c));
        }
    }
    ```

17. String类的valueOf()方法

    - valueOf()方法是String类的一个方法，用来返回 char 数组参数的字符串表示形式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            char[] c = {'h', 'e', 'l', 'l', 'o'};
            String s = String.valueOf(c);
            System.out.println(s);
        }
    }
    ```

18. String类的split()方法

    - split()方法是String类的一个方法，用来根据给定正则表达式的匹配拆分此字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello world";
            String[] array = s.split(" ");
            System.out.println(Arrays.toString(array));
        }
    }
    ```

19. String类的concat()方法

    - concat()方法是String类的一个方法，用来将指定字符串连接到此字符串的结尾。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.concat(" world");
            System.out.println(t);
        }
    }
    ```

20. String类的contains()方法

    - contains()方法是String类的一个方法，用来当且仅当此字符串包含指定的 char 值序列时，返回 true。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.contains("e");
            System.out.println(b);
        }
    }
    ```

21. String类的equals()方法

    - equals()方法是String类的一个方法，用来将此字符串与指定的对象比较。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.equals("hello");
            System.out.println(b);
        }
    }
    ```

22. String类的equalsIgnoreCase()方法

    - equalsIgnoreCase()方法是String类的一个方法，用来将此 String 与另一个 String 比较，不考虑大小写。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.equalsIgnoreCase("HELLO");
            System.out.println(b);
        }
    }
    ```

23. String类的format()方法

    - format()方法是String类的一个方法，用来使用指定的格式字符串和参数返回一个格式化字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = String.format("hello %s", "world");
            System.out.println(s);
        }
    }
    ```

24. String类的getBytes()方法

    - getBytes()方法是String类的一个方法，用来使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte
      数组中。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            byte[] b = s.getBytes();
            System.out.println(Arrays.toString(b));
        }
    }
    ```

25. String类的hashCode()方法

    - hashCode()方法是String类的一个方法，用来返回此字符串的哈希码。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            int i = s.hashCode();
            System.out.println(i);
        }
    }
    ```

26. String类的matches()方法

    - matches()方法是String类的一个方法，用来告知此字符串是否匹配给定的正则表达式。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches("h.*");
            System.out.println(b);
        }
    }
    ```

27. String类的replaceAll()方法

    - replaceAll()方法是String类的一个方法，用来使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.replaceAll("l", "w");
            System.out.println(t);
        }
    }
    ```

28. String类的replaceFirst()方法

    - replaceFirst()方法是String类的一个方法，用来使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.replaceFirst("l", "w");
            System.out.println(t);
        }
    }
    ```

29. String类的split(regex, limit)方法

    - split(regex, limit)方法是String类的一个方法，用来根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个子字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello world";
            String[] array = s.split(" ", 1);
            System.out.println(Arrays.toString(array));
        }
    }
    ```

30. String类的subSequence()方法

    - subSequence()方法是String类的一个方法，用来返回一个新的字符序列，它是此序列的一个子序列。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            CharSequence c = s.subSequence(1, 3);
            System.out.println(c);
        }
    }
    ```

31. String类的toString()方法

    - toString()方法是String类的一个方法，用来返回此对象本身（它已经是一个字符串！）。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            String t = s.toString();
            System.out.println(t);
        }
    }
    ```

32. String类的join()方法

    - join()方法是String类的一个方法，用来使用指定的定界符和元素数组返回一个字符串。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = String.join(",", "hello", "world");
            System.out.println(s);
        }
    }
    ```

## Day04

### 一、正则表达式

#### 1.1 正则表达式的概念

介绍:
正则表达式是一种用来匹配字符串的表达式。正则表达式是一种通用的字符串表达模式，用来检索、替换、匹配、分割字符串。

#### 1.2 正则表达式的语法

介绍:
正则表达式是一种通用的字符串表达模式，用来检索、替换、匹配、分割字符串。正则表达式的语法是一种特殊的语法，用来描述字符串的模式。

##### 1.2.1 正则表达式的语法规则

| 规则                      | 说明                                     |
|-------------------------|----------------------------------------|
| .                       | 匹配任意字符。                                |
| \d                      | 匹配数字。                                  |
| \D                      | 匹配非数字。                                 |
| \s                      | 匹配空白字符。                                |
| \S                      | 匹配非空白字符。                               |
| \w                      | 匹配单词字符。                                |
| \W                      | 匹配非单词字符。                               |
| [abc]                   | 匹配 a、b 或 c。                            |
| [^abc]                  | 匹配除了 a、b 和 c 之外的任意字符。                  |
| [a-z]                   | 匹配 a 到 z 之间的任意字符。                      |
| [^a-z]                  | 匹配除了 a 到 z 之间的任意字符。                    |
| [0-9]                   | 匹配 0 到 9 之间的任意字符。                      |
| [^0-9]                  | 匹配除了 0 到 9 之间的任意字符。                    |
| [a-z&&[def]]            | 匹配 d、e 或 f。                            |
| [a-z&&[^bc]]            | 匹配除了 b 和 c 之外的 a 到 z 之间的任意字符。          |
| [a-z&&[^m-p]]           | 匹配除了 m 到 p 之外的 a 到 z 之间的任意字符。          |
| a*                      | 匹配零个或多个 a。                             |
| a+                      | 匹配一个或多个 a。                             |
| a?                      | 匹配零个或一个 a。                             |
| a{n}                    | 匹配 n 个 a。                              |
| a{n,}                   | 匹配至少 n 个 a。                            |
| a{n,m}                  | 匹配 n 到 m 个 a。                          |
| a\|b                    | 匹配 a 或 b。                              |
| ^                       | 匹配字符串的开始。                              |
| $                       | 匹配字符串的结束。                              |
| \b                      | 匹配单词边界。                                |
| \B                      | 匹配非单词边界。                               |
| \d{3}                   | 匹配三个数字。                                |
| \d{3,}                  | 匹配至少三个数字。                              |
| \d{3,5}                 | 匹配三到五个数字。                              |
| \d{3,5}?                | 匹配三到五个数字，次数最少。                         |
| \d+                     | 匹配一个或多个数字。                             |
| \d*                     | 匹配零个或多个数字。                             |
| \d?                     | 匹配零个或一个数字。                             |
| \d{3}\s+\d{3}           | 匹配三个数字，至少一个空白字符，然后是三个数字。               |
| \d{3}-\d{3}-\d{4}       | 匹配三个数字，一个短横线，三个数字，一个短横线，四个数字。          |
| \(\d{3}\)\s+\d{3}-\d{4} | 匹配三个数字，括号，三个数字，一个空白字符，三个数字，一个短横线，四个数字。 |
| \d{3}\s*\d{3}\s*\d{4}   | 匹配三个数字，零个或多个空白字符，三个数字，零个或多个空白字符，四个数字。  |
| \d{3}-\d{2}-\d{4}       | 匹配三个数字，一个短横线，两个数字，一个短横线，四个数字。          |

##### 1.2.2 正则表达式的语法规则使用

1. 正则表达式的.规则

    - .规则是正则表达式的一个规则，用来匹配任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches("h.llo");
            System.out.println(b);
        }
    }
    ```

2. 正则表达式的\d规则

    - \d规则是正则表达式的一个规则，用来匹配数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d\\d\\d");
            System.out.println(b);
        }
    }
    ```

3. 正则表达式的\D规则

    - \D规则是正则表达式的一个规则，用来匹配非数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "abc";
            boolean b = s.matches("\\D\\D\\D");
            System.out.println(b);
        }
    }
    ```

4. 正则表达式的\s规则

    - \s规则是正则表达式的一个规则，用来匹配空白字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a b c";
            boolean b = s.matches("\\s\\s\\s");
            System.out.println(b);
        }
    }
    ```

5. 正则表达式的\S规则

    - \S规则是正则表达式的一个规则，用来匹配非空白字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "abc";
            boolean b = s.matches("\\S\\S\\S");
            System.out.println(b);
        }
    }
    ```

6. 正则表达式的\w规则

    - \w规则是正则表达式的一个规则，用来匹配单词字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "abc";
            boolean b = s.matches("\\w\\w\\w");
            System.out.println(b);
        }
    }
    ```

7. 正则表达式的\W规则

    - \W规则是正则表达式的一个规则，用来匹配非单词字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a b c";
            boolean b = s.matches("\\W\\W\\W");
            System.out.println(b);
        }
    }
    ```

8. 正则表达式的[abc]规则

    - [abc]规则是正则表达式的一个规则，用来匹配 a、b 或 c。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("[abc]");
            System.out.println(b);
        }
    }
    ```

9. 正则表达式的[^abc]规则

    - [^abc]规则是正则表达式的一个规则，用来匹配除了 a、b 和 c 之外的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "d";
            boolean b = s.matches("[^abc]");
            System.out.println(b);
        }
    }
    ```

10. 正则表达式的[a-z]规则

    - [a-z]规则是正则表达式的一个规则，用来匹配 a 到 z 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("[a-z]");
            System.out.println(b);
        }
    }
    ```

11. 正则表达式的[^a-z]规则

    - [^a-z]规则是正则表达式的一个规则，用来匹配除了 a 到 z 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "A";
            boolean b = s.matches("[^a-z]");
            System.out.println(b);
        }
    }
    ```

12. 正则表达式的[0-9]规则

    - [0-9]规则是正则表达式的一个规则，用来匹配 0 到 9 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "1";
            boolean b = s.matches("[0-9]");
            System.out.println(b);
        }
    }
    ```

13. 正则表达式的[^0-9]规则

    - [^0-9]规则是正则表达式的一个规则，用来匹配除了 0 到 9 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("[^0-9]");
            System.out.println(b);
        }
    }
    ```

14. 正则表达式的[a-z&&[def]]规则

    - [a-z&&[def]]规则是正则表达式的一个规则，用来匹配 d、e 或 f。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "d";
            boolean b = s.matches("[a-z&&[def]]");
            System.out.println(b);
        }
    }
    ```

15. 正则表达式的[a-z&&[^bc]]规则

    - [a-z&&[^bc]]规则是正则表达式的一个规则，用来匹配除了 b 和 c 之外的 a 到 z 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("[a-z&&[^bc]]");
            System.out.println(b);
        }
    }
    ```

16. 正则表达式的[a-z&&[^m-p]]规则

    - [a-z&&[^m-p]]规则是正则表达式的一个规则，用来匹配除了 m 到 p 之外的 a 到 z 之间的任意字符。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("[a-z&&[^m-p]]");
            System.out.println(b);
        }
    }
    ```

17. 正则表达式的a*规则

    - a*规则是正则表达式的一个规则，用来匹配零个或多个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "aaa";
            boolean b = s.matches("a*");
            System.out.println(b);
        }
    }
    ```

18. 正则表达式的a+规则

    - a+规则是正则表达式的一个规则，用来匹配一个或多个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "aaa";
            boolean b = s.matches("a+");
            System.out.println(b);
        }
    }
    ```

19. 正则表达式的a?规则

    - a?规则是正则表达式的一个规则，用来匹配零个或一个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("a?");
            System.out.println(b);
        }
    }
    ```

20. 正则表达式的a{n}规则

    - a{n}规则是正则表达式的一个规则，用来匹配 n 个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "aaa";
            boolean b = s.matches("a{3}");
            System.out.println(b);
        }
    }
    ```

21. 正则表达式的a{n,}规则

    - a{n,}规则是正则表达式的一个规则，用来匹配至少 n 个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "aaa";
            boolean b = s.matches("a{3,}");
            System.out.println(b);
        }
    }
    ```

22. 正则表达式的a{n,m}规则

    - a{n,m}规则是正则表达式的一个规则，用来匹配 n 到 m 个 a。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "aaa";
            boolean b = s.matches("a{3,5}");
            System.out.println(b);
        }
    }
    ```

23. 正则表达式的a|b规则

    - a|b规则是正则表达式的一个规则，用来匹配 a 或 b。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "a";
            boolean b = s.matches("a|b");
            System.out.println(b);
        }
    }
    ```

24. 正则表达式的^规则

    - ^规则是正则表达式的一个规则，用来匹配字符串的开始。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches("^h.*");
            System.out.println(b);
        }
    }
    ```

25. 正则表达式的$规则

    - $规则是正则表达式的一个规则，用来匹配字符串的结束。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches(".*o$");
            System.out.println(b);
        }
    }
    ```

26. 正则表达式的\b规则

    - \b规则是正则表达式的一个规则，用来匹配单词边界。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches("\\bhello\\b");
            System.out.println(b);
        }
    }
    ```

27. 正则表达式的\B规则

    - \B规则是正则表达式的一个规则，用来匹配非单词边界。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "hello";
            boolean b = s.matches("\\Bhello\\B");
            System.out.println(b);
        }
    }
    ```

28. 正则表达式的\d{3}规则

    - \d{3}规则是正则表达式的一个规则，用来匹配三个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d{3}");
            System.out.println(b);
        }
    }
    ```

29. 正则表达式的\d{3,}规则

    - \d{3,}规则是正则表达式的一个规则，用来匹配至少三个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d{3,}");
            System.out.println(b);
        }
    }
    ```

30. 正则表达式的\d{3,5}规则

    - \d{3,5}规则是正则表达式的一个规则，用来匹配三到五个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "1234";
            boolean b = s.matches("\\d{3,5}");
            System.out.println(b);
        }
    }
    ```

31. 正则表达式的\d{3,5}?规则

    - \d{3,5}?规则是正则表达式的一个规则，用来匹配三到五个数字，次数最少。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "1234";
            boolean b = s.matches("\\d{3,5}?");
            System.out.println(b);
        }
    }
    ```

32. 正则表达式的\d+规则

    - \d+规则是正则表达式的一个规则，用来匹配一个或多个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d+");
            System.out.println(b);
        }
    }
    ```

33. 正则表达式的\d*规则

    - \d*规则是正则表达式的一个规则，用来匹配零个或多个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d*");
            System.out.println(b);
        }
    }
    ```

34. 正则表达式的\d?规则

    - \d?规则是正则表达式的一个规则，用来匹配零个或一个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123";
            boolean b = s.matches("\\d?");
            System.out.println(b);
        }
    }
    ```

35. 正则表达式的\d{3}\s+\d{3}规则

    - \d{3}\s+\d{3}规则是正则表达式的一个规则，用来匹配三个数字，至少一个空白字符，然后是三个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123 456";
            boolean b = s.matches("\\d{3}\\s+\\d{3}");
            System.out.println(b);
        }
    }
    ```

36. 正则表达式的\d{3}-\d{3}-\d{4}规则

    - \d{3}-\d{3}-\d{4}规则是正则表达式的一个规则，用来匹配三个数字，一个短横线，三个数字，一个短横线，四个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123-456-7890";
            boolean b = s.matches("\\d{3}-\\d{3}-\\d{4}");
            System.out.println(b);
        }
    }
    ```

37. 正则表达式的\(\d{3}\)\s+\d{3}-\d{4}规则

    - \(\d{3}\)\s+\d{3}-\d{4}规则是正则表达式的一个规则，用来匹配三个数字，括号，三个数字，一个空白字符，三个数字，一个短横线，四个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "(123) 456-7890";
            boolean b = s.matches("\\(\\d{3}\\)\\s+\\d{3}-\\d{4}");
            System.out.println(b);
        }
    }
    ```

38. 正则表达式的\d{3}\s*\d{3}\s*\d{4}规则

    - \d{3}\s*\d{3}\s*\d{4}规则是正则表达式的一个规则，用来匹配三个数字，零个或多个空白字符，三个数字，零个或多个空白字符，四个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123 456 7890";
            boolean b = s.matches("\\d{3}\\s*\\d{3}\\s*\\d{4}");
            System.out.println(b);
        }
    }
    ```

39. 正则表达式的\d{3}-\d{2}-\d{4}规则

    - \d{3}-\d{2}-\d{4}规则是正则表达式的一个规则，用来匹配三个数字，一个短横线，两个数字，一个短横线，四个数字。

    ```java
    public class Demo {
        public static void main(String[] args) {
            String s = "123-45-6789";
            boolean b = s.matches("\\d{3}-\\d{2}-\\d{4}");
            System.out.println(b);
        }
    }
    ```

### 二、Collection集合

#### 2.1 Collection集合的概念

1. 集合概述

介绍:
Collection是Java集合框架中的一个接口，它是一个集合，用来存储一组对象。

ArrayList、LinkedList、HashSet、TreeSet、LinkedHashSet、HashMap、TreeMap、LinkedHashMap等都是Collection的实现类。

**集合就是一种能够存储多个数据的容器** 常见的容器有集合和数组。

集合和数组的区别：

- 数组的长度是固定的，集合的长度是可变的。
- 数组中存储的是同一类型的元素，集合中存储的是不同类型的元素。
- 数组中存储的是基本数据类型的元素，集合中存储的是引用数据类型的元素。
- 数组中存储的是元素本身，集合中存储的是元素的引用。
- 数组中存储的是有序的元素，集合中存储的是无序的元素。
- 集合可以且只能存储引用数据类型的元素，不能存储基本数据类型的元素。（如果要存储基本数据类型需要进行装箱）；数组可以存储基本数据类型的元素也可以存储引用数据类型（对象数组）。

集合的特点：

- 集合是一个容器，可以存储多个元素。
- 集合的长度是可变的，可以存储多个元素。
- 集合中存储的是引用数据类型的元素。
- 集合中存储的是元素的引用。
- 集合中存储的是无序的元素。
- 集合可以且只能存储引用数据类型的元素，不能存储基本数据类型的元素。（如果要存储基本数据类型需要进行装箱）。
- 集合中存储的是元素的引用，元素的引用是有序的。

#### 2.2. 集合的分类

集合的分类：

-

Collection集合：Collection是Java集合框架中的一个接口，它是一个集合，用来存储一组对象。ArrayList、LinkedList、HashSet、TreeSet、LinkedHashSet等都是Collection的实现类。

- Map集合：Map是Java集合框架中的一个接口，它是一个集合，用来存储键值对。HashMap、TreeMap、LinkedHashMap等都是Map的实现类。
- Collection集合和Map集合的区别：Collection集合是一个集合，用来存储一组对象；Map集合是一个集合，用来存储键值对。
- Collection集合的常用方法：Collection集合的常用方法有add()、remove()、contains()、size()、isEmpty()、clear()等。
- Collection集合的常用实现类：Collection集合的常用实现类有ArrayList、LinkedList、HashSet、TreeSet、LinkedHashSet等。
- Map集合的常用方法：Map集合的常用方法有put()、get()、remove()、containsKey()、containsValue()、size()、isEmpty()、clear()等。
- Map集合的常用实现类：Map集合的常用实现类有HashMap、TreeMap、LinkedHashMap等。

#### 2.3. Collection集合继承体系

Collection集合继承体系：

- Collection是Java集合框架中的一个接口，它是一个集合，用来存储一组对象。
- List 和 Set 是 Collection 的子接口。
- Vector、ArrayList和LinkedList都是 List 的实现类。
- HashSet、TreeSet和LinkedHashSet 都是 Set 的实现类。
- List 和 Set 都是 Collection 的子接口，它们都是一个集合，用来存储一组对象。
- List 和 Set 的区别：List 是有序的集合，可以存储重复的元素；Set 是无序的集合，不可以存储重复的元素。

#### 2.4. Collection集合的常用方法

Collection集合的常用方法：

- add(E e)：将指定的元素添加到此集合中。
- remove(Object o)：将指定的元素从此集合中移除。
- contains(Object o)：如果此集合包含指定的元素，则返回 true。
- size()：返回此集合中的元素个数。
- isEmpty()：如果此集合不包含元素，则返回 true。
- clear()：从此集合中移除所有元素。
- addAll(Collection<? extends E> c)：将指定集合中的所有元素添加到此集合中。
- removeAll(Collection<?> c)：移除此集合中那些也包含在指定集合中的所有元素。
- containsAll(Collection<?> c)：如果此集合包含指定集合中的所有元素，则返回 true。
- retainAll(Collection<?> c)：仅保留此集合中那些也包含在指定集合中的元素。
- toArray()：返回包含此集合中所有元素的数组。
- iterator()：返回在此集合的元素上进行迭代的迭代器。
- spliterator()：创建一个拥有此集合所有元素的 Spliterator。
- stream()：返回一个顺序 Stream，其中包含此集合中的所有元素。
- parallelStream()：返回一个并行 Stream，其中包含此集合中的所有元素。
- equals(Object o)：比较指定对象与此集合是否相等。
- hashCode()：返回此集合的哈希码值。
- toString()：返回此集合的字符串表示形式。
- forEach(Consumer<? super E> action)：对此集合的每个元素执行给定的操作，直到所有元素都被处理或操作引发异常。
- removeIf(Predicate<? super E> filter)：删除符合给定谓词的此集合的所有元素。

### 三、Iterator迭代器

#### 3.1. Iterator迭代器的概念

1. Iterator迭代器概述

    ArrayList集合对象可以使用传统for循环和增强for循环来遍历集合中的元素，那是因为ArrayList集合有索引，可以通过索引来获取集合中的元素。
    
    Collection集合：没有索引，不能通过索引来获取集合中的元素，通过Iterator迭代器来遍历集合中的元素。
    
    介绍:
    Iterator是Java集合框架中的一个接口，它是一个迭代器，用来遍历集合中的元素。

2. Iterator迭代器的作用

   - Iterator迭代器是一个迭代器，用来遍历集合中的元素。
   - Iterator迭代器的作用是遍历集合中的元素。
   - Iterator迭代器的作用是遍历集合中的元素，遍历集合中的元素时，可以获取集合中的元素，也可以删除集合中的元素。
   
3. Iterator迭代器的使用

    迭代器相关API介绍
    迭代器的使用有两个重要的接口 Iterator 和 Iterable。

4. Iterator迭代器的常用方法

    Iterator迭代器的常用方法：

   - boolean hasNext()：如果仍有元素可以迭代，则返回 true。
   - E next()：返回迭代的下一个元素。
   - void remove()：从迭代器指向的 collection 中移除迭代器返回的最后一个元素（可选操作）。
   - default void forEachRemaining(Consumer<? super E> action)：对剩余的每个元素执行给定的操作，直到所有元素都已经被处理或动作引发异常。

#### 3.2. Iterator执行原理

1. Iterator执行原理
   当获取迭代器后，迭代器与集合存在一一对应关系，迭代器是依赖于集合而存在的，迭代器是专门用来遍历集合中的元素的。每次hasNext()
   方法调用时，迭代器都会判断集合中是否有元素，如果有元素，返回true，否则返回false。每次next()
   方法调用时，迭代器都会获取集合中的元素，然后将指针向后移动一个位置。(直到没有下一个元素了，指针指向最后一个元素的后面)
2. Iterator迭代器的使用步骤

- 获取集合的迭代器：通过集合的iterator()方法获取集合的迭代器。
- 使用迭代器遍历集合：通过迭代器的hasNext()方法判断集合中是否有元素，通过迭代器的next()方法获取集合中的元素。
- 释放迭代器：使用完迭代器后，要释放迭代器。
- 注意事项：在使用迭代器遍历集合时，不要使用集合的方法操作集合，否则会发生并发修改异常。
- 并发修改异常：在使用迭代器遍历集合时，不要使用集合的方法操作集合，否则会发生并发修改异常。
- 解决方法：在使用迭代器遍历集合时，不要使用集合的方法操作集合，如果要操作集合，应该使用迭代器的方法操作集合。

#### 3.3. Iterator迭代器的使用注意事项

1. 在迭代器完成集合的遍历后，不要使用集合的方法操作集合，否则会发生 NoSuchElementException 异常。
2. 当迭代器在使用过程中，不能使用集合对象直接增删元素，否则会发生 ConcurrentModificationException 异常。 如果需要删除元素，应该使用迭代器的
   remove() 方法删除元素。
3. 在使用迭代器遍历集合时，不要使用集合的方法操作集合，如果要操作集合，应该使用迭代器的方法操作集合。

### 四、增强for循环

#### 4.1. 增强for循环的概念

1. 增强for循环概述

    介绍:
    增强for循环是Java5的新特性，是一种简化数组和集合的遍历方式。

2. 增强for循环的作用

   - 增强for循环是一种简化数组和集合的遍历方式。
   - 增强for循环的作用是遍历数组和集合中的元素。

3. 增强for循环的使用

    增强for循环的语法格式：
    
    ```java
    for(元素类型 变量名 :数组或集合){
            // 遍历数组或集合中的元素
            }
    ```
    
    元素类型就是数组或集合中的元素的类型；变量名就是每次遍历得到的元素；数组或集合就是要遍历的数组或集合。

4. 增强for循环的底层是什么

    增强for循环的底层是迭代器，增强for循环是通过迭代器来遍历数组和集合中的元素的。

## Day05

### 一、泛型

#### 1.1. 泛型的概念

1. 泛型概述

    介绍:
    泛型是Java5的新特性，是一种将数据类型参数化的技术，是一种将数据类型作为参数的类和方法。
    `ArrayList<E>` 这里的 `E` 就是泛型。 使用ArrayList时，只要给E指定一个具体的数据类型，就可以创建一个ArrayList集合，这个集合只能存储指定的数据类型。

2. 泛型的作用

    - 泛型是一种将数据类型参数化的技术。
    - 泛型的作用是将数据类型作为参数，这样就可以创建出适用于多种数据类型的类和方法。
    - 泛型的作用是提高代码的复用性，提高代码的安全性。
    - 泛型的作用是提高代码的可读性，提高代码的稳定性。
    - 使用泛型可以在编译时检查数据类型，避免不必要的类型转换操作，精简代码，提高代码的安全性。
    - 泛型是使用在编译时期的一种机制，编译后会被擦除，不会影响运行时的效率。

3. 泛型的使用

- 泛型类

问：什么时候使用泛型类？

答：当类中的成员变量的数据类型不确定时，可以使用泛型类。

```java
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
```

格式： `class 类名<泛型类型> { }`

在类型名后面加上一对尖括号，里面定义泛型。一般使用一个英文大写字母表示，如E、T、K、V等。如果有多个泛型，使用逗号隔开。

- 泛型方法

问：什么时候使用泛型方法？

答：当方法中的参数或返回值的数据类型不确定时，可以使用泛型方法。

```java
public class GenericMethod {
    public <E> void show(E e) {
        System.out.println(e);
    }
}
```

格式： `返回值类型 方法名<泛型类型>(参数列表) { }`

在方法名后面加上一对尖括号，里面定义泛型。一般使用一个英文大写字母表示，如E、T、K、V等。如果有多个泛型，使用逗号隔开。

- 泛型接口

问：什么时候使用泛型接口？

答：当接口中的方法的参数或方法返回值的数据类型不确定时，可以使用泛型接口。

```java
public interface GenericInterface<E> {
    void add(E e);
}
```

格式： `interface 接口名<泛型类型> { }`

在接口名后面加上一对尖括号，里面定义泛型。一般使用一个英文大写字母表示，如E、T、K、V等。如果有多个泛型，使用逗号隔开。

#### 1.2. 泛型的使用

Q: 开发时选择哪个泛型定义？

A:先明确要定义的是接口还是类

1. 如果类中的成员变量的数据类型不确定时，可以使用泛型类。
2. 如果方法中的参数或返回值的数据类型不确定时，可以使用泛型方法。
3. 如果接口中的方法的参数或方法返回值的数据类型不确定时，可以使用泛型接口。
4. 在编写工具类时，工具类中的方法参数或方法返回值的数据类型不确定时，可以使用泛型方法。

Q: 泛型定义的语法？

A: 

1. 泛型类

    ```java
    public class GenericClass<E> {
        private E name;
    
        public E getName() {
            return name;
        }
    
        public void setName(E name) {
            this.name = name;
        }
    }
    ```
    
2. 泛型方法

    ```java
    public class GenericMethod {
        public <E> void show(E e) {
            System.out.println(e);
        }
    }
    ```
    
3. 泛型接口

    ```java
    public interface GenericInterface<E> {
        void add(E e);
    }
    ```

Q: 怎么明确泛型指定的具体类型（指定泛型上的类型）

A: 

1. 泛型类

    在创建对象时，指定泛型的具体类型。
    `GenericClass<String> gc = new GenericClass<>();`

2. 泛型方法

    在调用方法时，指定泛型的具体类型。
    `gm.show("abc");`
3. 泛型接口

   1. 在子类实现接口时明确指定了泛型类
   
        ```java
        public class GenericInterfaceImpl implements GenericInterface<String> {
            @Override
            public void add(String s) {
                System.out.println(s);
            }
        }
        ```
   
   2. 子类继承接口上的泛型（子类变为泛型类）
      
        ```java
        public class GenericInterfaceImpl<E> implements GenericInterface<E> {
            @Override
            public void add(E e) {
                System.out.println(e);
            }
        }
        ```
   
#### 1.3. 泛型的通配符

1. 泛型的通配符概述

    介绍:
    泛型的通配符是一种不确定的数据类型，是一种可以接收任意数据类型的数据类型。
    当我们对泛型的类型确定不了，而想表达的可以是任意类型时，可以使用泛型的通配符。
2. 泛型的通配符的使用

    泛型通配符搭配集合使用一般在方法的参数中比较常见；
    在集合中泛型是不支持多态的，如果为了匹配任意类型，我们就会使用泛型通配符了。
    通常在开发中，通配符是和泛型的上下限一起使用的。而且上限用的比较多。

3. 受限泛型

    介绍:
    受限泛型是指，在使用通配符的过程中，可以对通配符进行受限，限制通配符的范围。给泛型指定类型时，只能是某个类型的夫类型或者子类型。

    1. 上限通配符

        上限通配符的格式：`? extends 类型`，表示只能接收该类型及其子类型。

    2. 下限通配符

        下限通配符的格式：`? super 类型`，表示只能接收该类型及其父类型。


### 二、数据结构

#### 2.1. 数据结构的概念

1. 数据结构概述

    介绍:
    数据结构是计算机存储、组织数据的方式，是指相互之间存在一种或多种特定关系的数据元素的集合。
2. 数据结构的分类

    数据结构的分类：
    - 线性结构：线性结构是一种数据元素之间存在一对一关系的结构，线性结构的特点是数据元素之间存在一对一的关系。
    - 非线性结构：非线性结构是一种数据元素之间存在一对多或多对多关系的结构，非线性结构的特点是数据元素之间存在一对多或多对多的关系。
    - 栈：栈是一种先进后出的数据结构，栈的特点是数据元素只能在栈顶进行插入和删除操作。
    - 队列：队列是一种先进先出的数据结构，队列的特点是数据元素只能在队头进行删除操作，只能在队尾进行插入操作。
    - 链表：链表是一种数据元素之间存在一对多关系的数据结构，链表的特点是数据元素之间存在一对多的关系。
    - 树：树是一种数据元素之间存在一对多关系的数据结构，树的特点是数据元素之间存在一对多的关系。
    - 图：图是一种数据元素之间存在多对多关系的数据结构，图的特点是数据元素之间存在多对多的关系。

#### 2.2. 栈

![栈](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/栈.gif)

1. 栈概述

    介绍:
    栈是一种先进后出的数据结构，栈的特点是数据元素只能在栈顶进行插入和删除操作。
2. 栈的应用

    - 方法调用栈：方法调用栈是一种栈结构，用来存储方法调用的信息。
    - 浏览器的前进和后退：浏览器的前进和后退是一种栈结构，用来存储浏览器的历史记录。
    - 撤销和恢复：撤销和恢复是一种栈结构，用来存储操作的历史记录。
    - 编译器的语法检查：编译器的语法检查是一种栈结构，用来存储编译器的语法检查信息。
    - 系统调用：系统调用是一种栈结构，用来存储系统调用的信息。
3. 栈的特点
   
    - 栈是一种先进后出的数据结构，栈的特点是数据元素只能在栈顶进行插入和删除操作。
    - 栈的插入操作叫做入栈，栈的删除操作叫做出栈。
    - 栈的插入操作和删除操作只能在栈顶进行。
    - 栈的插入操作和删除操作的时间复杂度都是O(1)。
    - 栈的插入操作和删除操作的空间复杂度都是O(1)。
4. 栈的实现

    - 栈的实现有两种方式：数组和链表。
    - 数组实现的栈叫做顺序栈，链表实现的栈叫做链式栈。
    - 顺序栈的特点是插入和删除操作的时间复杂度都是O(1)。
    - 链式栈的特点是插入和删除操作的时间复杂度都是O(1)。

#### 2.3. 队列

![queue](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/queue.gif)

1. 队列概述

    介绍:
    队列是一种先进先出的数据结构，队列的特点是数据元素只能在队头进行删除操作，只能在队尾进行插入操作。
2. 队列的应用

    - 线程池：线程池是一种队列结构，用来存储线程的任务。
    - 消息队列：消息队列是一种队列结构，用来存储消息的信息。
    - 阻塞队列：阻塞队列是一种队列结构，用来存储阻塞的任务。
    - 广度优先搜索：广度优先搜索是一种队列结构，用来存储广度优先搜索的节点。
    - 系统调用：系统调用是一种队列结构，用来存储系统调用的信息。
3. 队列的特点
   
    - 队列是一种先进先出的数据结构，队列的特点是数据元素只能在队头进行删除操作，只能在队尾进行插入操作。
    - 队列的插入操作叫做入队，队列的删除操作叫做出队。
    - 队列的插入操作和删除操作只能在队头和队尾进行。
    - 队列的插入操作和删除操作的时间复杂度都是O(1)。
    - 队列的插入操作和删除操作的空间复杂度都是O(1)。
4. 队列的实现

    - 队列的实现有两种方式：数组和链表。
    - 数组实现的队列叫做顺序队列，链表实现的队列叫做链式队列。
    - 顺序队列的特点是插入和删除操作的时间复杂度都是O(1)。
    - 链式队列的特点是插入和删除操作的时间复杂度都是O(1)。

#### 2.4. 链表

**头插法**：

![链表头插法](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/链表头插法.gif)

**尾插法**：

![链表尾插法](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/链表尾插法.gif)

1. 链表概述

    介绍:
    链表是一种数据元素之间存在一对多关系的数据结构，链表的特点是数据元素之间存在一对多的关系。
2. 链表的应用

    - 链表是一种数据元素之间存在一对多关系的数据结构，链表的特点是数据元素之间存在一对多的关系。
    - 链表的插入和删除操作的时间复杂度都是O(1)。
    - 链表的插入和删除操作的空间复杂度都是O(1)。
    - 链表的插入和删除操作的时间复杂度都是O(1)。
    - 链表的插入和删除操作的空间复杂度都是O(1)。
3. 链表的特点
   
    - 链表是一种数据元素之间存在一对多关系的数据结构，链表的特点是数据元素之间存在一对多的关系。
    - 链表的插入和删除操作的时间复杂度都是O(1)。
    - 链表的插入和删除操作的空间复杂度都是O(1)。
4. 链表的实现

    - 链表的实现有两种方式：单链表和双链表。
    - 单链表的特点是数据元素之间存在一对多的关系，单链表的插入和删除操作的时间复杂度都是O(1)。
    - 双链表的特点是数据元素之间存在一对多的关系，双链表的插入和删除操作的时间复杂度都是O(1)。

#### 2.5. 树

1. 树概述

   介绍:
   树是一种数据元素之间存在一对多关系的数据结构，树的特点是数据元素之间存在一对多的关系。

   树的相关概念：

    - 度：一个节点的子节点的个数称为该节点的度。
    - 叶子节点：度为0的节点称为叶子节点。
    - 根节点：树的顶端节点称为根节点。
    - 父节点：一个节点的子节点的节点称为该节点的父节点。
    - 子节点：一个节点的父节点的节点称为该节点的子节点。
    - 层次：根节点的层次为1，根节点的子节点的层次为2，以此类推。
    - 高度：树的高度是树中节点的最大层次。
    - 深度：树中节点的深度是根节点到该节点的唯一路径的边的个数。
    - 子树：树中的任意一个节点和它的子节点，以及子节点的子节点构成的树称为子树。
    - 森林：森林是多个树的集合。
    - 二叉树：二叉树是一种特殊的树，每个节点最多有两个子节点。
    - 满二叉树：满二叉树是一种特殊的二叉树，每个节点都有0个或2个子节点。
    - 完全二叉树：完全二叉树是一种特殊的二叉树，除了最后一层，其他层的节点个数都是满的，最后一层的节点都靠左排列。
    - 二叉搜索树：二叉搜索树是一种特殊的二叉树，每个节点的左子节点都小于该节点，每个节点的右子节点都大于该节点。
    - 平衡二叉树：平衡二叉树是一种特殊的二叉树，每个节点的左子树和右子树的高度差不超过1。
    - 红黑树：红黑树是一种特殊的二叉树，每个节点都有颜色，每个节点的颜色是红色或黑色，红黑树是一种自平衡的二叉树。
    - B树：B树是一种特殊的二叉树，每个节点都有多个子节点，B树是一种多路搜索树。
    - B+树：B+树是一种特殊的二叉树，每个节点都有多个子节点，B+树是一种多路搜索树。
    - AVL树：AVL树是一种特殊的二叉树，每个节点的左子树和右子树的高度差不超过1，AVL树是一种自平衡的二叉树。
    - Trie树：Trie树是一种特殊的二叉树，每个节点都有多个子节点，Trie树是一种多路搜索树。
    - 哈夫曼树：哈夫曼树是一种特殊的二叉树，每个节点都有权值，哈夫曼树是一种最优二叉树。
    - 二叉堆：二叉堆是一种特殊的二叉树，每个节点都大于或小于它的子节点，二叉堆是一种优先队列。

2. 二叉树

   介绍:
   二叉树是一种数据元素之间存在一对多关系的数据结构，二叉树的特点是数据元素之间存在一对多的关系。

   二叉树的结构

   ![image-20240516225002616](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/image-20240516225002616.png)

    - 平衡二叉树
        - 二叉树可以通过旋转操作来调整平衡，使得树的高度尽量小，这种二叉树称为平衡二叉树。
        - 平衡二叉树是一种特殊的二叉树，每个节点的左子树和右子树的高度差不超过1。
        - 平衡二叉树的插入和删除操作的时间复杂度都是O(logn)。
    - 红黑树（又称平衡二叉B树）
      - 红黑树是一种特殊的二叉树，每个节点都有颜色，每个节点的颜色是红色或黑色，红黑树是一种自平衡的二叉树。
      - 红黑规则：
        - 每个节点要么是红色，要么是黑色。
        - 根节点是黑色。
        - 如果一个节点没有子节点，则该节点相应的指针属性值为NIL，这些NIL视为叶子节点。
        - 每个叶子节点（NIL节点，空节点）是黑色。
        - 如果一个节点是红色，则它的子节点必须是黑色。（不能有两个相邻的红色节点）
        - 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
   
3. 树的应用

    - 树是一种数据元素之间存在一对多关系的数据结构，树的特点是数据元素之间存在一对多的关系。
    - 树的插入和删除操作的时间复杂度都是O(logn)。
    - 树的插入和删除操作的空间复杂度都是O(1)。
    - 树的插入和删除操作的时间复杂度都是O(logn)。
    - 树的插入和删除操作的空间复杂度都是O(1)。
    
4. 树的特点
    - 树是一种数据元素之间存在一对多关系的数据结构，树的特点是数据元素之间存在一对多的关系。
    - 树的插入和删除操作的时间复杂度都是O(logn)。
    - 树的插入和删除操作的空间复杂度都是O(1)。
   
5. 树的实现

    - 树的实现有两种方式：二叉树和多叉树。
    - 二叉树的特点是数据元素之间存在一对多的关系，二叉树的插入和删除操作的时间复杂度都是O(logn)。
    - 多叉树的特点是数据元素之间存在一对多的关系，多叉树的插入和删除操作的时间复杂度都是O(logn)。
    
6. 二叉查找树

    二叉查找树又称二叉排序树或二叉搜索树
    特点：
    - 每个节点上最多有两个子节点
    - 每个结点的左子节点比当前节点小，右子节点比当前节点大
    
7. 平衡二叉树
    特点：
    - 二叉树左右两个子树的高度差不超过1
    - 任意节点的左右两个子树都是一棵平衡二叉树
    - 歪脖子树可以通过旋转的方式来让树达到平衡，均匀分布
    
8. 红黑树
   
    红黑树又称平衡二叉B树，每一个节点可以是红或者黑。
    红黑规则:
    - 每一个节点要么是红色的要么是黑色的；
    - 根节点必须是黑色；
    - 如果一个节点没有子节点或者父节点，则该节点相应的指针属性值为Nil，这些 Nil视为叶节点，每个叶节点（Nil）是黑色的；
    - 如果某一个节点是红色，那么它的子节点必须是黑色（不能出现两个红色节点相连的情况）
    - 对每一个节点，从该节点到所有后代叶节点的简单路径上，均包含数目相同的黑色节点。


#### 2.6. 图

1. 图概述

    介绍:
    图是一种数据元素之间存在多对多关系的数据结构，图的特点是数据元素之间存在多对多的关系。
2. 图的应用

    - 图是一种数据元素之间存在多对多关系的数据结构，图的特点是数据元素之间存在多对多的关系。
    - 图的插入和删除操作的时间复杂度都是O(1)。
    - 图的插入和删除操作的空间复杂度都是O(1)。
    - 图的插入和删除操作的时间复杂度都是O(1)。
    - 图的插入和删除操作的空间复杂度都是O(1)。
3. 图的特点
   
    - 图是一种数据元素之间存在多对多关系的数据结构，图的特点是数据元素之间存在多对多的关系。
    - 图的插入和删除操作的时间复杂度都是O(1)。
    - 图的插入和删除操作的空间复杂度都是O(1)。
4. 图的实现

    - 图的实现有两种方式：邻接矩阵和邻接表。
    - 邻接矩阵的特点是数据元素之间存在多对多的关系，邻接矩阵的插入和删除操作的时间复杂度都是O(1)。
    - 邻接表的特点是数据元素之间存在多对多的关系，邻接表的插入和删除操作的时间复杂度都是O(1)。

#### 2.7. 数组

1. 数组概述

    介绍:
    数组是一种数据元素之间存在一对一关系的数据结构，数组的特点是数据元素之间存在一对一的关系。
2. 数组的特点
        
    - 数组是一种数据元素之间存在一对一关系的数据结构，数组的特点是数据元素之间存在一对一的关系。
    - 数组的插入和删除操作的时间复杂度都是O(n)。
    - 数组的插入和删除操作的空间复杂度都是O(1)。
3. 数组的实现

    - 数组的实现有两种方式：静态数组和动态数组。
    - 静态数组的特点是数据元素之间存在一对一的关系，静态数组的插入和删除操作的时间复杂度都是O(n)。
    - 动态数组的特点是数据元素之间存在一对一的关系，动态数组的插入和删除操作的时间复杂度都是O(n)。

#### 2.8 TreeSet

1. TreeSet概述

   介绍:
   TreeSet具有对所存储元素进行排序的功能，TreeSet是一个有序的集合，它是按照元素的自然顺序进行排序的。
   在TreeSet中存储的元素必须实现Comparable接口，否则会抛出ClassCastException异常。
   JDK提供的类型：String、Integer、Double等都实现了Comparable接口，所以可以直接存储。
   compareTo方法返回值为0，表示元素相同，不会存储；返回值大于0，表示元素大于；返回值小于0，表示元素小于。
   TreeSet是Java集合框架中的一个类，它是一个集合，用来存储一组对象。
   TreeSet是一个有序的集合，它是按照元素的自然顺序进行排序的。
   TreeSet底层使用：红黑树，实现了去重、排序（拿树中存在的元素，和要存储的元素进行比较【比较大小：0、正数还有负数】）；存储自定义元素要保证自定义元素有实现 java.lang.Comparable接口

2. TreeSet的特点

    - TreeSet是一个有序的集合，它是按照元素的自然顺序进行排序的。
    - 底层使用红黑树实现
    - 不能存储重复元素
    - 不具备索引

3. TreeSet的应用

    - TreeSet是一个有序的集合，它是按照元素的自然顺序进行排序的。
    - TreeSet的插入和删除操作的时间复杂度都是O(logn)。
    - TreeSet的插入和删除操作的空间复杂度都是O(1)。

4. TreeSet的实现

    - TreeSet的实现有两种方式：红黑树和跳表。
    - 红黑树的特点是数据元素之间存在一对多的关系，红黑树的插入和删除操作的时间复杂度都是O(logn)。
    - 跳表的特点是数据元素之间存在一对多的关系，跳表的插入和删除操作的时间复杂度都是O(logn)。

5. 比较器
   - TreeSet存储的元素必须实现Comparable接口，否则会抛出ClassCastException异常。
   - 如果存储的元素没有实现Comparable接口，可以使用比较器来进行排序。
   - 比较器是一个接口，它有两个方法：compare和equals。
   - 比较器的compare方法用来比较两个元素的大小，返回值为0，表示元素相同，不会存储；返回值大于0，表示元素大于；返回值小于0，表示元素小于。
   - 比较器的equals方法用来比较两个元素是否相等，返回值为true，表示元素相等；返回值为false，表示元素不相等。

### 三、List集合
- List集合是Collection集合子类型，继承了所有Collection中功能，同时List增加了带索引的功能
- 特点：
  - 元素存取是有序的 【有序】
  - 元素具备索引 【有索引】
  - 元素可以重复存储 【可重复】
- 常见的子类
  - ArrayList： 底层结构是数组 【查询快，增删慢】
  - Vector： 底层结构也是数组（线程安全 同步安全 低效所以用的少）
  - LinkedList： 底层是链表结构（双向链表）【查询慢 增删快】
- List中常用的方法
  - add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
  - get(int index):返回集合中指定位置的元素
  - remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
  - set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素
- LinkedList类
  - LinkedList底层结构是双向链表。每个节点有三个部分的数据，一个是保存元素数据，一个是保存前一个节点的地址，一个是保存后一个节点的地址。可以双向查询，效率会比单向链表高。
  - LinkedList特有方法
    - addFirst(E e):将指定元素插入此列表的开头。
    - addLast(E e):将指定元素添加到此列表的结尾。
    - getFirst():返回此列表的第一个元素。
    - getLast():返回此列表的最后一个元素。
    - removeFirst():移除并返回此列表的第一个元素。
    - removeLast():移除并返回此列表的最后一个元素。

### 四、Set集合
Set集合也是Collection集合的子类型，没有特有方法。Set比Collection定义更严谨
- 特点
  - 元素不能保证插入和存储顺序 【无序】
  - 元素没有索引            【无索引】
  - 元素唯一                【元素唯一】
- 常用子类
  - HashSet： 底层是HashMap，哈希表组成（去重、无索引、无序）哈希表结构的集合，操作效率会非常高
  - LinkedHashSet:底层结构链表加哈希表结构。 具有哈希表表结构的特点，也具有链表的特点。
  - TreeSet：底层是有TreeMap，底层数据结构 红黑树。 去重，让存入的元素具有排序（升序排序）

## Day06

### 一、Java集合

![Java集合体系框架](https://cdn.jsdelivr.net/gh/hiheya/images@master/img/Java集合体系框架.jpg)

### 二、可变参数

在Java语言中提供了一种特殊的参数：可变参数（可以改变的参数）： 在调用方法时，传递的参数可以是任意个（底层使用数组）

语法格式：

```java
public 返回值类型 方法名(参数类型... 参数名) {}
```

注意事项：
- 可变参数只能作为方法的最后一个参数，但其前面可以有或没有任何其他参数。
- 可变参数本质上是数组，不能作为方法的重载。如果同时出现相同类型的数组和可变参数方法，是不能编译通过的。

#### 可变参数的使用
- 调用可变参数方法，可以给出零到任意多个参数，编译器会将可变参数转化为一个数组，也可以直接传递一个数组。
方法内部使用时直接当做数组使用即可

```java
public class VariableDemo1 {
    public static void main(String[] args) {
        sum();
        sum(1, 2);
        sum(1, 2, 3, 4);
    }
    
    public static void sum(int... num) {// 方法的参数是一个int类型的可变参数
        int sum = 0;// 定义求和变量
        for (int i : num) {
            sum += i;
        }
        System.out.println(sum);
    }
}
```



### 三、排序查找算法
#### 1. 冒泡排序
- 冒泡排序：将一组数据按照从小到大方式进行排序；
- 原理：相邻元素两两比较大的元素往后放
- 实现
```java
public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j] > array[j + 1]) {
                int tempNum = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tempNum;
            }
        }
    }
}
```

#### 2. 选择排序
- 选择排序：
- 原理: 它的工作原理是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。
- 注意事项
  - 有n个元素，那么就要比较n-1轮次。
  - 每一趟中都会选出一个最值元素，较前一趟少比较一次
- 实现
```java
public static void selectionSort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
        int minIndex = i;
        int min = array[i];
        for (int j = i; j < array.length; j++) {
            if (array[j] <= min) {
                min = array[j];
                minIndex = j;
            }
        }

        if (i != minIndex) {
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
```

#### 3.二分查找
- 原理 : 每次去掉一般的查找范围
- 前提 : 数组必须有序
- 实现 :
```java
public static int binarySearch(int num, int[] array) {
    int min = 0;
    int max = array.length - 1;
    while (min <= max) {
        int half = (min + max ) / 2;
        if (num > array[half]) {
            min = half + 1;
        } else if(num < array[half]) {
            max = half - 1;
        } else {
            return half;
        }
    }
    return -1;
}
```

### 四、Map集合
#### Map集合的介绍

- java.util.Map<K,V> 集合，里面保存的数据是成对存在的，称之为双列集合。存储的数据，我们称为键值对。 之前所学的Collection集合中元素单个单个存在的，称为单列集合

#### 特点

- Map<K,V>   K：键的数据类型；V：值的数据类型

- 特点 :
    - 键不能重复，值可以重复
    - 键和值是 一 一 对应的，通过键可以找到对应的值
    - （键 + 值） 一起是一个整体 我们称之为“键值对” 或者  “键值对对象”，在Java中叫做“Entry对象”
- 使用场景
    - 凡是要表示一一对应的数据时就可以Map集合
        - 举例 : 学生的学号和姓名  ---  (itheima001	小智)
        - 举例 : 夫妻的关系 ---- (王宝强	马蓉 )     (谢霆锋	张柏芝) 

####  常用实现类

- HashMap：
    - 此前的HashSet底层实现就是HashMap完成的，HashSet保存的元素其实就是HashMap集合中保存的键，底层结构是哈希表结构，具有键唯一，无序，特点。
- LinkedHashMap：
    - 底层结构是有链表和哈希表结构，去重，有序
- TreeMap：
    - 底层是有红黑树，去重，通过键排序

#### 常用的方法

- public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
- public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
- public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
- public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
- public boolean containKey(Object key):判断该集合中是否有此键。

#### Map集合的遍历

##### 第一种方式 : 键找值
```java
public class MapTest1 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> hm = new HashMap<>();

        // 添加元素
        hm.put("周瑜", "小乔");
        hm.put("孙策", "大乔");
        hm.put("刘备", "孙尚香");
        hm.put("诸葛亮", "黄月英");
    
        // 获取健集合
        Set<String> set = hm.keySet();
        
        // 遍历健集合 , 通过键找值
        for (String key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}

``` 

##### 第二种方式： 获取键值对对象，再找到键和值

```java
public class MapTest2 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> hm = new HashMap<>();

        // 添加元素
        hm.put("张无忌", "赵敏");
        hm.put("张翠山", "殷素素");
        hm.put("张三丰", "郭芙");
    
        // 获取键值对对象集合
        Set<Map.Entry<String, String>> set = hm.entrySet();
    
        // 遍历键值对对象集合 , 获取每一个键值对对象
        for (Map.Entry<String, String> entry : set) {
            // 通过entry对象获取键
            String key = entry.getKey();
            // 通过entry对象获取值
            String value = entry.getValue();
            System.out.println(key + "--" + value);
        }
    }
}
```

#### HashMap集合

- 注意 : HashMap集合 , 要想保证键唯一 , 那么键所在的类必须重写hashCode和equals方法

#### LinkedHashMap集合

- LinkedHashMap类 , 在最底层采用的数据结构 : 是链表+哈希表。
- 特点 :
    - 元素唯一
    - 元素有序

#### TreeMap集合

- TreeMap的底层是红黑树实现的，有排序的能力，键去重。

- 可以自然排序（键所在的类要实现Comparable）
- 若自定义类没有自然排序功能，或自然排序功能不满足要求时。可以自定义比较器排序（Comparator）

### 五、集合嵌套

#### 6.1 List嵌套List
```java
public class Test3 {
    public static void main(String[] args) {
        List<String> 三年一班 = new ArrayList<>();
        三年一班.add("迪丽热巴");
        三年一班.add("古力娜扎");
        三年一班.add("马尔扎哈");
        三年一班.add("欧阳娜娜");

        List<String> 三年二班 = new ArrayList<>();
        三年二班.add("李小璐");
        三年二班.add("白百何");
        三年二班.add("马蓉");

        List<String> 三年三班 = new ArrayList<>();
        三年三班.add("林丹");
        三年三班.add("文章");
        三年三班.add("陈赫");

        List<List<String>> 年级 = new ArrayList<>();
        年级.add(三年一班);
        年级.add(三年二班);
        年级.add(三年三班);

        for (List<String> 班级 : 年级) {
            for (String name : 班级) {
                System.out.println(name);
            }
            System.out.println("-----------------");
        }
    }
}
```

#### 5.2 List嵌套Map

```java
package com.itheima.Collection_nested_demo;

import java.util.*;

/*
    List嵌套Map :

    使用场景举例：一年级有多个班级，每个班级有多名学生。要求保存每个班级的学生姓名，姓名有与之对应的学号，保存一年级所有的班级信息。

    思路：
        1 可以使用Map集合保存一个班级的学生（键是学号，值是名字）
        2 可以使用List集合保存所有班级

    因此我们可以定义集合如下：

    班级：Map<String,String> 键是学号，值是姓名
        举例 :
            Map<String,String> 三年一班 = {it001 = 迪丽热巴 , it002 = 古力娜扎 ,it003 = 马尔扎哈 ,it004 = 欧阳娜娜}
            Map<String,String> 三年二班 = {it001 = 李小璐 , it002 = 白百何 , it003 = 马蓉}
            Map<String,String> 三年三班 = {it001 = 林丹 ,it002 = 文章, it003 = 陈赫}

    年级：List<Map<String,String>>保存每个班级的信息
        举例 :
              List<Map<String,String>> 年级 = {三年一班 , 三年二班 , 三年三班}
 */
public class Test2 {
    public static void main(String[] args) {
        Map<String, String> 三年一班 = new HashMap<>();
        三年一班.put("it001", "迪丽热巴");
        三年一班.put("it002", "古力娜扎");
        三年一班.put("it003", "马尔扎哈");
        三年一班.put("it004", "欧阳娜娜");


        Map<String, String> 三年二班 = new HashMap<>();
        三年二班.put("it001", "李小璐");
        三年二班.put("it002", "白百何");
        三年二班.put("it003", "马蓉");

        Map<String, String> 三年三班 = new HashMap<>();
        三年三班.put("it001", "林丹");
        三年三班.put("it002", "文章");
        三年三班.put("it003", "陈赫");


        List<Map<String, String>> 年级 = new ArrayList<>();
        年级.add(三年一班);
        年级.add(三年二班);
        年级.add(三年三班);

        for (Map<String, String> 班级 : 年级) {
            Set<String> studentId = 班级.keySet();
            for (String id : studentId) {
                String name = 班级.get(id);
                System.out.println(id + "---" + name);
            }
            System.out.println("=================");
        }
    }
}

```

#### 5.3 ### Map嵌套Map

```java
package com.itheima.Collection_nested_demo;

import java.util.*;

/*
    Map嵌套Map

    使用场景举例：一个年级有多个班级，每个班级有多名学生。要求保存每个班级的学生姓名，姓名有与之对应的学号，保存一年级所有的班级信息，班级有与之对应的班级名称。

    思路：
    可以使用Map集合保存一个班级的学生（键是学号，值是名字）

    可以使用Map集合保存所有班级（键是班级名称，值是班级集合信息）

    因此我们可以定义集合如下：
    班级： Map<String,String> 键：学号，值：姓名
        举例 :
            Map<String,String> 三年一班 = {it001 = 迪丽热巴 , it002 = 古力娜扎 ,it003 = 马尔扎哈 ,it004 = 欧阳娜娜}
            Map<String,String> 三年二班 = {it001 = 李小璐 , it002 = 白百何 , it003 = 马蓉}
            Map<String,String> 三年三班 = {it001 = 林丹 ,it002 = 文章, it003 = 陈赫}

    年级： Map<String , Map<String,String>> 键：班级名称，值：具体班级信息
        举例:
            Map<String, Map<String,String>> 年级 = {"三年一班" = 三年一班 , "三年二班" = 三年二班 , "三年三班" = 三年三班 }

 */
public class Test3 {
    public static void main(String[] args) {

        Map<String, String> 三年一班 = new HashMap<>();
        三年一班.put("it001", "迪丽热巴");
        三年一班.put("it002", "古力娜扎");
        三年一班.put("it003", "马尔扎哈");
        三年一班.put("it004", "欧阳娜娜");


        Map<String, String> 三年二班 = new HashMap<>();
        三年二班.put("it001", "李小璐");
        三年二班.put("it002", "白百何");
        三年二班.put("it003", "马蓉");

        Map<String, String> 三年三班 = new HashMap<>();
        三年三班.put("it001", "林丹");
        三年三班.put("it002", "文章");
        三年三班.put("it003", "陈赫");


        Map<String, Map<String, String>> 年级 = new HashMap<>();
        年级.put("三年一班", 三年一班);
        年级.put("三年二班", 三年二班);
        年级.put("三年三班", 三年三班);

        Set<String> 班级名字集合 = 年级.keySet();

        for (String 班级名字 : 班级名字集合) {
            Map<String, String> 班级信息 = 年级.get(班级名字);
            Set<String> 学生学号 = 班级信息.keySet();
            for (String 学号 : 学生学号) {
                String 姓名 = 班级信息.get(学号);
                System.out.println("班级名字:" + 班级名字 + " ,学号:" + 学号 + " , 名字:" + 姓名);
            }
            System.out.println("============");
        }

    }
}

```

### 六、集合工具类
- Collections工具类介绍
    - java.util.Collections 是集合的工具类，里面提供了静态方法来操作集合，乱序，排序....

#### 6.1 shuffle方法

- public static void shuffle(List<?> list) 对集合中的元素进行打乱顺序。

- 集合中元素类型可以任意类型

  ```java
  package com.itheima.collections_demo;
  
  import java.util.ArrayList;
  import java.util.Collections;
  
  /*
      Collections类 : 操作单列集合的工具类
          public static void shuffle(List<?> list) 对集合中的元素进行打乱顺序
          1 乱序只能对List集合进行乱序
          2 集合中元素类型可以任意类型
  
          需求 : 定义一个List集合，里面存储若干整数。对集合进行乱序
   */
  public class ShuffleDemo {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(10);
          list.add(30);
          list.add(50);
          list.add(40);
          list.add(20);
  
          Collections.shuffle(list);
  
          System.out.println(list);// 打印集合中的元素
      }
  }
  
  ```

#### 6.2 sort方法

- public static <T extends Comparable> void sort (List<T> list): 对集合中的元素自然排序

    - 该方法只能对List集合进行排序
    - 从方法中泛型分析可知，集合中元素类型必须是Comparable的子类型

  ```java
  package com.itheima.collections_demo;
  
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.Comparator;
  
  /*
      Collections类 : 单列集合的工具类
          sort方法是一个重载的方法，可以实现自然排序及比较器排序。
          要特别注意的是sort方法只能对List集合进行排序，方法如下：
  
          public static <T extends Comparable> void sort (List<T> list)
  
          练习：定义List集合，存储若干整数，进行排序
   */
  public class SortDemo1 {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(3);
          list.add(2);
          list.add(4);
          list.add(1);
  
          // 使用此方法 , 需要集合中存储的元素实现Comparable接口
          Collections.sort(list);
  
          System.out.println(list);
      }
  }
  ```



- public static <T> void  sort (List<T> list, Comparator<? super T> c)

    - 方法只能对List集合排序

    - 对元素的类型没有要求

    - 需要定义一个比较器Comparator （规则和之前TreeSet时一样）

    - 使用场景：

        -  List集合中的元素类型不具备自然排序能力（元素类型没有实现结果 Comparable）
        -  List集合中的元素类型具备自然排序能力，但是排序规则不是当前所需要的。

### 七、斗地主案例
