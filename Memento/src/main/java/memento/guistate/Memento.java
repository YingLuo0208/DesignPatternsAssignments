package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Memento class stores the state of the Model.
 * It implements the IMemento interface.
 * Memento 类存储 Model 的状态。
 * 它实现了 IMemento 接口。
 */
public class Memento implements IMemento {
    private int[] options; // Stores the configuration of options // 存储选项配置
    private boolean isSelected; // Stores the selection state // 存储选中状态
    private LocalDateTime timestamp; // Timestamp of creation // 创建时间戳
    private String description; // Description of the state // 状态描述

    /**
     * Constructor for Memento.
     * @param options The array of options to save.
     * @param isSelected The selection state to save.
     * 构造函数。
     * @param options 要保存的选项数组。
     * @param isSelected 要保存的选中状态。
     */
    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        this.timestamp = LocalDateTime.now();
        this.description = generateDescription();
        System.out.println("Memento created at " + timestamp);
    }

    /**
     * Generates a description for the memento based on timestamp.
     * @return The description string.
     * 根据时间戳生成备忘录描述。
     * @return 描述字符串。
     */
    private String generateDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "State saved at " + timestamp.format(formatter);
    }

    /**
     * Gets the saved options.
     * @return The array of options.
     * 获取保存的选项。
     * @return 选项数组。
     */
    public int[] getOptions() {
        return options;
    }

    /**
     * Gets the saved selection state.
     * @return The selection state.
     * 获取保存的选中状态。
     * @return 选中状态。
     */
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
