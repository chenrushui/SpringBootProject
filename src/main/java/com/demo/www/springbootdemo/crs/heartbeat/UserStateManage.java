//package com.demo.www.springbootdemo.crs.heartbeat;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.HashMap;
//
//public class UserStateManage  extends Thread  {
//
//    //在线用户状态列表
//    static HashMap<Integer, UserState> userStateList = new HashMap<>();
//    Object hashLock = new Object();
//
//    //工作线程数
//    static int workThreadNum = 0;
//    //当前的连接数
//    static int socketConnect = 0;
//
//    private ServerSocket serverSocket;
//    //服务器IP
//    private String host = "10.82.81.79";
//    //服务器端口
//    private int stateReportPort = 60001;
//
//    //设置心跳包的结束标记
//    String endFlag = "</protocol>";
//    CharSequence csEndFlag = endFlag.subSequence(0, 10);
//
//    //扫描间隔
//    private int scanTime = 1800;
//
//    @Override
//    public void run() {
//        serverSocket = startListenUserReport(stateReportPort);
//        if(serverSocket == null){
//            System.out.println("【创建ServerSocket失败！】");
//            return;
//        }
//
//        //启动扫描线程
//        Thread scanThread = new Thread(new Scan());
//        scanThread.start();
//
//        //等待用户心跳包请求
//        while(true){
//            Socket socket = null;
//            try {
//                socketConnect = socketConnect + 1;
//                //接收客户端的连接
//                socket = serverSocket.accept();
//                //为该连接创建一个工作线程
//                Thread workThread = new Thread(new Handler(socket));
//                //启动工作线程
//                workThread.start();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private ServerSocket startListenUserReport(int stateReportPort) {
//
//
//    }
//}
