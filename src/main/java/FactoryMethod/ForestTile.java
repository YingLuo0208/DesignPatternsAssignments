package FactoryMethod;

/**
 * ForestTile - 森林地形块
 * 表示地图上的森林区域
 */
public class ForestTile implements Tile {
    /**
     * 返回森林地形的字符表示
     * @return 'F' 代表 Forest（森林）
     */
    @Override
    public char getCharacter() {
        return 'F';
    }

    /**
     * 返回地形类型名称
     * @return "Forest" - 森林
     */
    @Override
    public String getType() {
        return "Forest";
    }
}