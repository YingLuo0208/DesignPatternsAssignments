/**
 * 赔偿索赔处理器
 * 负责处理赔偿索赔类型的反馈
 */
public class CompensationHandler extends Handler {

    /**
     * 处理赔偿索赔消息
     * @param message 要处理的消息
     */
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("\n=== Compensation Claim Handler ===");
            System.out.println("Processing compensation claim from: " + message.getSenderEmail());
            System.out.println("Claim details: " + message.getContent());

            // 模拟审核过程
            boolean approved = reviewClaim(message.getContent());

            if (approved) {
                System.out.println("Status: APPROVED");
                System.out.println("Action: Compensation will be processed within 5-7 business days.");
            } else {
                System.out.println("Status: REJECTED");
                System.out.println("Action: Claim does not meet our compensation criteria.");
            }

            System.out.println("Response sent to: " + message.getSenderEmail());
        } else {
            passToNext(message);
        }
    }

    /**
     * 审核赔偿索赔
     * 简单的模拟逻辑：根据内容长度判断是否批准
     * @param content 索赔内容
     * @return 是否批准
     */
    private boolean reviewClaim(String content) {
        // 简单的审核逻辑：如果内容详细（长度超过50个字符），则批准
        return content.length() > 50;
    }
}

