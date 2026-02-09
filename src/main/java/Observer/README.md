# Observer Pattern - Weather Station Simulator
# 观察者模式 - 气象站模拟器

## Overview / 概述

This project demonstrates the Observer design pattern through a weather station simulator. The weather station runs in a separate thread and notifies registered observers whenever the temperature changes.

本项目通过气象站模拟器演示观察者设计模式。气象站在独立线程中运行，当温度变化时通知已注册的观察者。

## Code Files / 代码文件

### 1. Observer.java
Interface that defines the observer contract. All observers must implement the `update()` method.

定义观察者契约的接口。所有观察者必须实现 `update()` 方法。

### 2. WeatherObserver.java
Concrete implementation of the Observer interface. Displays unique messages when temperature changes.

Observer接口的具体实现。当温度变化时显示独特的消息。

### 3. Observable.java
Abstract class that manages observer registration, removal, and notification.

管理观察者注册、移除和通知的抽象类。

### 4. WeatherStation.java
Concrete observable that runs in a separate thread. Periodically updates temperature and notifies observers.

在独立线程中运行的具体被观察者。定期更新温度并通知观察者。

### 5. Main.java
Entry point that demonstrates the weather station functionality with multiple observers.

演示多个观察者的气象站功能的入口点。

## How to Run / 运行方式

### Using Command Line / 使用命令行

```bash
# Navigate to the project root directory
# 导航到项目根目录
cd C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments

# Compile the code
# 编译代码
javac -d target/classes src/main/java/Observer/**/*.java src/main/java/Observer/*.java

# Run the program
# 运行程序
java -cp target/classes Observer.Main
```

### Using Maven / 使用 Maven

```bash
# Compile the project
# 编译项目
mvn compile

# Run the Main class
# 运行 Main 类
mvn exec:java -Dexec.mainClass="Observer.Main"
```

### Using IDE / 使用集成开发环境

Right-click on `Main.java` and select "Run Main.main()"

右键点击 `Main.java` 并选择 "Run Main.main()"

## Expected Output / 预期输出

The program will:
1. Initialize a weather station with random temperature
2. Register three observers
3. Run for 10 seconds with periodic temperature updates
4. Remove one observer
5. Continue running for 10 more seconds
6. Stop the weather station

程序将：
1. 用随机温度初始化气象站
2. 注册三个观察者
3. 运行10秒，定期更新温度
4. 移除一个观察者
5. 继续运行10秒
6. 停止气象站

The output demonstrates that after removing observer 2, it no longer receives temperature updates.

输出演示了移除观察者2后，它不再接收温度更新。

