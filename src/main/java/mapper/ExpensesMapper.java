package mapper;

import entity.CallExpense;
import entity.DataExpense;

import java.util.List;
import java.util.Map;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public interface ExpensesMapper {

    List<CallExpense> getCallExpensesInRecentMonths(Map<String, Object> parameters);

    List<DataExpense> getDataExpensesInRecentMonths(Map<String, Object> parameters);
}
