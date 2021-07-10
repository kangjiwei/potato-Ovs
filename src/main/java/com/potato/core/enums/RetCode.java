package com.potato.core.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @author xuanr
 * @create 2021-03-08 6:24 PM
 */
@Getter
@ToString
public enum RetCode {

    OP_FAIL(-1, "操作失败"),
    OP_SUCC(200, "操作成功"),
    VAIL_PARAM(205,"非法参数"),
    NOT_FOUND_USER(407,"未发现用户信息"),
    NOT_NULL_SAMPLEUUID(408,"样本uuid不可以为空"),
    NOT_NULL_PLANNAME(409,"指标计划名称不可以为空"),
    NOT_NULL_PLANVERSION(410,"指标计划版本不可以为空"),
    NOT_NULL_NAMECN(411,"业务单元中文名称不可以为空"),
    NOT_NULL_SAMPLENAME(412,"样本名称不可以为空"),
    NOT_NULL_PLANUUID(413,"指标计划uuid不可以为空"),
    NOT_NULL_UNITINDEX(414,"业务单元不可以为空"),
    NOT_UNITINDEX(415,"业务单元,指标信息数量不匹配"),

    ;


    private int value;
    private String message;

    RetCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

}
