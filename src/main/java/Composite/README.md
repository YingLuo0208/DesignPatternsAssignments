# Composite Pattern - Organization Structure | 组合模式 - 组织结构

## File Descriptions | 文件说明

### 1. **OrganizationComponent.java** - Abstract Component | 抽象组件

**Role**: Component (Abstract Base Class)  
**角色**：组件（抽象基类）

Base class for all organization structure components (departments and employees).  
所有组织结构组件（部门和员工）的基类。

**Common Properties | 共同属性**:
- `protected String name` - Component name | 组件名称

**Common Methods | 共同方法**:
- `String getName()` - Get component name | 获取组件名称
- `void add(OrganizationComponent)` - Add child component | 添加子组件
- `void remove(OrganizationComponent)` - Remove child component | 移除子组件
- `abstract double getSalary()` - Get total salary | 获取总薪资
- `abstract void printXML(int indent)` - Print in XML format | 打印XML格式

---

### 2. **Employee.java** - Employee (Leaf) | 员工（叶子节点）

**Role**: Leaf  
**角色**：叶子节点

Represents an employee in the organization (leaf node in composite pattern).  
代表组织中的员工（组合模式中的叶子节点）。

**Properties | 属性**:
- `String name` - Employee name | 员工姓名
- `double salary` - Employee salary | 员工薪资

**Methods | 方法**:
- `double getSalary()` - Returns employee's salary | 返回员工薪资
- `void setSalary(double)` - Set employee's salary | 设置员工薪资
- `void printXML(int)` - Print employee in XML format | 打印员工的XML格式

**XML Format | XML格式**:
```xml
<Employee name="Alice Johnson" salary="85000.0" />
```

---

### 3. **Department.java** - Department (Composite) | 部门（组合节点）

**Role**: Composite  
**角色**：组合节点

Represents a department that can contain employees and sub-departments.  
代表可以包含员工和子部门的部门。

**Properties | 属性**:
- `String name` - Department name | 部门名称
- `List<OrganizationComponent> children` - Child components | 子组件列表

**Methods | 方法**:
- `void add(OrganizationComponent)` - Add employee or sub-department | 添加员工或子部门
- `void remove(OrganizationComponent)` - Remove child component | 移除子组件
- `List<OrganizationComponent> getChildren()` - Get all children | 获取所有子组件
- `double getSalary()` - Returns total salary of all children | 返回所有子组件的总薪资
- `void printXML(int)` - Print department structure in XML | 打印部门结构的XML格式

**XML Format | XML格式**:
```xml
<Department name="Technology">
  <Employee name="Alice Johnson" salary="85000.0" />
  <Department name="Development">
    <Employee name="Charlie Brown" salary="70000.0" />
  </Department>
</Department>
```

---

### 4. **Main.java** - Main Application | 主程序

**Role**: Client  
**角色**：客户端

Demonstrates the Composite pattern by creating and manipulating an organization structure.  
通过创建和操作组织结构来演示组合模式。

**Features | 功能**:
- Creates a multi-level organization structure | 创建多层级组织结构
- Calculates and displays total salary | 计算并显示总薪资
- Prints organization structure in XML format | 打印XML格式的组织结构
- Demonstrates dynamic add and remove operations | 演示动态添加和移除操作

---

## How to Run | 运行方法

### Compile | 编译
```bash
mvn compile
```

### Run | 运行
```bash
java -cp target/classes Composite.Main
```

### Expected Output | 预期输出
```
=== Composite Pattern - Organization Structure Demo ===

--- Total Salary ---
Total Organization Salary: $758000.0

--- Organization Structure in XML ---
<?xml version="1.0" encoding="UTF-8"?>
<Department name="TechCorp">
  <Department name="Technology">
    <Employee name="Alice Johnson" salary="85000.0" />
    <Employee name="Bob Smith" salary="75000.0" />
    <Department name="Development">
      <Employee name="Charlie Brown" salary="70000.0" />
      <Employee name="Diana Prince" salary="72000.0" />
    </Department>
    <Department name="Quality Assurance">
      <Employee name="Eve Davis" salary="65000.0" />
      <Employee name="Frank Miller" salary="63000.0" />
    </Department>
  </Department>
  <Department name="Human Resources">
    <Employee name="Grace Lee" salary="60000.0" />
    <Employee name="Henry Wilson" salary="58000.0" />
  </Department>
  <Department name="Sales">
    <Employee name="Ivy Chen" salary="55000.0" />
    <Employee name="Jack Robinson" salary="53000.0" />
    <Department name="Regional Sales">
      <Employee name="Kate Morgan" salary="50000.0" />
      <Employee name="Leo Martinez" salary="52000.0" />
    </Department>
  </Department>
</Department>

============================================================
--- Demonstrating Dynamic Operations ---

Initial total salary: $758000.0

Adding new Marketing Department with 2 employees...
New total salary: $884000.0

Removing Regional Sales department from Sales...
Regional Sales department removed.
Final total salary: $782000.0

--- Final Organization Structure ---
<?xml version="1.0" encoding="UTF-8"?>
<Department name="TechCorp">
  <Department name="Technology">
    <Employee name="Alice Johnson" salary="85000.0" />
    <Employee name="Bob Smith" salary="75000.0" />
    <Department name="Development">
      <Employee name="Charlie Brown" salary="70000.0" />
      <Employee name="Diana Prince" salary="72000.0" />
    </Department>
    <Department name="Quality Assurance">
      <Employee name="Eve Davis" salary="65000.0" />
      <Employee name="Frank Miller" salary="63000.0" />
    </Department>
  </Department>
  <Department name="Human Resources">
    <Employee name="Grace Lee" salary="60000.0" />
    <Employee name="Henry Wilson" salary="58000.0" />
  </Department>
  <Department name="Sales">
    <Employee name="Ivy Chen" salary="55000.0" />
    <Employee name="Jack Robinson" salary="53000.0" />
  </Department>
  <Department name="Marketing">
    <Employee name="Mike Taylor" salary="62000.0" />
    <Employee name="Nina Patel" salary="64000.0" />
  </Department>
</Department>
```
