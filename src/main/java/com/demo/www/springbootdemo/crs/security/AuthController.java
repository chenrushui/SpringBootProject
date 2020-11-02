//package com.demo.www.springbootdemo.crs.security;
//
//import com.demo.www.springbootdemo.pojo.BaseResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//     JWTTokenProvider  jwtTokenProvider;
//
//    @PostMapping("/login")
//    public BaseResult login(@Valid @RequestBody CustomUser user){
//        String mobile = user.getMobile();
//        String password = user.getPassword();
//        //只是获取认证主体
//        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobile, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        JWTUserDetails jwtUserDetails = (JWTUserDetails) authentication.getPrincipal();
//        //token生成规则
//        String token = jwtTokenProvider.getGeneralToken(jwtUserDetails);
//        return BaseResult.buildSuccess(token);
//
//    }
//}
