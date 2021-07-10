package com.potato.service.model.impl;


import com.potato.core.context.DCFRespMsg;
import com.potato.service.model.InfModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class BizModelServiceImpl implements InfModelService {
    @Autowired
    private DCFRespMsg dcfRespMsg;

}
