package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.condition.ArticleCondition;
import com.heeexy.example.dao.TestDao;
import com.heeexy.example.dao.UserDao;
import com.heeexy.example.domain.entity.Article;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author: chent
 * @description: 用户/角色/权限
 * @date: 2021/09/13 10:18
 */
@Service
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Resource
    private TestDao testDao;

    /**
     * 查询文章
     */
    public Article getArticle(int id){
        logger.error("收到查询文章请求,id:{}",id);
        return testDao.getArticle(id);
    }

    /**
     * 查询文章列表
     */
    public List<Article> queryList(ArticleCondition condition){
        logger.error("收到查询文章列表请求,condition:{}", JSONObject.toJSONString(condition));
        return testDao.queryList(condition);
    }

}
