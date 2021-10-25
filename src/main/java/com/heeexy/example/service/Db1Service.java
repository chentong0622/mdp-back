package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.condition.ArticleCondition;
import com.heeexy.example.dao.db1.Db1ArticleDao;
import com.heeexy.example.domain.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: chent
 * @description: 用户/角色/权限
 * @date: 2021/09/13 10:18
 */
@Service
public class Db1Service {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Resource
    private Db1ArticleDao db1ArticleDao;

    /**
     * 查询文章
     */
    public Article getArticle(int id) {
        logger.error("收到查询文章请求,id:{}", id);
        return db1ArticleDao.getArticle(id);
    }

    /**
     * 查询文章列表
     */
    public List<Article> queryList(ArticleCondition condition) {
        logger.error("收到查询文章列表请求,condition:{}", JSONObject.toJSONString(condition));
        return db1ArticleDao.queryList(condition);
    }

}
