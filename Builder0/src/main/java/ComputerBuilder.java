package builder.computers;

/**
 * 计算机构建器接口
 * 定义了构建计算机的所有步骤
 * 每个具体构建器都需要实现这些方法
 */
public interface ComputerBuilder {
    /**
     * 构建处理器
     */
    void buildProcessor();

    /**
     * 构建内存
     */
    void buildRAM();

    /**
     * 构建硬盘
     */
    void buildHardDrive();

    /**
     * 构建显卡
     */
    void buildGraphicsCard();

    /**
     * 构建操作系统
     */
    void buildOperatingSystem();

    /**
     * 获取已构建的计算机产品
     * @return 返回构建完成的Computer对象
     */
    Computer getComputer();
}
