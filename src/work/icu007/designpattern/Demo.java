package work.icu007.designpattern;

/**
 * @Author {xiheya}
 * @Date: 2024/04/08/ 21:39
 * @Description
 */
public abstract class Demo {

    // 作文
    public void writeComposition() {
        // 头部
        head();
        // 正文
        context();
        // 尾部
        end();
    }

    public abstract void context();

    private void head() {
        System.out.println("我来组成头部");
    }

    private void end() {
        System.out.println("我来组成尾部");
    }
}
