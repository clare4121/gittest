package com.cyp.gitnewmodulewhole.util.util.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author zhaoxuan
 * @description 能力汇聚参数处理
 * @createTime 2020/5/18 1:36 下午
 */
@Slf4j
@UtilityClass
public class CapacityConvergeResult {

    /**
     * 能力汇聚成功状态码
     */
    private final String RESPONSE_SUCCESS_CODE = "00000";

    /**
     * 解析业务响应信息，封装为JSONOjbect
     * @param result
     * @return
     * @throws Exception
     */
    public JSONObject parseResult(String result) throws Exception {
        JSONObject ccJsonObject = null;
        try {
            ccJsonObject = Optional.ofNullable(result).map(JSON::parseObject).orElseGet(JSONObject::new);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception();
        }
        if (!RESPONSE_SUCCESS_CODE.equals(String.valueOf(ccJsonObject.get("respCode")))) {
            throw new Exception();
        }
        try {
            return Optional.ofNullable(ccJsonObject.get("result")).map(Object::toString).map(JSON::parseObject).orElseGet(JSONObject::new);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception();
        }
    }

}
