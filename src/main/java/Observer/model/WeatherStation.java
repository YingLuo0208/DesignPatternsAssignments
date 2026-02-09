package Observer.model;

import java.util.Random;

/**
 * WeatherStation 类 - 气象站类
 * 继承Observable并实现Runnable，在独立线程中运行并定期更新温度
 * Extends Observable and implements Runnable to run in a separate thread and update temperature periodically
 */
public class WeatherStation extends Observable implements Runnable {
    // 当前温度 / Current temperature
    private double temperature;

    // 最低温度限制 / Minimum temperature limit
    private static final double MIN_TEMPERATURE = -30.0;

    // 最高温度限制 / Maximum temperature limit
    private static final double MAX_TEMPERATURE = 50.0;

    // 温度变化幅度 / Temperature change range
    private static final double TEMPERATURE_CHANGE = 1.0;

    // 随机数生成器 / Random number generator
    private Random random = new Random();

    // 线程运行标志 / Thread running flag
    private volatile boolean running = true;

    /**
     * 构造函数，设置初始随机温度
     * Constructor that sets an initial random temperature
     */
    public WeatherStation() {
        // 设置初始随机温度在合理范围内 / Set initial random temperature within a reasonable range
        this.temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        System.out.println("Weather Station initialized with temperature: " + String.format("%.2f", temperature) + "°C");
    }

    /**
     * 获取当前温度
     * Get the current temperature
     *
     * @return 当前温度 / Current temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * 更新温度并通知观察者
     * Update temperature and notify observers
     */
    private void updateTemperature() {
        // 随机增加或减少温度 / Randomly increase or decrease temperature
        double change = (random.nextBoolean() ? 1 : -1) * TEMPERATURE_CHANGE * random.nextDouble();
        double newTemperature = temperature + change;

        // 确保温度在最小和最大范围内 / Ensure temperature stays within min and max range
        if (newTemperature < MIN_TEMPERATURE) {
            newTemperature = MIN_TEMPERATURE;
        } else if (newTemperature > MAX_TEMPERATURE) {
            newTemperature = MAX_TEMPERATURE;
        }

        temperature = newTemperature;

        // 通知所有观察者 / Notify all observers
        System.out.println("\n--- Temperature Updated: " + String.format("%.2f", temperature) + "°C ---");
        notifyObservers(temperature);
    }

    /**
     * 线程运行方法，周期性更新温度
     * Thread run method that periodically updates temperature
     */
    @Override
    public void run() {
        while (running) {
            try {
                // 随机等待1-5秒 / Wait randomly for 1-5 seconds
                int sleepTime = (1 + random.nextInt(5)) * 1000;
                Thread.sleep(sleepTime);

                // 更新温度 / Update temperature
                updateTemperature();
            } catch (InterruptedException e) {
                System.out.println("Weather Station thread interrupted");
                break;
            }
        }
        System.out.println("Weather Station stopped");
    }

    /**
     * 停止气象站线程
     * Stop the weather station thread
     */
    public void stop() {
        running = false;
    }
}
