package FactoryMethod;

/**
 * RoadTile - 道路地形块
 * 表示地图上的道路区域
 */
public class RoadTile implements Tile {
    /**
     * 返回道路地形的字符表示
     * @return 'R' 代表 Road（道路）
     */
    @Override
    public char getCharacter() {
        return 'R';
    }

    /**
     * 返回地形类型名称
     * @return "Road" - 道路
     */
    @Override
    public String getType() {
        return "Road";
    }
}