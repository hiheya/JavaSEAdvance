package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 12:43
 * @Description
 */
public interface IShapePara {
    double getArea();

    double getCircumference();
}

class Circle implements IShapePara {
    public final double PI = 3.14;
    public double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void show() {
        System.out.println("半径为: " + radius + " 的圆, 面积为: " + getArea() + " 周长为: " + getCircumference());
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius *radius;
    }

    @Override
    public double getCircumference() {
        return 2 * PI * radius;
    }
}
