package com.jjk.testmybatisplus.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Shops extends Model<Shops> {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    @TableField("ShopNo")
    private Integer ShopNo;

    @TableField("ShopName")
    private String ShopName;

    @TableField("ShopOwner")
    private String ShopOwner;

    private String goods;

    private String charts;

    @TableField("IsExpired")
    private Boolean IsExpired;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
