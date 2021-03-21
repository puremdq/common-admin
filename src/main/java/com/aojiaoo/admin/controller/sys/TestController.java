package com.aojiaoo.admin.controller.sys;

import com.aojiaoo.admin.entity.sys.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puremdq
 */
@RestController
public class TestController {


    @RequestMapping("/getMenu")
    public String test(HttpServletRequest httpServletRequest, User user) {
        String s = "[\n" +
                "  {\n" +
                "    \"path\": \"/dashboard\",\n" +
                "    \"name\": \"dashboard111\",\n" +
                "    \"icon\": \"11\",\n" +
                "    \"children\": [\n" +
                "      {\n" +
                "        \"path\": \"/dashboard/analysis\",\n" +
                "        \"name\": \"analysis\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"path\": \"/dashboard/monitor\",\n" +
                "        \"name\": \"monitor\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"path\": \"/dashboard/workplace\",\n" +
                "        \"name\": \"workplace\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        return s;
    }

}
