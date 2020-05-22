package com.lei.log.plugin.server.defaults;

import com.lei.log.plugin.model.LogzlVO;
import com.lei.log.plugin.server.LogOperationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zl
 * @date 2020/5/21 15:17
 * @description 日志接口服务默认实现类
 */
public class LogOperationServiceImpl implements LogOperationsService {
    /** logger */
    private static final Logger log = LoggerFactory.getLogger(LogOperationServiceImpl.class);

    @Override
    public void save(LogzlVO vo) {
        log.error("未保存日志，请自己实现日志保存接口！... 实现LogOperationsService接口");
    }

    @Override
    public void saveOrUpdate(LogzlVO vo) {
        log.error("未保存日志，请自己实现日志保存接口！... 实现LogOperationsService接口");
    }
}
