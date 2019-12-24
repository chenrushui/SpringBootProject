package com.demo.www.springbootdemo.module.design.facade.demo1;

/**
 * Created on 2019/12/19 11:32
 * author:crs
 * Description:SecurityFacade
 */
public class SecurityFacade {

    private Camera camera1;
    private Light light1;

    public SecurityFacade() {
        this.camera1 = new Camera();
        this.light1 =  new Light();
    }

    /**
     * 开启
     */
    public void Activate() {
        camera1.TurnOn();
        light1.TurnOn();
    }

    /**
     * 关闭
     */
    public void Deactivate() {
        camera1.TurnOff();
        light1.TurnOff();
    }

    public static void main(String[] args) {
        SecurityFacade securityFacade = new SecurityFacade();
        securityFacade.Activate();
        securityFacade.Deactivate();
    }
}
