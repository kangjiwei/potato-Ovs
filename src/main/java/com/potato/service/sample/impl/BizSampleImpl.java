package com.potato.service.sample.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potato.core.context.DCFRespMsg;
import com.potato.mapper.charizard.IndexMapper;
import com.potato.service.sample.InfSampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BizSampleImpl implements InfSampleService {

    @Autowired
    private DCFRespMsg dcfRespMsg;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IndexMapper indexMapper;

    public static final String ATOKEN = "accountname";

    //删除时，修改状态为1
    public static final String DELETESTATUS = "1";

    //默认的状态 0
    public static final String DELETE = "0";

}
