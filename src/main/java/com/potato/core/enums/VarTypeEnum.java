package com.potato.core.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author huangyuling
 * @Date 2021/6/29 17:39
 */
@Getter
@ToString
public enum VarTypeEnum {
    MODEL_VAR(1),
    DEF_VAR(0),
    RULE_VAR(2);

    private Integer value;

    VarTypeEnum(Integer value) {
        this.value = value;
    }
}
