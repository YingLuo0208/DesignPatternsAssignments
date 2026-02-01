package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Department - 部门类
 * Department class (Composite in Composite pattern)
 * 组合模式中的组合节点，可以包含员工和子部门
 */
public class Department extends OrganizationComponent {
    /**
     * 子组件列表（员工和子部门）
     * List of child components (employees and sub-departments)
     */
    private List<OrganizationComponent> children;

    /**
     * 构造函数
     * Constructor
     * @param name 部门名称 | Department name
     */
    public Department(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    /**
     * 添加子组件（员工或子部门）
     * Add a child component (employee or sub-department)
     * @param component 子组件 | Child component
     */
    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    /**
     * 移除子组件
     * Remove a child component
     * @param component 子组件 | Child component
     */
    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    /**
     * 获取所有子组件
     * Get all child components
     * @return 子组件列表 | List of child components
     */
    public List<OrganizationComponent> getChildren() {
        return children;
    }

    /**
     * 获取部门总薪资（包括所有子部门和员工）
     * Get total salary of department (including all sub-departments and employees)
     * @return 总薪资 | Total salary
     */
    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationComponent component : children) {
            total += component.getSalary();
        }
        return total;
    }

    /**
     * 打印部门的XML格式
     * Print department in XML format
     * @param indent 缩进级别 | Indentation level
     */
    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Department name=\"" + name + "\">");

        // 递归打印所有子组件
        // Recursively print all child components
        for (OrganizationComponent component : children) {
            component.printXML(indent + 1);
        }

        System.out.println(getIndent(indent) + "</Department>");
    }

    /**
     * 获取部门信息字符串
     * Get department information string
     * @return 部门信息 | Department information
     */
    @Override
    public String toString() {
        return "Department{name='" + name + "', children=" + children.size() + ", totalSalary=" + getSalary() + "}";
    }
}

