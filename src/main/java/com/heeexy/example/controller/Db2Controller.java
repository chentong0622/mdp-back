package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.Db2Service;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db2Test")
public class Db2Controller {

    @Autowired
    private Db2Service db2Service;

    /**
     * 查询用户列表
     */
    @PostMapping("/getArticle")
    public JSONObject getArticle(@RequestBody JSONObject requestJson) {
        int id = Integer.parseInt((String)requestJson.get("id"));
        return CommonUtil.successJson(db2Service.getArticle(id));
    }
    /**
     * 查询用户列表
     */
    @PostMapping("/queryList")
    public JSONObject queryList(@RequestBody JSONObject requestJson) {
        return CommonUtil.successJson(db2Service.getArticle(1));
    }
}
