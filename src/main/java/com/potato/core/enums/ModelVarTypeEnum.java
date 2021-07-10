package com.potato.core.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author huangyuling
 * @Date 2021/6/28 14:17
 */
@Getter
@ToString
public enum ModelVarTypeEnum {
    MODEL_VAR("modelVarList"),
    DEF_VAR("defVarList"),
    RULE_VAR("ruleVarList"),
    MODEL_PAGE("modelPage"),
    DEF_PAGE("defPage"),
    RULE_PAGE("rulePage"),
    MODEL_PAGES("modelPages"),
    DEF_PAGES("defPages"),
    RULE_PAGES("rulePages"),
    MODEL_VAR_PAGE_LIST("modelVarPageList"),
    DEF_VAR_PAGE_LIST("defVarPageList"),
    RULE_VAR_PAGE_LIST("ruleVarPageList");

    private String value;

    ModelVarTypeEnum(String value) {
        this.value = value;
    }
}
