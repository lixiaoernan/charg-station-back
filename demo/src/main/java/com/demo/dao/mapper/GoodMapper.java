package com.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.bean.entity.Good;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodMapper extends BaseMapper<Good> {
}
