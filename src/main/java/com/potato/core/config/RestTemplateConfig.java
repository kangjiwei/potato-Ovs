package com.potato.core.config;

import com.potato.core.context.DCFRespBody;
import com.potato.core.context.DCFRespMsg;
import com.potato.core.enums.RetCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


/**
 * @Author huangyuling
 * @Date 2021/6/29 15:42
 */
@Configuration
@Slf4j
public class RestTemplateConfig {
    @Autowired
    private DCFRespMsg dcfRespMsg;
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers;

    /**
     * post请求调用
     *
     * @param urlApi 请求地址url
     * @param object 请求体内容
     */
    public DCFRespBody transferPostApi(String urlApi, Object object) {
        headers = new HttpHeaders();
        headers.add("accountname", "xiaomai");
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(object, headers);
        try {
            return restTemplate.postForObject(urlApi, httpEntity, DCFRespBody.class);
        } catch (Exception e) {
            log.info("访问接口异常{}",e.getMessage());
            return dcfRespMsg.putMsg(RetCode.OP_FAIL,"接口连接被拒绝");
        }
    }
}
