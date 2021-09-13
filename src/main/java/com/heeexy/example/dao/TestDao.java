package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.condition.ArticleCondition;
import com.heeexy.example.domain.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: heeexy
 * @description: 用户/角色/权限
 * @date: 2017-11-14 15:08:45
 */
public interface TestDao {
    /**
     * 查询用户数量
     */
    Article getArticle(int id);

    /**
     * 查询用户列表
     */
    List<Article> queryList(ArticleCondition condition);
}
