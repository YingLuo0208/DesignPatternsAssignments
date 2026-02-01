# Abstract Factory Pattern - Code Files | 抽象工厂模式 - 代码文件

## File Descriptions | 文件说明

### 1. **Widget.java** - Abstract Widget Base Class | 组件抽象基类

**Role**: Abstract Base Class  
**角色**：抽象基类

Base class for all UI widget types (Button, TextField, Checkbox).  
所有UI组件类型（按钮、文本框、复选框）的基类。

**Purpose | 目的**:
- Eliminates code duplication | 消除代码重复
- Provides common properties and methods | 提供共同的属性和方法
- Establishes a clear inheritance hierarchy | 建立清晰的继承层次

**Common Properties | 共同属性**:
- `protected String text` - Text content of the widget | 组件的文本内容

**Common Methods | 共同方法**:
- `abstract void display()` - Display the widget | 显示组件
- `void setText(String text)` - Change widget text | 更改组件文本
- `String getText()` - Get widget text | 获取组件文本

---

### 2. **Button.java** - Abstract Button Class | 按钮抽象类

**Role**: Abstract Product (extends Widget)  
**角色**：抽象产品（继承自 Widget）

Base class for all button implementations, inherits common functionality from Widget.  
所有按钮实现的基类，从 Widget 继承共同功能。

---

### 3. **TextField.java** - Abstract TextField Class | 文本框抽象类

**Role**: Abstract Product (extends Widget)  
**角色**：抽象产品（继承自 Widget）

Base class for all text field implementations, inherits common functionality from Widget.  
所有文本框实现的基类，从 Widget 继承共同功能。

---

### 4. **Checkbox.java** - Abstract Checkbox Class | 复选框抽象类

**Role**: Abstract Product (extends Widget)  
**角色**：抽象产品（继承自 Widget）

Base class for all checkbox implementations, inherits common functionality from Widget.  
所有复选框实现的基类，从 Widget 继承共同功能。

---

### 5. **ButtonA.java** - Style A Button | 样式A按钮

**Role**: Concrete Product  
**角色**：具体产品

Button with Style A - uses rounded corners with `=` and `|`.  
样式A的按钮 - 使用 `=` 和 `|` 绘制圆角边框。

**Display Style | 显示样式**:
```
=================
| Click Me |
=================
```

---

### 6. **TextFieldA.java** - Style A TextField | 样式A文本框

**Role**: Concrete Product  
**角色**：具体产品

Text field with Style A - uses single line border with `-` and `|`.  
样式A的文本框 - 使用 `-` 和 `|` 绘制单线边框。

**Display Style | 显示样式**:
```
+------------------+
| Enter text here |
+------------------+
```

---

### 7. **CheckboxA.java** - Style A Checkbox | 样式A复选框

**Role**: Concrete Product  
**角色**：具体产品

Checkbox with Style A - uses square brackets `[ ]`.  
样式A的复选框 - 使用方括号 `[ ]`。

**Display Style | 显示样式**:
```
[ ] Accept terms
```

---

### 8. **ButtonB.java** - Style B Button | 样式B按钮

**Role**: Concrete Product  
**角色**：具体产品

Button with Style B - uses bold border with `#`.  
样式B的按钮 - 使用 `#` 绘制粗边框。

**Display Style | 显示样式**:
```
###############
# Click Me #
###############
```

---

### 9. **TextFieldB.java** - Style B TextField | 样式B文本框

**Role**: Concrete Product  
**角色**：具体产品

Text field with Style B - uses double line border with `=` and `*`.  
样式B的文本框 - 使用 `=` 和 `*` 绘制双线边框。

**Display Style | 显示样式**:
```
*==================*
| Enter text here |
*==================*
```

---

### 10. **CheckboxB.java** - Style B Checkbox | 样式B复选框

**Role**: Concrete Product  
**角色**：具体产品

Checkbox with Style B - uses angle brackets `< >`.  
样式B的复选框 - 使用尖括号 `< >`。

**Display Style | 显示样式**:
```
< > Accept terms
```

---

### 11. **UIFactory.java** - Abstract Factory | 抽象工厂

**Role**: Abstract Factory  
**角色**：抽象工厂

Defines the interface for creating UI elements.  
定义创建UI元素的接口。

**Methods | 方法**:
- `abstract Button createButton(String text)` - Create a button | 创建按钮
- `abstract TextField createTextField(String text)` - Create a text field | 创建文本框
- `abstract Checkbox createCheckbox(String text)` - Create a checkbox | 创建复选框

---

### 12. **AFactory.java** - Style A Factory | 样式A工厂

**Role**: Concrete Factory  
**角色**：具体工厂

Factory for creating Style A UI elements (rounded & simple style).  
创建样式A的UI元素工厂（圆角和简单风格）。

Creates instances of: `ButtonA`, `TextFieldA`, `CheckboxA`  
创建实例：`ButtonA`、`TextFieldA`、`CheckboxA`

---

### 13. **BFactory.java** - Style B Factory | 样式B工厂

**Role**: Concrete Factory  
**角色**：具体工厂

Factory for creating Style B UI elements (bold & double line style).  
创建样式B的UI元素工厂（粗体和双线风格）。

Creates instances of: `ButtonB`, `TextFieldB`, `CheckboxB`  
创建实例：`ButtonB`、`TextFieldB`、`CheckboxB`

---

### 14. **Main.java** - Main Application | 主程序

**Role**: Client  
**角色**：客户端

Demonstrates the Abstract Factory pattern by creating and displaying UI elements.  
通过创建和显示UI元素来演示抽象工厂模式。

**Features | 功能**:
- Creates UI elements using both Style A and Style B factories | 使用样式A和样式B工厂创建UI元素
- Demonstrates dynamic text changes using `setText()` method | 使用 `setText()` 方法演示动态文本更改

---

## How to Run | 运行方法

### Compile | 编译
```bash
mvn compile
```

### Run | 运行
```bash
java -cp target/classes AbstractFactory.Main
```

### Expected Output | 预期输出
```
=== Abstract Factory Pattern Demo ===
=== 抽象工厂模式演示 ===

--- Style A (Rounded & Simple) ---
--- 样式A（圆角和简单风格） ---

Button | 按钮:
================
| Click Me |
================

TextField | 文本框:
+------------------+
| Enter text here |
+------------------+

Checkbox | 复选框:
[ ] Accept terms
[ ] Subscribe to newsletter

==================================================

--- Style B (Bold & Double Line) ---
--- 样式B（粗体和双线风格） ---

Button | 按钮:
###############
# Click Me #
###############

TextField | 文本框:
*==================*
| Enter text here |
*==================*

Checkbox | 复选框:
< > Accept terms
< > Subscribe to newsletter

==================================================

--- Demonstrating Dynamic Text Change ---
--- 演示动态文本更改 ---

Original button | 原始按钮:
=================
| Original Text |
=================

Updated button | 更新后的按钮:
================
| Updated Text |
================
```


