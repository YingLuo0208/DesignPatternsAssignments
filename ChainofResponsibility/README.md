# Chain of Responsibility - Customer Feedback Handler
# 责任链模式 - 客户反馈处理系统

## Project Overview / 项目概述

This project implements a Customer Feedback Handler system using the Chain of Responsibility design pattern.
本项目使用责任链设计模式实现了一个客户反馈处理系统。

The system handles different types of customer feedback messages: compensation claims, contact requests, development suggestions, and general feedback.
系统处理不同类型的客户反馈消息：赔偿索赔、联系请求、开发建议和一般反馈。

## File Structure / 文件结构

### Core Classes / 核心类

1. **MessageType.java** - Enum defining four types of feedback messages
   - 定义四种反馈消息类型的枚举

2. **Message.java** - Represents a customer feedback message with type, content, and sender email
   - 表示客户反馈消息，包含类型、内容和发件人邮箱

3. **Handler.java** - Abstract base class for all handlers in the chain
   - 责任链中所有处理器的抽象基类

### Handler Implementations / 处理器实现

4. **CompensationHandler.java** - Handles compensation claim messages
   - 处理赔偿索赔消息
   - Reviews claims and approves/rejects based on detail level
   - 审核索赔并根据详细程度批准/拒绝

5. **ContactRequestHandler.java** - Handles contact request messages
   - 处理联系请求消息
   - Routes requests to appropriate departments (Technical Support, Billing, Sales, Customer Service)
   - 将请求路由到适当的部门（技术支持、账单、销售、客户服务）

6. **DevelopmentSuggestionHandler.java** - Handles development suggestion messages
   - 处理开发建议消息
   - Logs suggestions and assigns priority (HIGH, MEDIUM, LOW)
   - 记录建议并分配优先级（高、中、低）

7. **GeneralFeedbackHandler.java** - Handles general feedback messages
   - 处理一般反馈消息
   - Analyzes sentiment (POSITIVE, NEUTRAL, NEGATIVE) and generates appropriate response
   - 分析情感倾向（积极、中性、消极）并生成适当的响应

### Main Program / 主程序

8. **FeedbackSystem.java** - Main class demonstrating the system
   - 演示系统的主类
   - Creates the chain of handlers and processes various feedback messages
   - 创建处理器链并处理各种反馈消息

## How to Run / 运行方式

### Method 1: Using Maven / 方法1：使用Maven

```bash
cd ChainofResponsibility
mvn compile
mvn exec:java -Dexec.mainClass="FeedbackSystem"
```

### Method 2: Using Java directly / 方法2：直接使用Java

```bash
cd ChainofResponsibility/src/main/java
javac *.java
java FeedbackSystem
```

### Method 3: Using IDE / 方法3：使用IDE

Open the project in your IDE and run `FeedbackSystem.java`
在IDE中打开项目并运行 `FeedbackSystem.java`

## Design Pattern Implementation / 设计模式实现

### Chain of Responsibility Pattern / 责任链模式

The system uses the Chain of Responsibility pattern where:
系统使用责任链模式，其中：

- Each handler can process a specific type of message
  每个处理器可以处理特定类型的消息

- If a handler cannot process a message, it passes it to the next handler
  如果处理器无法处理消息，则将其传递给下一个处理器

- The chain is: CompensationHandler → ContactRequestHandler → DevelopmentSuggestionHandler → GeneralFeedbackHandler
  链式结构为：赔偿处理器 → 联系请求处理器 → 开发建议处理器 → 一般反馈处理器

## Key Features / 关键特性

1. **Automatic Routing** - Messages are automatically routed to the correct handler
   自动路由 - 消息自动路由到正确的处理器

2. **Extensibility** - New handler types can be easily added to the chain
   可扩展性 - 可以轻松向链中添加新的处理器类型

3. **Decoupling** - Each handler is independent and doesn't need to know about others
   解耦 - 每个处理器都是独立的，不需要了解其他处理器

4. **Smart Processing** - Each handler includes intelligent processing logic
   智能处理 - 每个处理器都包含智能处理逻辑
   - Compensation: Approval based on detail level
     赔偿：基于详细程度的批准
   - Contact: Department routing based on keywords
     联系：基于关键词的部门路由
   - Development: Priority assignment
     开发：优先级分配
   - General: Sentiment analysis
     一般：情感分析

## Sample Output / 示例输出

The program demonstrates handling of 9 different feedback messages, showing:
程序演示处理9条不同的反馈消息，显示：
- Message type and content
  消息类型和内容
- Processing logic
  处理逻辑
- Action taken
  采取的行动
- Response sent to customer
  发送给客户的响应

