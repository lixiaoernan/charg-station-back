package com.demo.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("business_goods")
@Data
public class Good {
    private String id;
    private String goodsCode;
    private String goodsName;
    private String price;
    private String goodsSpec;
    private String goodsDesc;
    private String categoryId;
    private String createUser;
    private String createTime;
    private String modifyUser;
    private String modifyTime;
    private String deleted;
    private String goodsCount;
    private String goodsStatus;
}
