package com.jjk.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjk.testmybatisplus.domain.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuan
 * @since 2020-06-13
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
//        Page<Orders> selectByIdAndName();
}
