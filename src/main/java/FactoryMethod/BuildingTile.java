package FactoryMethod;

/**
 * BuildingTile - 建筑地形块
 * 表示地图上的建筑物区域
 */
public class BuildingTile implements Tile {
    /**
     * 返回建筑地形的字符表示
     * @return 'B' 代表 Building（建筑）
     */
    @Override
    public char getCharacter() {
        return 'B';
    }

    /**
     * 返回地形类型名称
     * @return "Building" - 建筑
     */
    @Override
    public String getType() {
        return "Building";
    }
}