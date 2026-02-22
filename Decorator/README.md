# Decorator Pattern - 装饰器模式

## Brief Explanation (简短英文说明)

**English:**  
This project implements the Decorator design pattern with 6 Java files:
- **Printer.java**: Abstract base class defining the `print()` interface
- **BasicPrinter.java**: Concrete component that outputs messages directly
- **PrinterDecorator.java**: Abstract decorator that holds a reference to a wrapped Printer
- **EncryptedPrinter.java**: Concrete decorator that encrypts messages using Caesar cipher
- **XMLPrinter.java**: Concrete decorator that wraps messages in XML tags
- **Main.java**: Demo program showing different decorator combinations

The implementation approach is: all components and decorators inherit from the same `Printer` abstract class. Decorators wrap another Printer object and add behavior before delegating to it. This allows flexible runtime composition - you can chain decorators in any order to combine functionalities like encryption and XML formatting.

**中文：**  
本项目使用 6 个 Java 文件实现装饰器设计模式：
- **Printer.java**：抽象基类，定义 `print()` 接口
- **BasicPrinter.java**：具体组件，直接输出消息
- **PrinterDecorator.java**：抽象装饰器，持有被包装的 Printer 引用
- **EncryptedPrinter.java**：具体装饰器，使用凯撒密码加密消息
- **XMLPrinter.java**：具体装饰器，用 XML 标签包装消息
- **Main.java**：演示程序，展示不同装饰器组合

实现思路：所有组件和装饰器都继承同一个 `Printer` 抽象类。装饰器内部持有另一个 Printer 对象，在委托调用前添加额外行为。这允许运行时灵活组合——可以按任意顺序链接装饰器，组合加密和 XML 格式化等功能。

---

## 文件结构 / File Structure

```
Decorator/
├── pom.xml                          # Maven 配置文件
├── README.md                        # 本文档
└── src/main/java/
    ├── Printer.java                 # 抽象基类（定义打印接口）
    ├── BasicPrinter.java            # 具体组件（基础打印器）
    ├── PrinterDecorator.java        # 抽象装饰器
    ├── EncryptedPrinter.java        # 具体装饰器（加密功能）
    ├── XMLPrinter.java              # 具体装饰器（XML 格式化）
    └── Main.java                    # 演示程序
```

---

## 各文件详解 / File Details

### 1. **Printer.java** - 抽象基类
**位置**：`src/main/java/Printer.java`  
**作用**：定义打印器的统一接口

**关键点**：
- 抽象类，所有打印器都必须继承它
- 定义了抽象方法 `print(String message)`
- 确保装饰器和被装饰对象具有相同的接口

**代码结构**：
```java
public abstract class Printer {
    public abstract void print(String message);
}
```

---

### 2. **BasicPrinter.java** - 基础打印器
**位置**：`src/main/java/BasicPrinter.java`  
**作用**：最基础的打印实现，直接输出原始消息

**关键点**：
- 继承 `Printer` 抽象类
- 实现 `print()` 方法，直接调用 `System.out.println()`
- 这是被装饰的核心对象，装饰链的终点

**代码逻辑**：
```java
public class BasicPrinter extends Printer {
    @Override
    public void print(String message) {
        System.out.println(message);  // 直接输出
    }
}
```

---

### 3. **PrinterDecorator.java** - 抽象装饰器
**位置**：`src/main/java/PrinterDecorator.java`  
**作用**：装饰器的基类，持有被装饰对象的引用

**关键点**：
- 继承 `Printer`（与被装饰对象同接口）
- 持有 `protected final Printer inner` 成员变量
- 通过构造函数注入被装饰对象
- 抽象类，具体装饰逻辑由子类实现

**代码结构**：
```java
public abstract class PrinterDecorator extends Printer {
    protected final Printer inner;  // 被装饰的对象
    
    public PrinterDecorator(Printer inner) {
        this.inner = inner;
    }
}
```

---

### 4. **EncryptedPrinter.java** - 加密装饰器
**位置**：`src/main/java/EncryptedPrinter.java`  
**作用**：在打印前对消息进行加密

**关键点**：
- 继承 `PrinterDecorator`
- 使用凯撒密码（Caesar Cipher）进行加密：字母循环移位
- 默认移位量是 3（H→K, e→h）
- 提供 `public static decrypt()` 方法用于解密

**工作流程**：
```
原始消息 → encrypt() 加密 → 传给 inner.print() → 输出加密文本
```

**加密算法示例**：
```
"Hello World!" → "Khoor Zruog!"
H(+3)→K, e(+3)→h, l(+3)→o, ...
```

---

### 5. **XMLPrinter.java** - XML 格式化装饰器
**位置**：`src/main/java/XMLPrinter.java`  
**作用**：将消息包装为 XML 格式

**关键点**：
- 继承 `PrinterDecorator`
- 将消息包装为 `<message>...</message>`
- 对特殊字符进行 XML 转义（& → &amp;, < → &lt;）

**工作流程**：
```
原始消息 → toXml() 包装 → 传给 inner.print() → 输出 XML
```

**转换示例**：
```
"Hello World!" → "<message>Hello World!</message>"
```

---

### 6. **Main.java** - 演示程序
**位置**：`src/main/java/Main.java`  
**作用**：演示装饰器模式的各种用法

**包含 6 个演示场景**：

1. **基础打印器**：直接输出原始消息
2. **XML 装饰器**：单独使用 XML 格式化
3. **加密装饰器**：单独使用凯撒加密
4. **先加密后 XML**：内容被加密，XML 标签不加密
5. **先 XML 后加密**：内容和 XML 标签都被加密
6. **解密演示**：展示解密功能

---

## 装饰器顺序的重要性 / Order Matters

**关键理解**：装饰器的包装顺序决定了处理顺序！

| 代码 | 处理顺序 | 输出 |
|------|---------|------|
| `new EncryptedPrinter(new XMLPrinter(...))` | 先加密内容 → 再包装 XML | `<message>Khoor Zruog!</message>` |
| `new XMLPrinter(new EncryptedPrinter(...))` | 先包装 XML → 再加密全部 | `<phvvdjh>Khoor Zruog!</phvvdjh>` |

**原理**：外层装饰器先处理消息，然后传给内层。调用顺序是从外到内。

---

## 运行方法 / How to Run

### **方法 1：使用 Maven 编译并运行（推荐）**
```bash
# 在项目根目录执行
# 1. 编译
mvn -pl Decorator -am clean compile

# 2. 运行
java -cp Decorator/target/classes Main
```

### **方法 2：在 IDE 中运行**
1. 打开 `src/main/java/Main.java`
2. 右键点击 `main` 方法
3. 选择 "Run Main.main()"

### **预期输出**
```
=== Basic Printer ===
Hello World!

=== XML Printer ===
<message>Hello World!</message>

=== Encrypted Printer ===
Khoor Zruog!

=== XML + Encrypted Printer ===
<message>Khoor Zruog!</message>

=== Encrypted + XML Printer (different order) ===
<phvvdjh>Khoor Zruog!</phvvdjh>

=== Demonstration of Decryption ===
Original: Hello World!
Encrypted: Khoor Zruog!
Decrypted: Hello World!
```

---
