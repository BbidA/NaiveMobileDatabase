package mapper;

import entity.BasicCharge;

/**
 * Author: J.D. Liao
 * Date: 2018/10/28
 * Description:
 */
public interface BasicChargeMapper {

    BasicCharge getCurrentCharge();

    void add(BasicCharge charge);
}
