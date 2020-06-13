package com.jjk.testmybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuan
 * @since 2020-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    @TableId("No")
    private String No;

    @TableField("goodName")
    private String goodName;

    @TableField("goodNo")
    private String goodNo;

    private BigDecimal cost;

    @TableField("ownerNo")
    private Long ownerNo;

    @TableField("IsExipred")
    private Integer IsExipred;

    @TableField("ShopNo")
    private Long ShopNo;


    @Override
    protected Serializable pkVal() {
        return this.No;
    }

}
