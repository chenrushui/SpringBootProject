package com.demo.www.springbootdemo.module.redisclient1;

import com.demo.www.springbootdemo.module.redisclient1.local.ILocalCache;
import com.pica.cloud.foundation.redis.command.ICacheCoreCommands;
import com.pica.cloud.foundation.redis.command.ICacheTokenCommands;


/**
 * Created on 2019/12/23 14:28
 * author:crs
 * Description:ICacheClient
 * 接口直接可以多继承
 */
public interface ICacheClient extends ICacheCoreCommands, ICacheTokenCommands {
    ILocalCache local();
}
