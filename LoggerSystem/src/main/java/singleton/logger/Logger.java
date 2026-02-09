package singleton.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logger 类 - 日志记录器类（单例模式）
 * 使用单例模式确保整个应用程序中只有一个日志记录器实例
 * Uses Singleton pattern to ensure only one logger instance exists in the application
 */
public class Logger {
    // 单例实例 / Singleton instance
    private static Logger instance;

    // 日志文件名 / Log file name
    private String fileName;

    // 缓冲写入器 / Buffered writer
    private BufferedWriter writer;

    // 日志目录路径 / Log directory path
    private static final String LOG_DIR = "src/main/java/singleton/logger/logs/";

    // 默认日志文件名 / Default log file name
    private static final String DEFAULT_FILE_NAME = "application.log";

    /**
     * 私有构造函数，防止外部实例化
     * Private constructor to prevent external instantiation
     */
    private Logger() {
        this.fileName = DEFAULT_FILE_NAME;
        initializeWriter();
    }

    /**
     * 获取Logger的唯一实例（线程安全）
     * Get the unique instance of Logger (thread-safe)
     *
     * @return Logger实例 / Logger instance
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * 初始化文件写入器
     * Initialize the file writer
     */
    private void initializeWriter() {
        try {
            // 确保日志目录存在 / Ensure log directory exists
            File logDir = new File(LOG_DIR);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            // 创建完整的文件路径 / Create full file path
            String fullPath = LOG_DIR + fileName;
            writer = new BufferedWriter(new FileWriter(fullPath, true));
            System.out.println("Logger initialized with file: " + fullPath);
        } catch (IOException e) {
            System.err.println("Error initializing logger with file: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * 设置新的日志文件名
     * Set a new log file name
     *
     * @param fileName 新的文件名 / New file name
     */
    public synchronized void setFileName(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            System.err.println("Invalid file name. Keeping current file: " + this.fileName);
            return;
        }

        // 关闭当前文件 / Close current file
        closeWriter();

        // 设置新文件名并打开 / Set new file name and open
        this.fileName = fileName;
        initializeWriter();
    }

    /**
     * 写入日志消息
     * Write a log message
     *
     * @param message 要写入的消息 / Message to write
     */
    public synchronized void write(String message) {
        if (writer == null) {
            System.err.println("Logger is not initialized. Cannot write message.");
            return;
        }

        try {
            writer.write(message);
            writer.newLine();
            writer.flush(); // 立即刷新到文件 / Flush immediately to file
            System.out.println("Log written: " + message);
        } catch (IOException e) {
            System.err.println("Error writing log message: " + message);
            e.printStackTrace();
        }
    }

    /**
     * 关闭写入器
     * Close the writer
     */
    private void closeWriter() {
        if (writer != null) {
            try {
                writer.close();
                System.out.println("Logger closed for file: " + LOG_DIR + fileName);
            } catch (IOException e) {
                System.err.println("Error closing logger for file: " + fileName);
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭日志记录器
     * Close the logger
     */
    public synchronized void close() {
        closeWriter();
        writer = null;
    }

    /**
     * 获取当前日志文件名
     * Get the current log file name
     *
     * @return 当前文件名 / Current file name
     */
    public String getFileName() {
        return fileName;
    }
}
