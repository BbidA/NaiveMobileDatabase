package mapper;

import entity.Plan;

import java.util.List;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public interface PlanMapper {

    List<Plan> getAllPlans();

    Plan getPlan(int id);

    List<Plan> findEffectivePlans(String phoneNumber);
}
