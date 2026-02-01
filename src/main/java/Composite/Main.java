package Composite;

/**
 * Main - 主程序类
 * Main application class demonstrating the Composite pattern
 * 演示组合模式的主程序
 */
public class Main {
    /**
     * 程序入口
     * Program entry point
     * @param args 命令行参数 | Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern - Organization Structure Demo ===\n");

        // 创建组织结构
        // Create organization structure
        OrganizationComponent organization = buildOrganization();

        // 打印总薪资
        // Print total salary
        System.out.println("--- Total Salary ---");
        System.out.println("Total Organization Salary: $" + organization.getSalary());
        System.out.println();

        // 打印XML格式的组织结构
        // Print organization structure in XML format
        System.out.println("--- Organization Structure in XML ---");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        organization.printXML(0);
        System.out.println();

        // 演示动态添加和移除
        // Demonstrate dynamic add and remove
        demonstrateDynamicOperations(organization);
    }

    /**
     * 构建组织结构
     * Build organization structure
     * @return 组织根部门 | Root department of organization
     */
    private static OrganizationComponent buildOrganization() {
        // 创建公司（根部门）
        // Create company (root department)
        Department company = new Department("TechCorp");

        // 创建技术部门
        // Create Technology Department
        Department techDept = new Department("Technology");
        techDept.add(new Employee("Alice Johnson", 85000));
        techDept.add(new Employee("Bob Smith", 75000));

        // 创建技术部门的子部门
        // Create sub-departments of Technology
        Department devTeam = new Department("Development");
        devTeam.add(new Employee("Charlie Brown", 70000));
        devTeam.add(new Employee("Diana Prince", 72000));

        Department qaTeam = new Department("Quality Assurance");
        qaTeam.add(new Employee("Eve Davis", 65000));
        qaTeam.add(new Employee("Frank Miller", 63000));

        techDept.add(devTeam);
        techDept.add(qaTeam);

        // 创建人力资源部门
        // Create Human Resources Department
        Department hrDept = new Department("Human Resources");
        hrDept.add(new Employee("Grace Lee", 60000));
        hrDept.add(new Employee("Henry Wilson", 58000));

        // 创建销售部门
        // Create Sales Department
        Department salesDept = new Department("Sales");
        salesDept.add(new Employee("Ivy Chen", 55000));
        salesDept.add(new Employee("Jack Robinson", 53000));

        Department regionalSales = new Department("Regional Sales");
        regionalSales.add(new Employee("Kate Morgan", 50000));
        regionalSales.add(new Employee("Leo Martinez", 52000));

        salesDept.add(regionalSales);

        // 将所有部门添加到公司
        // Add all departments to company
        company.add(techDept);
        company.add(hrDept);
        company.add(salesDept);

        return company;
    }

    /**
     * 演示动态添加和移除操作
     * Demonstrate dynamic add and remove operations
     * @param organization 组织结构 | Organization structure
     */
    private static void demonstrateDynamicOperations(OrganizationComponent organization) {
        System.out.println("=".repeat(60));
        System.out.println("--- Demonstrating Dynamic Operations ---\n");

        // 获取公司（根部门）
        // Get company (root department)
        Department company = (Department) organization;

        System.out.println("Initial total salary: $" + company.getSalary());
        System.out.println();

        // 添加新部门和员工
        // Add new department and employees
        System.out.println("Adding new Marketing Department with 2 employees...");

        Department marketingDept = new Department("Marketing");
        marketingDept.add(new Employee("Mike Taylor", 62000));
        marketingDept.add(new Employee("Nina Patel", 64000));

        company.add(marketingDept);

        System.out.println("New total salary: $" + company.getSalary());
        System.out.println();

        // 从销售部门移除区域销售部
        // Remove regional sales from sales department
        System.out.println("Removing Regional Sales department from Sales...");

        // 找到销售部门
        // Find sales department
        Department salesDept = null;
        for (OrganizationComponent comp : company.getChildren()) {
            if (comp.getName().equals("Sales")) {
                salesDept = (Department) comp;
                break;
            }
        }

        if (salesDept != null) {
            // 找到区域销售部
            // Find regional sales department
            OrganizationComponent regionalSales = null;
            for (OrganizationComponent comp : salesDept.getChildren()) {
                if (comp.getName().equals("Regional Sales")) {
                    regionalSales = comp;
                    break;
                }
            }

            if (regionalSales != null) {
                salesDept.remove(regionalSales);
                System.out.println("Regional Sales department removed.");
            }
        }

        System.out.println("Final total salary: $" + company.getSalary());
        System.out.println();

        // 打印最终的组织结构
        // Print final organization structure
        System.out.println("--- Final Organization Structure ---");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        company.printXML(0);
    }
}

