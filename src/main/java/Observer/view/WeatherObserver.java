package Observer.view;

/**
 * WeatherObserver 类 - 天气观察者类
 * 实现Observer接口，当温度变化时显示独特的消息
 * Implements Observer interface and displays unique messages when temperature changes
 */
public class WeatherObserver implements Observer {
    // 观察者名称 / Observer name
    private String name;

    /**
     * 构造函数
     * Constructor
     *
     * @param name 观察者名称 / Observer name
     */
    public WeatherObserver(String name) {
        this.name = name;
    }

    /**
     * 当温度变化时调用此方法
     * Called when temperature changes
     *
     * @param temperature 当前温度 / Current temperature
     */
    @Override
    public void update(double temperature) {
        System.out.println("[" + name + "] Received temperature update: " +
                         String.format("%.2f", temperature) + "°C - " + getWeatherComment(temperature));
    }

    /**
     * 根据温度返回天气评论
     * Return weather comment based on temperature
     *
     * @param temperature 温度 / Temperature
     * @return 天气评论 / Weather comment
     */
    private String getWeatherComment(double temperature) {
        if (temperature < 0) {
            return "It's freezing cold!";
        } else if (temperature < 10) {
            return "It's quite cold.";
        } else if (temperature < 20) {
            return "The weather is cool.";
        } else if (temperature < 30) {
            return "Nice warm weather!";
        } else {
            return "It's really hot!";
        }
    }

    /**
     * 获取观察者名称
     * Get observer name
     *
     * @return 观察者名称 / Observer name
     */
    public String getName() {
        return name;
    }
}
