package site.muzhi.secondkill.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.muzhi.exception.BusinessException;
import site.muzhi.secondkill.common.Order;
import site.muzhi.secondkill.common.Product;
import site.muzhi.secondkill.mapper.OrderMapper;
import site.muzhi.secondkill.mapper.ProductMapper;
import site.muzhi.secondkill.service.IOrderService;

/**
 * @author lichuang
 * @date 2021/05/23
 * @description
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private Snowflake snowflake;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void secondKill(Integer productId) throws BusinessException {
        Product product = productMapper.selectById(productId);
        if (product.getStock() <= 0) {
            throw new BusinessException("x001", "商品已售完");
        }

        // 创建订单
        Order order = new Order();
        order.setId(snowflake.nextId());
        order.setAmount(1);
        order.setProductId(productId);

        orderMapper.insert(order);

        // 减库存
        product.setStock(product.getStock() - 1);
        int i = productMapper.updateById(product);
        if (i <= 0) {
            throw new BusinessException("x001", "商品已售完");
        }
    }
}
