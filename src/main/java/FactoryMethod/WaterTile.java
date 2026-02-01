package FactoryMethod;

/**
 * WaterTile - 水域地形块
 * 表示地图上的水域区域（湖泊、河流等）
 */
public class WaterTile implements Tile {
    /**
     * 返回水域地形的字符表示
     * @return 'W' 代表 Water（水域）
     */
    @Override
    public char getCharacter() {
        return 'W';
    }

    /**
     * 返回地形类型名称
     * @return "Water" - 水域
     */
    @Override
    public String getType() {
        return "Water";
    }
}