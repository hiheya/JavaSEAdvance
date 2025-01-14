package work.icu007.day03.work;

/*
## 题目1

有以下类定义：

动物类

```
属性：名称、年龄、性别
行为：吃
```

猫类继承动物

```java
行为：
  吃（重写）
  捉老鼠
```

狗类继承动物

```java
行为：
  吃（重写）
  看家
```



**要求**

请按要求定义上述类，并用多态的格式测试调用“吃饭”和“捉老鼠”的方法，看看有什么特点？

 */
public class Test01 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
        if (cat instanceof Cat) {
            ((Cat) cat).catchMouse();
        }
        // cat.catchMouse(); // 编译报错

        Animal dog = new Dog();
        dog.eat();
        if (dog instanceof Dog) {
            ((Dog) dog).lookAfterHouse();
        }
        // dog.lookAfterHouse(); // 编译报错
    }
}

abstract class Animal {
    private String name;
    private int age;
    private String gender;

public abstract void eat();
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        System.out.println("猫捉老鼠");
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void lookAfterHouse() {
        System.out.println("狗看家");
    }
}
