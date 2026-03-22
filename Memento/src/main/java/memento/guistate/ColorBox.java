package memento.guistate;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * ColorBox represents a clickable colored rectangle in the GUI.
 * It changes color when clicked and notifies the controller.
 * ColorBox 代表 GUI 中可点击的彩色矩形。
 * 点击时会改变颜色并通知控制器。
 */
public class ColorBox {

    private int id; // Identifier for the ColorBox // 颜色框的标识符
    private Controller controller; // Reference to the controller // 控制器引用

    private Rectangle rectangle; // The JavaFX Rectangle node // JavaFX 矩形节点
    // Available colors for the box // 可用的颜色
    private Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};
    private int colorIndex = 0; // Current color index // 当前颜色索引

    /**
     * Constructor for ColorBox.
     * @param id The identifier for the box.
     * @param controller The controller to notify of changes.
     * 构造函数。
     * @param id 盒子标识符。
     * @param controller 用于通知更改的控制器。
     */
    public ColorBox(int id, Controller controller) {

        // Initialize the rectangle with default size and color
        // 初始化矩形，设置默认大小和颜色
        rectangle = new Rectangle(100, 100);
        rectangle.setFill(colors[colorIndex]);

        // Add a mouse click listener to change color on click
        // 添加鼠标点击监听器，点击时改变颜色
        rectangle.setOnMouseClicked(event -> {
            changeColor();
            controller.setOption(id, colorIndex);
        });
    }

    /**
     * Returns the visual Rectangle node.
     * @return The JavaFX Rectangle.
     * 返回可视化的矩形节点。
     * @return JavaFX Rectangle 对象。
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * Cycles to the next color in the array.
     * 循环切换到数组中的下一个颜色。
     */
    private void changeColor() {
        colorIndex = (colorIndex + 1) % colors.length;
        rectangle.setFill(colors[colorIndex]);
    }

    /**
     * Sets the color based on the given index.
     * @param colorIndex The index of the color to set.
     * 根据给定索引设置颜色。
     * @param colorIndex 要设置的颜色索引。
     */
    public void setColor(int colorIndex) {
        this.colorIndex = colorIndex;
        rectangle.setFill(colors[colorIndex]);
    }

}
