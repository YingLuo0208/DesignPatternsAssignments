package FactoryMethod;

/**
 * WildernessMap - 荒野地图
 * 具体的地图类型，包含荒野特有的地形：森林、沼泽和水域
 * 这是工厂方法模式中的具体创建者（Concrete Creator）
 */
public class WildernessMap extends Map {
    /**
     * 构造函数 - 创建指定大小的荒野地图
     * @param width 地图宽度
     * @param height 地图高度
     */
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    /**
     * 工厂方法的具体实现 - 创建荒野地形块
     * 从森林、沼泽和水域三种地形中随机选择一种
     * @return 随机创建的荒野地形块（ForestTile、SwampTile 或 WaterTile）
     */
    @Override
    public Tile createTile() {
        // 荒野地图包含的三种地形类型
        Tile[] types = new Tile[]{new ForestTile(), new SwampTile(), new WaterTile()};
        // 随机选择一种地形
        int rand = random.nextInt(types.length);
        return types[rand];
    }
}