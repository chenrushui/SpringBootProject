package com.demo.www.springbootdemo.module.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

/**
 * Created on 2019/11/25 13:20
 * author:crs
 * Description:测试事务的执行
 */
@Service
public class TransactionService {
    @Autowired
    private TransactionUserDao transactionUserDao;



    @Transactional
    public TransactionUser add(TransactionUser u) {
        transactionUserDao.insert(u);
        return u;
    }

    @Transactional
    public int delete(int id) {
        int i = transactionUserDao.deleteByPrimaryKey(id);
        return i;
    }

    @Transactional(rollbackFor = Exception.class)
    public void test_thread2() throws ExecutionException, InterruptedException, ExecutionException {
        //同一类中的添加方法
        add(new TransactionUser("5","姓名","密码"));
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                //同一类中的添加方法
                add(new TransactionUser("6","姓名","密码"));
                //同一类中的删除方法
                delete(6);
                //抛异常
                throw new Exception("模拟异常操作");
            }
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> submit = pool.submit(callable);
        pool.shutdown();
        System.out.println(submit.get());
    }






}
