package FactoryMethod;

/**
 * CityMap - 城市地图
 * 具体的地图类型，包含城市特有的地形：建筑、道路和森林
 * 这是工厂方法模式中的具体创建者（Concrete Creator）
 */
public class CityMap extends Map {
    /**
     * 构造函数 - 创建指定大小的城市地图
     * @param width 地图宽度
     * @param height 地图高度
     */
    public CityMap(int width, int height) {
        super(width, height);
    }

    /**
     * 工厂方法的具体实现 - 创建城市地形块
     * 从建筑、道路和森林三种地形中随机选择一种
     * @return 随机创建的城市地形块（BuildingTile、RoadTile 或 ForestTile）
     */
    @Override
    public Tile createTile() {
        // 城市地图包含的三种地形类型
        Tile[] types = new Tile[]{new BuildingTile(), new RoadTile(), new ForestTile()};
        // 随机选择一种地形
        int rand = random.nextInt(types.length);
        return types[rand];
    }

}