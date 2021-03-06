package priv.ljh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * 处理前后端跨域问题
 * @author lijinghai
<<<<<<< HEAD
 * @Date 2021-1-26
=======
 * @Date 2021-1-27
>>>>>>> dev
 */
@Configuration
@Slf4j
public class MyWebCrossOrgin {

    @Value("${allowed.origin}")
    private String allowedOrigin;
    @Value("${allowed1.origin1}")
    private String allowedOrigin1;
    @Value("${allowed2.origin2}")
    private String allowedOrigin2;
    @Bean
    public CorsFilter corsFilter() {
        log.info(this.allowedOrigin);
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        //这里填写请求的前端服务器
        config.addAllowedOrigin(allowedOrigin);
        config.addAllowedOrigin(allowedOrigin1);
        config.addAllowedOrigin(allowedOrigin2);
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 4）允许的头信息
        config.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}