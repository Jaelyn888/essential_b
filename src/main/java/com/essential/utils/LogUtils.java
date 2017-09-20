package com.essential.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

	public static void debug(String msg) {
		debug("essential", msg);
	}

	public static void debug(String tag, Throwable t) {
		debug(tag, t.toString());
	}

	public static void debug(String tag, String msg) {
		Logger logger = LoggerFactory.getLogger(tag);
		logger.debug(msg);
	}

	public static void info(String msg) {
		info("essential", msg);
	}

	public static void info(String tag, Throwable t) {
		info(tag, t.toString());
	}

	public static void info(String tag, String msg) {
		Logger logger = LoggerFactory.getLogger(tag);
		logger.info(msg);
	}

	
	public static void warn(String msg) {
		warn("essential", msg);
	}

	public static void warn(String tag, Throwable t) {
		warn(tag, t.toString());
	}

	public static void warn(String tag, String msg) {
		Logger logger = LoggerFactory.getLogger(tag);
		logger.warn(msg);
	}
	
	public static void error(String msg) {
		error("essential", msg);
	}

	public static void error(String tag, Throwable t) {
		error(tag, t.toString());
	}

	public static void error(String tag, String msg) {
		Logger logger = LoggerFactory.getLogger(tag);
		logger.error(msg);
	}
	
}
