package com.cyp.gitnewmodulewhole.util.util.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxuan
 * @description TODO
 * @createTime 2020/6/16 8:16 下午
 */
@UtilityClass
@Slf4j
public class StringUtils {

    /**
     * 获取表名
     * 从from tableName@dblink tableName中获取tableName
     * @param str
     * @return
     */
    public String lastWord(String str) {
        try {
            int position = str.lastIndexOf(" ");
            if (position == -1) {
                return null;
            }
            String strTem=str.substring(0,position).trim();
            return str.substring(position).trim();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
