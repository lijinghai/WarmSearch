package priv.ljh.config;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger
 * @author lijinghai
 * @Date 2021-1-19
 */

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class MySwagger {

    /**
     * https://localhost:8080/swagger-ui.html
     * https://localhost:8080/doc.html
     * 配置了Swagger的Docket的Bean实例
     * @return
     */
    @Bean
    public Docket docket(Environment environment){
//    public Docket docket(){

       //设置Swagger要显示的环境
        Profiles profiles = Profiles.of("dev");
        //获取项目的环境
        //通过environment.acceptsProfiles判断是否在自己设置的环境当中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置分组 一个Docket 一个组
                .groupName("李京海")
                //enable(false) 是否自动开启Swagger false不能访问
//                .enable(flag)
                //Swagger配置扫描接口
                .select()
                //RequestHandlerSelectors ->配置扫描接口的方式
                //basePackage() 指定要扫描的包
                //any() 扫描全部
                //none() 不扫描
                // withClassAnnotation(***.class) 扫描类上的注解,参数是一个注解的反射对象
                //withMethodAnnotation() 扫描方法上的注解
                //.apis(RequestHandlerSelectors.basePackage("priv.ljh.operate.controller"))
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage("priv.ljh.operate.controller"),
                        RequestHandlerSelectors.basePackage("priv.ljh.uniapp.controller"),
                        RequestHandlerSelectors.basePackage("priv.ljh.utils")
                ))
                //paths() 过滤什么路径
                //.paths(PathSelectors.ant("/**/**"))
                //build() 类似工厂模式
                .build();
    }

    /**
     * 配置Swagger信息=apiInfo
     * @return
     */
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("李京海", "http://github.com/Dorian1015", "1503676492@qq.com");
        return new ApiInfo(
                "李京海的SwaggerAPI文档",
                "东道若逢相识问，青袍今已误儒生。",
                "v1.0",
                "http://github.com/Dorian1015",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("default");
    }
}
