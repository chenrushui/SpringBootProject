package com.yunque.www.springbootdemo.validate;

import com.yunque.www.springbootdemo.pojo.User;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validator(User user) {
        return user == null;
    }
}
