package com.demo.www.springbootdemo.module.design.facade.demo1;

/**
 * Created on 2019/12/19 11:30
 * author:crs
 * Description:相机
 */
public class Camera {

    public void TurnOn() {
        System.out.println("Turning on the camera.");
    }

    public void TurnOff() {

        System.out.println("Turning off the camera.");
    }

    public void Rotate(int degrees) {
        System.out.println("Rotating the camera by {0} degrees." + degrees);
    }
}
