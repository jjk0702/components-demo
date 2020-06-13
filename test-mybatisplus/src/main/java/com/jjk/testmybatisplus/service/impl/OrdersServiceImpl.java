package com.jjk.testmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjk.testmybatisplus.domain.entity.Orders;
import com.jjk.testmybatisplus.mapper.OrdersMapper;
import com.jjk.testmybatisplus.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjk
 * @since 2020-06-13
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public void Create(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public void Update(Orders orders) {
        Wrapper<Orders> wrapper = new Wrapper<Orders>() {
            @Override
            public Orders getEntity() {
                return null;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getCustomSqlSegment() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        };
        orders.update(wrapper);

//        orders.selectById()
    }

    @Override
    public void findByOrders(Orders orders) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("No", "goodName","goodNo").eq("ownerNo",123);
        Page<Orders> ordersIPage = new Page<Orders>();
        ordersIPage.setPages(0);
        ordersIPage.setSize(10);
        ordersMapper.selectPage(ordersIPage,queryWrapper);

        System.out.println(ordersIPage.getRecords().size());

    }
}
