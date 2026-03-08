/**
 * 一般反馈处理器
 * 负责处理一般反馈类型的消息
 */
public class GeneralFeedbackHandler extends Handler {

    /**
     * 处理一般反馈消息
     * @param message 要处理的消息
     */
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("\n=== General Feedback Handler ===");
            System.out.println("Processing general feedback from: " + message.getSenderEmail());
            System.out.println("Feedback: " + message.getContent());

            // 分析反馈情感倾向
            String sentiment = analyzeSentiment(message.getContent());

            System.out.println("Sentiment Analysis: " + sentiment);
            System.out.println("Action: Feedback recorded and analyzed for quality improvement");

            // 根据情感倾向生成响应
            String response = generateResponse(sentiment);
            System.out.println("Response: " + response);
            System.out.println("Response sent to: " + message.getSenderEmail());
        } else {
            passToNext(message);
        }
    }

    /**
     * 分析反馈的情感倾向
     * @param content 反馈内容
     * @return 情感倾向（POSITIVE, NEUTRAL, NEGATIVE）
     */
    private String analyzeSentiment(String content) {
        String lowerContent = content.toLowerCase();

        // 积极情感关键词
        if (lowerContent.contains("great") || lowerContent.contains("excellent") ||
            lowerContent.contains("love") || lowerContent.contains("amazing") ||
            lowerContent.contains("good") || lowerContent.contains("thank")) {
            return "POSITIVE";
        }
        // 消极情感关键词
        else if (lowerContent.contains("bad") || lowerContent.contains("terrible") ||
                 lowerContent.contains("hate") || lowerContent.contains("worst") ||
                 lowerContent.contains("disappointed") || lowerContent.contains("poor")) {
            return "NEGATIVE";
        }
        // 中性
        else {
            return "NEUTRAL";
        }
    }

    /**
     * 根据情感倾向生成响应
     * @param sentiment 情感倾向
     * @return 响应内容
     */
    private String generateResponse(String sentiment) {
        return switch (sentiment) {
            case "POSITIVE" -> "Thank you for your positive feedback! We're glad you're enjoying our service.";
            case "NEGATIVE" -> "We're sorry to hear about your experience. We'll work to improve our service.";
            default -> "Thank you for your feedback. We appreciate your input.";
        };
    }
}

