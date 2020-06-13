package com.jjk.testmybatisplus.service;

import com.jjk.testmybatisplus.domain.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuan
 * @since 2020-06-13
 */
public interface OrdersService extends IService<Orders> {
    void Create(Orders orders);

    void Update(Orders orders);

    void findByOrders(Orders  orders);
}
