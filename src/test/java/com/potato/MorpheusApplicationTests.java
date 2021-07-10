package com.potato;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootTest
@Profile(value = "dev")
class MorpheusApplicationTests {

    public static void main(String[] args) {

    }

    @Test
    public void testJson(){

    }
}
