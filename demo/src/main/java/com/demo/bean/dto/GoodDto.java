package com.demo.bean.dto;

import lombok.Data;

@Data
public class GoodDto {
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
