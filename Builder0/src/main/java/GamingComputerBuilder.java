package builder.computers;

/**
 * 游戏电脑构建器
 * 实现ComputerBuilder接口，专门用于构建游戏电脑
 * 配置高性能硬件组件
 */
public class GamingComputerBuilder implements ComputerBuilder {
    // 正在构建的计算机产品
    private Computer computer;

    /**
     * 构造函数
     * 初始化一个新的Computer对象
     */
    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    /**
     * 为游戏电脑配置高端处理器
     */
    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9-14900K");
    }

    /**
     * 为游戏电脑配置大容量内存
     */
    @Override
    public void buildRAM() {
        computer.setRam(32);
    }

    /**
     * 为游戏电脑配置高速硬盘
     */
    @Override
    public void buildHardDrive() {
        computer.setHardDrive("2 TB NVMe SSD");
    }

    /**
     * 为游戏电脑配置高端显卡
     */
    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 4090");
    }

    /**
     * 为游戏电脑配置操作系统
     */
    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    /**
     * 返回已构建的游戏电脑
     */
    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
