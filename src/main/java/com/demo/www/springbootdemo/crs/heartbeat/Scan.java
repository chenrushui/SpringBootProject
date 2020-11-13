//package com.demo.www.springbootdemo.crs.heartbeat;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import static java.lang.Thread.sleep;
//
//public class Scan implements Runnable{
//
//    //在线用户状态列表
//    static HashMap<Integer, UserState> userStateList = new HashMap<>();
//    Object hashLock = new Object();
//
//    //扫描间隔
//    private int scanTime = 1800;
//
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println("*******"+new Date()+"：扫描线程开始扫描"+"*******");
//            synchronized (hashLock) {
//                if(!userStateList.isEmpty()){
//                    //遍历在线用户列表
//                    for (Map.Entry<Integer, UserState> entry : userStateList.entrySet()) {
//                        int flag = entry.getValue().getFlag();
//                        if ( (flag - 1) < 0) {
//                            //在这里通知该用户的好友其状态发生改变
////                              announceStateChange(entry.getKey() , 0);
//                        }else{
//                            entry.getValue().setFlag(flag - 1);
//                            userStateList.put(entry.getKey(), entry.getValue());
//                        }
//                        System.out.println(entry.getKey() + "-->" + entry.getValue().toString());
//                    }
//                }else{
//                    System.out.println("现在还没有在线用户！");
//                }
//            }
//            //实现定时扫描
//            try {
//                sleep(scanTime);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
