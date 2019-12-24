package com.demo.www.springbootdemo.module.design.facade.demo1;

/**
 * Created on 2019/12/19 11:31
 * author:crs
 * Description:Light
 */
public class Light {

    public void TurnOn() {
        System.out.println("Turning on the light.");
    }

    public void TurnOff() {

        System.out.println("Turning off the light.");
    }

    public void ChangeBulb(int degrees) {
        System.out.println("changing the light-bulb.");
    }
}

