package work.icu007.day02.interface_app.example;

//篮球男孩
public class BasketBallBoy extends Boy implements PlayBasketBall {
    public BasketBallBoy(String name, int age) {
        super(name, age);
    }

    @Override  //重写接口中的抽象方法
    public void playBasketBall(){
        System.out.println(super.name + " 男篮同学 打球");
    }
}
