package com.wyl.mall.utils;/**
 * @Auther:calf
 * @Date:2021/8/7
 * @Description:mall411
 * @version:1.0
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志处理
 **/
public class Log4jUtil {
    private static final Logger logger = LoggerFactory.getLogger(Log4jUtil.class);

    public static void info(String info) {
        logger.info(info);
    }

    public static void error(String error) {
        logger.error(error);
    }

    public static void warn(String warn) { logger.warn(warn); }

}
