package com.xebia.starters.utils;

import org.json.JSONObject;
import org.slf4j.Logger;

public class LogUtils {
    public static void logAsJsonObjet(Logger logger, String format, JSONObject jsonObject) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, jsonObject.toString(2));
        }
    }
}
