package com.potato.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author huangyuling
 * @Date 2021/6/29 16:34
 */
@Component
@Data
public class ApiInfo {
    @Value("${runModel}")
    public String runModel;
}
