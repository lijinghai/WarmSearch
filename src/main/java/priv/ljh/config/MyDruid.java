package priv.ljh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid 自定义配置
 * @author lijinghai
 * @Date 2021-1-19
 */
@Configuration
public class MyDruid {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource DruidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 后台监控
     * sprinboot内置了servlet容器，所以没有web.xml
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //登录的key是固定的
        initParameters.put("loginUsername","Dorian");
        initParameters.put("loginPassword","101599");

        //允许谁来验证
        initParameters.put("allow","");

        //禁止谁来访问
//        initParameters.put("aa","192.168.11.123");

        //设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //创建一个过滤器
        bean.setFilter(new WebStatFilter());
        //自定义过滤请求
        Map<String, String> initParameters = new HashMap<>();

        //排除哪些  这些东西不进行统计
        initParameters.put("exclusions","*.js,*/css,/druid/**");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
