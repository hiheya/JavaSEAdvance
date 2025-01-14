package work.icu007.day01.work;

/**
 * @Author {xiheya}
 * @Date: 2024/04/09/ 20:54
 * @Description
 */

/*
我们计划为一个动物园制作一套信息管理系统，根据与甲方沟通，我们归纳了有以下几种动物需要记录到系统中：

```java
鸟类：		 鹦鹉、猫头鹰、喜鹊
哺乳类：	大象、狼、长颈鹿
爬行类：	鳄鱼、蛇、乌龟
```

**要求：**

请根据以上需求，使用“继承”设计出三层的类结构

```java
|--动物类
    |--鸟类：
        |--鹦鹉类
        |--猫头鹰类
        |--喜鹊类

    |--哺乳类：
        |--大象类
        |--狼类
        |--长颈鹿类

    |--爬行类：
        |--鳄鱼类
        |--蛇类
        |--乌龟类
```


 */
public class Demo02 {
}

class Animal {
    String color;

    public void eat(){
        System.out.println("正在吃饭");
    }
    public void howl(){
        System.out.println("正在嚎叫");
    }
}
// 鸟类
class Bird extends Animal {
    // 特有属性

    // 特有方法
}
// 鹦鹉类
class Parrot extends Bird{
    // 特有属性

    // 特有方法
}
// 喜鹊类
class Magpie extends Bird{
    // 特有属性

    // 特有方法
}
// 猫头鹰类
class Owl extends Bird{
    // 特有属性

    // 特有方法
}

// 哺乳类
class Mammal extends Animal {
    // 特有属性

    // 特有方法
}
// 大象类
class Elephant extends Mammal {
    // 特有属性

    // 特有方法
}
// 狼类
class Wolf extends Mammal {
    // 特有属性

    // 特有方法
}
// 长颈鹿类
class Giraffe extends Mammal {
    // 特有属性

    // 特有方法
}

// 爬行类
class Reptiles extends Animal {
    // 特有属性

    // 特有方法
}
// 鳄鱼类
class Alligator extends Reptiles {
    // 特有属性

    // 特有方法
}
// 蛇类
class Snake extends Reptiles {
    // 特有属性

    // 特有方法
}
// 乌龟类
class Turtles extends Reptiles {
    // 特有属性

    // 特有方法
}