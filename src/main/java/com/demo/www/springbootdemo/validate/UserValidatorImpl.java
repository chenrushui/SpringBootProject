package com.demo.www.springbootdemo.validate;

import com.demo.www.springbootdemo.pojo.User;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validator(User user) {
        return user == null;
    }
}
