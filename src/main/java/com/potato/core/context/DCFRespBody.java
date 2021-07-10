package com.potato.core.context;

import com.potato.core.enums.RetCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class DCFRespBody {
    public DCFRespBody() {
    }

    public int retCode;
    public String message;
    public HashMap<String, Object> contents = new HashMap<>();

    public DCFRespBody(RetCode retCode1, String message1) {
        this.retCode = retCode1.getValue();
        this.message = message1;
    }

    public DCFRespBody addContent(String key, Object value) {
        contents.put(key, value);
        return this;
    }

    public DCFRespBody addPlanInfo(HashMap<String,Object> contentMap){
        this.contents = contentMap;
        return this;
    }

}
