package com.lei.log.plugin.server;

import com.lei.log.plugin.model.LogzlVO;

/**
 * @author: zl
 * @date: 2020/5/21 10:47
 * @description: 日志操作接口定义
 */
public interface LogOperationsService {
    /**
     * 方法执行前保存日志
     * @param vo 日志信息
     */
    void save(LogzlVO vo);

    /**
     * 方法执行完保存日志，日志信息中有返回结果
     * @param vo 日志信息
     */
    void saveOrUpdate(LogzlVO vo);
}
