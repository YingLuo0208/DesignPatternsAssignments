/**
 * 反馈系统主程序
 * 演示责任链模式处理不同类型的客户反馈
 */
public class FeedbackSystem {

    public static void main(String[] args) {
        // 创建处理器对象
        Handler compensationHandler = new CompensationHandler();
        Handler contactRequestHandler = new ContactRequestHandler();
        Handler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        Handler generalFeedbackHandler = new GeneralFeedbackHandler();

        // 构建责任链
        compensationHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        System.out.println("========================================");
        System.out.println("Customer Feedback Handler System");
        System.out.println("========================================");

        // 创建各种类型的客户反馈消息并处理

        // 测试赔偿索赔（内容详细，会被批准）
        Message message1 = new Message(
            MessageType.COMPENSATION_CLAIM,
            "I purchased your product last week and it arrived damaged. The packaging was torn and the item inside was broken. I would like a full refund or replacement.",
            "customer1@example.com"
        );
        compensationHandler.handleMessage(message1);

        // 测试赔偿索赔（内容不详细，会被拒绝）
        Message message2 = new Message(
            MessageType.COMPENSATION_CLAIM,
            "Product broken, need refund.",
            "customer2@example.com"
        );
        compensationHandler.handleMessage(message2);

        // 测试联系请求（技术支持）
        Message message3 = new Message(
            MessageType.CONTACT_REQUEST,
            "I am experiencing a technical error when trying to log into my account. Can someone help?",
            "customer3@example.com"
        );
        compensationHandler.handleMessage(message3);

        // 测试联系请求（账单问题）
        Message message4 = new Message(
            MessageType.CONTACT_REQUEST,
            "I was charged twice for my last purchase. Please check my billing statement.",
            "customer4@example.com"
        );
        compensationHandler.handleMessage(message4);

        // 测试开发建议（高优先级）
        Message message5 = new Message(
            MessageType.DEVELOPMENT_SUGGESTION,
            "It would be great to add a security feature for two-factor authentication. This is important for user safety.",
            "customer5@example.com"
        );
        compensationHandler.handleMessage(message5);

        // 测试开发建议（中等优先级）
        Message message6 = new Message(
            MessageType.DEVELOPMENT_SUGGESTION,
            "Could you improve the search functionality to make it faster?",
            "customer6@example.com"
        );
        compensationHandler.handleMessage(message6);

        // 测试一般反馈（积极）
        Message message7 = new Message(
            MessageType.GENERAL_FEEDBACK,
            "Your service is excellent! I love the user interface and everything works great.",
            "customer7@example.com"
        );
        compensationHandler.handleMessage(message7);

        // 测试一般反馈（消极）
        Message message8 = new Message(
            MessageType.GENERAL_FEEDBACK,
            "The product quality is terrible and I am very disappointed with this purchase.",
            "customer8@example.com"
        );
        compensationHandler.handleMessage(message8);

        // 测试一般反馈（中性）
        Message message9 = new Message(
            MessageType.GENERAL_FEEDBACK,
            "The product meets my basic needs.",
            "customer9@example.com"
        );
        compensationHandler.handleMessage(message9);

        System.out.println("\n========================================");
        System.out.println("All feedback messages have been processed");
        System.out.println("========================================");
    }
}

