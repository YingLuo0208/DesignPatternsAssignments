package Observer;

import Observer.model.WeatherStation;
import Observer.view.WeatherObserver;

/**
 * Main 类 - 主程序类
 * 演示观察者模式的天气站系统
 * Demonstrates the Observer pattern with a weather station system
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Weather Station Simulator ===\n");

        // 创建气象站 / Create weather station
        WeatherStation weatherStation = new WeatherStation();

        // 创建多个观察者 / Create multiple observers
        WeatherObserver observer1 = new WeatherObserver("Weather Display 1");
        WeatherObserver observer2 = new WeatherObserver("Weather Display 2");
        WeatherObserver observer3 = new WeatherObserver("Weather Display 3");

        // 注册观察者 / Register observers
        System.out.println("\n--- Registering Observers ---");
        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        // 启动气象站线程 / Start weather station thread
        System.out.println("\n--- Starting Weather Station ---");
        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        try {
            // 运行10秒 / Run for 10 seconds
            System.out.println("Running simulation for 10 seconds...\n");
            Thread.sleep(10000);

            // 移除一个观察者 / Remove one observer
            System.out.println("\n=== Removing Observer 2 ===");
            weatherStation.removeObserver(observer2);

            // 继续运行10秒 / Continue running for 10 seconds
            System.out.println("\nContinuing simulation for 10 more seconds...\n");
            Thread.sleep(10000);

            // 停止气象站 / Stop weather station
            System.out.println("\n=== Stopping Weather Station ===");
            weatherStation.stop();
            weatherThread.join(2000); // 等待线程结束 / Wait for thread to finish

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\n=== Simulation Ended ===");
    }
}
