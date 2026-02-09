package Observer.model;

import Observer.view.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Observable 类 - 被观察者抽象类
 * 提供注册、移除和通知观察者的基本功能
 * Provides basic functionality for registering, removing, and notifying observers
 */
public abstract class Observable {
    // 观察者列表 / List of observers
    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * Register an observer
     *
     * @param observer 要注册的观察者 / The observer to register
     */
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer registered: " + observer.getClass().getSimpleName());
        }
    }

    /**
     * 移除观察者
     * Remove an observer
     *
     * @param observer 要移除的观察者 / The observer to remove
     */
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer removed: " + observer.getClass().getSimpleName());
        }
    }

    /**
     * 通知所有注册的观察者
     * Notify all registered observers
     *
     * @param temperature 当前温度 / Current temperature
     */
    protected void notifyObservers(double temperature) {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
