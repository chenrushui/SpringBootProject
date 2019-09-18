//package com.yunque.www.springbootdemo.interceptor;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.yunque.www.springbootdemo.anno.loginpermission.LoginPermission;
//import com.yunque.www.springbootdemo.base.BaseController;
//import com.yunque.www.springbootdemo.base.PicaUser;
//import com.yunque.www.springbootdemo.pojo.BaseResult;
//import com.yunque.www.springbootdemo.redis.RedisUtils;
//import io.micrometer.core.instrument.util.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.lang.reflect.Method;
//import java.net.URLDecoder;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * 1）打印请求头信息
// * 2）进行登陆权限判断
// */
//@Component
//public class GlobalInterceptor extends HandlerInterceptorAdapter {
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            if (handlerMethod.getBean() != null && handlerMethod.getBean() instanceof BaseController) {
//                //BaseController baseController = (BaseController) handlerMethod.getBean();
//                logger.info("request header and params----->" + getRequestInfo(request));
//                Method method = handlerMethod.getMethod();
//                LoginPermission loginPermission = method.getAnnotation(LoginPermission.class);
//                if (loginPermission != null) {
//                    PicaUser user = this.getPicaUser(request);
//                    logger.info("picaUser----->" + user.toString());
//                    //logger.info("picaUser----->" +JSONObject.toJSONString(user);
//                    if (null == user || user.getId() == null || user.getId() == 0) {
//                        response.setContentType("application/json; charset=utf-8");
//                        PrintWriter writer = response.getWriter();
//                        writer.print(JSONObject.toJSONString(BaseResult.buildSuccess(null), new SerializerFeature[]{SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat}));
//                        writer.close();
//                        response.flushBuffer();
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    /**
//     * 如果用户登陆成功，获取用户信息
//     *
//     * @param request
//     * @return
//     */
//    private PicaUser getPicaUser(HttpServletRequest request) throws Exception {
//        String user = request.getHeader("picaUser");
//        String token = request.getHeader("token");
//        PicaUser picaUser = null;
//        //一般是空的
//        if (!StringUtils.isEmpty(user)) {
//            user = URLDecoder.decode(user, "utf-8");
//            picaUser = (PicaUser) JSONObject.parseObject(user, PicaUser.class);
//        }
//        if (!StringUtils.isEmpty(token)) {
//            picaUser = (PicaUser) this.redisUtils.getToken(token, PicaUser.class);
//        }
//        return picaUser;
//    }
//
//    /**
//     * 获取请求信息
//     *
//     * @param request
//     * @return
//     */
//    private Map<String, Object> getRequestInfo(HttpServletRequest request) {
//        HashMap<String, Object> map = new HashMap<>();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = headerNames.nextElement();
//            Object value = request.getHeader(key);
//            map.put(key, value);
//        }
//        return map;
//    }
//}
