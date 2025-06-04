package com.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.bean.entity.Good;
import com.demo.dao.mapper.GoodMapper;
import com.demo.service.DeepSeekService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloWordController {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private DeepSeekService deepSeekService;

    @GetMapping("/hello")
    public String getHelloWord() {
        return "Hello World";
    }

    @GetMapping("/good")
    public String getGood() {
        return goodMapper.selectById("18a94ecb79e6b95191b3f68315191a5c").getGoodsName();
    }

    @GetMapping("/goods")
    public List<Good> getGoods() {
        return goodMapper.selectList(Wrappers.lambdaQuery());
    }

    @GetMapping("/chat")
    public String chatTest() {
        return deepSeekService.chatCompletions("{\n" +
                "  \"model\": \"deepseek-chat\",\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"role\": \"system\",\n" +
                "      \"content\": \"帮我写一个查询所有学生成绩的sql\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"stream\": false\n" +
                "}");
    }

    @GetMapping("/chatRestTemplate")
    public String chatByRestTemplate() throws JsonProcessingException {
        return deepSeekService.chatCompletionsRestTemplate();
    }
}
