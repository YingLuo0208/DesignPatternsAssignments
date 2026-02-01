package FactoryMethod;

/**
 * Tile接口 - 地形块接口
 * 定义了所有地形块必须实现的方法
 */
public interface Tile {
    /**
     * 获取地形块的字符表示
     * @return 代表该地形类型的字符（如 'S'、'W'、'R'、'F'、'B'）
     */
    char getCharacter();

    /**
     * 获取地形块的类型名称
     * @return 地形类型的字符串描述（如 "Swamp"、"Water" 等）
     */
    String getType();
}