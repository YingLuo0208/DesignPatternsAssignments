package builder.computers;

/**
 * 主类 - 演示Builder设计模式的使用
 * 通过导演类和不同的构建器来构建不同类型的电脑
 */
public class Main {
    /**
     * 主方法
     * 演示构建游戏电脑和办公电脑的过程
     */
    public static void main(String[] args) {

        // --- 构建游戏电脑 ---
        // 创建游戏电脑构建器
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        // 创建导演，并注入游戏电脑构建器
        ComputerDirector director = new ComputerDirector(gamingBuilder);

        // 导演指挥构建器按照步骤构建电脑
        director.constructComputer();
        // 从构建器获取已构建完成的游戏电脑
        Computer gamingComputer = gamingBuilder.getComputer();

        // 显示游戏电脑配置信息
        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingComputer);

        System.out.println();

        // --- 构建办公电脑 ---
        // 创建办公电脑构建器
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        // 为同一个导演更换构建器
        director.setBuilder(officeBuilder);

        // 导演指挥新的构建器按照相同步骤构建电脑
        director.constructComputer();
        // 从构建器获取已构建完成的办公电脑
        Computer officeComputer = officeBuilder.getComputer();

        // 显示办公电脑配置信息
        System.out.println("=== Office Computer ===");
        System.out.println(officeComputer);
    }
}
