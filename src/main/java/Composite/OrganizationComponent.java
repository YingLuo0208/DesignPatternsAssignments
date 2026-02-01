package Composite;

/**
 * OrganizationComponent - 组织组件抽象类
 * Abstract base class for organization structure components
 * 组织结构组件的抽象基类（组合模式的 Component）
 */
public abstract class OrganizationComponent {
    /**
     * 组件名称
     * Component name
     */
    protected String name;

    /**
     * 构造函数
     * Constructor
     * @param name 组件名称 | Component name
     */
    public OrganizationComponent(String name) {
        this.name = name;
    }

    /**
     * 获取组件名称
     * Get component name
     * @return 名称 | Name
     */
    public String getName() {
        return name;
    }

    /**
     * 添加子组件
     * Add a child component
     * 默认实现抛出异常，只有部门（Composite）需要重写此方法
     * @param component 子组件 | Child component
     */
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf component");
    }

    /**
     * 移除子组件
     * Remove a child component
     * 默认实现抛出异常，只有部门（Composite）需要重写此方法
     * @param component 子组件 | Child component
     */
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf component");
    }

    /**
     * 获取总薪资
     * Get total salary
     * 由子类实现
     * @return 总薪资 | Total salary
     */
    public abstract double getSalary();

    /**
     * 打印XML格式的组织结构
     * Print organization structure in XML format
     * 由子类实现
     * @param indent 缩进级别 | Indentation level
     */
    public abstract void printXML(int indent);

    /**
     * 获取缩进字符串
     * Get indentation string
     * @param level 缩进级别 | Indentation level
     * @return 缩进字符串 | Indentation string
     */
    protected String getIndent(int level) {
        return "  ".repeat(level);
    }
}

