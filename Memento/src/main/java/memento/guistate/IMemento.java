package memento.guistate;

import java.time.LocalDateTime;

/**
 * IMemento interface defines the metadata methods for a Memento.
 * It provides a narrow interface to the Caretaker (Controller).
 * IMemento 接口定义了 Memento 的元数据方法。
 * 它为 Caretaker (Controller) 提供了一个窄接口。
 */
public interface IMemento {
    // Metadata methods
    // 元数据方法
    LocalDateTime getTimestamp(); // Get the timestamp of creation // 获取创建时间戳
    String getDescription(); // Get the description of the state // 获取状态描述
}
