package FactoryMethod;

/**
 * Game - 游戏主类
 * 包含程序入口和地图创建的工厂方法
 * 演示工厂方法模式在RPG地图生成中的应用
 */
public class Game {
    /**
     * 程序入口方法
     * 创建并显示不同类型的地图
     */
    public static void main(String[] args) {
        // 创建并显示5x5的城市地图
        System.out.println("Creating a 5x5 City map...");
        Map cityMap = createMap("city",5, 5);
        cityMap.display();

        // 创建并显示10x10的荒野地图
        System.out.println("\nCreating a 10x10 Wilderness map...");
        Map wildernessMap = createMap("wilderness", 10, 10);
        wildernessMap.display();
    }

    /**
     * 地图创建工厂方法
     * 根据类型字符串创建相应的地图对象
     * @param type 地图类型（"city" 或 "wilderness"）
     * @param width 地图宽度
     * @param height 地图高度
     * @return 创建的地图对象（CityMap 或 WildernessMap）
     * @throws IllegalArgumentException 如果地图类型未知
     */
    public static Map createMap(String type, int width, int height) {
        if (type.equals("city")) {
            return new CityMap(width, height);
        } else if (type.equals("wilderness")) {
            return new WildernessMap(width, height);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + type);

        }
    }
}