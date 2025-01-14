package work.icu007.day01.work;

/**
 * @Author {xiheya}
 * @Date: 2024/04/09/ 20:27
 * @Description
 */

/*
我们计划为一个电器销售公司制作一套系统，
公司的主要业务是销售一些家用电器，例如：电冰箱、洗衣机、电视机产品。

类的设计为：

```
冰箱类
	属性：品牌、型号、颜色、售价、门款式、制冷方式

洗衣机类
	属性：品牌、型号、颜色、售价、电机类型、洗涤容量

电视类
	属性：品牌、型号、颜色、售价、屏幕尺寸、分辨率
```

**要求：**

请根据上述类的设计，抽取父类“电器类”，并代码实现父类“电器类”、子类“冰箱类”，“洗衣机类”、“电视类”
 */
public class Demo01 {
    public static void main(String[] args) {
        // 冰箱
        Refrigerator mediaRefrigerator = new Refrigerator("media", "0041", "白色", 1399.00, "双开门", "电机制冷");
        System.out.println(mediaRefrigerator);

        // 洗衣机
        Washer hairWasher = new Washer("hair", "0001", "黑色", 1899.00, "双电机", 5.00F);
        System.out.println(hairWasher);

        // 电视机
        Television xiaomiTelevision = new Television("xiaomi", "大师探索版", "黑色", 2099.00, "50英寸", "4K");
        System.out.println(xiaomiTelevision);
    }
}

// 电器类; 冰箱 洗衣机 电视机的父类
class Electrical {
    String brand;       // 品牌
    String type;        // 型号
    String color;       // 颜色
    double price;        // 价格

    public Electrical() {
    }

    public Electrical(String brand, String type, String color, double price) {
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.price = price;
    }
}

// 电冰箱类 继承自电器类
class Refrigerator extends Electrical {
    private String doorStyle;       // 门款式
    private String coldMethod;      // 制冷类型

    public Refrigerator(String doorStyle, String coldMethod) {
        this.doorStyle = doorStyle;
        this.coldMethod = coldMethod;
    }

    public Refrigerator(String brand, String type, String color, double price, String doorStyle, String coldMethod) {
        super(brand, type, color, price);
        this.doorStyle = doorStyle;
        this.coldMethod = coldMethod;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", doorStyle='" + doorStyle + '\'' +
                ", coldMethod='" + coldMethod + '\'' +
                '}';
    }
}

// 洗衣机类 继承自电器类
class Washer extends Electrical {
    private String motorType;       // 电机类型
    private float volume;           // 洗涤容量 单位L

    public Washer(String motorType, float volume) {
        this.motorType = motorType;
        this.volume = volume;
    }

    public Washer(String brand, String type, String color, double price, String motorType, float volume) {
        super(brand, type, color, price);
        this.motorType = motorType;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Washer{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", motorType='" + motorType + '\'' +
                ", volume=" + volume +
                '}';
    }
}

// 电视机类 继承自电器类
class Television extends Electrical {
    private String screenSize;      // 屏幕尺寸
    private String resolution;      // 分辨率

    public Television(String screenSize, String resolution) {
        this.screenSize = screenSize;
        this.resolution = resolution;
    }

    public Television(String brand, String type, String color, double price, String screenSize, String resolution) {
        super(brand, type, color, price);
        this.screenSize = screenSize;
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Television{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", screenSize='" + screenSize + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}