package com.jiaxin.constellation.scorpio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jiaxin.gong
 * @date 2020/9/10 22:05
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(getApiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.jiaxin.constellation.scorpio.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
            .title("Swagger2....")
            .description("Swagger2")
            .version("1.0")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .build();
    }
}
