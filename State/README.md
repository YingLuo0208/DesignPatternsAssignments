# State Pattern - 状态模式

## Brief Explanation (简短英文说明)

**English:**  
This project implements the State design pattern with a game character development system. The system consists of 7 Java files:
- **State.java**: Interface defining all possible character actions (train, meditate, fight)
- **NoviceState.java**: Novice level - only training is available
- **IntermediateState.java**: Intermediate level - training and meditation available
- **ExpertState.java**: Expert level - all actions available including fighting
- **MasterState.java**: Master level - game complete
- **GameCharacter.java**: Character class that delegates actions to its current state
- **Main.java**: Game loop with user interaction

The implementation approach: The GameCharacter holds a reference to a State object. When actions are performed, the character delegates to the current state, which implements the behavior. As experience increases, the character transitions to new states, unlocking new abilities. This demonstrates how the State pattern allows an object to change its behavior when its internal state changes.

**中文：**  
本项目使用 7 个 Java 文件实现状态设计模式的游戏角色发展系统：
- **State.java**：定义所有可能的角色操作（训练、冥想、战斗）的接口
- **NoviceState.java**：新手等级 - 只能训练
- **IntermediateState.java**：中级等级 - 可以训练和冥想
- **ExpertState.java**：专家等级 - 所有操作都可用，包括战斗
- **MasterState.java**：大师等级 - 游戏完成
- **GameCharacter.java**：角色类，将操作委托给当前状态
- **Main.java**：游戏循环和用户交互

实现思路：GameCharacter 持有一个 State 对象的引用。执行操作时，角色委托给当前状态来实现行为。随着经验值增加，角色转换到新状态，解锁新能力。这展示了状态模式如何让对象在其内部状态改变时改变其行为。

---

## 文件结构 / File Structure

```
State/
├── pom.xml                          # Maven 配置文件
├── README.md                        # 本文档
└── src/main/java/
    ├── State.java                   # 状态接口
    ├── NoviceState.java             # 新手状态
    ├── IntermediateState.java       # 中级状态
    ├── ExpertState.java             # 专家状态
    ├── MasterState.java             # 大师状态
    ├── GameCharacter.java           # 游戏角色类
    └── Main.java                    # 主程序
```

---

## 各文件详解 / File Details

### 1. **State.java** - 状态接口
**位置**：`src/main/java/State.java`  
**作用**：定义角色在不同状态下可执行的所有操作

**关键方法**：
- `train(GameCharacter)` - 训练操作
- `meditate(GameCharacter)` - 冥想操作
- `fight(GameCharacter)` - 战斗操作
- `getStateName()` - 获取状态名称
- `displayAvailableActions()` - 显示可用操作

**设计要点**：
- 使用接口确保所有状态类实现相同的方法
- 每个方法接收 GameCharacter 参数，以便修改角色属性

---

### 2. **NoviceState.java** - 新手状态
**位置**：`src/main/java/NoviceState.java`  
**作用**：实现新手等级的行为

**特性**：
- ✅ **训练**：增加 20 经验值
- ❌ **冥想**：不可用
- ❌ **战斗**：不可用

**升级条件**：达到 100 经验值升级到中级

---

### 3. **IntermediateState.java** - 中级状态
**位置**：`src/main/java/IntermediateState.java`  
**作用**：实现中级等级的行为

**特性**：
- ✅ **训练**：增加 25 经验值
- ✅ **冥想**：恢复 15 生命值
- ❌ **战斗**：不可用

**升级条件**：达到 250 经验值升级到专家

---

### 4. **ExpertState.java** - 专家状态
**位置**：`src/main/java/ExpertState.java`  
**作用**：实现专家等级的行为

**特性**：
- ✅ **训练**：增加 30 经验值
- ✅ **冥想**：恢复 20 生命值
- ✅ **战斗**：失去 15 生命值，但获得 40 经验值

**升级条件**：达到 500 经验值升级到大师

**战斗机制**：
- 战斗是高风险高回报的操作
- 可能导致生命值过低（需要冥想恢复）
- 生命值降至 0 游戏结束

---

### 5. **MasterState.java** - 大师状态
**位置**：`src/main/java/MasterState.java`  
**作用**：表示游戏完成状态

**特性**：
- 所有操作都显示"已达到大师等级"的消息
- 不再需要训练或战斗
- 游戏胜利条件

---

### 6. **GameCharacter.java** - 游戏角色类
**位置**：`src/main/java/GameCharacter.java`  
**作用**：管理角色属性和状态转换

**核心属性**：
- `name` - 角色名称
- `level` - 当前等级（1-4）
- `experiencePoints` - 经验值
- `healthPoints` - 生命值（0-100）
- `currentState` - 当前状态对象

**核心方法**：
- `setState()` - 切换到新状态
- `train()`, `meditate()`, `fight()` - 将操作委托给当前状态
- `checkLevelUp()` - 检查并处理升级
- `displayStatus()` - 显示角色状态

