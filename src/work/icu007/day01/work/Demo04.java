package work.icu007.day01.work;

/**
 * @Author {xiheya}
 * @Date: 2024/04/09/ 21:57
 * @Description
 */
public class Demo04 {
    public static void main(String[] args) {
        Cucumber cucumber = new Cucumber("青", 200.00);
        System.out.println(cucumber);
        Banana banana = new Banana("黄", 200.00);
        System.out.println(banana);
        EggPlant eggPlant  = new EggPlant("紫", 200.00);
        System.out.println(eggPlant);
        Durian durian = new Durian("黄", 200.00);
        System.out.println(durian);
        Eel eel = new Eel(500,"进口" ,200.00);
        System.out.println(eel);
        Hairtail hairtail = new Hairtail(600 ,"国产" , 200.00);
        System.out.println(hairtail);


    }
}

/*
创建类描述黄瓜、茄子、香蕉、榴莲、黄鳝、带鱼；它们各自拥有的属性和功能如下：（后面带小括号的是功能）

        黄瓜：颜色；重量；可以吃(){黄瓜炒蛋}；可以使用(){做面膜}

        茄子：颜色；重量；可以吃(){油焖茄子}；可以使用(){做中药}

        香蕉：颜色；重量；可以吃(){脆皮香蕉}；可以使用(){做香蕉面膜}

        榴莲：颜色；重量；可以吃(){榴莲酥}；可以使用(){砸人}

        黄鳝：重量；品种；价格；可以吃(){鳝鱼粥};

        带鱼：重量；品种；价格；可以吃(){糖醋带鱼};

        请用继承的思想设计设计以上类型。
*/
abstract class Food {
    public Food() {
    }

    public Food(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private String color;
    private double weight;

    public abstract void eat();

    public abstract void use();
}

// 定义黄瓜类Cucumber，继承自Food
class Cucumber extends Food {
    @Override
    public String toString() {
        eat();
        use();
        return "Cucumber: 颜色 " + getColor() + " 重量"+ getWeight();
    }

    public Cucumber(String color, double weight) {
        super(color, weight);
    }

    @Override
    public void eat() {
        System.out.println("黄瓜炒蛋");
    }

    @Override
    public void use() {
        System.out.println("敷面膜");
    }
}

// 茄子
class EggPlant extends Food {
    public EggPlant() {
    }

    public EggPlant(String color, double weight) {
        super(color, weight);
    }

    @Override
    public void eat() {
        System.out.println("油焖茄子");
    }

    @Override
    public void use() {
        System.out.println("做中药");
    }

    @Override
    public String toString() {
        eat();
        use();
        return "EggPlant: 颜色 " + getColor() + " 重量"+ getWeight();
    }
}

// 香蕉
class Banana extends Food {

    public Banana() {
    }

    public Banana(String color, double weight) {
        super(color, weight);
    }

    @Override
    public void eat() {
        System.out.println("脆皮香蕉");
    }

    @Override
    public void use() {
        System.out.println("香蕉面膜");
    }
    @Override
    public String toString() {
        eat();
        use();
        return "Banana: 颜色 " + getColor() + " 重量"+ getWeight();
    }
}

// 榴莲
class Durian extends Food {

    public Durian() {
    }

    public Durian(String color, double weight) {
        super(color, weight);
    }

    @Override
    public void eat() {
        System.out.println("榴莲酥");
    }

    @Override
    public void use() {
        System.out.println("砸人");
    }
    @Override
    public String toString() {
        eat();
        use();
        return "Durian{}: 颜色 " + getColor() + " 重量"+ getWeight();
    }
}

/*
        榴莲：颜色；重量；可以吃(){榴莲酥}；可以使用(){砸人}

        黄鳝：重量；品种；价格；可以吃(){鳝鱼粥};

        带鱼：重量；品种；价格；可以吃(){糖醋带鱼};
 */
// 水产类
abstract class AquaticProduct extends Food {
    protected String variety;
    protected double price;

    AquaticProduct(double weight, String variety, double price) {
        super("无", weight);
        this.variety = variety;
        this.price = price;
    }
}

// 黄鳝
class Eel extends AquaticProduct {

    Eel(double weight, String variety, double price) {
        super(weight, variety, price);
    }

    @Override
    public void eat() {
        System.out.println("鳝鱼粥");
    }

    @Override
    public void use() {
        System.out.println("没啥用");
    }
    @Override
    public String toString() {
        eat();
        use();
        return "Eel{}: 颜色 " + getColor() + " 种类 " + variety +  " 重量"+ getWeight();
    }
}

// 带鱼
class Hairtail extends AquaticProduct {

    Hairtail(double weight, String variety, double price) {
        super(weight, variety, price);
    }

    @Override
    public void eat() {
        System.out.println("糖醋带鱼");
    }

    @Override
    public void use() {
        System.out.println("没啥用");
    }
    @Override
    public String toString() {
        eat();
        use();
        return "Hairtail: 颜色 " + getColor() + " 种类 " + variety +  " 重量"+ getWeight();
    }
}

/*
 */