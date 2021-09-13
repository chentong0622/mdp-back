package com.heeexy.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章类
 *
 * @author chent
 * @Date 2021-09-13 9:42:42
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 文章
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}