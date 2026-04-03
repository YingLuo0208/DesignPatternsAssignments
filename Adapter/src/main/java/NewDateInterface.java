package adapter.calendar;

public interface NewDateInterface {
    void setDay(int day);
    void setMonth(int month);   // 注意：传入 1-12，内部转换
    void setYear(int year);

    int getDay();
    int getMonth();             // 返回 1-12，对外屏蔽 Calendar 从 0 开始的细节
    int getYear();

    void advanceDays(int days);
}