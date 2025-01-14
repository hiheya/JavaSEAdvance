package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 12:55
 * @Description
 */
public interface ICharge {
    void charge();
}

interface IPlay {
    void play();
}

class Bus implements ICharge {
    @Override
    public void charge() {
        System.out.println("公交车 票价 1元/张, 不记公里数");
    }
}
class Taxi implements ICharge {
    @Override
    public void charge() {
        System.out.println("出租车 票价 1.6元/公里, 起家三公里");
    }
}

class Cinema implements ICharge, IPlay {
    @Override
    public void charge() {
        System.out.println("解放电影院：30元/张，凭学生证享受半价。");
        play();
    }

    @Override
    public void play() {
        System.out.println("正在放映");
    }
}