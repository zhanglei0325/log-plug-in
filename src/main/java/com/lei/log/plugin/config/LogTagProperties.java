package com.lei.log.plugin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zl
 * @date 2020/5/21 16:42
 * @description 配置信息
 * ignoreInvalidFields=true  属性类型对应错误，不会启动失败
 */
@ConfigurationProperties(prefix = "aspect", ignoreInvalidFields = true)
public class LogTagProperties {
    /**
     * 是否启动日志保存插件
     */
    public Boolean logTagEnable = true;

    public Boolean getLogTagEnable() {
        return logTagEnable;
    }

    public void setLogTagEnable(Boolean logTagEnable) {
        this.logTagEnable = logTagEnable;
    }
}
