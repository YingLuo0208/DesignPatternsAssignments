package FactoryMethod;

import java.util.Random;

/**
 * Map - 地图抽象类
 * 使用工厂方法模式创建地形块并生成地图
 * 这是工厂方法模式中的抽象创建者（Abstract Creator）
 */
public abstract class Map {
    // 地图宽度
    protected int width;
    // 地图高度
    protected int height;
    // 地形块二维数组，存储整个地图
    protected Tile[][] tiles;
    // 随机数生成器，用于随机生成地形
    protected Random random = new Random();

    /**
     * 构造函数 - 初始化地图并填充地形块
     * @param width 地图宽度
     * @param height 地图高度
     */
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        // 遍历地图的每个位置，通过工厂方法创建地形块
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    /**
     * 工厂方法 - 创建地形块
     * 这是工厂方法模式的核心，由子类实现以创建不同类型的地形
     * @return 创建的地形块对象
     */
    public abstract Tile createTile();

    /**
     * 显示地图
     * 将地图以字符矩阵的形式打印到控制台
     * 注意：此方法对具体的地形类型是无感知的，只通过接口方法访问
     */
    public void display() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}