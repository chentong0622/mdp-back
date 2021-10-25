package com.heeexy.example.dao.db1;

import com.heeexy.example.condition.ArticleCondition;
import com.heeexy.example.domain.entity.Article;

import java.util.List;

/**
 * @author: heeexy
 * @description: 用户/角色/权限
 * @date: 2017-11-14 15:08:45
 */
public interface Db1ArticleDao {
    /**
     * 查询用户数量
     */
    Article getArticle(int id);

    /**
     * 查询用户列表
     */
    List<Article> queryList(ArticleCondition condition);
}
