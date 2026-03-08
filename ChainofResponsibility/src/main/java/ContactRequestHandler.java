/**
 * 联系请求处理器
 * 负责处理联系请求类型的反馈
 */
public class ContactRequestHandler extends Handler {

    /**
     * 处理联系请求消息
     * @param message 要处理的消息
     */
    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("\n=== Contact Request Handler ===");
            System.out.println("Processing contact request from: " + message.getSenderEmail());
            System.out.println("Request: " + message.getContent());

            // 根据请求内容转发到相应部门
            String department = routeToDepartment(message.getContent());

            System.out.println("Action: Request forwarded to " + department + " department");
            System.out.println("Status: You will receive a response within 24 hours.");
            System.out.println("Confirmation sent to: " + message.getSenderEmail());
        } else {
            passToNext(message);
        }
    }

    /**
     * 根据内容将请求路由到相应部门
     * @param content 请求内容
     * @return 部门名称
     */
    private String routeToDepartment(String content) {
        String lowerContent = content.toLowerCase();

        if (lowerContent.contains("technical") || lowerContent.contains("bug") || lowerContent.contains("error")) {
            return "Technical Support";
        } else if (lowerContent.contains("billing") || lowerContent.contains("payment") || lowerContent.contains("invoice")) {
            return "Billing";
        } else if (lowerContent.contains("sales") || lowerContent.contains("purchase") || lowerContent.contains("product")) {
            return "Sales";
        } else {
            return "Customer Service";
        }
    }
}

