package com.demo.www.springbootdemo.module.shorturl;

import com.demo.www.springbootdemo.exceptions.demo.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2019/9/20 15:52
 * author:crs
 * Description:短链接Controller
 */
@Controller
public class ShortUrlController {

    @GetMapping(value = "/short/url")
    @ResponseBody
    public BaseResponse processShortUrl(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(302);
        //短链接的生成逻辑。
        httpServletResponse.setHeader("location", "https://www.baidu.com/");
        return BaseResponse.toResponse("success");
    }
}
