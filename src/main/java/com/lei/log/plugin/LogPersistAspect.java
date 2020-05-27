package com.lei.log.plugin;

import com.alibaba.fastjson.JSON;
import com.lei.log.plugin.annotation.LogTag;
import com.lei.log.plugin.model.LogzlVO;
import com.lei.log.plugin.server.LogOperationsService;
import com.lei.log.plugin.utils.RequestAssistUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zl
 * @date: 2020/5/21 10:21
 * @description: 日志持久化插件
 */
@Aspect
@Order(10)
public class LogPersistAspect {
    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(LogPersistAspect.class);

    @Resource
    private LogOperationsService logService;

    @Around("@annotation(com.lei.log.plugin.annotation.LogTag)")
    public Object pointcutLog(ProceedingJoinPoint joinPoint) throws Throwable {
        LogzlVO logzlVO = null;
        try {
            logzlVO = analysisData(joinPoint);
        } catch (Exception e) {
            log.error("保存日志失败：", e);
        }
        Object proceed = joinPoint.proceed();
        if (logzlVO != null) {
            try {
                logzlVO.setResults(JSON.toJSONString(proceed));
                logService.saveOrUpdate(logzlVO);
            } catch (Exception e) {
                log.error("方法返回结果获取日志失败：", e);
            }
        }
        return proceed;
    }

    private LogzlVO analysisData(ProceedingJoinPoint joinPoint) {
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            return null;
        }
        UserAgent userAgent = getOperatingSystem(request);
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();

        String url = request.getRequestURI();
        String method = request.getMethod();
        String ip = RequestAssistUtil.getIpAddress(request);
        String systemName = os.getName();
        String browserName = browser.getName();
        String params = Arrays.toString(joinPoint.getArgs());
        LogTag logTag = getAnnotationLog(joinPoint);
        String title = logTag != null ? logTag.title() : "";
        String name = logTag != null ? logTag.name() : "";
        int type = logTag != null ? logTag.type() : 0;
        LogzlVO vo = new LogzlVO(title, name, type, url, method, ip, systemName, browserName, params, null);
        logService.save(vo);
        return vo;
    }

    private UserAgent getOperatingSystem(HttpServletRequest request) {
        return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
    }

    /**
     * 获取request
     */
    private HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (sra == null) {
            return null;
        }
        return sra.getRequest();
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private LogTag getAnnotationLog(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(LogTag.class);
        }
        return null;
    }
}
