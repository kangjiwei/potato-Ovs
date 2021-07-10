package com.potato.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author XiongDa
 * @Date 2021/05/14
 */
@Slf4j
public class GenerateUuid {

    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }


    public static boolean isNull(Object param) {
        return param == null || "".equals(param);
    }

    public static boolean isNotNull(Object param) {
        return null != param && !"null".equals(param) && !"".equals(param);
    }

    public static String toStr(Object paramObj) {
        if (paramObj instanceof String) {
            return paramObj + "";
        }
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(paramObj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}


