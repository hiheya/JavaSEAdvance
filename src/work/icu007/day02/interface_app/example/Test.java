package work.icu007.day02.interface_app.example;

public class Test {
    public static void main(String[] args) {
        //创建男学习同学
        StudyBoy studyBoy = new StudyBoy("张三", 12);
        studyBoy.study();

        //创建男篮同学
        BasketBallBoy basketBallBoy = new BasketBallBoy("李四", 13);
        basketBallBoy.study();
        basketBallBoy.playBasketBall();
        System.out.println("====================================================");
        //创建女学习同学
        StudyGirl studyGirl = new StudyGirl("王笑笑", 12);
        studyGirl.study();

        //创建男篮同学
        BasketBallGirl basketBallGirl = new BasketBallGirl("李娇娇", 13);
        basketBallGirl.study();
        basketBallGirl.playBasketBall();
    }
}
