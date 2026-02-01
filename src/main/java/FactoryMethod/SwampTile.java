package FactoryMethod;

/**
 * SwampTile - 沼泽地形块
 * 表示地图上的沼泽区域
 */
public class SwampTile implements Tile {
    /**
     * 返回沼泽地形的字符表示
     * @return 'S' 代表 Swamp（沼泽）
     */
    @Override
    public char getCharacter() {
        return 'S';
    }

    /**
     * 返回地形类型名称
     * @return "Swamp" - 沼泽
     */
    @Override
    public String getType() {
        return "Swamp";
    }
}