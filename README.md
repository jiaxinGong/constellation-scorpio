# 大概涉及点
 ## 1、springboot spring
 ## 2、api core web模块
 ## 3、mysql mybatis mybatis-plus HikariCP
 ## 4、todo dubbo 
 ## 5、redis zookeeper 
    中心化和去中心化思想
 ## 6 elastic-job 
 ## 7、权限 shiro jwt
 ## 8、idWork Snowflake

## 1)mybatis-plus集成
    1.1) 导包
    <dependency>
         <groupId>com.baomidou</groupId>
         <artifactId>mybatis-plus-boo t-starter</artifactId>
         <version>3.1.2</version>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-generator</artifactId>
        <version>3.1.2</version>
    </dependency> 
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>6.0.6</version>
    </dependency>
  
  ## 1.2)配置文件
  ## hikariCP
  spring.datasource.type=com.zaxxer.hikari.HikariDataSource
  spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
  spring.datasource.url=jdbc:mysql://192.168.150.11:3306/apolloconfigdb?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&generateSimpleParameterMetadata=true&useSSL=false
  spring.datasource.username=root
  spring.datasource.password=123456
  datasource.connectionProperties=config.decrypt=false;config.decrypt.key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJv4CwvgYgsoHK+vsDlYfLyY9H6kUYB0UznYxrE4mF4eg8qwjMyG/N0PBhVbOFPlAD20Cg44hBegEeSjlf+DY7sCAwEAAQ==
  spring.datasource.hikari.pool-name=constellation-scorpio
  spring.datasource.hikari.minimum-idle=5
  spring.datasource.hikari.maximum-pool-size=50
  spring.datasource.hikari.idle-timeout=600000
  spring.datasource.hikari.max-lifetime=1800000
  spring.datasource.hikari.connection-timeout=30000
  spring.datasource.hikari.connection-test-query=SELECT 'scorpio'
  
  ##mybatis
  mybatis-plus.mapper-locations=classpath:/mapper/*Mapper.xml
  mybatis-plus.type-aliases-package=com.jiaxin.constellation.scorpio.dao.entity
  
  ##1.3) bean配置
    注意：可以使用 @MapperScan 指定 mapper类所在包目录，也可以用@Bean MapperScannerConfigurer设置
    @Configuration
    @MapperScan("com.jiaxin.constellation.scorpio.dao.mapper*")
    public class MybatisPlusConfig {
    
        /**
         * pagination interceptor
         * 
         * @return
         */
        @Bean
        public PaginationInterceptor paginationInterceptor() {
            PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
            paginationInterceptor.setSqlParserList(new ArrayList<>());
    
            return paginationInterceptor;
        }
    
        /**
         * mybatis mapper scanner configurations
         * 
         * @return
         */
    //    @Bean
    //    public MapperScannerConfigurer mapperScannerConfigurer() {
    //        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
    //        scannerConfigurer.setBasePackage("com.jiaxin.constellation.scorpio.dao.mapper*");
    //        return scannerConfigurer;
    //    }
}
  
