package priv.ljh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.ljh.utils.JWTInterceptor;

/**
 * JWT拦截器配置类
 * @author lijinghailjh@163.com
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //设置拦截的路劲  其他接口保护
                .addPathPatterns("/pcuser/**")
                //排除用户相关的路径  放行所有用户请求
                .excludePathPatterns("/pcuser/login")
                .excludePathPatterns("/pcuser/add");
//                .excludePathPatterns("/user/login");
    }
}
