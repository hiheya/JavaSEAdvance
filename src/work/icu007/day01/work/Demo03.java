package work.icu007.day01.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author {xiheya}
 * @Date: 2024/04/09/ 21:05
 * @Description
 */

/*

1、定义员工Employee类,该类具有如下成员:

```java
(1) 属性：姓名(name,字符串类型)，工号(workId,字符串类型)，部门(dept,字符串类型),属性私有
(2) 方法:
		1. 空参数构造和满参数构造
		2. 提供属性的set/get方法
		3. 定义showMsg方法抽象方法
```

2、定义经理Manager类继承Employee类，该类具有如下成员:

```
(1) 属性:职员Clerk(该经理的职员)
(2) 方法:
		1. 空参数构造方法和满参数构造方法
		2. 属性的get和set方法
		3. 重写父类的showMsg方法，按照要求实现信息打印

public class 经理{
     //属性： 经理的下级
     Clerk  c;
}
```

3、定义职员Clerk类继承Employee类，该类具有如下成员:

```
(1) 属性:经理Manager(该职员的经理)
(2) 方法:
		1. 空参数构造方法和满参数构造方法
		2. 属性的get和set方法
		3. 重写父类的showMsg方法，按照要求实现信息打印


public class 职员{
     //属性： 职员的上级
     Manager m;


}

```
4、创建Test测试类，测试类中创建main方法，main方法中创建经理对象和职员对象，信息分别如下:


```java
经理：工号为 M001,名字为 张小强，部门为 销售部
职员：工号为 C001,名字为 李小亮，部门为 销售部

经理的职员为李小亮，职员的经理为张小强
```

分别调用经理的showMsg方法和职员的showMsg方法打印结果：
 */
public class Demo03 {
    public static void main(String[] args) {
        List<String> clerks = new ArrayList<>();
        clerks.add("李小亮");
        clerks.add("王小明");
        clerks.add("张小宝");
        Manager manager = new Manager("张小强", "M001", "销售部", clerks);
        Clerk clerk = new Clerk("李小亮", "C001", "销售部", "张小强");
        manager.showMsg();
        clerk.showMsg();
    }

}

/*
1、定义员工Employee类,该类具有如下成员:

```java
(1) 属性：姓名(name,字符串类型)，工号(workId,字符串类型)，部门(dept,字符串类型),属性私有
(2) 方法:
		1. 空参数构造和满参数构造
		2. 提供属性的set/get方法
		3. 定义showMsg方法抽象方法
```
 */

abstract class Employee {
    String name;
    String workId;
    private String dept;

    public Employee() {
    }

    public Employee(String name, String workId, String dept) {
        this.name = name;
        this.workId = workId;
        this.dept = dept;
    }

    public abstract void showMsg();

    @Override
    public String toString() {
        return dept + "的: " + name + ", 员工编号是" + workId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}

/*
2、定义经理Manager类继承Employee类，该类具有如下成员:

        ```
        (1) 属性:职员Clerk(该经理的职员)
        (2) 方法:
        1. 空参数构造方法和满参数构造方法
        2. 属性的get和set方法
        3. 重写父类的showMsg方法，按照要求实现信息打印

public class 经理{
    //属性： 经理的下级
    Clerk  c;
}
```
*/
class Manager extends Employee {
    private List<String> clerks;

    public Manager(String name, String workId, String dept, List<String>  clerks) {
        super(name, workId, dept);
        this.clerks = clerks;
    }

    public List<String>  getClerks() {
        return clerks;
    }

    public void setClerks(List<String>  clerks) {
        this.clerks = clerks;
    }

    public Manager(List<String>  clerks) {
        this.clerks = clerks;
    }

    @Override
    public void showMsg() {
        System.out.println(getDept() + "的: " + getName() + " 员工编号: " + getWorkId() + " 他的职员是: " + clerks.toString());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                '}';
    }
}

/*
3、定义职员Clerk类继承Employee类，该类具有如下成员:

```
(1) 属性:经理Manager(该职员的经理)
(2) 方法:
		1. 空参数构造方法和满参数构造方法
		2. 属性的get和set方法
		3. 重写父类的showMsg方法，按照要求实现信息打印


public class 职员{
     //属性： 职员的上级
     Manager m;


}
 */
class Clerk extends Employee {
    String manager;

    public Clerk() {
    }

    public Clerk(String name, String workId, String dept, String manager) {
        super(name, workId, dept);
        this.manager = manager;
    }

    @Override
    public void showMsg() {
        System.out.println(getDept() + "的: " + getName() + " 员工编号: " + getWorkId() + " 他的职员是: " + manager);
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + name + '\'' +
                '}';
    }
}