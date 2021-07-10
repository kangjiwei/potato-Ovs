package com.potato.controller;

import com.potato.core.context.DCFRespMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author huangyuling
 * @Date 2021/6/25 20:00
 */
@RequestMapping("/stitch")
@Controller
@Slf4j
public class AddModelController {

    @Autowired
    private DCFRespMsg dcfRespMsg;

}
