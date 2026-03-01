# Template Method Pattern - Dice Game / 模板方法模式 - 掷骰子游戏

## Project Overview / 项目概述

This project demonstrates the Template Method design pattern by implementing a simple dice game.  
本项目通过实现一个简单的掷骰子游戏来演示模板方法设计模式。

The Template Method pattern defines the skeleton of an algorithm in a base class, allowing subclasses to override specific steps without changing the algorithm's structure.  
模板方法模式在基类中定义算法的骨架，允许子类在不改变算法结构的情况下重写特定步骤。

---

## File Structure / 文件结构

### 1. `Game.java` - Abstract Game Framework / 游戏框架抽象类
- **Purpose / 作用**: Defines the template method pattern framework for all games  
  定义所有游戏的模板方法模式框架
- **Key Method / 关键方法**: `play(int numberOfPlayers)` - The template method that defines the game flow  
  模板方法，定义游戏流程
- **Abstract Methods / 抽象方法**:
  - `initializeGame()` - Initialize game state / 初始化游戏状态
  - `endOfGame()` - Check if game is over / 检查游戏是否结束
  - `playSingleTurn()` - Execute one player's turn / 执行单个玩家的回合
  - `displayWinner()` - Show the winner / 显示获胜者

### 2. `Dice.java` - Dice Component / 骰子组件类
- **Purpose / 作用**: Handles dice rolling logic  
  处理骰子掷骰逻辑
- **Key Methods / 关键方法**:
  - `roll()` - Roll the dice and return a random value (1-6) / 掷骰子并返回随机值（1-6）
  - `getMinValue()` - Get minimum dice value / 获取骰子最小值
  - `getMaxValue()` - Get maximum dice value / 获取骰子最大值
- **Benefits / 优点**: Separates dice logic from game logic for better maintainability  
  将骰子逻辑与游戏逻辑分离，提高可维护性

### 3. `DiceGame.java` - Concrete Dice Game Implementation / 掷骰子游戏实现类
- **Purpose / 作用**: Extends Game class and implements the specific dice game logic  
  继承Game类并实现具体的掷骰子游戏逻辑
- **Game Rules / 游戏规则**:
  - Players take turns rolling a dice (1-6) / 玩家轮流掷骰子（1-6点）
  - Scores accumulate with each roll / 分数随每次掷骰子累加
  - First player to reach 20 points wins / 第一个达到20分的玩家获胜
- **Fields / 字段**:
  - `WINNING_SCORE` - Target score to win (20) / 获胜目标分数（20分）
  - `playerScores[]` - Stores each player's score / 存储每个玩家的分数
  - `winner` - Stores the winning player's index / 存储获胜玩家的索引
  - `dice` - Dice object for rolling / 用于掷骰子的骰子对象

### 4. `Main.java` - Main Entry Point / 主入口类
- **Purpose / 作用**: Demonstrates the dice game by creating and running a game instance  
  通过创建和运行游戏实例来演示掷骰子游戏
- **Functionality / 功能**: Creates a DiceGame with 3 players and starts the game  
  创建一个有3个玩家的掷骰子游戏并开始游戏

---

## How to Run / 运行方式

### Method 1: Using Maven / 方法1：使用Maven
```cmd
cd C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments\TemplateMethod
mvn clean compile
java -cp target/classes Main
```

### Method 2: Using IDE / 方法2：使用IDE
1. Open the project in IntelliJ IDEA / 在IntelliJ IDEA中打开项目
2. Navigate to `Main.java` / 导航到`Main.java`
3. Right-click and select "Run 'Main.main()'" / 右键点击并选择"运行'Main.main()'"

---

## Design Pattern Explanation / 设计模式说明

### Template Method Pattern / 模板方法模式

**Key Concept / 核心概念**:  
The `Game` class defines the template method `play()` which cannot be overridden (final). This method orchestrates the game flow by calling abstract methods that subclasses must implement.  
`Game`类定义了不可被重写的模板方法`play()`（final）。该方法通过调用子类必须实现的抽象方法来编排游戏流程。

**Benefits / 优点**:
- Code reuse: Common game flow is defined once / 代码复用：通用游戏流程只定义一次
- Flexibility: Specific game logic can vary / 灵活性：具体游戏逻辑可以变化
- Control: The framework controls the algorithm structure / 控制性：框架控制算法结构

---

## Quick Reference / 快速参考

### Class-File Mapping / 类名与文件位置对照

| Class Name / 类名 | File Location / 文件位置 | Description / 描述 |
|-------------------|-------------------------|-------------------|
| `Game` | `src/main/java/Game.java` | Abstract framework / 抽象框架 |
| `Dice` | `src/main/java/Dice.java` | Dice component / 骰子组件 |
| `DiceGame` | `src/main/java/DiceGame.java` | Concrete implementation / 具体实现 |
| `Main` | `src/main/java/Main.java` | Entry point / 入口点 |

### Brief Explanation / 简要说明

**English**: This project implements a dice game using the Template Method pattern. The `Game` class provides the game framework with a template method `play()` that defines the game flow: initialize → play turns → check end condition → display winner. The `Dice` class encapsulates the dice rolling logic. The `DiceGame` class extends `Game` and implements the specific logic for a dice rolling game where players take turns rolling dice until someone reaches 20 points.

**中文**: 本项目使用模板方法模式实现掷骰子游戏。`Game`类提供游戏框架，其模板方法`play()`定义游戏流程：初始化 → 执行回合 → 检查结束条件 → 显示获胜者。`Dice`类封装了掷骰子的逻辑。`DiceGame`类继承`Game`并实现掷骰子游戏的具体逻辑，玩家轮流掷骰子直到有人达到20分。

---

## Implementation Details / 实现细节

### Game Flow / 游戏流程
1. **Initialize / 初始化**: Set player count and scores to 0 / 设置玩家数量，分数初始化为0
2. **Loop / 循环**: Players take turns until someone wins / 玩家轮流直到有人获胜
3. **Turn / 回合**: Roll dice (1-6), add to score / 掷骰子（1-6），加到分数上
4. **Check / 检查**: After each turn, check if any player reached 20 points / 每回合后检查是否有玩家达到20分
5. **End / 结束**: Display winner and final scores / 显示获胜者和最终分数

### Key Features / 关键特性
- Random dice rolls (1-6) / 随机掷骰子（1-6点）
- Turn-based gameplay / 回合制游戏
- Automatic winner detection / 自动检测获胜者
- Clear game status display / 清晰的游戏状态显示

