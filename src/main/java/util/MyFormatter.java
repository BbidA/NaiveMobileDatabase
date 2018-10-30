package util;

import entity.CallExpense;
import entity.DataExpense;
import entity.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: J.D. Liao
 * Date: 2018/10/29
 * Description:
 */
public class MyFormatter {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    private static final String EXPENSE_FORMAT = "%s %10d %15.2f";


    public static String formatData(double dataFlow) {
        if (dataFlow > 1024)
            return String.format("%.2fG", dataFlow / 1024);
        else
            return String.format("%.2fM", dataFlow);
    }

    static String formatTime(LocalDateTime dateTime) {
        return dateTimeFormatter.format(dateTime);
    }

    static String formatOrderState(Order.State state) {
        switch (state) {
            case effective:
                return "生效中";
            case waiting_effective:
                return "次月生效";
            case out:
                return "已失效";
            case waiting_out:
                return "次月失效";
            default:
                throw new IllegalStateException();
        }
    }

    static String formatDataType(DataExpense.Type type) {
        switch (type) {
            case Local:
                return "本地流量";
            case Domestic:
                return "全国流量";
            default:
                throw new IllegalStateException();
        }
    }

    static String formatDataExpense(DataExpense expense) {
        return String.format("%s %s %10s %10s %10.2f", formatTime(expense.getStartTime()),
                formatTime(expense.getEndTime()), formatDataType(expense.getType()), formatData(expense.getDataConsumption()),
                expense.getExpense());
    }

    static String formatCallExpense(CallExpense expense) {
        return String.format(EXPENSE_FORMAT, formatTime(expense.getStartTime()),
                expense.getDuration(), expense.getExpense());
    }
}
