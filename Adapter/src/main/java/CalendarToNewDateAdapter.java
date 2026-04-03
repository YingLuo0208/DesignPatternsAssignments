package adapter.calendar;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    // 内部持有 Calendar 实例（对象适配器的核心）
    private final Calendar calendar;

    public CalendarToNewDateAdapter() {
        // 用当前时间初始化，也可以从外部传入
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Calendar 的月份是 0-based（0=January），
        // 而 NewDateInterface 约定 1-based，所以这里要 -1
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Calendar 返回 0-based，对外转回 1-based
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        // Calendar.add() 会自动处理跨月、跨年的进位
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}