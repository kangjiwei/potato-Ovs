package com.potato.core.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potato.core.enums.RetCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Component
public class DCFRespMsg {

    public DCFRespMsg() {
    }

    public DCFRespBody putMsg(RetCode retCode, String msg) {
        return new DCFRespBody(retCode, msg);
    }

    public DCFRespBody getResponseBody(RetCode retCode) {
        return new DCFRespBody(retCode, this.getMsg(retCode));
    }

    public void writeErrorCode(HttpServletResponse response, RetCode retCode) {
        try {
            DCFRespBody respbody = this.getResponseBody(retCode);
            PrintWriter pw = response.getWriter();
            ObjectMapper mapper = new ObjectMapper(); // can reuse, share
            // globally
            String body = mapper.writeValueAsString(respbody);
            pw.write(body);
            log.debug("error msg:{}", body);
        } catch (Exception exp) {
            log.error(exp.toString());
        }
    }

    public String getMsg(RetCode retCode) {
        return retCode.getMessage();
    }

}
