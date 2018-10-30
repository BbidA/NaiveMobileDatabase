package mapper;

import entity.Order;
import entity.Plan;

import java.util.List;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public interface OrderMapper {

    default Order getByPhoneAndPlan(String phone, int planId) {
        return findByPhoneAndPlan(new PhoneAndPlan(phone, planId));
    }

    void unsubscribeImmediately(Order order);

    void unsubscribeNextMonth(Order order);

    void addOrder(Order order);

    List<Order> findCurrentlyEffectiveOrders(String phoneNumber);

    List<Order> findAllOrders(String phoneNumber);

    Order findByPhoneAndPlan(PhoneAndPlan phoneAndPlan);

    Order get(String phone, Integer planId);

    class PhoneAndPlan {
        private String phone;

        private int planId;

        PhoneAndPlan(String phone, int planId) {
            this.phone = phone;
            this.planId = planId;
        }

        public String getUserPhone() {
            return phone;
        }

        public int getPackageId() {
            return planId;
        }
    }
}
