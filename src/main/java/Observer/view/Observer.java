package Observer.view;

/**
 * Observer 接口 - 观察者接口
 * 定义观察者的更新方法，当被观察对象状态改变时会被调用
 * Defines the update method that will be called when the observable object's state changes
 */
public interface Observer {
    /**
     * 当被观察对象发生变化时调用此方法
     * Called when the observable object changes
     *
     * @param temperature 当前温度 / Current temperature
     */
    void update(double temperature);
}
