package builder.computers;

/**
 * 计算机产品类
 * 此类代表被构建的产品，包含计算机的各个硬件组件
 */
public class Computer {
    // 处理器
    private String processor;
    // 内存（GB）
    private int ram;
    // 硬盘
    private String hardDrive;
    // 显卡
    private String graphicsCard;
    // 操作系统
    private String operatingSystem;

    /**
     * 设置处理器
     */
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    /**
     * 设置内存大小
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * 设置硬盘
     */
    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    /**
     * 设置显卡
     */
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    /**
     * 设置操作系统
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * 返回计算机配置信息的字符串表示
     */
    @Override
    public String toString() {
        return "Computer Configuration:\n" +
               "  Processor      : " + processor + "\n" +
               "  RAM            : " + ram + " GB\n" +
               "  Hard Drive     : " + hardDrive + "\n" +
               "  Graphics Card  : " + graphicsCard + "\n" +
               "  Operating System: " + operatingSystem;
    }
}
