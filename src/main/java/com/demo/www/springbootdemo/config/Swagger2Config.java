package com.demo.www.springbootdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2 //@EnableSwagger2开启swagger2
//@ConfigurationProperties(prefix ="swagger")
public class Swagger2Config {

//    @Value("${swagger}")
    private Boolean swagger=true;

    @Bean
    public Docket createRestApi() {

        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("用户token")
                .modelRef(new ModelRef("String")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数

        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(pars)
                //是否开启swagger功能

                .apiInfo(apiInfo())
                .select()
                //apis()指定扫描的包会生成文档
                .apis(RequestHandlerSelectors.basePackage("com.demo.www.springbootdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档工具")
                .description("Author：陈如水")
                .termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                .build();
    }
}
