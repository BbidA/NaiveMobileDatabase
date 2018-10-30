package mapper;

import entity.User;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public interface UserMapper {

    User getByPhoneNumber(String phoneNumber);

    void save(User user);

    void update(User user);
}
