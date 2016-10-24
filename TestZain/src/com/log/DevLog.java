package com.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @title 日志打印工具类
 * @author Zain.Luo
 * @version 1.0<br>
 *          history<br>
 *          2016年10月17日 Zain.Luo create file<br>
 *          Id:DevLog.java,v1.0 2016年10月17日 下午4:54:09
 */
public class DevLog {
	private static final Logger logger = LogManager.getLogger("log4j.xml");

	public static void traceLog(String message) {
		logger.trace(message);
	}

	public static void debugLog(String message) {
		logger.debug(message);
	}

	public static void infoLog(String message) {
		logger.info(message);
	}

	public static void warnLog(String message) {
		logger.warn(message);
	}

	public static void errorLog(String message) {
		logger.error(message);
	}

	public static void fatalLog(String message) {
		logger.fatal(message);
	}

}
