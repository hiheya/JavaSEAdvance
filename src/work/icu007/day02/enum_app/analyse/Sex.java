package work.icu007.day02.enum_app.analyse;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 2:07
 * @Description
 */
public enum Sex {
    GIRL("女孩"), BOY("男孩");

    public String getName() {
        return name;
    }

    private String name;

    Sex(String name) {
        this.name = name;
    }
}
