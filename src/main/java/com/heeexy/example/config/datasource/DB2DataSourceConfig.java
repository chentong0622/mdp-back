package com.heeexy.example.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = DB2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DB2DataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.heeexy.example.dao.db2";
    static final String MAPPER_LOCATION = "classpath:mapper/db2/*.xml";

    @Value("${spring.db2.datasource.url}")
    private String url;

    @Value("${spring.db2.datasource.username}")
    private String user;

    @Value("${spring.db2.datasource.password}")
    private String password;

    @Value("${spring.db2.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "db2DataSource")
    public DataSource db2DataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager db2TransactionManager() {
        return new DataSourceTransactionManager(db2DataSource());
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("db2DataSource") DataSource db2DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(db2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DB2DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
