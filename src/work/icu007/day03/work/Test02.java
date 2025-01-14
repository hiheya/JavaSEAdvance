package work.icu007.day03.work;
/*
**需求：**

模拟公司给员工发工资，代码实现，执行效果如图所示：



参考下面的继承结构图完成相关代码的设计：

1、程序员和经理都属于员工，使用继承完成相关类的设计

2、员工作为父类，为其提供带参的构造函数，子类的有参构造需调用父类的有参构造

3、创建接口Money，定义发工资功能，为员工发工资。

4、公司类中定义总资金属性，实现Money接口，通过总资金扣除员工的工资，得出发工资后工资剩余的总资金

5、创建测试类，在main方法中创建经理对象，程序员对象，及公司对象。调用方法给经理和程序员发工资。
 */
public class Test02 {
    public static void main(String[] args) {
        Employee programmer = new Programmer("张三", 10000);
        Employee manager = new Manager("李四", 20000);
        Company company = new Company(1000000);
        company.paySalary(programmer);
        company.paySalary(manager);
    }
}

class Employee {
    public String getName() {
        return name;
    }

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        System.out.println("员工" + name + "的工资为：" + salary);
        return salary;
    }
}

class Programmer extends Employee {
    public Programmer(String name, double salary) {
        super(name, salary);
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }
}

interface Money {
    void paySalary(Employee employee);
}

class Company implements Money {
    private double totalMoney;

    public Company(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public void paySalary(Employee employee) {
        double employeeSalary = employee.getSalary();
        totalMoney = totalMoney - employeeSalary;
        System.out.println("给" + employee.getName() + "发工资 " + employeeSalary + "元，公司剩余资金：" + totalMoney);
    }
}
