/**
 * 开发建议处理器
 * 负责处理开发建议类型的反馈
 */
public class DevelopmentSuggestionHandler extends Handler {

    /**
     * 处理开发建议消息
     * @param message 要处理的消息
     */
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("\n=== Development Suggestion Handler ===");
            System.out.println("Processing development suggestion from: " + message.getSenderEmail());
            System.out.println("Suggestion: " + message.getContent());

            // 记录建议并评估优先级
            String priority = evaluatePriority(message.getContent());

            System.out.println("Action: Suggestion logged in development backlog");
            System.out.println("Priority: " + priority);
            System.out.println("Status: Your suggestion will be reviewed by our product team.");
            System.out.println("Thank you message sent to: " + message.getSenderEmail());
        } else {
            passToNext(message);
        }
    }

    /**
     * 评估建议的优先级
     * @param content 建议内容
     * @return 优先级（HIGH, MEDIUM, LOW）
     */
    private String evaluatePriority(String content) {
        String lowerContent = content.toLowerCase();

        // 包含紧急、安全、重要等关键词的建议优先级高
        if (lowerContent.contains("urgent") || lowerContent.contains("security") ||
            lowerContent.contains("critical") || lowerContent.contains("important")) {
            return "HIGH";
        }
        // 包含改进、优化等关键词的建议优先级中等
        else if (lowerContent.contains("improve") || lowerContent.contains("enhance") ||
                 lowerContent.contains("optimize")) {
            return "MEDIUM";
        }
        // 其他建议优先级低
        else {
            return "LOW";
        }
    }
}

