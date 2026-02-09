package singleton.logger;

/**
 * Main 类 - 主程序类
 * 演示单例模式的日志记录器系统
 * Demonstrates the Singleton pattern Logger system
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Logger System Demo ===\n");

        // 获取Logger单例实例 / Get Logger singleton instance
        Logger logger = Logger.getInstance();

        // 使用默认文件写入日志 / Write logs using default file
        logger.write("Application started");
        logger.write("Loading configuration...");
        logger.write("Configuration loaded successfully");

        System.out.println();

        // 更改日志文件名 / Change log file name
        logger.setFileName("new_log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        System.out.println();

        // 验证单例模式 - 获取相同的实例 / Verify Singleton - get same instance
        Logger logger2 = Logger.getInstance();
        System.out.println("Are both logger instances the same? " + (logger == logger2));
        logger2.write("This message is from logger2 instance");

        System.out.println();

        // 演示多线程环境下的单例 / Demonstrate Singleton in multi-threaded environment
        System.out.println("Testing in multi-threaded environment...");
        Thread thread1 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.write("Log from Thread 1");
        });

        Thread thread2 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.write("Log from Thread 2");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        // 关闭日志记录器 / Close the logger
        logger.close();

        System.out.println("\n=== Logger System Demo Finished ===");
    }
}
