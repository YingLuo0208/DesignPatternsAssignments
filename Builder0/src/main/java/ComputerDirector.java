package builder.computers;

/**
 * 计算机构建导演类
 * 负责按照特定步骤和顺序指挥构建器构建计算机
 * 即使使用不同的构建器，也能确保按照相同的构建流程进行
 */
public class ComputerDirector {
    // 持有一个构建器实例
    private ComputerBuilder builder;

    /**
     * 构造函数
     * @param builder 指定要使用的构建器
     */
    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    /**
     * 设置或更换构建器
     * @param builder 新的构建器
     */
    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    /**
     * 执行计算机构建过程
     * 按照特定顺序调用构建器的各个构建方法
     */
    public void constructComputer() {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
    }
}
