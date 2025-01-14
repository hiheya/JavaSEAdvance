package work.icu007.day02.work;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/14/ 12:25
 * @Description
 */
/*
1. 请定义“员工(类)”：
   属性：姓名、性别、年龄(全部私有)
   行为：工作(抽象)
   无参、全参构造方法
   get/set方法

2. 请定义“绘画(接口)”
   抽象方法：绘画
3. 请定义“Java讲师类”继承自“员工类”
4. 请定义”UI讲师类”，继承自“员工类”，并实现“绘画”接口。
 */
public abstract class Staff {
    private String name;
    private String gender;
    private int age;

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Staff() {
    }

    public Staff(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

interface IPaint {
    void painting();
}

class JavaLecturer extends Staff{

    public JavaLecturer() {
    }

    public JavaLecturer(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void work() {
        System.out.println("我是" + super.getName() + ",  " + super.getGender() +", " + super.getAge() +  "岁, 一名Java讲师, 我的工作是讲解Java知识");
    }
}

class UILecturer extends Staff implements IPaint{
    public UILecturer() {
    }

    public UILecturer(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void work() {
        System.out.println("我是" + super.getName() + ", " + super.getGender() +", " + super.getAge() +  "岁, 一名UI讲师, 我的工作是讲解UI知识");
    }

    @Override
    public void painting() {
        System.out.println("我还会画画");
    }
}