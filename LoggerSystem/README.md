# Singleton Pattern - Logger System
# 单例模式 - 日志记录器系统

## Overview / 概述

This project demonstrates the Singleton design pattern through a Logger system that writes log messages to files. The Logger ensures only one instance exists throughout the application lifecycle.

本项目通过日志记录器系统演示单例设计模式。日志记录器确保整个应用程序生命周期中只存在一个实例。

## Code Files / 代码文件

### 1. Logger.java
Singleton class that manages log file writing. Key features:
- Thread-safe singleton implementation
- Dynamic file name changing
- Automatic file opening and closing
- Safe exception handling for I/O operations

单例类，管理日志文件写入。主要特性：
- 线程安全的单例实现
- 动态更改文件名
- 自动文件打开和关闭
- I/O操作的安全异常处理

### 2. Main.java
Entry point that demonstrates the Logger functionality including:
- Basic log writing
- Changing log file dynamically
- Singleton verification
- Multi-threaded environment testing

入口点，演示日志记录器功能，包括：
- 基本日志写入
- 动态更改日志文件
- 单例验证
- 多线程环境测试

## How to Run / 运行方式

### Using Command Line / 使用命令行

```bash
# Navigate to the LoggerSystem directory
# 导航到 LoggerSystem 目录
cd C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments\LoggerSystem

# Compile the code
# 编译代码
javac -encoding UTF-8 -d target/classes src/main/java/singleton/logger/*.java

# Run the program
# 运行程序
java -cp target/classes singleton.logger.Main
```

### Using Maven / 使用 Maven

```bash
# Navigate to the LoggerSystem directory
# 导航到 LoggerSystem 目录
cd C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments\LoggerSystem

# Compile the project
# 编译项目
mvn compile

# Run the Main class
# 运行 Main 类
mvn exec:java -Dexec.mainClass="singleton.logger.Main"
```

### Using IDE / 使用集成开发环境

Right-click on `Main.java` and select "Run Main.main()"

右键点击 `Main.java` 并选择 "Run Main.main()"

## Expected Output / 预期输出

The program will:
1. Create a Logger instance with default file "application.log"
2. Write several log messages to the default file
3. Change the log file to "new_log.txt" and write more messages
4. Verify that getInstance() always returns the same instance
5. Test multi-threaded logging
6. Close the logger gracefully

程序将：
1. 创建带有默认文件 "application.log" 的Logger实例
2. 向默认文件写入多条日志消息
3. 将日志文件更改为 "new_log.txt" 并写入更多消息
4. 验证 getInstance() 始终返回相同的实例
5. 测试多线程日志记录
6. 优雅地关闭日志记录器

## Generated Files / 生成的文件

After running the program, you will find two log files in the project directory:
- `application.log` - Contains the first three log messages
- `new_log.txt` - Contains subsequent log messages

运行程序后，您将在项目目录中找到两个日志文件：
- `application.log` - 包含前三条日志消息
- `new_log.txt` - 包含后续的日志消息

