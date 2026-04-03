package builder.computers;

/**
 * 办公电脑构建器
 * 实现ComputerBuilder接口，专门用于构建办公电脑
 * 配置适合办公应用的硬件组件
 */
public class OfficeComputerBuilder implements ComputerBuilder {
    // 正在构建的计算机产品
    private Computer computer;

    /**
     * 构造函数
     * 初始化一个新的Computer对象
     */
    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    /**
     * 为办公电脑配置中端处理器
     */
    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5-13500");
    }

    /**
     * 为办公电脑配置适中的内存
     */
    @Override
    public void buildRAM() {
        computer.setRam(16);
    }

    /**
     * 为办公电脑配置标准容量硬盘
     */
    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    /**
     * 为办公电脑配置集成显卡
     */
    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Intel UHD Graphics 770 (Integrated)");
    }

    /**
     * 为办公电脑配置操作系统
     */
    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    /**
     * 返回已构建的办公电脑
    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
