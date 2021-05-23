package site.muzhi.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.muzhi.exception.BusinessRuntimeException;
import site.muzhi.secondkill.common.Order;

/**
 * @author lichuang
 * @date 2021/05/23
 * @description
 */
public interface IOrderService extends IService<Order> {

    void secondKill(Integer productId) throws BusinessRuntimeException;
}
