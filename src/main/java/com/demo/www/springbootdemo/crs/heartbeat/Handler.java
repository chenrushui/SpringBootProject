//package com.demo.www.springbootdemo.crs.heartbeat;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class Handler implements  Runnable {
//    private Socket socket;
//    UserState us = null;
//    User newUser = null;
//    private int userId;
//    private int userState;
//    /**
//     * 构造函数，从调用者那里取得socket
//     * @param socket 指定的socket
//     * @author dream
//     */
//    public Handler(Socket socket){
//        this.socket = socket;
//    }
//
//    /**
//     * 从指定的socket中得到输入流
//     * @param socket 指定的socket
//     * @return 返回BufferedReader
//     * @author dream
//     */
//    private BufferedReader getReader(Socket socket){
//        InputStream is = null;
//        BufferedReader br = null;
//
//        try {
//            is = socket.getInputStream();
//            br = new BufferedReader(new InputStreamReader(is));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return br;
//    }
//
//    public void run() {
//        try{
//            workThreadNum = workThreadNum +1;
//            System.out.println("【第"+workThreadNum+"个的连接:"+socket.getInetAddress()+":"+socket.getPort()+"】");
//            BufferedReader br = getReader(socket);
//            String meg = null;
//            StringBuffer report = new StringBuffer();
//            while ((meg = br.readLine()) != null) {
//                report.append(meg);
//                if (meg.contains(csEndFlag)) {
//                    us = getReporterUserState(meg, socket);
//                    synchronized (hashLock) {
//                        userStateList.put(userId, us);
//                    }
//                }
//            }
//        }catch(IOException e){
//            System.out.println("【客户:"+newUser.getUser_id()+"已经断开连接！】");
//            userStateList.remove( userId );
//            announceStateChange( userId , -1);
//        }finally{
//            if(socket != null){
//                try {
//                    //断开连接
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    private UserState getReporterUserState(String meg , Socket socket){
//        UserState us = new UserState();
//        try {
//            Document requestDoc = DocumentHelper.parseText(meg);
//            newUser = ServerControler.parseXmlToUserState(requestDoc,socket);
//            userId = newUser.getUser_id();
//            userState = newUser.getUser_state();
//            us.setFlag(2);
//            us.setUser_state( userState );
//            us.setUser_id( userId );
//            us.setUser_ip(newUser.getUser_ip());
//            us.setUser_port(newUser.getUser_port());
//        } catch (DocumentException e) {
//            System.out.println("【来自客户端的信息不是一个合法的心跳包协议】");
//        }
//        return us;
//    }
//}
