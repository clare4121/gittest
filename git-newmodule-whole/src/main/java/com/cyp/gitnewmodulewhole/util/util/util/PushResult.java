package com.cyp.gitnewmodulewhole.util.util.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoxuan
 * @description
 * @createTime 2020/5/27 4:17 下午
 */
@Data
@AllArgsConstructor
public class PushResult {

    private Boolean accessPush;

    private String result;

    private String capacityCode;

    private String capacityMsg;

    private String businessCode;

    private String businessMsg;


    /**
     * 错误1 - 没有返回信息，或者返回信息出错
     * @param result
     * @return
     */
    public static PushResult errorCapacityResponse(String result) {
        return new PushResult(false, result, null, null, null, null);
    }

    /**
     * 错误2 - 能力汇聚返回状态码不对
     * @param result
     * @return
     */
    public static PushResult errorCapacityCodeStatus(String result, String capacityCode, String capacityMsg) {
        return new PushResult(false, result, capacityCode, capacityMsg, null, null);
    }

    /**
     * 错误3 - 没有业务返回信息，或者返回信息出错
     * @param result
     * @return
     */
    public static PushResult errorBusinessResponse(String result, String capacityCode, String capacityMsg) {
        return new PushResult(false, result, capacityCode, capacityMsg, null, null);
    }


    /**
     * 错误4 - 业务返回状态码不对
     * @param result
     * @return
     */
    public static PushResult errorBusinessCodeStatus(String result, String capacityCode, String capacityMsg, String businessCode, String businessMsg) {
        return new PushResult(false, result, capacityCode, capacityMsg, businessCode, businessMsg);
    }

    /**
     * 错误5 - 其他错误
     * @param result
     * @return
     */
    public static PushResult error(String result) {
        return new PushResult(false, result, null, null, null, null);
    }


    /**
     * 调用成功
     * @return
     */
    public static PushResult success() {
        return new PushResult(true, null, null, null, null, null);
    }
    /**
     * 调用成功
     * @return
     */
    public static PushResult success(String balance){

        return new PushResult(true,balance,null,null,null,null);
    }
}
