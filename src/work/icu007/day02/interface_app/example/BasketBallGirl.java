package work.icu007.day02.interface_app.example;

//篮球女孩（子类）
public class BasketBallGirl extends Girl implements PlayBasketBall{

    public BasketBallGirl(String name, int age) {
        super(name, age);
    }

    @Override
    public void playBasketBall(){
        System.out.println(super.name + " 女篮同学 打球");
    }
}
