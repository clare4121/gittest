package com.cyp.gitnewmodulewhole.util.util.util;

/**
 * @author zhaoxuan
 * @description TODO
 * @createTime 2020/5/27 5:41 下午
 */
public enum  FilterEnum {

    USER_STATUS_ERR("1001","用户状态异常"),
    CUR_MONTH_PUSHED("1002","当月已经发送过"),
    NO_FUNDS("1003","余额不足或异常"),
    GREAT_MAX_PUSH_NUMS("1004","超过最大发送次数"),
    GREAT_RETRY_NUMS("1005", "超过重试次数"),
    SYSTEM_ERR("1006", "系统错误"),
    FIRST_PUSH_RECORD_EXCEPTION("1007","判断超过最大发送次数过程中，查询首冲记录为空"),
    FIRST_PUSH_DATE_EXCEPTION("1008","判断超过最大发送次数过程中，查询首冲日期为空");

    public final String filterCode;

    public final String filterMsg;

    FilterEnum(String filterCode, String filterMsg) {
        this.filterCode = filterCode;
        this.filterMsg = filterMsg;
    }
}
