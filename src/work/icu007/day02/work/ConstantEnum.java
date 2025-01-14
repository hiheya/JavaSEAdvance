package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 13:03
 * @Description
 */
/*
请为性别，方向，季度，星期，月份定义枚举类型表示。

```java
方向：上，下，左，右
季节：春，夏，秋，冬
星期：星期一....星期日
```


 */
public enum ConstantEnum {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

// idea中 将 字符快速转换大小写 快捷键 ctrl + shift + U
enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}

enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
