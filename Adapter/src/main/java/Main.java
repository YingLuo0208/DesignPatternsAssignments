package adapter.calendar;

public class Main {
    public static void main(String[] args) {

        // 客户端只依赖 NewDateInterface，不知道 Calendar 的存在
        NewDateInterface date = new CalendarToNewDateAdapter();

        // 设置日期为 2026 年 4 月 3 日
        date.setYear(2026);
        date.setMonth(4);
        date.setDay(3);

        System.out.println("Initial date:");
        printDate(date);

        // 向后推进 3 天（跨月测试：2月26 + 3 = 2月29，2024是闰年）
        date.advanceDays(3);
        System.out.println("\nAfter advancing 3 days:");
        printDate(date);

        // 再推进 10 天（跨月：2月29 + 10 = 3月10）
        date.advanceDays(10);
        System.out.println("\nAfter advancing 10 more days:");
        printDate(date);

        // 推进 300 天（跨年测试）
        date.advanceDays(300);
        System.out.println("\nAfter advancing 300 more days (crossing year):");
        printDate(date);
    }

    // 辅助方法，格式化打印日期
    private static void printDate(NewDateInterface date) {
        System.out.printf("  %04d-%02d-%02d%n",
                date.getYear(), date.getMonth(), date.getDay());
    }
}