**状态转换逻辑**：
```
Novice (Level 1)  →  100 EXP  →  Intermediate (Level 2)
                  →  250 EXP  →  Expert (Level 3)
                  →  500 EXP  →  Master (Level 4)
```

**设计要点**：
- Context 角色，持有状态引用
- 将行为委托给状态对象
- 负责状态转换的时机判断

---

### 7. **Main.java** - 主程序
**位置**：`src/main/java/Main.java`  
**作用**：实现游戏循环和用户交互

**游戏流程**：
1. 输入角色名称
2. 显示当前状态和可用操作
3. 接收用户选择（0-3）
4. 执行对应操作
5. 检查升级或游戏结束条件
6. 重复 2-5 直到游戏结束

**游戏结束条件**：
- 达到大师等级（胜利）
- 生命值降至 0（失败）
- 用户选择退出

---

## 游戏机制 / Game Mechanics

### 升级系统
| 状态 | 经验值要求 | 可用操作 |
|------|-----------|---------|
| Novice | 0 - 99 | 训练 |
| Intermediate | 100 - 249 | 训练、冥想 |
| Expert | 250 - 499 | 训练、冥想、战斗 |
| Master | 500+ | 游戏完成 |

### 操作收益对比
| 操作 | 经验值 | 生命值 | 可用等级 |
|------|--------|--------|---------|
| 训练 | +20/+25/+30 | 0 | 所有 |
| 冥想 | 0 | +15/+20 | 中级及以上 |
| 战斗 | +40 | -15 | 专家及以上 |

### 策略建议
- **新手期**：只能训练，快速升级
- **中级期**：平衡训练和冥想，为战斗做准备
- **专家期**：战斗获得经验快但要注意生命值，适时冥想恢复

---

## 运行方法 / How to Run

### **方法 1：使用 Maven 编译并运行（推荐）**
```bash
# 在项目根目录执行
# 1. 编译
mvn -pl State clean compile

# 2. 运行
java -cp State/target/classes Main
```

### **方法 2：在 IDE 中运行**
1. 打开 `src/main/java/Main.java`
2. 右键点击 `main` 方法
3. 选择 "Run Main.main()"

### **游戏操作说明**
```
启动后输入角色名称
在每回合选择操作：
  1 - 训练
  2 - 冥想
  3 - 战斗
  0 - 退出游戏
```

---

## 运行示例 / Example Gameplay

```
============================================================
    GAME CHARACTER DEVELOPMENT SYSTEM
============================================================

Enter your character's name: Hero

Welcome, Hero!
Your journey begins as a Novice...

==================================================
CHARACTER STATUS
==================================================
Name:       Hero
Level:      1 (Novice)
Experience: 0 / 100
Health:     100 / 100
==================================================
Available Actions:
  [1] Train    - Gain experience points
  [2] Meditate - NOT AVAILABLE
  [3] Fight    - NOT AVAILABLE
  [0] Quit

Choose an action (0-3): 1

Hero is training hard...
   [+] Gained 20 experience points!

[Press Enter to continue...]

==================================================
CHARACTER STATUS
==================================================
Name:       Hero
Level:      1 (Novice)
Experience: 20 / 100
Health:     100 / 100
==================================================
...

>>> Hero has advanced to Intermediate level!

... (继续游戏直到达到大师等级)

============================================================
    GAME COMPLETED!
    Hero has become a Master!
============================================================
```

---

## 核心设计思想 / Core Design Principles

### **状态模式三要素**
1. **State 接口**：定义状态的统一行为
2. **具体状态类**：实现不同状态的具体行为
3. **Context (GameCharacter)**：持有状态引用，委托行为

### **关键特点**
- ✅ **封装状态行为**：每个状态类封装该状态的所有行为
- ✅ **消除条件判断**：不需要大量 if-else 判断当前状态
- ✅ **易于扩展**：添加新状态只需创建新的状态类
- ✅ **状态转换集中**：状态转换逻辑在 Context 中统一管理

### **状态模式 vs 策略模式**
| 特性 | 状态模式 | 策略模式 |
|------|----------|----------|
| 目的 | 对象在不同状态下有不同行为 | 选择不同的算法 |
| 状态转换 | Context 通常会自动切换状态 | 客户端主动选择策略 |
| 状态间关系 | 状态间可能有转换关系 | 策略间独立 |

---

## 实际应用 / Real-World Applications

- **TCP 连接**：Closed, Listen, Established 等状态
- **订单系统**：待支付、已支付、已发货、已完成等状态
- **文档编辑**：草稿、审核中、已发布等状态
- **游戏角色**：空闲、移动、攻击、死亡等状态

---

## 总结 / Summary

**记忆要点**：
- 状态模式将**与状态相关的行为**封装到独立的状态类中
- Context 对象持有**当前状态的引用**
- 行为的改变通过**切换状态对象**实现
- 避免大量的**条件判断语句**

**本项目展示**：
- 角色从新手到大师的成长过程
- 每个等级解锁不同的能力
- 状态转换的自动触发
- 状态模式的典型应用场景

