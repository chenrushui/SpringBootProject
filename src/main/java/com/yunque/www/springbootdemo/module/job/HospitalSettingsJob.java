package com.yunque.www.springbootdemo.module.job;

import com.yunque.www.springbootdemo.module.redis.RedisUtils;
import com.yunque.www.springbootdemo.service.HospitalDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 机构加入方式定时任务
 */
@Component
public class HospitalSettingsJob {
    /**
     * 1)服务器上部署了四台hospital服务，不需要四台都执行此定时任务，只需要其中的一台执行即可
     * 2)使用redis的setNX方法实现分布式锁功能。
     * 3)result=1表示当前机器插入成功，其他三台机器不执行此定时任务。
     * 4)设置当前key的过期时间主要用于释放锁，防止死锁。
     * 5)当前job每天只会执行一次。
     * 6)job执行完成后，休眠30秒释放锁。
     */

    private final String KEY = "resetJoinWay";
    private static Logger logger = LoggerFactory.getLogger(HospitalSettingsJob.class);
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private HospitalDepartmentService hospitalDepartmentService;

    @Scheduled(cron = "0 0 3 * * ?")
    public void resetJoinWay() {
        long result = redisUtils.setNX(KEY, "1");
        if (result == 1) {
            //说明当前机器已经获取到锁,其他机器已经不能执行定时任务
            redisUtils.expire(KEY, 60 * 15);
            logger.info("重置机构加入方式定时任务开始执行");
            Integer sum = hospitalDepartmentService.resetJoinWay();
            //logger里面占位符的使用
            logger.info("重置机构加入方式定时任务开始结束，影响机构数：{}", sum);
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                logger.error(ex.getMessage(), ex);
            }

            redisUtils.del(KEY);
        }
    }
}
