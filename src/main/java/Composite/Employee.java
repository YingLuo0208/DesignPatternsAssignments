package Composite;

/**
 * Employee - 员工类
 * Employee class (Leaf in Composite pattern)
 * 组合模式中的叶子节点，代表组织中的员工
 */
public class Employee extends OrganizationComponent {
    /**
     * 员工薪资
     * Employee salary
     */
    private double salary;

    /**
     * 构造函数
     * Constructor
     * @param name 员工姓名 | Employee name
     * @param salary 员工薪资 | Employee salary
     */
    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    /**
     * 获取员工薪资
     * Get employee salary
     * @return 薪资 | Salary
     */
    @Override
    public double getSalary() {
        return salary;
    }

    /**
     * 设置员工薪资
     * Set employee salary
     * @param salary 新薪资 | New salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 打印员工的XML格式
     * Print employee in XML format
     * @param indent 缩进级别 | Indentation level
     */
    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }

    /**
     * 获取员工信息字符串
     * Get employee information string
     * @return 员工信息 | Employee information
     */
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

