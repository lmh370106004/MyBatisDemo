package com.lmh.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * Created by liumuhang on 2018/6/15.
 */
@Configuration
@MapperScan(basePackages = {"com.lmh.demo.mapper.testOne"}, sqlSessionFactoryRef = "testOneSqlSessionFactory")
public class TestOneDataSourceConfig {

  @Autowired
  private MybatisProperties mybatisProperties;
  /**
   * mybatis mapper resource 路径
   */
  private static final String MAPPER_PATH = "mapper/testOne/**.xml";

  @Bean("testOneDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.druid")
  public DruidDataSource dataSource() {
    return new DruidDataSource();
  }

  @Bean("testOneTransactionManager")
  public DataSourceTransactionManager dataSourceTransactionManager(
      @Qualifier("testOneDataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean("testOneSqlSessionFactory")
  public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("testOneDataSource") DataSource dataSource)
      throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
    /** 添加mapper 扫描路径 */
    PathMatchingResourcePatternResolver
        pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
    String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
    sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
    return sqlSessionFactoryBean.getObject();
  }
}
