package com.lei.log.plugin.config;

import com.lei.log.plugin.LogPersistAspect;
import com.lei.log.plugin.server.LogOperationsService;
import com.lei.log.plugin.server.defaults.LogOperationServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zl
 * @date 2020/5/21 11:48
 * @description 自动配置加载插件
 */
@Configuration
@ConditionalOnWebApplication
public class LoadPluginConfig {

    /**
     * 日志处理切面添加到IOC容器中
     */
    @ConditionalOnExpression("${aspect.logTag-enable:true}")
    @Bean
    public LogPersistAspect getLogPersistAspect(){
        return new LogPersistAspect();
    }

    /**
     * 没有实现日志保存接口，则注入默认实现类的bean
     */
    @ConditionalOnExpression("${aspect.logTag-enable:true}")
    @ConditionalOnMissingBean(LogOperationsService.class)
    @Bean
    public LogOperationServiceImpl getDefaultService(){
        return new LogOperationServiceImpl();
    }

    @ConditionalOnExpression("${aspect.logTag-enable:true}")
    @Bean
    public LogTagProperties logTagProperties(){
        return new LogTagProperties();
    }
}
