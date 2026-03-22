package memento.guistate;

/**
 * Model represents the data and logic of the application.
 * It acts as the Originator in the Memento pattern.
 * Model 代表应用程序的数据和逻辑。
 * 它在备忘录模式中充当 Originator（原发器）。
 */
public class Model {
    private int[] options = new int[3]; // Represents the state of 3 options // 代表3个选项的状态
    private boolean isSelected; // Represents a boolean state // 代表一个布尔状态

    /**
     * Sets an option value.
     * @param optionNumber The index of the option (1-3).
     * @param choice The value to set.
     * 设置选项值。
     * @param optionNumber 选项索引 (1-3)。
     * @param choice 要设置的值。
     */
    public void setOption(int optionNumber, int choice) {
        System.out.println("optionNumber: " + optionNumber + " choice: " + choice);
        if (optionNumber >= 1 && optionNumber <= 3) {
            options[optionNumber - 1] = choice;
        }
    }

    /**
     * Gets an option value.
     * @param optionNumber The index of the option.
     * @return The value of the option.
     * 获取选项值。
     * @param optionNumber 选项索引。
     * @return 选项的值。
     */
    public int getOption(int optionNumber) {
        if (optionNumber >= 1 && optionNumber <= 3) {
            return options[optionNumber - 1];
        }
        return -1;
    }

    /**
     * Sets the selection state.
     * @param isSelected The new state.
     * 设置选中状态。
     * @param isSelected 新状态。
     */
    public void setIsSelected(boolean isSelected) {
        System.out.println("isSelected: " + isSelected);
        this.isSelected = isSelected;
    }

    /**
     * Gets the selection state.
     * @return The current state.
     * 获取选中状态。
     * @return 当前状态。
     */
    public boolean getIsSelected() {
        return isSelected;
    }

    // method to save the state of the model
    // 保存模型状态的方法
    public IMemento createMemento() {
        return new Memento(options, isSelected);
    }

    // method to restore the state of the model
    // 恢复模型状态的方法
    public void restoreState(IMemento memento) {
        Memento selectionMemento = (Memento) memento;
        options = selectionMemento.getOptions();
        System.out.println("options: " + options[0] + " " + options[1] + " " + options[2]);
        isSelected = selectionMemento.isSelected();
        System.out.println("isSelected: " + isSelected);
        System.out.println("State restored");
    }
}
